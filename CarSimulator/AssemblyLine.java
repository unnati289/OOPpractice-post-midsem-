class AssemblyLine
{
private Slot[] slots; // Slots of an Assembly Line
private boolean assemblyLineInitialized; // boolean variable to check if an an Assembly Line is Initialized or not
private boolean assemblyLineStarted; // boolean variable to check if an an Assembly Line is Started or not
// Constructor Method
AssemblyLine()
{
slots = new Slot[10]; // An assembly Line has 10 fixed Slots
for (int i = 0; i < slots.length; i++) {
        slots[i] = new Slot(false,false,false,false); // Initialize each Slot
     }
assemblyLineInitialized=assemblyLineStarted=false; // Initial Staus : Not Initialized and Not Started
}
// Accessor Methods
public synchronized Slot[] getSlots() { return slots;}
public synchronized boolean isInitialized() { return assemblyLineInitialized;}
public synchronized boolean isStarted() { return assemblyLineStarted;}
// Methods to Initialize and Start an Assembly Line
public void initialize() { assemblyLineInitialized = true; }
public void start() { assemblyLineStarted = true; }
}// End of class AssemblyLine