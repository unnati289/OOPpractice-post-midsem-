import java.util.concurrent.CopyOnWriteArrayList;
public class CopyOnWriteArrayListExample{
    public static void main(String[] args){
        CopyOnWriteArrayList<Integer> list= new CopyOnWriteArrayList<>();
        Runnable task=()->{
            for (int i=0;i<5;i++){
                list.add(i);
                System.out.println(Thread.currentThread().getName()+"added "+ i+ "to the list");
                try{
                    Thread.sleep(100);
                }catch(Exception e){};

            }
        };
        Thread thread1= new Thread(task,"Thread1");
        Thread thread2= new Thread(task,"Thread2");
        thread1.start();
        try{
            thread1.join();
            
        }catch(Exception e){};
        thread2.start();
        
        try{
            thread2.join();
            
        }catch(Exception e){};
        System.out.println("final list "+ list);
    }
}