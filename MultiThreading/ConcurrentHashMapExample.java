import java.util.Map;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class Update implements Runnable {
    ConcurrentHashMap<String, Integer> mp = null;
    ConcurrentHashMap<String, Integer> mp2 = null;

    Update(ConcurrentHashMap<String, Integer> mp, ConcurrentHashMap<String, Integer> mp2) {
        this.mp = mp;
        this.mp2 = mp2;
    }

    public void upd() {
        Iterator<Map.Entry<String, Integer>> it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            mp2.put(entry.getKey(), entry.getValue());  // Use entry instead of it for getKey and getValue
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        this.upd();
    }
}

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> mp = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Integer> mp2 = new ConcurrentHashMap<>();

        mp.put("Alice", 85);
        mp.put("Riya", 70);
        mp.put("Aayush", 50);
        mp2.put("Alicia", 65);
        mp2.put("Riyal", 90);

        Runnable u1 = new Update(mp, mp2);
        Runnable u2 = new Update(mp, mp2);
        Thread t1 = new Thread(u1);
        Thread t2 = new Thread(u2);

        // Start the threads
        t1.start();
        t2.start();

        
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        Iterator<Map.Entry<String, Integer>> i = mp2.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<String, Integer> e = i.next();
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }
}
