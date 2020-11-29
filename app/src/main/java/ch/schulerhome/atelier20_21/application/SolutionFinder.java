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

    public void findSolution(List<Item> items, List<Question> questions, final SolutionCallback callback) {

        if (items.size() > 1 && questions.size() > 0) {
            final List<Item> candidates = new ArrayList<>(items);
            final List<Question> remainingQuestions = new ArrayList<>(questions);

            Question question = questionSelector.selectQuestion(candidates, remainingQuestions);
            remainingQuestions.remove(question);

            responder.answer(
                    question,
                    candidates,
                    new Responder.ResponderCallback() {
                        @Override
                        public void select(Answer answer) {
                            findSolution(
                                    itemFilter.filter(candidates, answer),
                                    remainingQuestions,
                                    callback
                            );
                        }
                    });
        } else {
            callback.select(items);
        }

    }

    public interface SolutionCallback {
        void select(List<Item> items);
    }
}
