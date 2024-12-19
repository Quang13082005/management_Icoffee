import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Menu> menuList = new ArrayList<Menu>();
        menuList.add(new Menu("1", "Pizza Hải Sản", 120000.0, "Pizza với hải sản tươi ngon, phô mai tan chảy.", "Pizza"));
        menuList.add(new Menu("2", "Mì Ý Sốt Kem", 90000.0, "Mì Ý truyền thống với sốt kem béo ngậy và thịt xông khói.", "Món Ý"));
        menuList.add(new Menu("3", "Salad Rau Xanh", 50000.0, "Rau xanh tươi mát với sốt dầu giấm chua ngọt.", "Món Khai Vị"));
        menuList.add(new Menu("4", "Burger Gà", 75000.0, "Bánh burger nhân gà nướng, rau xà lách và sốt đặc biệt.", "Burger"));
        menuList.add(new Menu("5", "Khoai Tây Chiên", 30000.0, "Khoai tây chiên giòn, kèm sốt cà chua.", "Món Ăn Kèm"));
        int choice;
        /**
         * Create Menu to Manage
         */
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
                    System.out.print("Please enter the name of the menu to edit: ");
                    String oldname = sc.nextLine();
                    System.out.print("Please enter the price of the menu to edit: ");
                    double oldprice = sc.nextDouble();
                    editMenu(oldname, oldprice, menuList);
                    break;
                case 3:
                    System.out.println("----- Delete menu -----");
                    showMenu(menuList);
                    System.out.print("Please enter the name of the menu to delete: ");
                    String nameDelete = sc.nextLine();
                    deleteMenu(nameDelete, menuList);
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

    // Function add menu
    /**
     * Function add menu
     * @param menuList List
     */
    public static void addMenu(List<Menu> menuList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please add id: ");
        String id = sc.nextLine();
        System.out.print("Please add name: ");
        String name = sc.nextLine();
        System.out.print("Please add price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Please add description: ");
        String description = sc.nextLine();
        System.out.print("Please add category: ");
        String category = sc.nextLine();

        Menu menu = new Menu(id, name, price, description, category);
        menuList.add(menu);
        System.out.println("Menu added successfully.");

    }

    // Function edit menu
    /**
     * Function edit menu
     * @param oldname String
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
                System.out.print("Enter new price: ");
                double newPrice = sc.nextDouble();
                menu.setPrice(newPrice);
                System.out.println("Edit menu successfully.");
            }
        }
        if (!isFound) {
            System.out.println("Name of the menu not found!");
        }
    }

    // Function Delete Menu
    /**
     * Function Delete Menu
     * @param nameDelete String
     * @param menuList List
     */
    public static void deleteMenu(String nameDelete, List<Menu> menuList) {
        boolean isFound = false;
        for (Menu menu : menuList) {
            if (menu.getName().equalsIgnoreCase(nameDelete)) {
                isFound = true;
                menuList.remove(menu);
                System.out.println("Name of the menu deleted successfully.");
                break;
            }
        }
        if (!isFound) {
            System.out.println("Name of the menu not found!");
        }
    }

    // Function Show menu
    /**
     * Function Show menu
     * @param menuList List
     */
    public static void showMenu(List<Menu> menuList) {
        if (menuList.isEmpty()) {
            System.out.println("Menu is empty!");
        }
        else {
            for (Menu menu : menuList) {
                System.out.println(menu);
            }
        }
    }

    // Function Search menu by name
    /**
     * Function Search menu by name
     * @param menuList List
     */
    public static void searchMenuByNameOrPrice (List<Menu> menuList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the name of the menu to search: ");
        String nameSearch = sc.nextLine();
        boolean isFound = false;
        for (Menu menu : menuList) {
            if (menu.getName().equalsIgnoreCase(nameSearch)) {
                System.out.println(menu);
                isFound = true;
                break;
            }
        }
        if(!isFound) {
            System.out.println("Name of the menu not found!");
        }
    }
}


