import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("E001", "Alice", "Manager", 1200.5));
        employeeList.add(new Employee("E002", "Bob", "Developer", 900.0));
        employeeList.add(new Employee("E003", "Charlie", "Tester", 800.0));
        employeeList.add(new Employee("E004", "Alice", "Manager", 1200.5));
        int choice;

        do {
            System.out.println("1. Add Employee");
            System.out.println("2. Edit Employee Name");
            System.out.println("3. Delete Employee");
            System.out.println("4. Show Employee list");
            System.out.println("5. Exit Program");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(employeeList);
                    break;
                case 2:
                    editEmployeeName(employeeList);
                    break;
                case 3:
                    deleteEmployee(employeeList);
                    break;
                case 4:
                    showInformation(employeeList);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again");
            }
        } while (choice != 5);
    }

    /**
     * Function: add Employee information
     * @param employeeList List<Employee> employeeList
     */
    public static void addEmployee(List<Employee> employeeList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee Information");
        System.out.println("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.println("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Employee Position: ");
        String position = sc.nextLine();

        System.out.println("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        Employee employee = new Employee(id, name, position, salary);
        employeeList.add(employee);

    }

    /**
     * Function: edit Employee name
     * @param employeeList List<Employee> employeeList
     */
    public static void editEmployeeName(List<Employee> employeeList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Name You Want To Edit: ");
        String oldName = sc.nextLine();
        boolean isFound = false;
        for (Employee employee : employeeList) {
            if (employee.getName().equals(oldName)) {
                isFound = true;
                System.out.println(employee);
            }
        }
        if (isFound) {
            System.out.println("Enter Employee ID You Want To Edit: ");
            String id = sc.nextLine();
            boolean isEdit = false;
            for (Employee employee : employeeList) {
                if (employee.getEmployeeId().equals(id)) {
                    isEdit = true;
                    System.out.println("Enter New Employee Name: ");
                    String newName = sc.nextLine();
                    employee.setName(newName);
                    break;
                }
            }
            if (!isEdit) {
                System.out.println("No Exist " + id + " In The List");
            }

        }
        if (!isFound) {
            System.out.println("No Exist " + oldName + " In The List");
        }
    }

    /**
     * Function: delete Employee information
     * @param employeeList List<Employee> employeeList
     */
    public static void deleteEmployee(List<Employee> employeeList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Name You Want To Delete: ");
        String name = sc.nextLine();
        boolean isFound = false;
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name)) {
                isFound = true;
                System.out.println(employee);
            }
        }
        if (isFound) {
            System.out.println("Enter Employee ID You Want To Delete: ");
            String id = sc.nextLine();
            boolean isDelete = false;

            for (Employee employee : employeeList) {
                if (employee.getEmployeeId().equals(id)) {
                    isDelete = true;
                    employeeList.remove(employee);
                    System.out.println(name + "'s information was successfully deleted.");
                    break;
                }
            }
            if (!isDelete) {
                System.out.println("No Exist " + id + " In The List");
            }

        }

        if (!isFound) {
            System.out.println("No Exist " + name + " In The List");
        }
    }

    /**
     * Function: show Employee information
     * @param employeeList List<Employee> employeeList
     */
    public static void showInformation(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}