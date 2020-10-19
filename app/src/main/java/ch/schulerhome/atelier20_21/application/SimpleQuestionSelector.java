package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Item;
import ch.schulerhome.atelier20_21.model.Question;

import java.util.List;

public class SimpleQuestionSelector implements QuestionSelector {
    @Override
    public Question selectQuestion(List<Item> items, List<Question> questions) {
        return questions.get(0);
    }
}
