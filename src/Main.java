import java.security.spec.ECPoint;

public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[9] = new Employee("Andrey Fursov", 1, 50_000);
        employees[0] = new Employee("Tatyana Logova", 3, 13_000);
        employees[6] = new Employee("Sergei Morenkov", 1, 28_000);
        employees[5] = new Employee("Svetlana Chistova", 2, 41_000);
        employees[2] = new Employee("Ilya Lobanov", 1, 57_000);
        employees[4] = new Employee("Evgeniya Kulik", 2, 38_000);

        System.out.println("Сотрудник с минимальной зарплатой: " + findMinSalaryDepartmentEmployee(1));
        System.out.println("Сотрудник с максимальной зарплатой: " + findMaxSalaryDepartmentEmployee(1));
        System.out.println("Сумма затрат отдела в этом месяце составила: " + calculateSumSalaryDepartment(2) + " рублей.");
        System.out.println("Средняя зарплата составила: " + String.format("%.2f", getAverageSalaryDepartmentEmployees(2)) + " рублей.");
        setIndexSalaryDepartmentEmployees(6, 1);
        showAllDataDepartmentEmployees(3);
        showAllFullNameDepartmentEmployees(3);
        System.out.println("Сотрудники у которых зарплата меньше числа:");
        printMinSalaryAllEmployee(41_000);
        System.out.println("Сотрудники у которых зарплата больше числа:");
        printMaxSalaryAllEmployee(41_000);
    }

    public static void showAllDataDepartmentEmployees(int department) {     //Показать всех сотрудников отдела(все данные кроме отдела)
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getDepartmentEmployee() == department) {
                System.out.println("ID " + employee.getId() + ": " + "Ф.И.О: " + employee.getFullNameEmployee()
                        + " - зарплата: " + employee.getSalaryEmployee() + ".");
            }
        }
    }

    public static void showAllFullNameDepartmentEmployees(int department) {     //Получить список Ф.И.О сотрудников отдела
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getDepartmentEmployee() == department) System.out.println(employee.getFullNameEmployee());
        }
    }

    public static double calculateSumSalaryDepartment(int department) {     //Сумма затрат отдела за месяц
        double sumSalary = 0;
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");

        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getDepartmentEmployee() == department)
                sumSalary += employee.getSalaryEmployee();
        }
        return sumSalary;
    }

    public static Employee findMinSalaryDepartmentEmployee(int department) {     //Вывод сотрудника отдела с минимальной зарплатой
        double minSalary = Double.MAX_VALUE;
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");
        Employee employeeMinSalary = null;

        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getSalaryEmployee() < minSalary && employee.getDepartmentEmployee() == department) {
                minSalary = employee.getSalaryEmployee();
                employeeMinSalary = employee;
            }
        }
        return employeeMinSalary;
    }
    public static void printMinSalaryAllEmployee(double minSalary) {     //Печатать всех сотрудников с зарплатой меньше числа
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getSalaryEmployee() < minSalary) {
                System.out.println("ID " + employee.getId() + ": " + "Ф.И.О: " + employee.getFullNameEmployee()
                        + " - зарплата: " + employee.getSalaryEmployee() + ".");
            }
        }
    }

    public static Employee findMaxSalaryDepartmentEmployee(int department) {     //Вывод сотрудника отдела с максимальной зарплатой
        double maxSalary = Double.MIN_VALUE;
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");
        Employee employeeMaxSalary = null;

        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getSalaryEmployee() > maxSalary && employee.getDepartmentEmployee() == department) {
                maxSalary = employee.getSalaryEmployee();
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }
    public static void printMaxSalaryAllEmployee(double maxSalary) {     //Печатать всех сотрудников с зарплатой больше числа
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getSalaryEmployee() >= maxSalary) {
                System.out.println("ID " + employee.getId() + ": " + "Ф.И.О: " + employee.getFullNameEmployee()
                        + " - зарплата: " + employee.getSalaryEmployee() + ".");
            }
        }
    }

    public static double getAverageSalaryDepartmentEmployees(int department) {      //Вывод среднего значения зарплат отдела
        int count = 0;
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");

        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getDepartmentEmployee() == department) {
                count++;
            }
        }
        double averageSumMonth = calculateSumSalaryDepartment(department) / count;
        return averageSumMonth;
    }

    public static void setIndexSalaryDepartmentEmployees(double per, int department) { //Проиндексировать сотрудникам отдела зарплату
        double indexSalary;
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");

        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getDepartmentEmployee() == department) {
                indexSalary = (employee.getSalaryEmployee() / 100) * per + employee.getSalaryEmployee();
                employee.setSalaryEmployee(indexSalary);
            }
        }
    }
}