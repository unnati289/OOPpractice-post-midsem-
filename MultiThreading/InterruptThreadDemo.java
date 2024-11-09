class MyThreadi extends Thread{
	public void run(){
		for( int i=1;i<=10;i++){
			if (Thread.interrupted()) {
                System.out.println("Thread was interrupted before starting the task");
                return; // Exit early if interrupted
            }
		 
        
			System.out.println("I am lazy_"+i);
		
    }
		
	}
}
 class InterruptThreadDemo{
	public static void main(String args[]){
		MyThreadi t=new MyThreadi();
		t.start();
		t.interrupt();
        t.interrupt();
		System.out.println("End of main thread");
	}
}
