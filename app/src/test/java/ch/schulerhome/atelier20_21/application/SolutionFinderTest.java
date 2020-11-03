package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Dictionary;
import ch.schulerhome.atelier20_21.model.DictionaryBuilder;
import ch.schulerhome.atelier20_21.model.Item;
import org.junit.Test;

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

        List<Item> answer = solutionFinder.findSolution(dictionary.items, dictionary.questions);

        assertTrue(answer.contains(solution));
        assertTrue(dictionary.items.size() > answer.size());
    }
}
