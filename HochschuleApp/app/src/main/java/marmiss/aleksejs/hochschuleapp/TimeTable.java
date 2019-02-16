package marmiss.aleksejs.hochschuleapp;

public class TimeTable {
    String specialization;
    String link;
    String abbr;



    TimeTable(String specialization, String link, String abbr ){
        this.specialization = specialization;
        this.link = link;
        this.abbr = abbr;

    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getSpecialization() {
        return specialization;
    }

}
