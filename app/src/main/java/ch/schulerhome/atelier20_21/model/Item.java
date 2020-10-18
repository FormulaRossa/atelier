package ch.schulerhome.atelier20_21.model;

import java.util.List;

public class Item {
    public String name;
    public List<Property> properties;


    public Item() {
    }
    public Item(String name, List<Property> properties){
        this.name = name;
        this.properties = properties;
    }
}
