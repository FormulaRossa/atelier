package ch.schulerhome.atelier20_21;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    final String EXTRA_MESSAGE = "ch.schulerhome.atelier20_21.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        final ArrayList<String> itemNames = (ArrayList<String>) intent.getSerializableExtra(EXTRA_MESSAGE);
        LinearLayout linearLayout = findViewById(R.id.resultView);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_restart:
                        restart();
                        return true;
                    default:
                        return false;
                }
            }
        });

        toolbar.setTitle("Atelier");
        for (String name : itemNames) {
            CardView cardView = new CardView(this);
            cardView.setContentPadding(10, 10, 10, 10);

            TextView textView = new TextView(this);
            textView.setText(name);
            textView.setTextSize(24);
            cardView.addView(textView);
            final AppCompatActivity activity = this;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*
                    Intent intent = new Intent(activity, SingleViewActivity.class);
                    startActivity(intent);
                    */
                }
            });
            linearLayout.addView(cardView);
        }

    }

    public void restart() {
        Intent myIntent = new Intent(this, MainActivity.class);
        this.startActivity(myIntent);
    }
}