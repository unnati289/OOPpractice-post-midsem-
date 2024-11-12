
class Data{
    int chance=1;
    
    public void setChance(int chance){
        this.chance=chance;
    }
    public  int getChance(){
        return chance;
    }
}
class Ping extends Thread{
    
    Data d;
    Ping(Data d){
        this.d=d;
    }
    public void run(){
        synchronized(d){
        for(int i=0;i<5;i++){
            try{
            while(d.getChance()!=1){
                d.wait();
            }
            System.out.println("ping");
            d.setChance(2);
            d.notify();
            try{
                Thread.sleep(100);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
}
}

class Pong extends Thread{
    
    Data d;
    Pong(Data d){
        this.d=d;
    }
    public void run(){
        synchronized(d){
        for(int i=0;i<5;i++){
            try{
            while(d.getChance()!=2){
                d.wait();
            }
            System.out.println("pong");
            d.setChance(1);
            d.notify();
            try{
                Thread.sleep(100);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
}
}
public class XYZ {
    public static void main(String[] args) {
        Data data = new Data();  // Shared Data object for synchronizing
        Ping pingThread = new Ping(data);
        Pong pongThread = new Pong(data);
        pingThread.start();  // Start Ping thread
        pongThread.start();  // Start Pong thread
    }
}