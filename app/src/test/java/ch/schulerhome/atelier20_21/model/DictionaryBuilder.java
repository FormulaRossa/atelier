package ch.schulerhome.atelier20_21.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DictionaryBuilder {

    public static Dictionary givenDictionary() {
        List<Question> questions = givenQuestions();
        List<Item> items = givenItems();

        return new Dictionary(items, questions);
    }

    public static List<Item> givenItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Banane", propertiesOf("color", "Gelb", "peel", "Nein")));
        items.add(new Item("Orange", propertiesOf("color", "Orange", "peel", "Nein")));
        items.add(new Item("Aprikose", propertiesOf("color", "Orange", "peel", "Ja")));
        items.add(new Item("Ananas", propertiesOf("color", "Braun", "peel", "Nein")));
        return items;
    }


    private static List<Property> propertiesOf(String... names) {
        List<Property> properties = new ArrayList<>();
        for (int i = 0; i < names.length; i += 2) {
            Set<String> values = new HashSet();
            values.add(names[i + 1]);
            properties.add(new Property(names[i], values));
        }
        return properties;
    }

    public static List<Question> givenQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Ist die Schale der Frucht essbar?", "peel"));
        questions.add(new Question("Welche Farbe hat die Frucht?", "color"));
        return questions;
    }
}
