package financial;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class MonthlyExpense implements Serializable {
    
    private List<BigDecimal> personalExpenses;
    private List<BigDecimal> foodExpenses;
    private List<BigDecimal> entertainmentExpenses;
    private List<BigDecimal> transportationExpenses;
    private List<BigDecimal> groceryExpenses;

    public MonthlyExpense(List<BigDecimal> personalExpenses, List<BigDecimal> foodExpenses, List<BigDecimal> entertainmentExpenses, 
    List<BigDecimal> transportationExpenses, List<BigDecimal> groceryExpenses) {
        this.personalExpenses = new ArrayList<>();
        this.foodExpenses = new ArrayList<>();
        this.entertainmentExpenses = new ArrayList<>();
        this.transportationExpenses = new ArrayList<>();
        this.groceryExpenses = new ArrayList<>();
    }

    public List<BigDecimal> getPersonalExpenses() {
        return personalExpenses;
    }

    public void addPersonalExpenses(BigDecimal p) {
        getPersonalExpenses().add(p);
    }

    public List<BigDecimal> getFoodExpenses() {
        return foodExpenses;
    }

    public void addFoodExpenses(BigDecimal f) {
        getFoodExpenses().add(f);
    }

    public List<BigDecimal> getEntertainmentExpenses() {
        return entertainmentExpenses;
    }

    public void addEntertainmentExpenses(BigDecimal e) {
        getEntertainmentExpenses().add(e);
    }

    public List<BigDecimal> getTransportationExpenses() {
        return transportationExpenses;
    }

    public void addTransportationExpenses(BigDecimal t) {
        getTransportationExpenses().add(t);
    }

    public List<BigDecimal> getGroceryExpenses() {
        return groceryExpenses;
    }

    public void addGroceryExpenses(BigDecimal g) {
        getGroceryExpenses().add(g);
    }
}