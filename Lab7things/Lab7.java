/*JAVA interface: is a contract for what the classes can do. It, however, does not specify how the classes should do
*/
public class Lab7 { // Correct class declaration

    public static void main(String[] args) { // Correct main method declaration
        Movable m1 = new MovablePoint(5, 6, 10,20);
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);

        Movable m2 = new MovableCircle(2, 1, 2, 20,41);
        Movable m3 = new MovableCircle(2, 1, 2, 20,41); // upcast
        System.out.println(m2);
        //m2.moveRight();
        System.out.println(m2);
        System.out.println(m3.equals(m2));
    }
}
