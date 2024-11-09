import java.util.LinkedList;
class Stack<T>{
    LinkedList<T> l;
    public Stack(){
        this.l=new LinkedList<>();
    }
    public void push(T element){
        this.l.addFirst(element);
    }
    public void pop(){
        try{
            if(l.size()==0){
                throw new EmptyStackException("the stack is empty!");
            }
            
            this.l.remove();
        
        }catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    public T top(){
        if(l.size()!=0){
            T e=this.l.get(0);
            return e;
        }else{
            System.out.println("Stack is empty!");
            return null;
        }
    }
    
    
}
class EmptyStackException extends Exception{
    public EmptyStackException(String mssg){
        super(mssg);
    }
}