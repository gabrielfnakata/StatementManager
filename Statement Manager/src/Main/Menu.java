package Main;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import financial.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Menu {
    
    private static Scanner input = new Scanner(System.in);
    private static Path road;

    public static void showFiles() {
        try {
            road = Paths.get("Statement Manager\\monthly expenses");
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(road);

            System.out.printf("%nFiles:%n");
            for(Path file : directoryStream)
                System.out.printf("- %s%n", file);   
        }
        catch(IOException ioException) {
            System.err.println("Error: " + ioException);
        }
    }

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
        MonthlyExpense monthlyExpense = new MonthlyExpense();

        System.out.printf("%nInsert your personal expenses (insert any negative number to exit):");
        monthlyExpense.addPersonalExpenses(requestExpense());

        System.out.printf("%nInsert your food expenses (insert any negative number to exit):");
        monthlyExpense.addFoodExpenses(requestExpense());

        System.out.printf("%nInsert your entertainment expenses (insert any negative number to exit):");
        monthlyExpense.addEntertainmentExpenses(requestExpense());

        System.out.printf("%nInsert your transportation expenses (insert any negative number to exit):");
        monthlyExpense.addTransportationExpenses(requestExpense());

        System.out.printf("%nInsert your grocery expenses (insert any negative number to exit):");
        monthlyExpense.addGroceryExpenses(requestExpense());
        
        showFiles();
        do {
            System.out.printf("Insert a file name: ");
            road = Paths.get("Statement Manager\\monthly expenses\\" + input.nextLine());
        } while(!Files.exists(road));
        
        WriteFile.writeFile(null, null);
    }

    public static List<BigDecimal> requestExpense() {
        BigDecimal option = BigDecimal.ONE;
        List<BigDecimal> list = new ArrayList<>();

        while(option.compareTo(BigDecimal.ZERO) >= 0) {
            try {
                System.out.print("\n? ");
                option = input.nextBigDecimal();
                if(option.compareTo(BigDecimal.ZERO) > 0)
                    list.add(option);
            }
            catch(InputMismatchException inputMismatchException) {
                System.err.println("Error: " + inputMismatchException);
                input.nextLine();
            }
            catch(NoSuchElementException elementException) {
                System.err.println("Invalid input. Please, try again.");
                input.nextLine();
            }
        }

        return list;
    }
}