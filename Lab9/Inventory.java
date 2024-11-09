import java.util.logging.Logger;
public class Inventory{
    private static final Logger l=Logger.getLogger(Inventory.class.getName());
    private int stock;
    public Inventory(int initialStock){
        this.stock=initialStock;
    }
    public void addStock(int quantity){
        assert quantity>=0 : "quantity can not be negative";
        l.info("new stock is added ");
        l.info("old stock was "+ this.stock);
        this.stock+=quantity;
        l.info("new stock is "+ this.stock);
    }
    public void removeStock(int quantity){
        assert quantity>=0 :"quantity is less than 0!";
        assert quantity<=this.stock :"quantity is more than stock!";
        try{
            if(quantity<0){
                throw new Exception("quantity is less than 0");
                
            }
            if(quantity>this.stock){
                throw new Exception("quantity is more than stock");
                
            }
            this.stock-=quantity;
            l.info("follwing quantity of stock is removed: "+ quantity+" so the new stock is "+this.stock);

        }catch(Exception e){
            l.warning(e.getMessage());
        }
        public int getStock() {
            return stock;
        }

    }
}
