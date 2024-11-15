public class Driver {
    public static void main(String[] args) {
        // Create an instance of AssemblyLine
        AssemblyLine assemblyLine = new AssemblyLine();
        assemblyLine.initialize();
        // Create and start AdderThread
        AdderThread adderThread = new AdderThread(assemblyLine);
        adderThread.start();

        // Create and start EngineThread
        EngineThread engineThread = new EngineThread(assemblyLine);
        engineThread.start();

        // Create and start TyreThread
        TyreThread tyreThread = new TyreThread(assemblyLine);
        tyreThread.start();

        // Create and start LightThread
        LightThread lightThread = new LightThread(assemblyLine);
        lightThread.start();

        // Create and start RemoveThread
        RemoveThread removeThread = new RemoveThread(assemblyLine);
        removeThread.start();

        // Simulate starting the assembly line
        try {
            Thread.sleep(5000); // Allow threads to initialize
            synchronized (assemblyLine) {
                System.out.println("Starting the assembly line...");
                assemblyLine.start(); // Start the assembly line
                assemblyLine.notifyAll(); // Notify all threads to begin work
            }
        } catch (InterruptedException e) {
            System.out.println("Error starting the assembly line: " + e.getMessage());
        }

    }
}
