package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Item;
import ch.schulerhome.atelier20_21.model.Property;
import ch.schulerhome.atelier20_21.model.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Property property = item.findPropertyByFeature(question.feature);
            if (property != null) {
                for (String value: property.value) {
                    if (!result.containsKey(value)) {
                        result.put(value, 0);
                    }
                    result.put(value, result.get(value) + 1);
                }
            }
        }


        return result;
    }

}
