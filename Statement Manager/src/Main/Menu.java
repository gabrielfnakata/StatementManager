package Main;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import financial.*;
import java.math.BigDecimal;

public class Menu {
    
    private static Scanner input = new Scanner(System.in);
    private static Path road;

    public static void main(String[] args) {
        int option = 0;

        while(option != 3) {
            showMenu();
            option = requestInput();

            switch(option) {
                case 1:
                showFiles();
                WriteFile.writeFile();
                break;
                case 2:
                showFiles();
                readingExistingFile();
                break;
                default:
                System.out.printf("%n%s", (option == 3) ? "Closing program." : "Insert a valid input.");
            }
        }
    }

    public static void showFiles() {
        road = Paths.get("monthly expenses");
        
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(road)) {
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
                input.nextLine();
            }
            catch(NoSuchElementException elementException) {
                System.err.println("Invalid input. Please, try again.");
                input.nextLine();
            }
        }

        return option;
    }

    public static void readingExistingFile() {
        BigDecimal totalValue = BigDecimal.ZERO;
        
        showFiles();
        do {
            System.out.printf("Insert a file name: ");
            String fileName = input.nextLine();
            road = Paths.get("monthly expenses\\" + fileName + ".ser");
        } while(!Files.exists(road));

        MonthlyExpense monthlyExpense = ReadFile.readFile(road);
        
        System.out.print("\nPersonal Expenses:\n");
        for(BigDecimal value : monthlyExpense.getPersonalExpenses()) {
            System.out.printf("- %.2f%n", value);
            totalValue = totalValue.add(value);
        }
        
        System.out.print("\nFood Expenses:\n");
        for(BigDecimal value : monthlyExpense.getFoodExpenses()) {
            System.out.printf("- %.2f%n", value);
            totalValue = totalValue.add(value);
        }

        System.out.print("\nEntertainment Expenses:\n");
        for(BigDecimal value : monthlyExpense.getEntertainmentExpenses()) {
            System.out.printf("- %.2f%n", value);
            totalValue = totalValue.add(value);
        }

        System.out.print("\nTransportation Expenses:\n");
        for(BigDecimal value : monthlyExpense.getTransportationExpenses()) {
            System.out.printf("- %.2f%n", value);
            totalValue = totalValue.add(value);
        }

        System.out.print("\nGrocery Expenses:\n");
        for(BigDecimal value : monthlyExpense.getGroceryExpenses()) {
            System.out.printf("- %.2f%n", value);
            totalValue = totalValue.add(value);
        }
        
        System.out.printf("%nTotal Expenses: %.2f", totalValue);
    }
}