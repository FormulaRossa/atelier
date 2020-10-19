package ch.schulerhome.atelier20_21.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModelTest {
    public final String JSON_STRING = "{\"items\":[{\"name\":\"Banane\",\"properties\":[{\"feature\":\"color\",\"value\":\"Gelb\"},{\"feature\":\"peel\",\"value\":\"Nein\"}]},{\"name\":\"Orange\",\"properties\":[{\"feature\":\"color\",\"value\":\"Orange\"},{\"feature\":\"peel\",\"value\":\"Nein\"}]}],\"questions\":[{\"question\":\"Ist die Schale der Frucht essbar?\",\"feature\":\"peel\"},{\"question\":\"Welche Farbe hat die Frucht?\",\"feature\":\"color\"}]}";

    @Test
    public void testJacksonSerializer() throws Exception {
        Dictionary dictionary = DictionaryBuilder.givenDictionary();

        String json = new ObjectMapper().writeValueAsString(dictionary);

        assertEquals(JSON_STRING, json);
    }

    @Test
    public void testJacksonDeserializer() throws Exception {

        Dictionary dictionary = new ObjectMapper().readValue(JSON_STRING, Dictionary.class);

        assertEquals(dictionary.items.get(0).name, "Banane");
    }

}