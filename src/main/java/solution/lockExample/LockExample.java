package solution.lockExample;

public class LockExample {
    private Thread worker;
    private static int x = 0;

    private static Object staticLock = new Object(); // shared by all objects of LockExample

    public LockExample() {
        worker = new Worker(staticLock);
        worker.start();
    }

    private class Worker extends Thread {
        private Object lock;

        public Worker(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized(lock) {
                for (int i = 0; i < 1000; i++)
                    x++;
                System.out.println(x);
            }
        }
    }

    public static void main(String[] args) {
        LockExample demoA = new LockExample();
        LockExample demoB = new LockExample();
        // Since the lock is static, the two workers (one in demoA and one in demoB)
        // will compete for the lock; so only one of the threads can enter
        // the synchronized block of code in run() at the same time
    }
}


