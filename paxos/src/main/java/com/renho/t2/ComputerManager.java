package com.renho.t2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
class ComputerManager {

    private List<Computer> computers = new ArrayList();//定义一个集合
    private Integer startSize;

    /**
     * 启动所有服务器
     *
     * @throwsException
     */

    public void start(Integer startSize) throws Exception {

        if (computers != null && computers.size() > 0) {
            throw new Exception("restart error");
        }
        this.startSize = startSize;
        Paxos paxos = new Paxos();
        for (int i = 0; i < startSize; i++) {
            Computer computer = new Computer(this);
            Thread thread = new Thread(computer);
            thread.start();
        }

    }

    /**
     * 启动完成的服务器注册
     *
     * @return
     */

    public void register(Computer computer) {
        computers.add(computer);
    }

    /**
     * 获取所有服务器
     *
     * @return
     */

    public Integer getHelfSize() {
        return computers.size() / 2 + 1;
//            return startSize / 2 + 1;

    }

    /**
     * 获取一个法定集合
     *
     * @return
     */

    public synchronized List getLegalComputers() {
        List list = new ArrayList();
        int count = 0;
        int computerSize = computers.size();
        int helfCount = computerSize / 2 + 1;
        Random random = new Random();
        while (count < helfCount) {
            //生成一个随机数
            int _random = Math.abs(random.nextInt(computerSize));
            if (_random >= 0 && _random < computerSize) {
                Computer _computer = computers.get(_random);
                if (!list.contains(_computer)) {
                    list.add(_computer);
                    count++;
                }
            }
        }
        return list;
    }
}