import javax.swing.plaf.ToolBarUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Table> tableList = new ArrayList<Table>();
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

    // Function add table
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

        System.out.print("Add Table Available (true: available / false: unavailable): ");
        Boolean isAvailable = sc.nextBoolean();
        sc.nextLine();

        Table table = new Table(tableId, isAvailable);
        tableList.add(table);
        System.out.println("Add Table Successfully!");
    }

    // Function edit table

    /**
     * Function edit table
     * @param tableList List
     */
    public static void editTable(List <Table> tableList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Add Table ID to edit: ");
        String editId = sc.nextLine();

        boolean isAvailable = false;
        for (Table table : tableList){
            if (table.getTableId().equals(editId)){
                System.out.print("Add Status Table (true: available / false: unavailable): ");
                Boolean status = sc.nextBoolean();
                table.setAvailable(status);
                System.out.println("Edit Status Table Successfully!");
                isAvailable = true;
                break;
            }
        }
        if (!isAvailable){
            System.out.println("Error: Table ID does not exist! Please try again.");
        }
    }

    // Function display table
    /**
     * Function display table
     * @param tableList List
     */
    public static void displayTable(List<Table> tableList) {
        for (Table table : tableList) {
                System.out.println(table);
            }
            }

    // Function delete table
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

