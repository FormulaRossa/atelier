package ch.schulerhome.atelier20_21.model;

import java.util.Set;

public class Property {
    public String feature;
    public Set<String> value;


    public Property() {
    }

    public Property(String feature, Set value) {
        this.feature = feature;
        this.value = value;
    }
}
