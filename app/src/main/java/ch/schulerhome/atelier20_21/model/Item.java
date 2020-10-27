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

    public Property findPropertyByFeature(String feature) {
        for (Property property : properties) {
            if (property.feature.equals(feature)) {
                return property;
            }
        }
        return null;
    }
}
