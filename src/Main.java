import java.security.spec.ECPoint;

public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[9] = new Employee("Andrey Fursov", 1, 50_000);
        employees[0] = new Employee("Tatyana Logova", 3, 13_000);
        employees[6] = new Employee("Sergei Morenkov", 1, 28_000);
        employees[5] = new Employee("Svetlana Chistova", 2, 41_000);


        showAllDataEmployees();
        System.out.println("Сумма всех затрат на сотрудников в этом месяце составила: " + calculateSumSalary() + " рублей.");
        System.out.println("Сотрудник с минимальной зарплатой: " + findMinSalaryEmployee());
        System.out.println("Сотрудник с максимальной зарплатой: " + findMaxSalaryEmployee());
        System.out.println("Средняя зарплата составила: " + String.format("%.2f", getAverageSalaryEmployees()) + " рублей.");
        showAllFullNameEmployees();


    }

    public static void showAllDataEmployees() {     //Получить список всех сотрудников со всеми данными
        for (Employee employee : employees) {
            if (employee == null) continue;
            System.out.println(employee);
        }
    }

    public static void showAllFullNameEmployees() {     //Получить список Ф.И.О сотрудников
        for (Employee employee : employees) {
            if (employee == null) continue;
            System.out.println(employee.getFullNameEmployee());
        }
    }

    public static double calculateSumSalary() {     //Сумма затрат зарплат за месяц
        double sumSalary = 0;

        for (Employee employee : employees) {
            if (employee == null) continue;
            sumSalary += employee.getSalaryEmployee();
        }
        return sumSalary;
    }

    public static Employee findMinSalaryEmployee() {     //Вывод сотрудника с минимальной зарплатой
        double minSalary = Double.MAX_VALUE;
        Employee employeeMinSalary = null;

        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getSalaryEmployee() < minSalary) {
                minSalary = employee.getSalaryEmployee();
                employeeMinSalary = employee;
            }
        }
        return employeeMinSalary;
    }

    public static Employee findMaxSalaryEmployee() {     //Вывод сотрудника с максимальной зарплатой
        double maxSalary = Double.MIN_VALUE;
        Employee employeeMaxSalary = null;

        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getSalaryEmployee() > maxSalary) {
                maxSalary = employee.getSalaryEmployee();
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }

    public static double getAverageSalaryEmployees() {      //Вывод среднего значения зарплат
        int count = 0;
        for (Employee employee : employees) {
            if (employee == null) continue;
            count++;
        }
        double averageSumMonth = calculateSumSalary() / count;
        return averageSumMonth;
    }

}