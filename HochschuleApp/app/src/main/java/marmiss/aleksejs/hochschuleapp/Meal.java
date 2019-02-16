package marmiss.aleksejs.hochschuleapp;

public class Meal {

    private String name;
    private double price;


    Meal(String name, double price){
        this.name = name;

        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }


}
