package marmiss.aleksejs.hochschuleapp;

public class Professor {
    private String name;
    private String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    Professor(String name, String contact){
        this.contact = contact;
        this.name = name;
    }

}

