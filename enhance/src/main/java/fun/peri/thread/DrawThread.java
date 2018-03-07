package fun.peri.thread;

import fun.peri.model.Account;

class DrawThread extends Thread{
    private Account acct;
    private double drawAmount;

    public DrawThread(String name, Account acct, double drawAmount){
        super(name);
        this.acct = acct;
        this.drawAmount = drawAmount;
    }

    /**
     * 线程体，执行取款 100 次
     */
    @Override
    public void run(){
        for (int i = 0; i < 20; i ++){
            acct.draw(drawAmount);
        }
    }
}
