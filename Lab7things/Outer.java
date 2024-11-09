class Outer {
    // Declare an instance of Inner
    Inner i1 = new Inner();
    
    // Outer instance variable
    private String s = "Outer string";
    
    // Method in Outer to print its instance variable `s`
    void getS() {
        System.out.println(s);
    }

    // Method in Outer to print the Inner class's `s`
    void getInnerS() {
        System.out.println(i1.s);
    }

    // Inner class
    class Inner {
        // Inner instance variable
        private String s = "Inner string";
        
        // Method in Inner to print its instance variable `s`
        void getS() {
            System.out.println(s);
        }
        
        // Method in Inner to print Outer class's `s`
        void getOuterS() {
            System.out.println(Outer.this.s);
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Create an instance of Outer
        Outer o = new Outer();
        
        // Create an instance of Inner
        Outer.Inner oi = o.new Inner();
        
        // Call methods to test the output
        o.getS();           // Prints "Outer string"
        oi.getS();          // Prints "Inner string"
        o.getInnerS();      // Prints "Inner string"
        oi.getOuterS();     // Prints "Outer string"
    }
}
