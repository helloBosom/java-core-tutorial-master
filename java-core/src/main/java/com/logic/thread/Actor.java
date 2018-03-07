package com.logic.thread;

public class Actor extends Thread {
    @Override
    public void run() {
        int counter = 0;
        boolean keepRunning = true;
        System.out.println(this.getName() + " 开始演出了");
        while (keepRunning) {
            System.out.println(this.getName() + " 演出次数 " + (++counter));
            if (counter == 100) keepRunning = false;
            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

        }
        System.out.println(this.getName() + " 结束演出");
    }

    public static void main(String[] args) {
        Thread thread = new Actor();
        thread.setName("actor xiaobai");
        thread.start();

        Thread actress = new Thread(new Actress(), "actress xiaohei");
        actress.start();
    }
}

