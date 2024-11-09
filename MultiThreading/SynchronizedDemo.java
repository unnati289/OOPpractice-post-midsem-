 class Display {
    
    private String name = "Display Thread";

    public synchronized void displayn() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
            System.out.println(name);  // Print the name variable
        }
    }

    public synchronized void displayc() {
        for (int i = 65; i <= 74; i++) {
            System.out.println((char) i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
            System.out.println(name);  // Print the name variable
        }
    }
}

class MyThread1i extends Thread {
    Display d;

    public MyThread1i(Display d) {
        this.d = d;
    }

    public void run() {
        d.displayn();  // Run the displayn method of Display class
    }
}

class MyThread2ii extends Thread {
    Display d;

    public MyThread2ii(Display d) {
        this.d = d;
    }

    public void run() {
        d.displayc();  // Run the displayc method of Display class
    }
}
 class SynchronizedDemo {
 	public static void main(String args[]){
		Display d=new Display();
		MyThread1i t1=new MyThread1i(d);
		MyThread2ii t2=new MyThread2ii(d);
		t1.start();
		t2.start();
	}
}
