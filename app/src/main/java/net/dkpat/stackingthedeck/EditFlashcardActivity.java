package net.dkpat.stackingthedeck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import net.dkpat.stackingthedeck.Model.Flashcard;

/**
 * Created by C-Wo on 12/13/2015.
 */
public class EditFlashcardActivity extends AppCompatActivity {

    private TextView editTextTerm;
    private TextView editTextDefn;
    private Intent intent;
    private String term;
    private String defn;
    private Button btnSave;
    private Flashcard mFlashcard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_flashcard);

        final String flashcardId = getIntent().getStringExtra("FlashcardId");

        intent = getIntent();

        editTextTerm = (TextView) findViewById(R.id.editTextTerm);
        editTextDefn = (TextView) findViewById(R.id.editTextDefn);

        ParseQuery<Flashcard> query = ParseQuery.getQuery("Flashcard");
        query.getInBackground(flashcardId, new GetCallback<Flashcard>() {
            public void done(Flashcard flashcard, ParseException e) {
                if (e == null) {
                    mFlashcard = flashcard;
                    term = mFlashcard.getTerm();
                    defn = mFlashcard.getDefinition();

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
            public void onClick(View arg0) {

                if (term.equals("") && term.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter a Term and definition",
                            Toast.LENGTH_LONG).show();

                } else {

                    mFlashcard.setTerm(term);
                    mFlashcard.setDefinition(defn);
                    mFlashcard.saveInBackground();

                    finish();

                }
            }
        });
    }
}
//
////        query.getInBackground(flashcardId, new GetCallback<ParseObject>() {
//
//
//            public void done(ParseObject task, ParseException e) {
//                if (e == null) {
//                    term = flashcard.getString("term");
//                    defn = flashcard.getString("definition");
//
//                    editTextTerm.setText(term);
//                    editTextDefn.setText(defn);
//
//                } else {
//                    Toast.makeText(getApplicationContext(),
//                            "Something went wrong",
//                            Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//        btnSave = (Button) findViewById(R.id.btnSave);
//            btnSave.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    term = editTextTerm.getText().toString();
//                    defn = editTextDefn.getText().toString();
//
//                    if (term.equals("") && defn.equals("")) {
//                        Toast.makeText(getApplicationContext(),
//                                "Please enter name and description",
//                                Toast.LENGTH_LONG).show();
//
//                    } else {
//                        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
//
//                        query.getInBackground(flashcard.getObjectId(), new GetCallback<ParseObject>() {
//                            public void done(ParseObject task, ParseException e) {
//                                if (e == null) {
//                                    task.put("term", term);
//                                    task.put("definition", defn);
//                                    task.saveInBackground();
//
//                                    Intent listActivity = new Intent(getApplicationContext(), ListActivity.class);
//                                    startActivity(listActivity);
//                                } else {
//                                    Toast.makeText(getApplicationContext(),
//                                            "Something went wrong",
//                                            Toast.LENGTH_LONG).show();
//                                }
//                            }
//                        });
//
//
//                    }
//
//                }