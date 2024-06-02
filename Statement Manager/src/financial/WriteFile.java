package financial;

import java.io.IOException; 
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteFile {

    public static void writeFile(String path, MonthlyExpense monthlyExpense) {
        try(ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)))) {
            output.writeObject(monthlyExpense);
        }
        catch(IOException ioException) {
            System.err.println("Error: " + ioException);
            System.exit(1);
        }
    }
}