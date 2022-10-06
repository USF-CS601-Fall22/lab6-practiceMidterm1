package solution.volatilePackage;

public class VolatileExample {
    // Is the following ("volatile") enough to provide synchronization in this case?
    private static volatile boolean stopGenerating = false;

    public class RandomNumberGeneratorTask implements Runnable {
        @Override
        public void run() {
            while (!stopGenerating) {
                double randomNum = Math.random();
                System.out.println("Generated a random number " + randomNum);
            }
            System.out.println("Done.");
        }
    }

    public static void stopGeneratingNumbers() {
        stopGenerating = true;
    }


    public static void main(String[] args) {
        VolatileExample ex = new VolatileExample();
        Thread randomNumGenThread = new Thread(ex.new RandomNumberGeneratorTask());
        randomNumGenThread.start();
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        stopGenerating = true;
    }

}
