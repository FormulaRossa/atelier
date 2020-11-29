package ch.schulerhome.atelier20_21.application;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import ch.schulerhome.atelier20_21.R;
import ch.schulerhome.atelier20_21.model.Answer;
import ch.schulerhome.atelier20_21.model.Item;
import ch.schulerhome.atelier20_21.model.Question;

import java.util.List;
import java.util.Set;

public class InteractiveResponder implements Responder {

    private final AppCompatActivity appCompatActivity;
    String selectedAnswer = null;

    public InteractiveResponder(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public void answer(final Question question, List<Item> candidates, final ResponderCallback responderCallback) {

        TextView questionView = (TextView) appCompatActivity.findViewById(R.id.question);
        questionView.setText(question.question);
        Set<String> answers = new AnswerFetcher().fetchAnswers(question, candidates).keySet();

        RadioGroup radioGroup = appCompatActivity.findViewById(R.id.RadioGroup);
        radioGroup.removeAllViews();
        for (String answer : answers) {
            addRadioButton(answer);
        }

        Button nextButton = appCompatActivity.findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                responderCallback.select(new Answer(selectedAnswer, question.feature));
            }
        });
    }

    private void addRadioButton(String text) {
        RadioGroup radioGroup = appCompatActivity.findViewById(R.id.RadioGroup);
        RadioButton radioButton = new RadioButton(appCompatActivity);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioButton = (RadioButton) view;
                selectedAnswer = (String) radioButton.getText();
            }
        });
        radioButton.setText(text);
        radioGroup.addView(radioButton);
    }
}
