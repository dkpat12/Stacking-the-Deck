package net.dkpat.stackingthedeck;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.parse.ParseException;
import com.parse.ParseQuery;

import net.dkpat.stackingthedeck.Model.Flashcard;
import net.dkpat.stackingthedeck.Model.Deck;

public class CreateFlashcardActivity extends AppCompatActivity {

    private TextView editTextTerm;
    private TextView editTextDefn;

    private Flashcard flashcard;
    private String term;
    private String definition;
    private Button btnCreate;
    private Deck mDeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_flashcard);

        final String deckId = getIntent().getStringExtra("DeckId");

        flashcard = new Flashcard();

        editTextTerm = (TextView) findViewById(R.id.editTextTerm);
        editTextDefn = (TextView) findViewById(R.id.editTextDefn);

        ParseQuery<Deck> query = ParseQuery.getQuery("Deck");
        try {
            mDeck = query.get(deckId);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        btnCreate = (Button) findViewById(R.id.createFlashcard);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                term = editTextTerm.getText().toString();
                definition = editTextDefn.getText().toString();

                if (term.equals("") && term.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter a Term and definition",
                            Toast.LENGTH_LONG).show();

                } else {
                    Flashcard flashcard = new Flashcard();

                    flashcard.setTerm(term);
                    flashcard.setDefinition(definition);
                    flashcard.setDeck(mDeck);
                    flashcard.saveInBackground();

                    //Finish Activity
                    finish();
                }
            }
        });


    }
}
