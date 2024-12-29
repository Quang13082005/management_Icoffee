import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Table> tableList = new ArrayList<Table>();

        tableList.add(new Table("T001", true, 20.5, 4));
        tableList.add(new Table("T002", false, 15.0, 2));
        tableList.add(new Table("T003", true, 30.0, 6));
        tableList.add(new Table("T004", true, 25.0, 5));
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
            }else{
            System.out.println("Please add 1 or 2!");
        }
    }
        Table table = new Table (tableId, isAvailable, price, availableSlot);
        tableList.add(table);
        System.out.println("Add Table Successfully!");
    }
    /**
     * Function edit table
     * @param tableList List
     */
    public static void editTable(List <Table> tableList) {
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
        if (!isAvailable){
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
        } else{
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
            if (table.getTableId().equals(deleteId)){
                tableList.remove(table);
                System.out.println("Delete Table Successfully!");
                isAvailable = true;
                break;
            }
        }
        if (!isAvailable){
            System.out.println("Error: Table ID does not exist! Please try again.");
        }
    }
}

