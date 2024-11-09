class MyThread extends Thread{
	public void run(){
		for( int i=0;i<10;i++){
			System.out.println("Child  Thread");
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
	}
}
class ThreadDemo{
	public static void main(String args[]){
		MyThread  t=new MyThread();
		t.start();
		for( int  i=0;i<10;i++)
			System.out.println("Parent  Thread");
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
	}
}