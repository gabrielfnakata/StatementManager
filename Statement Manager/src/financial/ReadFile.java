package financial;

import java.io.EOFException;  
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {
    
    public static MonthlyExpense readFile(String path) {
        MonthlyExpense monthlyExpense = null;
        
        try(ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(path)))) {
            monthlyExpense = (MonthlyExpense) input.readObject();
        }
        catch(EOFException endOfFileException) {
            System.err.println("Error: " + endOfFileException);
        }
        catch(ClassNotFoundException classNotFoundException) {
            System.err.println("Error: " + classNotFoundException);
        }
        catch(IOException ioException) {
            System.err.println("Error: " + ioException);
            System.exit(1);
        }
        
        return monthlyExpense;
    }
}