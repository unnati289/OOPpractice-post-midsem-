// Define the interface correctly
interface Things {
    Circle getCircle(int radius);
}

// The main class
public class Anonymous {
    // Method to get a Circle using the interface
    public Circle getCircle(int radius) {
        // Create an anonymous class that implements the Things interface
        Things circle = new Things() {
            @Override
            public Circle getCircle(int radius) {
                Circle c = new Circle(radius);
                return c; // Return the Circle object
            }
        };
        return circle.getCircle(radius); // Call the method with radius
    }

    public static void main(String[] args) {
        Anonymous p = new Anonymous();
        Circle w = p.getCircle(10); // Get the Circle object

        // Print the area of the circle
        System.out.println(w.area());
    }
}

// Circle class definition
class Circle {
    private int rad;

    public Circle(int radius) {
        rad = radius; // Initialize radius
    }

    public double area() {
        return Math.PI * rad * rad; // Calculate area using π * r^2
    }
}
