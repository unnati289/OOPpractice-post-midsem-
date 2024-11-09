class MyThread2 extends Thread{
	public void start(){
		super.start();
		System.out.println("start  method");
	}
	public void run(){
		 System.out.println("run method");
	}
}
class ThreadDemo2{
	public static void main(String args[]){
		MyThread2  t=new MyThread2();
		t.start();
		 System.out.println("main method");
	}
}
