package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Answer;
import ch.schulerhome.atelier20_21.model.Item;
import ch.schulerhome.atelier20_21.model.Property;
import ch.schulerhome.atelier20_21.model.Question;

import java.util.List;

public class ItemResponder implements Responder {

    Item item;

    public ItemResponder(Item item) {
        this.item = item;
    }

    @Override
    public void answer(Question question, List<Item> candidates, ResponderCallback callback) {
        System.out.println("-----------------------------");
        System.out.println("Question: " + question.question);
        Property property = item.findPropertyByFeature(question.feature);
        System.out.println("Answer: " + property.value);
        callback.select(new Answer(property.value.iterator().next(), property.feature));
    }
}
