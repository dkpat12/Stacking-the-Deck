package net.dkpat.stackingthedeck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        flashcard = new Flashcard();

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

//        btnSave = (Button) findViewById(R.)


    }


}
