/*class MyThreadN1 implements Runnable{
    public void run (){
        System.out.println("MyThread1");
    }
}
class MyThreadN2 implements Runnable{
    public void run (){
        System.out.println("MyThread2");
    }
}*/
class PriorityDemo{
    public static void main(String[] args){
        System.out.println("name of current thread"+ Thread.currentThread().getName());
        System.out.println("priority of current thread"+ Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(5);
        MyThreadN1 t=new MyThreadN1();
        Thread thread = new Thread(t);
        thread.start();

        System.out.println("name of child thread "+ thread.getName());
        
        System.out.println("priority of current thread:"+Thread.currentThread().getPriority());

        

    }
}