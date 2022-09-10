import java.security.spec.ECPoint;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[9] = new Employee("Andrey", 1, 50_000);
        employees[0] = new Employee("Tanya", 3, 13_000);
        employees[6] = new Employee("Sergei", 1, 28_000);
        employees[6] = new Employee("Svetlana", 2, 41_000);


        showAllDataEmployees(employees);
        System.out.println("Сумма всех затрат на сотрудников в этом месяце составила: " + calculateSumSalary(employees) + " рублей.");
        calculateMinSalaryEmployee(employees);
        calculateMaxSalaryEmployee(employees);

        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        System.out.println("Средняя зарплата составила: " + calculateSumSalary(employees) / count + " рублей.");
        showAllFullNameEmployees(employees);


    }

    //Получить список всех сотрудников со всеми данными
    public static void showAllDataEmployees(Employee[] arr) {
        for (Employee employee : arr) {
            if (employee != null) System.out.println(employee);
        }
    }

    //Получить список Ф.И.О сотрудников
    public static void showAllFullNameEmployees(Employee[] arr) {
        for (Employee employee : arr) {
            if (employee != null) System.out.println(employee.getFullNameEmployee());
        }
    }

    //Сумма затрат зарплат за месяц
    public static double calculateSumSalary(Employee[] arr) {
        double sumSalary = 0;

        for (Employee employee : arr) {
            if (employee != null) {
                sumSalary += employee.getSalaryEmployee();
            }
        }
        return sumSalary;
    }

    //Сотрудник с минимальной зарплатой
    public static void calculateMinSalaryEmployee(Employee[] arr) {
        double minSalary = 1_000_000;
        String fullName = "";

        for (Employee employee : arr) {
            if (employee != null) {
                if (employee.getSalaryEmployee() < minSalary) {
                    minSalary = employee.getSalaryEmployee();
                    fullName = employee.getFullNameEmployee();
                }
            }
        }
        System.out.println("У сотрудника: " + fullName + " самая низкая зарплата, в размере: "+ minSalary + " рублей");
    }

    //Сотрудник с максимальной зарплатой
    public static void calculateMaxSalaryEmployee(Employee[] arr) {
        double maxSalary = 10_000;
        String fullName = "";

        for (Employee employee : arr) {
            if (employee != null) {
                if (employee.getSalaryEmployee() > maxSalary) {
                    maxSalary = employee.getSalaryEmployee();
                    fullName = employee.getFullNameEmployee();
                }
            }
        }
        System.out.println("У сотрудника: " + fullName + " самая высокая зарплата, в размере: "+ maxSalary + " рублей");
    }

}