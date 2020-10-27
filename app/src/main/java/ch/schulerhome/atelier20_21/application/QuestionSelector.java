package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Item;
import ch.schulerhome.atelier20_21.model.Question;

import java.util.List;

public interface QuestionSelector {

    Question selectQuestion(List<Item> items, List<Question> questions);

}
