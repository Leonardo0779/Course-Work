import java.util.Objects;

public class Employee {
    private final String fullname;
    private double salary;
    private int department;
    private int id;
    public static int count = 0;

    public Employee(String fullName, double salary, int department) {
        this.fullname = fullName;
        this.salary = salary;
        this.department = department;
        this.id = count++;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Зарплата не может быть отрицательной!");
            return;
        }
        this.salary = salary;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            System.out.println("Значение должно быть от 1 до 5");
            return;
        }
        this.department = department;
    }

    @Override
    public String toString() {
        return "Id" + id +
                "\nФИО: " + fullname + "\n отдел " + department +
                "\n зарплата " + salary + "\n";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return Double.compare(salary, employee.salary) == 0 && department == employee.department && id == employee.id
                && Objects.equals(fullname, employee.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, salary, department, id);
    }
}

