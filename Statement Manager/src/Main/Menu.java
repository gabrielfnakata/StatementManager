package Main;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    
    private static Scanner input = new Scanner(System.in);

    public static void showMenu() {
        System.out.printf("%n%s%n%s%n%s%n%s%n? ",
        "-/-/-/-/-/-/-/-/-/-/-/-/MENU-/-/-/-/-/-/-/-/-/-/-/-/",
        "1 - Register new finance",
        "2 - Read existing finance",
        "3 - Exit");
    }

    public static int requestInput() {
        int option = 0;
        
        while(option < 1 || option > 3) {

            try {
                option = input.nextInt();
            }
            catch(NoSuchElementException elementException) {
                System.err.println("Invalid input. Please, try again.");
                input.nextLine();
            }
        }

        return option;
    }

    public static void registerFinance() {
        
    }
}
