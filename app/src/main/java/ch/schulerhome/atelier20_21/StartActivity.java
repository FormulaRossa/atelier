package ch.schulerhome.atelier20_21;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ch.schulerhome.atelier20_21.model.DictionariesJson;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.lang.reflect.Field;

public class StartActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "ch.schulerhome.atelier20_21.NAME";
    DictionariesJson dictionariesJson;
    String selected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Atelier");
        setSupportActionBar(toolbar);

        RadioGroup radioGroup = this.findViewById(R.id.RadioGroup);

        loadDictionaries();

        for (String filename : dictionariesJson.dictionaries.keySet()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RadioButton radioButton = (RadioButton) view;
                    selected = (String) radioButton.getText();
                    selected = dictionariesJson.dictionaries.get(selected);
                    startMainActivity(selected);
                }
            });
            filename = filename.substring(0, 1).toUpperCase() + filename.substring(1);
            radioButton.setText(filename);
            radioGroup.addView(radioButton);
        }
    }

    public void startMainActivity(String selected) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, selected);
        startActivity(intent);
    }

    private void loadDictionaries() {
        try {
            Field idField = R.raw.class.getDeclaredField("dictionaries");
            int id = idField.getInt(idField);
            InputStream in_s = getResources().openRawResource(id);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String json = new String(b);

            this.dictionariesJson = new ObjectMapper().readValue(json, DictionariesJson.class);
            return;
        } catch (Exception e) {
        }

    }
}