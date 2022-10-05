package lockExample;

public class LockExample {
    private Thread worker;
    private static int x = 0;

    // FILL IN CODE: create a lock that you will pass to the worker


    public LockExample() {
        // FILL IN CODE: create and start the worker, pass the lock


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
    }
}


