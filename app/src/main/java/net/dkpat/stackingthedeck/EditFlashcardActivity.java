package net.dkpat.stackingthedeck;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import net.dkpat.stackingthedeck.Model.Flashcard;

import java.awt.font.TextAttribute;

import bolts.Task;

/**
 * Created by C-Wo on 12/13/2015.
 */
public class EditFlashcardActivity extends AppCompatActivity {

    private TextView editTextTerm;
    private TextView editTextDefn;
    private Intent intent;
    private Flashcard flashcard;
    private String term;
    private String defn;
    private Button btnSave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_flashcard);
//
//        String deckId = getIntent().getStringExtra("DeckId");
        intent = getIntent();
        flashcard = new Flashcard();
        flashcard.setObjectId(intent.getStringExtra("objectId"));

        editTextTerm = (TextView) findViewById(R.id.editTextTerm);
        editTextDefn = (TextView) findViewById(R.id.editTextDefn);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Flashcard");
        query.getInBackground(flashcard.getObjectId(), new GetCallback<ParseObject>() {
            public void done(ParseObject task, ParseException e) {
                if (e == null) {
                    term = flashcard.getString("term");
                    defn = flashcard.getString("definition");

                    editTextTerm.setText(term);
                    editTextDefn.setText(defn);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Something went wrong",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSave = (Button) findViewById(R.id.btnSave);
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    term = editTextTerm.getText().toString();
                    defn = editTextDefn.getText().toString();

                    if (term.equals("") && defn.equals("")) {
                        Toast.makeText(getApplicationContext(),
                                "Please enter name and description",
                                Toast.LENGTH_LONG).show();

                    } else {
                        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");

                        query.getInBackground(flashcard.getObjectId(), new GetCallback<ParseObject>() {
                            public void done(ParseObject task, ParseException e) {
                                if (e == null) {
                                    task.put("term", term);
                                    task.put("definition", defn);
                                    task.saveInBackground();

                                    Intent listActivity = new Intent(getApplicationContext(), ListActivity.class);
                                    startActivity(listActivity);
                                } else {
                                    Toast.makeText(getApplicationContext(),
                                            "Something went wrong",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });


                    }

                }
            });


    }


}
