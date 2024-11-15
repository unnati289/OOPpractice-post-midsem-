class Car{
    private boolean engineFitted;
    private boolean tyreFitted;
    private boolean lightSystemFitted;

    Car(){
        this.engineFitted=this.tyreFitted=this.lightSystemFitted=false;
    }
    public boolean isEngineFitted() { return engineFitted;}
    public boolean isTyreFitted() { return tyreFitted;}
    public boolean isLightSystemFitted() { return lightSystemFitted;}
    public boolean isCarReady() { return engineFitted && tyreFitted && lightSystemFitted; }

    public void fitEngine() { engineFitted = true;}
    public void fitTyres() { tyreFitted = true; }
    public void fitLightSystem() { lightSystemFitted = true;}
}