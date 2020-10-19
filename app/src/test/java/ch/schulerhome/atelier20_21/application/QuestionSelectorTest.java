package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Dictionary;
import ch.schulerhome.atelier20_21.model.Question;
import org.junit.Test;

import java.util.List;

import static ch.schulerhome.atelier20_21.model.DictionaryBuilder.givenDictionary;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QuestionSelectorTest {

    @Test
    public void testSimpleQuestionSelector() {
        Dictionary dictionary = givenDictionary();
        QuestionSelector underTest = new SimpleQuestionSelector();

        Question result = underTest.selectQuestion(dictionary.items, dictionary.questions);

        assertNotNull(result);
        assertEquals("peel", result.feature);
    }

    //@Test
    public void testBestMatchQuestionSelector() {
        Dictionary dictionary = givenDictionary();
        QuestionSelector underTest = new BestMatchQuestionSelector();

        Question result = underTest.selectQuestion(dictionary.items, dictionary.questions);

        assertNotNull(result);
        assertEquals("peel", result.feature);
    }
}
