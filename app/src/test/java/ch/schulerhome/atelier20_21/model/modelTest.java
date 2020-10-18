package ch.schulerhome.atelier20_21.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class modelTest {
    public final String JSON_STRING = "{\"items\":[{\"name\":\"Banane\",\"properties\":[{\"feature\":\"color\",\"value\":\"Gelb\"}]}],\"questions\":[{\"question\":\"Welche Farbe?\",\"feature\":\"color\"}]}";

    @Test
    public void testJacksonSerializer() throws Exception {
        Dictionary dictionary = generateDictionary();
        String json = new ObjectMapper().writeValueAsString(dictionary);

        assertEquals(json, JSON_STRING);
    }

    @Test
    public void testJacksonDeserializer() throws Exception {
        Dictionary dictionary = new ObjectMapper().readValue(JSON_STRING, Dictionary.class);
        assertEquals(dictionary.items.get(0).name, "Banane");
    }

    public Dictionary generateDictionary() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Welche Farbe?", "color"));

        List<Property> properties = new ArrayList<>();
        properties.add(new Property("color", "Gelb"));

        List<Item> items = new ArrayList<>();
        items.add(new Item("Banane", properties));

        Dictionary dictionary = new Dictionary(items, questions);

        return  dictionary;
    }
}