package financial;

import java.util.Scanner;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException; 
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class WriteFile {

    private static ObjectOutputStream output;
    private static Scanner input = new Scanner(System.in);
    private static Path path;

    public static void writeFile() {
        MonthlyExpense monthlyExpense = new MonthlyExpense();

        do {
            System.out.print("\nInsert a file name: ");
            String fileName = input.nextLine();
            path = Paths.get("monthly expenses\\" + fileName + ".ser");
            
            try {
                output = new ObjectOutputStream(Files.newOutputStream(path));
            }
            catch(IOException ioException) {
                System.err.println("Error: " + ioException);
                System.exit(1);
            }
        } while(!Files.exists(path));
        
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

        try {
            output.writeObject(monthlyExpense);
        }
        catch(IOException ioException) {
            System.err.println("Error: " + ioException);
            System.exit(1);
        }

        try {
            if(output != null)
                output.close();
        }
        catch(IOException ioException) {
            System.err.println("Error: " + ioException);
        }
    }

    public static List<BigDecimal> requestExpense() {
        BigDecimal option = BigDecimal.ONE;
        List<BigDecimal> list = new ArrayList<>();

        while(option.compareTo(BigDecimal.ZERO) >= 0) {
            try {
                System.out.print("\n? ");
                option = input.nextBigDecimal();
                input.nextLine();
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