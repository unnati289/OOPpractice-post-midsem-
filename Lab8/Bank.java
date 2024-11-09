import java.util.Random;
class Account{
    private long acctNumber;
    private double balance;
    private String name;

    public Account(){
        this.acctNumber=generate_acctNumber();
        this.balance=0;
    }
    public Account(double balance){
        this.acctNumber=generate_acctNumber();
        this.balance=balance;
    }
    public Account(String name){
        this.acctNumber=generate_acctNumber();
        this.balance=0;
        this.name=name;
    }
    public Account(double balance,String name){
        this.acctNumber=generate_acctNumber();
        this.balance=balance;
        this.name=name;
    }
    private generate_acctNumber(){
        Random r=new Random();
        long min = 1_000_000_000_000L;
        long max = 9_999_999_999_999L;
        long acctnumber= min+(long)(r.nextDouble()*(max-min));
        return acctNumber;
    }
    public long getActnumber(){
        return this.acctNumber;
    }
    public String getName(){
        return this.name;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public void setName(String name){
        this.name=name;
    }
    @Override
    public String toString(){
        return "The account is in the name of "+this.name+" with balance "+this.balance+" and account number "+this.acctNumber;
    }
}
public class Bank{
    private ArrayList<Account> accts;
    int maxActive;
    public boolean addAccount(Account newone){
        if(this.accts.size()==this.maxActive){
            return false;
        }else{
            accts.add(newone);
            return true;
        }
    }
    public boolean removeAccount(long acctnum){
        ListIterator litr=this.acct.listIterator();
        while(litr.hasNext()){
            Account a=(Account) litr.next();
            if(a.getActnumber()==acctnum){
                litr.remove();
                return true;
            }
        }
        return false;
    }
    public double deposit(long acctnum,double amount){
        ListIterator litr=this.acct.listIterator();
        while(litr.hasNext()){
            Account a=(Account)litr.next();
            if(a.getActnumber()==acctnum){
                a.setBalance(a.getBalance+amount);
                return a.getBalance();
            }
        }
        return -1;
    }
    public double withdraw(long acctnum, double amount){
        ListIterator litr=this.acct.listIterator();
        while(litr.hasNext()){
            Account a=(Account)litr.next();
            if(a.getActnumber()==acctnum && a.getBalance()>=amount){
                a.setBalance(a.getBalance-amount);
                return a.getBalance();
            }
        }
        return -1;
    }
    @Override
    public String toString(){
        for(Account a: this.accts){
            System.out.println(a.toString());
        }
    }
}