package ch.schulerhome.atelier20_21.application;

import ch.schulerhome.atelier20_21.model.Answer;
import ch.schulerhome.atelier20_21.model.DictionaryBuilder;
import ch.schulerhome.atelier20_21.model.Item;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemFilterTest {
    @Test
    public void testItemFilter() {
        List<Item> items = DictionaryBuilder.givenItems();
        Answer answer = new Answer("Orange", "color");

        List<Item> newItems = new ItemFilter().filter(items, answer);

        assertEquals(2, newItems.size());
    }
}
