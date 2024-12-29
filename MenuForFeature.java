import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuForFeature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();
        List<Menu> menuList = new ArrayList<Menu>();
        List<Table> tableList = new ArrayList<Table>();

        int choice;
        do {
            System.out.println("----- I Coffee Management -----");
            System.out.println("1. Manage Menu");
            System.out.println("2. Manage Table");
            System.out.println("3. Manage Employee");
            System.out.println("4. Create Bill");
            System.out.println("5. Calculate Revenue");
            System.out.println("6. Exit Program");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("------------------------");
                    commonMenu(menuList);
                    break;
                case 2:
                    System.out.println("------------------------");
                    commonTable(tableList);
                    break;
                case 3:
                    System.out.println("----- Manage Employee! -----");
                    manageMenuEmployee(employeeList);
                    break;
                case 4:
                    System.out.println("----- Create Bill! -----");
                    break;
                case 5:
                    System.out.println("----- Calculate Revenue! -----");
                    break;
                case 6:
                    System.out.println("----- Exit Program! -----");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
                    break;
            }
        } while (choice != 6);
    }

    /**
     * Function add menu
     *
     * @param menuList List
     */
    public static void addMenu(List<Menu> menuList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please add id: ");
        String id = sc.nextLine();

        for (Menu menu : menuList) {
            if (menu.getId().equals(id)) {
                System.out.println("Id already exists! Please try again!");
                return;
            }
        }
        System.out.print("Please add name: ");
        String name = sc.nextLine();
        double price = -1;
        while (price <= 0) {
            System.out.print("Please add price: ");
            price = sc.nextDouble();
            if (price <= 0) {
                System.out.println("Price must be positive number!");
            }
        }
        sc.nextLine();
        System.out.print("Please add description: ");
        String description = sc.nextLine();
        System.out.print("Please add category: ");
        String category = sc.nextLine();

        Menu menu = new Menu(id, name, price, description, category);
        menuList.add(menu);
        System.out.println("Menu added successfully.");

    }

    /**
     * Function edit menu
     *
     * @param oldname  String
     * @param oldprice String
     * @param menuList List
     */
    public static void editMenu(String oldname, double oldprice, List<Menu> menuList) {
        Scanner sc = new Scanner(System.in);
        boolean isFound = false;
        for (Menu menu : menuList) {
            if (menu.getName().equalsIgnoreCase(oldname) && menu.getPrice() == oldprice) {
                isFound = true;
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                menu.setName(newName);
                double newPrice = -1;
                while (newPrice <= 0) {
                    System.out.print("Enter new price: ");
                    newPrice = sc.nextDouble();
                    menu.setPrice(newPrice);
                    if (newPrice <= 0) {
                        System.out.println("Error: Price must be positive number!");
                    }
                }
                System.out.println("Edit menu successfully.");
            }
        }
        if (!isFound) {
            System.out.println("Name of the menu not found!");
        }
    }

    /**
     * Function Delete Menu By Id
     *
     * @param menuList List
     */
    public static void deleteMenuById(List<Menu> menuList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Add a name you want to delete: ");
        String nameDelete = sc.nextLine();
        boolean isFound = false;
        for (Menu menu : menuList) {
            if (menu.getName().equalsIgnoreCase(nameDelete)) {
                isFound = true;
                System.out.println(menu);
            }
        }
        if (isFound) {
            System.out.print("Add id you want to delete: ");
            String idDelete = sc.nextLine();
            boolean isDelete = false;

            for (Menu menu : menuList) {
                if (menu.getId().equals(idDelete)) {
                    isDelete = true;
                    menuList.remove(menu);
                    System.out.println("Deleted id " + idDelete + " successfully.");
                    break;
                }
            }
            if (!isDelete) {
                System.out.println(idDelete + " not found in menu list.");
            }
        }

        if (!isFound) {
            System.out.println("Name of the menu not found!");
        }
    }

    /**
     * Function Show menu
     *
     * @param menuList List
     */
    public static void showMenu(List<Menu> menuList) {
        if (menuList.isEmpty()) {
            System.out.println("Menu is empty!");
        } else {
            for (Menu menu : menuList) {
                System.out.println(menu);
            }
        }
    }

    /**
     * Function Search menu by name
     *
     * @param menuList List
     */
    public static void searchMenuByNameOrPrice(List<Menu> menuList) {
        Scanner sc = new Scanner(System.in);
        List<Menu> menuSearch = new ArrayList<>();
        System.out.print("Please enter the name of the menu to search: ");
        String nameSearch = sc.nextLine();
        boolean isFound = false;
        for (Menu menu : menuList) {
            if (menu.getName().equalsIgnoreCase(nameSearch)) {
                System.out.println(menu);
                menuSearch.add(menu);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Name of the menu not found!");
        }
    }

    /**
     * Function add table
     *
     * @param tableList List
     */
    public static void addTable(List<Table> tableList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Add Table ID: ");
        String tableId = sc.nextLine();

        for (Table table : tableList) {
            if (table.getTableId().equals(tableId)) {
                System.out.println("Error: Table ID already exists! Please use a different ID.");
                return;
            }
        }

        double price = -1;
        while (price <= 0) {
            System.out.print("Enter Table Price: ");
            price = sc.nextDouble();
            if (price <= 0) {
                System.out.println("Error: Price must be a positive number.");
            }
        }
        sc.nextLine();
        int availableSlot = -1;
        while (availableSlot <= 0) {
            System.out.print("Add Table Available Slot: ");
            availableSlot = sc.nextInt();
            if (availableSlot <= 0) {
                System.out.println("Error: Available slot must be a positive number.");
            }
        }
        sc.nextLine();
        boolean isAvailable = false;
        while (true) {
            System.out.print("Add Table Available (1-Available / 2-Unavailable): ");
            int input = sc.nextInt();

            if (input == 1) {
                isAvailable = true;
                break;
            } else if (input == 2) {
                isAvailable = false;
                break;
            } else {
                System.out.println("Please add 1 or 2!");
            }
        }
        Table table = new Table(tableId, isAvailable, price, availableSlot);
        tableList.add(table);
        System.out.println("Add Table Successfully!");
    }

    /**
     * Function edit table
     *
     * @param tableList List
     */
    public static void editTable(List<Table> tableList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Add Table ID to edit: ");
        String editId = sc.nextLine();

        boolean isAvailable = false;
        for (Table table : tableList) {
            if (table.getTableId().equals(editId)) {
                boolean status = false;
                while (true) {
                    System.out.print("Add New Status Table (1-Available / 2-Unavailable): ");
                    int input = sc.nextInt();
                    if (input == 1) {
                        status = true;
                        break;
                    } else if (input == 2) {
                        status = false;
                        break;
                    } else {
                        System.out.println("Please add 1 or 2!");
                    }
                }
                table.setAvailable(status);
                isAvailable = true;

                double price = -1;
                while (price <= 0) {
                    System.out.print("Add New Price to edit: ");
                    price = sc.nextDouble();
                    table.setPrice(price);
                    if (price <= 0) {
                        System.out.println("Error: Price must be a positive number.");
                    }
                }
                int availableSlot = -1;
                while (availableSlot <= 0) {
                    System.out.print("Add New Available Slot: ");
                    availableSlot = sc.nextInt();
                    table.setAvailableSlot(availableSlot);
                    if (availableSlot <= 0) {
                        System.out.println("Error: Available slot must be a positive number.");
                    }
                }
                System.out.println("Edit Table Successfully!");
            }
        }
        if (!isAvailable) {
            System.out.println("Error: Table ID does not exist! Please try again.");
        }
    }

    /**
     * Function display table
     *
     * @param tableList List
     */
    public static void displayTable(List<Table> tableList) {
        if (tableList.isEmpty()) {
            System.out.println("Nothing to Display!");
        } else {
            for (Table table : tableList) {
                System.out.println(table);
            }
        }
    }

    /**
     * Function delete table
     *
     * @param tableList List
     */
    public static void deleteTable(List<Table> tableList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Add Table ID to delete: ");
        String deleteId = sc.nextLine();

        boolean isAvailable = false;
        for (Table table : tableList) {
            if (table.getTableId().equals(deleteId)) {
                tableList.remove(table);
                System.out.println("Delete Table Successfully!");
                isAvailable = true;
                break;
            }
        }
        if (!isAvailable) {
            System.out.println("Error: Table ID does not exist! Please try again.");
        }
    }

    /**
     * Create common Function for Menu management
     *
     * @param menuList List
     */
    public static void commonMenu(List<Menu> menuList) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- Manage Menu -----");
            System.out.println("1. Add new menu");
            System.out.println("2. Edit menu");
            System.out.println("3. Delete menu");
            System.out.println("4. Show menu");
            System.out.println("5. Search menu by name");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("----- Add menu -----");
                    addMenu(menuList);
                    break;
                case 2:
                    System.out.println("----- Edit menu -----");
                    showMenu(menuList);
                    System.out.print("Please enter the name of the menu to edit: ");
                    String oldname = sc.nextLine();
                    System.out.print("Please enter the price of the menu to edit: ");
                    double oldprice = sc.nextDouble();
                    editMenu(oldname, oldprice, menuList);
                    break;
                case 3:
                    System.out.println("----- Delete menu -----");
                    showMenu(menuList);
                    deleteMenuById(menuList);
                    break;
                case 4:
                    System.out.println("----- Show menu -----");
                    showMenu(menuList);
                    break;
                case 5:
                    System.out.println("----- Search menu by name -----");
                    searchMenuByNameOrPrice(menuList);
                    break;
                case 6:
                    System.out.println("----- Exit -----");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
                    break;
            }
        } while (choice != 6);
    }

    /**
     * Create common function for Table management
     *
     * @param tableList List
     */
    public static void commonTable(List<Table> tableList) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- Manage Table -----");
            System.out.println("1. Add Table");
            System.out.println("2. Edit Table");
            System.out.println("3. Delete Table");
            System.out.println("4. Display Table");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("----- Add Table -----");
                    addTable(tableList);
                    break;
                case 2:
                    System.out.println("----- Edit Table -----");
                    displayTable(tableList);
                    editTable(tableList);
                    break;
                case 3:
                    System.out.println("----- Delete Table -----");
                    deleteTable(tableList);
                    break;
                case 4:
                    System.out.println("----- Display Table -----");
                    displayTable(tableList);
                    break;
                case 5:
                    System.out.println("----- Exit -----");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }


        } while (choice != 5);
    }

    /**
     * Function: common to manage Menu Employee
     *
     * @param employeeList List<Employee>
     */

    public static void manageMenuEmployee(List<Employee> employeeList) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Employee");
            System.out.println("2. Edit Employee Name");
            System.out.println("3. Delete Employee");
            System.out.println("4. Show Employee list");
            System.out.println("5. Exit Program");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(employeeList);
                    break;
                case 2:
                    showInformation(employeeList);
                    editEmployeeName(employeeList);
                    break;
                case 3:
                    showInformation(employeeList);
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
     *
     * @param employeeList List<Employee> employeeList
     */
    public static void addEmployee(List<Employee> employeeList) {
        Scanner sc = new Scanner(System.in);
        boolean isIDValid = false;

        System.out.println("Enter Employee Information");
        String id = null;
        Pattern ID = Pattern.compile("^[A-Z]{2}\\d{6}$");
        while (!isIDValid) {
            boolean isFound = false;
            System.out.print("Enter Employee ID: ");
            id = sc.nextLine();
            if (ID.matcher(id).matches()) {
                for (Employee employee : employeeList) {
                    if (employee.getEmployeeId().equals(id)) {
                        isFound = true;
                        System.out.println("This " + id + " already exists in the list, please try again");
                        break;
                    }
                }
                if (!isFound) {
                    isIDValid = true;
                }
            } else {
                System.out.println("Invalid input ID. Please use the format: 2 uppercase letters followed by 6 digits.");
                System.out.println("Example: DE201453");
            }
        }

        String name = null;
        Pattern Name = Pattern.compile("^([A-Z][a-z]+)(\\s[A-Z][a-z]+)*$");
        boolean isNameValid = false;
        while (!isNameValid) {
            System.out.print("Enter Employee Name: ");
            name = sc.nextLine();
            if (!Name.matcher(name).matches()) {
                System.out.println("Invalid format name. Please capitalize the first letter.");
                System.out.println("Example: Nguyen Hai Quang");
            } else {
                isNameValid = true;
            }
        }

        System.out.print("Enter Employee Position: ");
        String position = sc.nextLine();

        double salary;
        do {
            System.out.println("Enter Employee Salary: ");
            salary = sc.nextDouble();
            if (salary < 0) {
                System.out.println("Error: Price must be positive number!");
            } else {
                Employee employee = new Employee(id, name, position, salary);
                employeeList.add(employee);
                System.out.println(name + "'s information has been added successfully.");
            }
        } while (salary < 0);

    }

    /**
     * Function: edit Employee name
     *
     * @param employeeList List<Employee> employeeList
     */
    public static void editEmployeeName(List<Employee> employeeList) {
        Scanner sc = new Scanner(System.in);
        List<Employee> sameName = new ArrayList<>();
        System.out.print("Enter Employee Name You Want To Edit: ");
        String oldName = sc.nextLine();
        boolean isFound = false;
        for (Employee employee : employeeList) {
            if (employee.getName().equals(oldName)) {
                isFound = true;
                System.out.println(employee);
                sameName.add(employee);
            }
        }
        if (isFound) {
            System.out.print("Enter Employee ID You Want To Edit: ");
            String id = sc.nextLine();
            boolean isEdit = false;
            for (Employee employee : sameName) {
                if (employee.getEmployeeId().equals(id)) {
                    isEdit = true;
                    System.out.print("Enter New Employee Name: ");
                    String newName = sc.nextLine();
                    employee.setName(newName);
                    System.out.println("Edited successfully");
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
     *
     * @param employeeList List<Employee> employeeList
     */
    public static void deleteEmployee(List<Employee> employeeList) {
        Scanner sc = new Scanner(System.in);
        List<Employee> sameName = new ArrayList<>();
        System.out.print("Enter Employee Name You Want To Delete: ");
        String name = sc.nextLine();
        boolean isFound = false;
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name)) {
                isFound = true;
                System.out.println(employee);
                sameName.add(employee);
            }
        }
        if (isFound) {
            System.out.print("Enter Employee ID You Want To Delete: ");
            String id = sc.nextLine();
            boolean isDelete = false;

            for (Employee employee : sameName) {
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
     *
     * @param employeeList List<Employee> employeeList
     */
    public static void showInformation(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}





