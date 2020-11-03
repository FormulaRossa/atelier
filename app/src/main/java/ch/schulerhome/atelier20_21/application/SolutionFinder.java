package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Answer;
import ch.schulerhome.atelier20_21.model.Item;
import ch.schulerhome.atelier20_21.model.Question;

import java.util.ArrayList;
import java.util.List;

public class SolutionFinder {

    QuestionSelector questionSelector;
    Responder responder;
    ItemFilter itemFilter = new ItemFilter();

    public SolutionFinder(QuestionSelector questionSelector, Responder responder) {
        this.questionSelector = questionSelector;
        this.responder = responder;
    }

    List<Item> findSolution(List<Item> items, List<Question> questions) {

        List<Item> candidates = new ArrayList<>(items);
        List<Question> remainingQuestions = new ArrayList<>(questions);

        do {
            Question question = questionSelector.selectQuestion(candidates, remainingQuestions);
            Answer answer = responder.answer(question);
            remainingQuestions.remove(question);
            candidates = itemFilter.filter(candidates, answer);
        } while (candidates.size() > 1 && remainingQuestions.size() > 0);

        return candidates;

    }
}
