public class MovablePoint implements Movable{
    int x;
    int y;
    int xSpeed;
    int ySpeed;
    public MovablePoint(int x, int y, int xSpeed, int ySpeed){
        this.x=x;
        this.y=y;
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;

    }
    @Override
    public String toString(){
        return "The point is at "+ this.x+","+this.y+" with speed "+this.xSpeed+" , "+this.ySpeed;
    }
    public void moveUp(){
        this.y+=this.ySpeed;
    }
    public void moveDown(){
        this.y-=this.ySpeed;
    }
    public void moveLeft(){
        this.x-=this.xSpeed;
    }
    public void moveRight(){
        this.x+=this.xSpeed;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null || obj.getClass()!=obj.getClass()){
            return false;
        }
        MovablePoint point=(MovablePoint) obj;
        return this.x == point.x && this.y == point.y;
    }

}