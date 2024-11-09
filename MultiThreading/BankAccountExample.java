import java.util.logging.Logger;
import java.util.Random;
class BankAccount{
    private static final Logger logger = Logger.getLogger(BankAccount.class.getName());
    private double balance;
    BankAccount(){
        this.balance=0;
    }
    BankAccount(double balance){
        this.balance=balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public  synchronized void deposit(double sum){
        try{
            if(sum<0){
                throw new Exception("sum cannot be negative");
            }
            this.setBalance(this.getBalance()+sum);
            logger.info("a deposit of "+sum+" has been made and now the balance is "+this.getBalance());
            notify();
        }catch(Exception e){
            System.out.println(e.getMessage());
            logger.severe("Error occurred during deposit: " + e.getMessage());
        }
    }
    public synchronized void withdraw(double sum){
        try{
            if(sum<0){
                throw new Exception("sum cannot be negative");
            }
            if(sum>this.getBalance()){
                try{
                    wait();
                }catch(Exception e){};
            }
            this.setBalance(this.getBalance()-sum);
            logger.info("a withdrawal of "+sum+" has been made and now the balance is "+this.getBalance());
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            logger.severe("Error occurred during withdraw: " + e.getMessage());
        }
    }
}
class Depositor implements Runnable{
    
    BankAccount b;
    Depositor(BankAccount b){
        this.b=b;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            Random r=new Random();
            double rand=100+(r.nextDouble()*(500-100));
            b.deposit(rand);
            try{
                    Thread.sleep(100);
            }catch(Exception e){};
        }
    }
}

class Withdrawal implements Runnable{
    
    BankAccount b;
    Withdrawal(BankAccount b){
        this.b=b;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            Random r=new Random();
            double rand=100+(r.nextDouble()*(500-100));
            b.withdraw(rand);
            try{
                    Thread.sleep(100);
            }catch(Exception e){};
        }
    }
}
public class BankAccountExample{
    public static void main(String[] args){
        BankAccount account = new BankAccount();

        // Create depositor and withdrawal threads
        Depositor depositor = new Depositor(account);
        Withdrawal withdrawal = new Withdrawal(account);

        Thread depositorThread = new Thread(depositor);
        Thread withdrawalThread = new Thread(withdrawal);

        // Start the threads
        depositorThread.start();
        withdrawalThread.start();

        try {
            // Wait for both threads to finish
            depositorThread.join();
            withdrawalThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    }
}