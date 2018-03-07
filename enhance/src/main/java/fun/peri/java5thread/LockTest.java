package fun.peri.java5thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    class OutPut {
        Lock lock = new ReentrantLock();

        public void output(String content) {
            lock.lock();
            try {
                for (int i = 0; i < content.length(); i++)
                    System.out.print(content.charAt(i));
                System.out.println();
            } finally {
                lock.unlock();
            }
        }
    }

    class MyRunnable implements Runnable {
        private String content;
        private OutPut outputer;

        public MyRunnable(String _content, OutPut _outputer) {
            content = _content;
            outputer = _outputer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputer.output(content);
            }
        }
    }

    private void init() {
        OutPut outputer = new OutPut();
        new Thread(new MyRunnable("llllllllll", outputer)).start();
        new Thread(new MyRunnable("oooooooooo", outputer)).start();
    }

    public static void main(String[] args) {
        new LockTest().init();
    }
}
