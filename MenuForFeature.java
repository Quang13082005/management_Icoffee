import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuForFeature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
}


