# **About this Project**

This program receives values from your receipts or bank statements and stores them in files.

## **Project Structure**

This project has 4 classes:

### **MonthlyExpense**

This class has 5 lists that store values for different expenses:

1. Personal Expenses;
2. Food Expenses;
3. Entertainment Expenses;
4. Transportation Expenses;
5. Grocery Expenses.

### **WriteFile**

This class requests a file name, creates it, instantiates a *MonthlyExpense* and stores its values in the created file.

### **ReadFile**

This class gets the content of a file - a *MonthlyExpense* object - chosen by the user and returns it.

### **Menu**

Main class responsible for displaying a menu that manages 3 options:

- Register new finance;
- Read existing finance;
- Exit.

## **Libraries**

### **Class MonthlyExpense**

```java
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
```

### **Class WriteFile**

```java
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
```

### **Class ReadFile**

```java
import java.io.EOFException;  
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
```

### **Class Menu**

```java
import financial.*;
import java.util.Scanner;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.NoSuchElementException;
```

### **How Does It Work?**

Firstly, the user chooses between either registering or reading a finance file or exiting. 

If the first option is chosen, a file name is requested, and 5 loops are initiated, one at a time, where the user is able to input their expenses.

If the second one is chosen, a list that contains the files in the *monthly expenses* directory is displayed. Then, the user may choose a file to have its contents returned.

## **Functions**

- **showFiles()**: This functions shows the files inside the *monthly expenses* directory;
- **showMenu()**: This functions displays a menu for the user;
- **requestInput()**: Function that requests an int option for the menu and catches possible erros;
- **readingExistingFile()**: This function shows the values of an object from the chosen file;
- **writeFile()**: Function that requests values for storing them in a file;
- **requestExpense()**: Facilitating function for storing values in Lists;
- **readFile()**: Function that opens a file and return the object inside it.
