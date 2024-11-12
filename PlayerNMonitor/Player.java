import java.util.Random;
class Player implements Runnable {
    private Data d;
    private Random rand = new Random();

    public Player(Data d) {
        this.d = d;
    }

    public void run() {
        
        
            synchronized (d) {
                while (!d.getPChance()) {
                    try {
                        d.wait();
                    } catch (InterruptedException e) {
                        System.err.println("InterruptedException: " + e.getMessage());
                    }
                }
                d.setResult(rand.nextInt(2));
                d.setMChance(true);
                d.setPChance(false);
                d.notify();
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    System.err.println("InterruptedException while sleeping: " + e.getMessage());
                }
            }
            
    }
}

