package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Dictionary;
import ch.schulerhome.atelier20_21.model.Question;
import org.junit.Test;

import java.util.Map;

import static ch.schulerhome.atelier20_21.model.DictionaryBuilder.givenDictionary;
import static org.junit.Assert.assertEquals;

public class AnswerFetcherTest {
    @Test
    public void testFetchAnswer() {
        Dictionary dictionary = givenDictionary();
        Question question = givenQuestion();

        AnswerFetcher underTest = new AnswerFetcher();
        Map<String, Integer> result = underTest.fetchAnswers(question, dictionary.items);

        assertEquals(3, result.size());
        assertEquals(Integer.valueOf(2), result.get("Orange"));
    }

    private Question givenQuestion() {

        return givenDictionary().questions.get(1);
    }
}
