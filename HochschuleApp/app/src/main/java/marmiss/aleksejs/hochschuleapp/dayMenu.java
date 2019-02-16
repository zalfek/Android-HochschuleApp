package marmiss.aleksejs.hochschuleapp;

public class dayMenu {

    private String Tagessupe;
    private Meal GutUndGgunstig;
    private Meal PrimaKlima;
    private Meal Gourmet;
    private String day;

    public String getTagessupe() {
        return Tagessupe;
    }

    public Meal getGutUndGgunstig() {
        return GutUndGgunstig;
    }

    public Meal getPrimaKlima() {
        return PrimaKlima;
    }

    public Meal getGourmet() {
        return Gourmet;
    }

    public String getDay() {
        return day;
    }

    dayMenu(String day, String Tagessupe, Meal GutUndGgunstig, Meal PrimaKlima, Meal Gourmet){
        this.Tagessupe = Tagessupe;
        this.Gourmet = Gourmet;
        this.GutUndGgunstig = GutUndGgunstig;
        this.PrimaKlima = PrimaKlima;
        this.day = day;

    }





}
