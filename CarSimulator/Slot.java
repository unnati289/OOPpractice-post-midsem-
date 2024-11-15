class Slot{
    private boolean slotHeadingLabel; // Slot Heading Label (For Example "Slot I","Slot II" etc. )
    private boolean engineButton; // Engine Button of Slot
    private boolean tyreButton; // Tyre Button of Slot
    private boolean lightSystemButton; // Light System Button of Slot
    private Car car; // Car held by the Slot
    // Constructor Method
    Slot(boolean slotHeadingLabel, boolean engineButton, boolean tyreButton, boolean lightSystemButton)
    {
        this.slotHeadingLabel = slotHeadingLabel;
        this.engineButton = engineButton;
        this.tyreButton = tyreButton;
        this.lightSystemButton = lightSystemButton;
        this.car = null; // <-- Initially Slot Holds No Car
    }

// Accessor Methods
    public boolean getSlotHeadingLabel() { return this.slotHeadingLabel;}
    public boolean getEngineButton() { return this.engineButton;}
    public boolean getTyreButton() { return this.tyreButton;}
    public boolean getLightSystemButton() { return this.lightSystemButton;}
    public Car getCar() { return this.car; }
    // Method to Add a car into a Slot
    public void addCarToSlot(Car c)
    {
        this.car = c;
    }
   // Method to Remove a car From a Slot
    public void removeCarFromSlot()
    {
        this.car = null;
    }
    // Method to check if a slot holds a car or empty
    public boolean isEmpty()
    {
        if (this.car == null ) return true;
        else return false;
    }
}// End of Class Slot