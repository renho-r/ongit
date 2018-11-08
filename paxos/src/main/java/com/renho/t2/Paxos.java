package com.renho.t2;

/**
 * @author https://www.jianshu.com/p/664e16e83c90
 */
public class Paxos {

    public static void main(String[] args) {

        ComputerManager computerManager = new ComputerManager();
        try {
            computerManager.start(7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}