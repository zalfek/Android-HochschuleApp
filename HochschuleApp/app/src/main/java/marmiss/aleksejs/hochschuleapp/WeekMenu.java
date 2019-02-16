package marmiss.aleksejs.hochschuleapp;

public class WeekMenu {

private static final dayMenu[] menu = {
        new dayMenu("Monday", "Italienische Gemüsesuppe",new Meal("Cevapcici mit Ajvar auf Djuvetschreis",3.00),
                new Meal("Gegrillter MaultaschenSnackriegel mit pikanter TomatenCurrysoße und Röstzwiebeln",2.50),
                new Meal("Gesottene Rinderbrust auf Bouillonkartoffeln mit Meerrettich",3.60)),
        new dayMenu("Tuesday", "Gebrannte Grießsuppe",new Meal("Glacierter Schweinerücken, Bratensoße, Bayrisch Kraut",2.60),
                new Meal("Gemüse Burger mit Barbecue Dip und wilden Kartoffeln",3.20),
                new Meal("Putenschnitzel (Halal) in Waldpilzrahmsoße",3.50)),
        new dayMenu("Wednesday", "Blumenkohlcremesuppe ",new Meal("Hähnchenkeule an Paprikasoße mit Gemüsereis",2.40),
                new Meal("Gnocchi mit Ofengemüse (Karotten, Topinambur und roten Zwiebeln)",2.20),
                new Meal("Hirschragout mit Champignons und Preiselbeerbirne",3.60)),
        new dayMenu("Thursday", "Kartoffelsuppe ",new Meal("Schollenfilet gebacken Tatarensoße",2.50),
                new Meal("Käse-Dinkelschupfnudeln mit Wirsing und Lauch",3.10),
                new Meal("Kalbsgeschnetzeltes \"Züricher Art\"",3.50)),
        new dayMenu("Friday", "Kräuterrahmsuppe",new Meal("Putenschnitzel gebacken Geflügelsoße",3.00),
                new Meal("Quorn-Lasagne mit Gemüse und Champignons in Käsesoße",2.90),
                new Meal(" ",0.00)),
};

    public dayMenu[] getMembers() { return menu;}
}
