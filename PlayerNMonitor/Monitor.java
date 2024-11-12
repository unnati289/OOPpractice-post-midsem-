import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Monitor implements Runnable{
    private Data d;
    private int tails;
    private int heads;
    public Monitor(Data d){this.d=d;};
    public void run(){
        int tosses=this.d.getNop();
        while(tosses>0){
            synchronized(d){
                while(!this.d.getMChance()){
                    try{
                        d.wait();
                    }catch (InterruptedException e) {
                        System.err.println("InterruptedException: " + e.getMessage());
                    }
                }
                System.out.println("monitor is going to read value..");
                if(d.getResult() == 0) tails++;	else heads++;
                d.setMChance(false);
                d.setPChance(true);
                d.notifyAll();
                try {
                    Thread.sleep(100);  // Sleep for 0.5 second (500 milliseconds)
                } catch (InterruptedException e) {
                    System.err.println("InterruptedException while sleeping: " + e.getMessage());
                }
            }
            tosses--;
        }
        PrintWriter p=null;
        try{
            p=new PrintWriter(new FileOutputStream("out.txt",true));
            p.println(tails+" "+heads);
            
        }catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } finally {
            if (p != null) {
                p.close();
            }
        }
        
        
        
    }
}