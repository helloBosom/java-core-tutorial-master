package com.logic.thread;

class Actress implements Runnable{
    @Override
    public void run(){
        int counter = 0;
        boolean keepRunning = true;
        System.out.println(Thread.currentThread().getName() + " 开始表演");
        while (keepRunning){
            System.out.println(Thread.currentThread().getName() + " 表演 " + (++ counter));
            try{
                Thread.sleep(200);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
            if (counter == 100) keepRunning = false;
        }
        System.out.println(Thread.currentThread().getName() + " 结束表演");
     }
}
