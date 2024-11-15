class AdderThread extends Thread{
    private boolean working=true;
    AssemblyLine a;
    AdderThread(AssemblyLine a){
        this.a=a;
    }
    public boolean getWorking(){
        return this.working;
    }
    public void setWorking(boolean w){
        this.working=w;
    }
    public void run(){
        
        int i=1;
        
        while(true){
            synchronized(a){
            long t1=System.currentTimeMillis();
            this.setWorking(true);
            while(!a.isStarted()){
                
                System.out.println("Iteration Number: "+ i);
                System.out.println("Adder Thread is going to wait state ");
                try{
                    Thread.sleep(2000);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                long t2=System.currentTimeMillis();
                System.out.println("Iteration Execution Time:" + (t2-t1) +  "Milli Seconds");

                this.setWorking(false);
                try{
                    a.wait();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }

            Slot[] slots=a.getSlots();
            
            System.out.println("AdderThreadRunning");
            System.out.println("Iteration number " + i);
            for(int j=0;j<10;j++){
                Slot s=slots[j];
                System.out.println("Checking for Slot number "+ (j+1));
                if(s.isEmpty()){
                    System.out.println("Status: Slot Empty .. Adding Car");
                    Car c=new Car();
                    s.addCarToSlot(c);
                    try{
                        Thread.sleep(2000);
                    }catch(Exception e){
                    System.out.println(e.getMessage());
                    }
                    System.out.println("Status: Car Added");
                }else{
                    System.out.println("Status: Slot Already Full");
                }
            }
            a.notifyAll();
            
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("Adder Thread going in waiting state ");
            long t2=System.currentTimeMillis();
            System.out.println("Iteration Execution Time:" + (t2-t1) +  "Milli Seconds");
            this.setWorking(false);
            try{
                a.wait();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            }
            i++;
        }
    

    }

}