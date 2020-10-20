package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Item;
import ch.schulerhome.atelier20_21.model.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestMatchQuestionSelector implements QuestionSelector {
    @Override
    public Question selectQuestion(List<Item> items, List<Question> questions) {
        Map<Question, Integer> highestAnswerCount = new HashMap<>();

        for (Question question : questions) {
            Map<String, Integer> answerCount = new AnswerFetcher().fetchAnswers(question, items);
            int biggest = 0;
            for (int size : answerCount.values()) {
                if (size > biggest) {
                    biggest = size;
                }
            }
            highestAnswerCount.put(question, biggest);
        }

        Integer smallest = Integer.MAX_VALUE;
        Question result = null;
        for (Question question : highestAnswerCount.keySet()) {
            if (highestAnswerCount.get(question) < smallest) {
                smallest = highestAnswerCount.get(question);
                result = question;
            }
        }
        return result;
    }
}
