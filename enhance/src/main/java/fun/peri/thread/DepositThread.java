package fun.peri.thread;

import fun.peri.model.Account;

class DepositThread extends Thread{
    private Account acct;
    private double depositAmount;

    public DepositThread(String name, Account acct, double depositAmount){
        super(name);
        this.acct = acct;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run(){
        for (int j = 0; j < 20; j ++){
            acct.deposit(depositAmount);
        }
    }
}
