package fun.peri.thread;


import fun.peri.model.Account;

public class Demo {
    public static void main(String... args){
        Account acct = new Account("zhouzhou", 0);
        new DrawThread("取钱者1", acct, 600).start();
        new DepositThread("存钱者甲", acct, 600).start();

//        new DrawThread("取钱者2", acct, 600).start();
//        new DrawThread("取钱者3", acct, 600).start();
//        new DepositThread("存钱者乙", acct, 600).start();
//        new DepositThread("存钱者丙", acct, 600).start();
    }
}
