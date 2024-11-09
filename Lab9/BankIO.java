import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
public class BankIO{
    public static void readFile(String filename , Bank bank){
        Scanner s=null;
        try{
            s=new Scanner(new File(filename));
            while(s.hasNextLine()){
                BankAccount b=readAccount(s);
                bank.add(b);
            }
        }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
        }finally{
            s.close();
        }
    }
    public static BankAccount readAccount(Scanner in){
            int accountnumber=in.nextInt();
            double balance=in.nextDouble();
            
            //System.out.println(balance);
            //in.nextLine();
            BankAccount b=new BankAccount(balance,accountnumber);
            return b;
            
            
            
            

        
    }
    public static void write(Bank b, String s){
        PrintWriter o=null;
        try{
            o=new PrintWriter(s);
            o.println(b.toString());

        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }finally{
            o.close();
        }
    }
    public static void main(String[] args){
        Bank bank = new Bank(20);
        
        // Reading accounts from a file
        String inputFile = "badinput.txt";
        readFile(inputFile, bank);
        
        // Displaying the accounts in the bank
        System.out.println("Accounts loaded from file:");
        System.out.println(bank);
        
        // Writing accounts to an output file
        String outputFile = "accounts_output.txt";
        write(bank, outputFile);
        System.out.println("Accounts have been written to " + outputFile);
    }

}