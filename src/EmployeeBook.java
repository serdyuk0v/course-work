public class EmployeeBook {
    private int size;
    private final Employee[] employees = new Employee[10];


    public void addEmployee(String fullNameEmployee,
                            int departmentEmployee,
                            int salaryEmployee) {
        if (size >= employees.length) throw new RuntimeException("Книга переполнена!");
        Employee newEmployee = new Employee(fullNameEmployee, departmentEmployee, salaryEmployee);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                size++;
                break;
            }
        }
    }

    public void removeEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullNameEmployee().equals(fullName)) {
                employees[i] = null;
                size--;
                break;
            }
        }
    }

    public void modDepartmentEmployee(String fullName, int modDepartment) { //Изменить отдел сотруднику
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getFullNameEmployee().equals(fullName)) {
                employee.setDepartmentEmployee(modDepartment);
                System.out.println("У сотрудника " + fullName + " сменён отдел на: " + modDepartment);
            }
        }
    }

    public void modSalaryEmployee(String fullName, int modSalary) { //Изменить зарплату сотруднику
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getFullNameEmployee().equals(fullName)) {
                employee.setSalaryEmployee(modSalary);
                System.out.println("У сотрудника " + fullName + " изменена зарплата на: " + modSalary);
            }
        }
    }



    public void showAllDataDepartmentEmployees(int department) {     //Показать всех сотрудников отдела(все данные кроме отдела)
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getDepartmentEmployee() == department) {
                System.out.println("ID " + employee.getId() + ": " + "Ф.И.О: " + employee.getFullNameEmployee()
                        + " - зарплата: " + employee.getSalaryEmployee() + ".");
            }
        }
    }

    public void showAllFullNameDepartmentEmployees(int department) {     //Получить список Ф.И.О сотрудников отдела
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getDepartmentEmployee() == department) System.out.println(employee.getFullNameEmployee());
        }
    }

    public double calculateSumSalaryDepartment(int department) {     //Сумма затрат отдела за месяц
        double sumSalary = 0;
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");

        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getDepartmentEmployee() == department)
                sumSalary += employee.getSalaryEmployee();
        }
        return sumSalary;
    }

    public Employee findMinSalaryDepartmentEmployee(int department) {     //Вывод сотрудника отдела с минимальной зарплатой
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

    public void printMinSalaryAllEmployee(double minSalary) {     //Печатать всех сотрудников с зарплатой меньше числа
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getSalaryEmployee() < minSalary) {
                System.out.println("ID " + employee.getId() + ": " + "Ф.И.О: " + employee.getFullNameEmployee()
                        + " - зарплата: " + employee.getSalaryEmployee() + ".");
            }
        }
    }

    public Employee findMaxSalaryDepartmentEmployee(int department) {     //Вывод сотрудника отдела с максимальной зарплатой
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

    public void printMaxSalaryAllEmployee(double maxSalary) {     //Печатать всех сотрудников с зарплатой больше числа
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (employee.getSalaryEmployee() >= maxSalary) {
                System.out.println("ID " + employee.getId() + ": " + "Ф.И.О: " + employee.getFullNameEmployee()
                        + " - зарплата: " + employee.getSalaryEmployee() + ".");
            }
        }
    }

    public double getAverageSalaryDepartmentEmployees(int department) {      //Вывод среднего значения зарплат отдела
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

    public void setIndexSalaryDepartmentEmployees(double per, int department) { //Проиндексировать сотрудникам отдела зарплату
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
