class EngineThread extends Thread{
    private AssemblyLine a;
    EngineThread(AssemblyLine a){
        this.a=a;
    }
    public void run(){
        synchronized(a){
            long t1=System.currentTimeMillis();
            
            while(!a.isStarted()){
                
                
                System.out.println("Engine Thread is going to wait state ");
                try{
                    Thread.sleep(2000);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                long t2=System.currentTimeMillis();
               System.out.println("Iteration Execution Time:" + (t2-t1) +  "Milli Seconds");

                
                try{
                    a.wait();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            Slot[] slots=a.getSlots();
            System.out.println("EngineThreadRunning");
            //System.out.println("Iteration number " + i);
            for(int j=0;j<10;j++){
                Slot s=slots[j];
                System.out.println("Engine Thread Checking for Slot number "+ (j+1));
                if(s.isEmpty()){
                    System.out.println("Status: Slot Empty");
                    
                
                }else{
                    if(s.getCar().isEngineFitted()){
                        System.out.println("Status: Engine Already Fitted");
                    }else{
                        System.out.println("Status: ...Adding Engine into Car");
                        try{
                            Thread.sleep(2000);
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        s.getCar().fitEngine(); 
                        System.out.println("Status: Engine Added To Car");
                    }
                    
                    
                }
            }
            a.notifyAll();
            
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("Engine Thread going in waiting state ");
            long t2=System.currentTimeMillis();
            System.out.println("Iteration Execution Time:" + (t2-t1) +  "Milli Seconds");
            //this.setWorking(false);
            try{
                a.wait();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }

    }
}