package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Answer;
import ch.schulerhome.atelier20_21.model.Item;
import ch.schulerhome.atelier20_21.model.Property;
import ch.schulerhome.atelier20_21.model.Question;

public class ItemResponder implements Responder {

    Item item;

    public ItemResponder(Item item) {
        this.item = item;
    }

    @Override
    public Answer answer(Question question) {
        Property property = item.findPropertyByFeature(question.feature);
        return new Answer(property.value, property.feature);
    }
}
