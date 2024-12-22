import java.util.Scanner;

public class MenuForFeature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                    System.out.println("----- Manage Menu! -----");
                    break;
                case 2:
                    System.out.println("----- Manage Table! -----");
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
}
