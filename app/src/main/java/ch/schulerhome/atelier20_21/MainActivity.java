package ch.schulerhome.atelier20_21;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ch.schulerhome.atelier20_21.application.*;
import ch.schulerhome.atelier20_21.model.Dictionary;
import ch.schulerhome.atelier20_21.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Dictionary dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String EXTRA_MESSAGE = "ch.schulerhome.atelier20_21.MESSAGE";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MainActivity activity = this;
        dictionary = loadDictionary();
        Responder responder = new InteractiveResponder(this);
        QuestionSelector questionSelector = new BestMatchQuestionSelector();
        SolutionFinder solutionFinder = new SolutionFinder(questionSelector, responder);
        solutionFinder.findSolution(
                dictionary.items,
                dictionary.questions,
                new SolutionFinder.SolutionCallback() {
                    @Override
                    public void select(List<Item> items) {
                        Intent intent = new Intent(activity, ResultActivity.class);

                        ArrayList<String> itemNames = new ArrayList<>();
                        for (Item item : items) {
                            itemNames.add(item.name);
                        }

                        intent.putExtra(EXTRA_MESSAGE, itemNames);
                        startActivity(intent);
                    }
                });

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Atelier");
    }

    private Dictionary loadDictionary() {
        try {
            InputStream in_s = getResources().openRawResource(R.raw.dictionary);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String json = new String(b);

            Dictionary dictionary = new ObjectMapper().readValue(json, Dictionary.class);
            return dictionary;
        } catch (Exception e) {
            return null;
        }

    }
}