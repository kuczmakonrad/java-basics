package pl.kuczdev.__work_questions.oop_javablog;
/*
Encapsulation is process of wrapping data and function into single unit.
You can use access modifier for variables, so other classes may not access it directly but it can be accessed only through public methods of the class.
You can create class fully encapsulated using private variables.

Encapsulation in java is the process of binding related data(variables) and functionality(methods) into a single unit called class.
Encapsulation can be achieved by using access modifier such as public, private, protected or default,
so your class will be safe from unauthorized access by others and will be simple to maintain.

We can create fully encapsulated class by:
    * Making variables private
    * Providing getters and setters methods for the accessing the variables.

Encapsulation is also termed as data hiding because you are making variables private and variables can be only accessed through public getters and setters.

Advantages of Encapsulation in java:
    * It provides control over data. For example: If You want to check if age of employee is greater than 18 in setter method(setAge(int age)).
        You can easily do it in setter method without breaking any code.
    * Increase reusability.
    * Makes class easy to use for other clients.
    * It helps the developer to write code more flexible and maintainable by binding them into a single unit
        and use appropriate access modifier to access the code as per need.

Difference between abstraction and encapsulation in java:
    1.  Encapsulation means data hiding using getter and setters.
        Abstraction means hiding implementation details using abstract class and interface.
    2.  Abstraction is more of design level concept and Encapsulation is more of implementation level concept.

That’s all about encapsulation in java.
*/
class Employee {
    private int employeeId;
    private String employeeName;
    private String department;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setEmployeeName("Emil");
        employee.setDepartment("H&R");

        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Employee name: " + employee.getEmployeeName());
        System.out.println("Employee department: " + employee.getDepartment());
    }
}