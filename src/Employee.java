public class Employee {
    private final String fullNameEmployee;
    private int departmentEmployee;
    private double salaryEmployee;
    private final int id;
    private static int idCount;


    public Employee(String fullNameEmployee, int departmentEmployee, double salaryEmployee) {
        this.id = ++idCount;
        this.fullNameEmployee = fullNameEmployee;
        if (departmentEmployee <= 0 || departmentEmployee > 5) throw new RuntimeException("Не существует такого отдела!");
        this.departmentEmployee = departmentEmployee;
        this.salaryEmployee = salaryEmployee;
    }

    public String getFullNameEmployee() {
        return fullNameEmployee;
    }

    public int getDepartmentEmployee() {
        return departmentEmployee;
    }

    public void setDepartmentEmployee(int departmentEmployee) {
        if (departmentEmployee <= 0 || departmentEmployee > 5) throw new RuntimeException("Не существует такого отдела!");
        this.departmentEmployee = departmentEmployee;
    }

    public double getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(double salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID " + id + ": " + "Ф.И.О: " + fullNameEmployee
                + " - отдел: " + departmentEmployee
                + " - зарплата: " + salaryEmployee + ".";
    }


}
