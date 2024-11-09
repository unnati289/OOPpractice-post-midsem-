import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class Data{
    private int result;
    private boolean pChance;
    private boolean mChance;
    private int nop;
    private Object lock;
    public Data(){
        try {
            Scanner is = new Scanner(new FileInputStream("input.txt"));
            this.result = is.nextInt();
            this.pChance = is.nextBoolean();
            this.mChance = is.nextBoolean();
            this.nop = is.nextInt();
            this.lock = new Object();
            is.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
    //write all getters and setters
    // Getters
    public int getResult() {
        return result;
    }

    public boolean getPChance() {
        return pChance;
    }

    public boolean getMChance() {
        return mChance;
    }

    public int getNop() {
        return nop;
    }

    public Object getLock() {
        return lock;
    }

    // Setters
    public void setResult(int result) {
        this.result = result;
    }

    public void setPChance(boolean pChance) {
        this.pChance = pChance;
    }

    public void setMChance(boolean mChance) {
        this.mChance = mChance;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }
}