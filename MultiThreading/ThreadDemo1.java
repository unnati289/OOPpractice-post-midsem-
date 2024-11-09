class MyThreadEx1 extends Thread{
    public void run(){
        System.out.println("no arg");
    }
    public void run(int x){
        System.out.println("arrg");
    }
}
class ThreadDemo1{
    public static void main(String[] args){
        MyThreadEx1 t=new MyThreadEx1();
        t.start();
    }
}