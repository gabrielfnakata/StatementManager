package financial;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class MonthlyExpense implements Serializable {
    
    private List<BigDecimal> personalExpenses;
    private List<BigDecimal> foodExpenses;
    private List<BigDecimal> entertainmentExpenses;
    private List<BigDecimal> transportationExpenses;
    private List<BigDecimal> groceryExpenses;

    public MonthlyExpense(List<BigDecimal> personalExpenses, List<BigDecimal> foodExpenses, List<BigDecimal> entertainmentExpenses, 
    List<BigDecimal> transportationExpenses, List<BigDecimal> groceryExpenses) {
        this.personalExpenses = new ArrayList<>(personalExpenses);
        this.foodExpenses = new ArrayList<>(foodExpenses);
        this.entertainmentExpenses = new ArrayList<>(entertainmentExpenses);
        this.transportationExpenses = new ArrayList<>(transportationExpenses);
        this.groceryExpenses = new ArrayList<>(groceryExpenses);
    }

    public MonthlyExpense() {
        this.personalExpenses = new ArrayList<>();
        this.foodExpenses = new ArrayList<>();
        this.entertainmentExpenses = new ArrayList<>();
        this.transportationExpenses = new ArrayList<>();
        this.groceryExpenses = new ArrayList<>();
    }

    public List<BigDecimal> getPersonalExpenses() {
        return personalExpenses;
    }

    public void addPersonalExpenses(List<BigDecimal> p) {
        getPersonalExpenses().addAll(p);
    }

    public List<BigDecimal> getFoodExpenses() {
        return foodExpenses;
    }

    public void addFoodExpenses(List<BigDecimal> f) {
        getFoodExpenses().addAll(f);
    }

    public List<BigDecimal> getEntertainmentExpenses() {
        return entertainmentExpenses;
    }

    public void addEntertainmentExpenses(List<BigDecimal> e) {
        getEntertainmentExpenses().addAll(e);
    }

    public List<BigDecimal> getTransportationExpenses() {
        return transportationExpenses;
    }

    public void addTransportationExpenses(List<BigDecimal> t) {
        getTransportationExpenses().addAll(t);
    }

    public List<BigDecimal> getGroceryExpenses() {
        return groceryExpenses;
    }

    public void addGroceryExpenses(List<BigDecimal> g) {
        getGroceryExpenses().addAll(g);
    }
}