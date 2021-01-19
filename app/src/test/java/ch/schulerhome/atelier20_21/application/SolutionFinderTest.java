package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Dictionary;
import ch.schulerhome.atelier20_21.model.DictionaryBuilder;
import ch.schulerhome.atelier20_21.model.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SolutionFinderTest {

    @Test
    public void testFindSolution() {
        Dictionary dictionary = DictionaryBuilder.givenDictionary();
        QuestionSelector questionSelector = new SimpleQuestionSelector();
        Item solution = dictionary.items.get(0);
        Responder responder = new ItemResponder(solution);
        SolutionFinder solutionFinder = new SolutionFinder(questionSelector, responder);

        final List<Item> answer = new ArrayList<>();

        solutionFinder.findSolution(
                dictionary.items,
                dictionary.questions,
                new SolutionFinder.SolutionCallback() {
                    @Override
                    public void select(List<Item> items) {
                        answer.addAll(items);
                    }
                });

        System.out.println("-----------------------------");
        System.out.println("Antwort: " + answer.get(0).name);

        assertTrue(answer.contains(solution));
        assertTrue(dictionary.items.size() > answer.size());
    }
}
