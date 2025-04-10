package bai1_4;

public class Employee {
	private int id;
    private String firstName;
    private String lastName;
    private int Salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getName(){
        return firstName + " "+lastName ;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
    public int getAnnualSalary(){
        return Salary * 12;
    }
    public int raiseSalary(int percent) {
        Salary += Salary * percent / 100;
        return Salary;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Salary=" + Salary +
                ']';
    }

}
