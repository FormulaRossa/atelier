package ch.schulerhome.atelier20_21;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ch.schulerhome.atelier20_21.application.*;
import ch.schulerhome.atelier20_21.model.Dictionary;
import ch.schulerhome.atelier20_21.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Dictionary dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        TextView questionView = (TextView) findViewById(R.id.question);
                        questionView.setText(Integer.toString(items.size()) + ":" + items.get(0).name);
                        // list -> item.size()>1
                        // detail -> item.size() = 1

                        // show result
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