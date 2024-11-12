class QArray{
    int f=0;
    public int max_size;
    public QArray(int max_size){
        
        this.max_size=max_size;

    }

}
class Cook extends Thread{
    QArray q;
    Cook(QArray q){
        this.q=q;
    }
    public void run(){
            while(true){
            synchronized(q){
            while(this.q.f==this.q.max_size){
                try{
                q.wait();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            this.q.f++;
            System.out.println("Thread "+ Thread.currentThread().getId()+" cook has added to the queue leaving the size "+ this.q.f);
            q.notifyAll();
            try{
                Thread.sleep(100);
            }catch (Exception e){
                System.out.println(e.getMessage());            
            }
            }
            }  
        
    }
}

class Waiter extends Thread{
    QArray q;
    Waiter(QArray q){
        this.q=q;
    }
    public void run(){
        
            synchronized(q){
            while(this.q.f==0){
                try{
                q.wait();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            
            this.q.f--;
            System.out.println("Thread "+ Thread.currentThread().getId()+" waiter has taken out from the queue making the size "+ this.q.f);
            q.notifyAll();
            try{
                Thread.sleep(100);
            }catch (Exception e){
                System.out.println(e.getMessage());            
            }
            }
        
    }
}

class XYZ{
    public static void main(String[] args){
        QArray q=new QArray(5);
        Thread t=new Cook(q);
        for(int i=0;i<6;i++){
            
            Thread t2=new Waiter(q);
            t2.start();
        }
        t.start();
        
    }
}