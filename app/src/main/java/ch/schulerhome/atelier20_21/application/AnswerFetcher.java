package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Item;
import ch.schulerhome.atelier20_21.model.Property;
import ch.schulerhome.atelier20_21.model.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public class AnswerFetcher {
    /**
     * finds all possible answers within items and groups them by number of occurrence
     *
     * @param question
     * @param items
     * @return Map of question string to number of occurrence
     */
    public Map<String, Integer> fetchAnswers(Question question, List<Item> items) {
        Map<String, Integer> result = new HashMap<>();
        for (Item item : items) {
            Property property = findPropertyByFeature(question.feature, item.properties);
            if (property != null) {
                if (!result.containsKey(property.value)) {
                    result.put(property.value, 0);
                }
                result.put(property.value, result.get(property.value) + 1);
            }
        }


        return result;
    }

    private Property findPropertyByFeature(String feature, List<Property> properties) {
        for (Property property : properties) {
            if (property.feature.equals(feature)) {
                return property;
            }
        }
        return null;
    }
}
