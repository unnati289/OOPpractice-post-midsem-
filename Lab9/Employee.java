import java.util.logging.Logger;
public class Employee{
    private static final Logger logger = Logger.getLogger(Employee.class.getName());
    private String name;
    private double salary;
    public Employee(String name, double initialSalary){
        this.name=name;
        this.salary=initialSalary;
        logger.info("Employee with name "+name+" and salary " +salary +" logged in ");

    }
    public void updateSalary(double newSalary) {
        assert newSalary>=0 : "newSalary can not be negative!";
        try{
            if(newSalary<0){
                throw new Exception(" new salary is less than 0!");
            }
            logger.info("old salary was "+this.salary);
            this.salary=newSalary;
            logger.info("new salary is "+ this.salary);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 5000);
        emp.updateSalary(5500);
        emp.updateSalary(-2000); // This will trigger an exception and log it
    }


}