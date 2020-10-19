package ch.schulerhome.atelier20_21.model;

import java.security.Policy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DictionaryBuilder {

    public static Dictionary givenDictionary() {
        List<Question> questions = givenQuestions();
        List<Item> items = givenItems();

        return new Dictionary(items, questions);
    }

    private static List<Item> givenItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Banane", propertiesOf("color", "Gelb", "peel", "Nein")));
        items.add(new Item("Orange", propertiesOf("color", "Orange", "peel", "Nein")));
        return items;
    }


    private static List<Property> propertiesOf(String... names) {
        List<Property> properties = new ArrayList<>();
        for (int i = 0; i < names.length; i += 2) {
            properties.add(new Property(names[i], names[i + 1]));
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
