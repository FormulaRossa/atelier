package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Answer;
import ch.schulerhome.atelier20_21.model.Item;
import ch.schulerhome.atelier20_21.model.Property;

import java.util.ArrayList;
import java.util.List;

public class ItemFilter {
    public List<Item> filter(List<Item> items, Answer answer) {
        List<Item> result = new ArrayList<>(items);
        for (Item item : items) {
            Property property = item.findPropertyByFeature(answer.feature);
            if (!(property.value.equals(answer.answer))) {
                result.remove(item);
            }
        }
        return result;
    }
}
