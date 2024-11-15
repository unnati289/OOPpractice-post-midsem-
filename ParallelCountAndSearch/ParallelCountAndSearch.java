import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class ParallelCountAndSearch{
    ArrayList<Integer> ls;
    
    Map<Integer,Integer> hs;
    
    ParallelCountAndSearch(ArrayList<Integer> ls){
        this.ls=ls;
        
        this.hs=new HashMap<> ();
    }
    class KeyFinder extends Thread{
        int key;
        KeyFinder(int key){
            this.key=key;
        }
        public void run(){
            int i=0;
            boolean ans=false;
            while( i<ls.size()){
                if(ls.get(i)==key){
                    System.out.println("key found at index " + i);
                    ans=true;
                }
                i++;
                
            }
            if(!ans){
            System.out.println("Key not found.");
            }
        }
    }
    class FrequencyCounter extends Thread{
        public void run(){
            for(int i=0; i<ls.size();i++){
                hs.put(ls.get(i),hs.getOrDefault(ls.get(i),0)+1);
            }
            for(Map.Entry<Integer,Integer> e : hs.entrySet()){
                System.out.println(e.getKey()+" "+e.getValue());
            }
        }
    }
    public void searchKey(int k){
        Thread t=new KeyFinder(k);
        t.start();
    }
    public void countFrequency(){
        Thread t= new FrequencyCounter();
        t.start();
    }

    
    public static void main(String[] args) {
        // Create an ArrayList of integers
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(6);
        
        // Create an instance of ParallelCountAndSearch
        ParallelCountAndSearch searchAndCount = new ParallelCountAndSearch(list);

        // Search for key '2'
        searchAndCount.searchKey(2);

        // Count frequencies of elements
        searchAndCount.countFrequency();
    }
    
}