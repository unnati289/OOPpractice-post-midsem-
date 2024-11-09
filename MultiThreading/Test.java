class MyThreadN1 implements Runnable{
    public void run (){
        System.out.println("MyThread1");
    }
}
class MyThreadN2 implements Runnable{
    public void run (){
        System.out.println("MyThread2");
    }
}
class Test{
    public static void main(String[] args){
        System.out.println("name of current thread"+ Thread.currentThread().getName());
        MyThreadN1 t=new MyThreadN1();
        Thread thread = new Thread(t);
        thread.start();
        System.out.println("name of child thread "+ thread.getName());
        Thread.currentThread().setName("iwfh");
        System.out.println("now name of current thread:"+Thread.currentThread().getName());

    }
}