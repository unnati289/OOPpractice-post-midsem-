public class MovableCircle implements Movable{
    private MovablePoint centre;
    private int radius;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
        this.centre=new MovablePoint(x,y,xSpeed,ySpeed);
        this.radius= radius;
    }
    public void moveUp(){
        this.centre.moveUp();
    }
    public void moveDown(){
        this.centre.moveDown();
    }
    public void moveLeft(){
        this.centre.moveLeft();
    }
    public void moveRight(){
        this.centre.moveRight();
    }
    @Override
    public String toString(){
        String s=centre.toString()+" with radius "+this.radius;
        return s;
    }
    
    public boolean equals_r(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null || obj.getClass()!=obj.getClass()){
            return false;
        }
        MovableCircle circle=(MovableCircle) obj;
        if(circle.radius==this.radius){
            return true;
        }
        return false;
    }
    
    public boolean equals_c(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null || obj.getClass()!=obj.getClass()){
            return false;
        }
        MovableCircle circle=(MovableCircle) obj;
        return this.centre.equals(circle.centre);
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null || obj.getClass()!=obj.getClass()){
            return false;
        }
        MovableCircle circle=(MovableCircle) obj;
        
        return this.equals_r(obj) && this.equals_c(obj);
        

    }

}