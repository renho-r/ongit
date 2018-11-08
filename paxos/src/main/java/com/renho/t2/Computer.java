package com.renho.t2;

import java.util.List;
import java.util.Random;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Computer implements Runnable {

    private Integer id = Math.abs(new Random().nextInt());//服务器ID
    private Integer maxN;//当前接收到的提案号
    private Integer acceptN;//已经同意的提案号
    private Integer acceptV;//已经同意的提案号对应的值
    private ComputerManager computerManager;
    Computer(ComputerManager computerManager) {
        this.computerManager = computerManager;
    }

    public synchronized Object[] prepaer(Integer acceptN) {

        System.out.println("---------------------------------------------------分割线------------------------------");
        System.out.println(acceptN + "申请提案:" + this.id + ".........." + this.maxN + "........" + this.acceptN + "......" + this.acceptV);
        /*这里模拟一个断网情况，如果随机为2则断网*/
        Random random = new Random();
        int state = random.nextInt(10);
        if (state == 2) {
            return null;
        }

        /*以下为正常情况*/

//如果之前没有接受过提案，直接返回null

        if (maxN == null) {
            this.maxN = acceptN;//令当前接收到的提案号=当前申请的提案号
            return new Object[]{
                    "pok", null, null
            };
        }

        if (maxN > acceptN) {
//由于当前申请提案号小于已经同意的提案号，所以不接收提案申请
            return new Object[]{
                    "error", null, null
            };

        }

        if (acceptN > maxN) {//判断新申请的提案是否为新提案
            this.maxN = acceptN;//令当前接收到的提案号=当前申请的提案号
            if (this.acceptN == null) {//如果之前没有通过任何提案，返回null
                return new Object[]{
                        "pok", null, null
                };
            } else {
//如果之前同意过提案，返回最后同意的提案编号和提案值
                return new Object[]{
                        "pok", this.acceptN, this.acceptV
                };
            }
        }
        return null;
    }

    public synchronized String accept(Integer acceptN, Integer acceptV) {

//首先当前申请的提案号acceptN不能小于maxN

        if (maxN <= acceptN) {
            maxN = acceptN;
            this.acceptN = acceptN;
            this.acceptV = acceptV;
            return "aok";
        }
        return "error";

    }

    /**
     * 进行选举
     */

    public void paxos(Computer computer) {

//获取一个法定集合

        List<Computer> computers = computerManager.getLegalComputers();
        Integer _acceptN = 0;
        Integer _acceptV = 0;
        int count = 0;
        Integer cid = CId.getCid();
        for (Computer _computer : computers) {
            Object[] prepaer = _computer.prepaer(cid);//申请提交提案
            if (prepaer == null) {
                continue;
            }
            System.out.println(cid + "(" + _acceptN + ":" + _acceptV + ")" + "返回提案:" + _computer.id + ".........." + prepaer[0] + "........" + prepaer[1] + "......" + prepaer[2]);
            String state = (String) prepaer[0];
            if ("pok".equals(state))//接收到申请的情况
            {
                count++;
                if (_acceptN == 0 && prepaer[1] == null) {
                    //生成一个新的acceptV
                    _acceptV = computer.id;
                } else {
                    Integer acceptN = (Integer) prepaer[1];
                    Integer acceptV = (Integer) prepaer[2];
//使用返回的acceptV
                    if (acceptN >= _acceptN) {
                        _acceptN = acceptN;
                        _acceptV = acceptV;
                    }
                }
            }
        }
//如果接收到的回复超过了半数，则正式提交提案

        if (count >= computerManager.getHelfSize()) {
            _acceptN = cid;
//获取一个法定集合
            List<Computer> computers1 = computerManager.getLegalComputers();
            int acount = 0;
            for (Computer _computer : computers1) {
                System.out.println(_acceptN + "(" + _acceptV + ")" + "提交提案:" + _computer.id + ".........." + _computer.maxN + "........" + _computer.acceptN + "......" + _computer.acceptV);
                String accept = _computer.accept(_acceptN, _acceptV);//申请提交提案
                if ("aok".equals(accept)) {
                    acount++;
                }
            }

            if (acount >= computerManager.getHelfSize()) {
                System.out.println("提案被多数通过:" + _acceptN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + _acceptV);
                for (Computer _computer : computers1) {
                    System.out.println(_computer.id + ".........." + _computer.maxN + "........" + _computer.acceptN + "......" + _computer.acceptV);
                }

            }

        }

    }

    /**
     * 启动命令
     */

    @Override
    public void run() {

        Computer computer = this;
        computerManager.register(computer);//注册到启动集群中
        paxos(computer);

    }

}
