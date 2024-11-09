public class SyncTest{
    public static void main(String[] args){
        Data d= new Data();
        int nop=d.getNop();
        
        while(nop>0){
            Player p=new Player(d);
            Thread t=new Thread(p);
            t.start();
            nop--;
        }
        Monitor m=new Monitor(d);
        Thread t2=new Thread(m);
        t2.start();
    }
}