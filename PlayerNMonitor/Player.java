import java.util.Random;
class Player implements Runnable {
    private Data d;
    private Random rand = new Random();

    public Player(Data d) {
        this.d = d;
    }

    public void run() {
        
        
            synchronized (d.getLock()) {
                while (!d.getPChance()) {
                    try {
                        d.getLock().wait();
                    } catch (InterruptedException e) {
                        System.err.println("InterruptedException: " + e.getMessage());
                    }
                }
                d.setResult(rand.nextInt(2));
                d.setMChance(true);
                d.setPChance(false);
                d.getLock().notify();
                try {
                    Thread.sleep(10); // Sleep for 1 second (1000 milliseconds)
                } catch (InterruptedException e) {
                    System.err.println("InterruptedException while sleeping: " + e.getMessage());
                }
            }
            
    }
}

