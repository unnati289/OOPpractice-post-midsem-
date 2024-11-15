class LightThread extends Thread{
    private AssemblyLine a;
    LightThread(AssemblyLine a){
        this.a=a;
    }
    public void run(){
        synchronized(a){
            long t1=System.currentTimeMillis();
            
            while(!a.isStarted()){
                
                
                System.out.println("Light Thread is going to wait state ");
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
            System.out.println("LightThreadRunning");
            //System.out.println("Iteration number " + i);
            for(int j=0;j<10;j++){
                Slot s=slots[j];
                System.out.println("Light Thread Checking for Slot number "+ (j+1));
                if(s.isEmpty()){
                    System.out.println("Status: Slot Empty");
                    
                
                }else{
                    if(s.getCar().isLightSystemFitted()){
                        System.out.println("Status: Light Already Fitted");
                    }else{
                        System.out.println("Status: ...Adding Light into Car");
                        try{
                            Thread.sleep(2000);
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        s.getCar().fitLightSystem(); 
                        System.out.println("Status: Light Added To Car");
                    }
                    
                    
                }
            }
            a.notifyAll();
            
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("Light Thread going in waiting state ");
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