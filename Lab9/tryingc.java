import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class tryingc{
    public static void main(String[] args){
        Scanner is=null;
        try{
            is=new Scanner(new FileInputStream("trial.txt"));
            System.out.println("First line: " + is.nextLine());
            System.out.println("Next integer: " + is.nextInt());
        }catch(Exception e){

        }
        finally{
            is.close();
        }
    }
}