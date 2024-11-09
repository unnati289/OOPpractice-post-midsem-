import java.util.ArrayList;
public class Sort{
    public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(21);
    list.add(20);
    list.add(34);
    Comparator c=(int a,int b)-> a-b;
    for(int i=0;i<list.size();i++){
        for (int j=i;j<list.size()-1;j++){
            if(c.compare(list.get(j), list.get(j + 1)) > 0){
                int t=list.get(j);
                list.set(j, list.get(j + 1));
                list.set(j + 1, t);
            }
        }
    }
    for(Integer i : list){
        System.out.println(i);
    }
    }
}