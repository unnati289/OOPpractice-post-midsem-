class MyThreadii extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("I am lazy_" + i);
            System.out.println("I am going to sleep");

            try {
                Thread.sleep(500);  // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("I got interrupted");
                return;  // Exit the thread if interrupted during sleep
            }
        }
    }
}

class InterruptThreadDemo2 {
    public static void main(String args[]) {
        MyThreadii t = new MyThreadii();
        t.start();  // Start the thread
        try {
            Thread.sleep(2000);  // Let the thread run for 500ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();  // Interrupt the thread after 500ms
        System.out.println("End of main thread");
    }
}
