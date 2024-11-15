class Barber{
    private int cutting_time;
    Barber(int cutting_time){
        this.cutting_time=cutting_time;
    }
    public void cuts(){
        for(int i=0;i<this.cutting_time;i++){
            System.out.println("Barber is cutting hair");
        }
    }
}
class Customer{
    
}
class BarberShop{

}