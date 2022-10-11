
public class Main {


    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Andrey Fursov", 1, 50_000);
        employeeBook.addEmployee("Tatyana Logova", 3, 13_000);
        employeeBook.addEmployee("Sergei Morenkov", 1, 28_000);
        employeeBook.addEmployee("Svetlana Chistova", 2, 41_000);
        employeeBook.addEmployee("Ilya Lobanov", 1, 57_000);
        employeeBook.addEmployee("Evgeniya Kulik", 2, 38_000);

        System.out.println("Сотрудник с минимальной зарплатой: " + employeeBook.findMinSalaryDepartmentEmployee(1));
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeBook.findMaxSalaryDepartmentEmployee(1));
        System.out.println("Сумма затрат отдела в этом месяце составила: " + employeeBook.calculateSumSalaryDepartment(2) + " рублей.");
        System.out.println("Средняя зарплата составила: " + String.format("%.2f", employeeBook.getAverageSalaryDepartmentEmployees(3)) + " рублей.");
        employeeBook.setIndexSalaryDepartmentEmployees(6, 1);
        employeeBook.showAllDataDepartmentEmployees(3);
        employeeBook.showAllFullNameDepartmentEmployees(3);
        System.out.println("Сотрудники у которых зарплата меньше числа:");
        employeeBook.printMinSalaryAllEmployee(41_000);
        System.out.println("Сотрудники у которых зарплата больше числа:");
        employeeBook.printMaxSalaryAllEmployee(41_000);
        employeeBook.modDepartmentEmployee("Andrey Fursov", 2);
        employeeBook.modSalaryEmployee("Andrey Fursov", 51_000);
    }

}