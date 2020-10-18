package ch.schulerhome.atelier20_21.model;

import java.util.List;

public class Dictionary {
    public List<Item> items;
    public List<Question> questions;


    public Dictionary() {
    }

    public Dictionary(List<Item> items, List<Question> questions) {
        this.items = items;
        this.questions = questions;
    }
}
