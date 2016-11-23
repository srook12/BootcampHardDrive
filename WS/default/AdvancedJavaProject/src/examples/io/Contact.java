package examples.io;

import java.io.Serializable;

public class Contact implements Serializable{
    private String name, city, state;
    private int zip;

    public Contact(String name, String city,
            String state, int zipCode) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.zip = zipCode;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder(100);
        sb.append(name).append('\n');
        sb.append(city).append(", ").append(state);
        sb.append('\n').append(zip).append('\n');
        return sb.toString();
    }
}