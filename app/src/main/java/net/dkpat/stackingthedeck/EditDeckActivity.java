package net.dkpat.stackingthedeck;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parse.ParseQueryAdapter;

import net.dkpat.stackingthedeck.Model.Deck;
import net.dkpat.stackingthedeck.Model.Flashcard;

public class EditDeckActivity extends AppCompatActivity implements DeckFragment.OnDeckFragmentListener,
    FlashcardFragment.OnFlashCardListFragmentInteractionListener {

    private LayoutInflater inflater;
//    private OnFlashCardListFragmentInteractionListener mListener;
    private ParseQueryAdapter<Deck> deckListAdapter;
    private Deck deck;


    public static EditDeckActivity newInstance(Deck deck) {
        EditDeckActivity fragment = new EditDeckActivity();
        fragment.deck = deck;
        return fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_deck);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddDeckDialogFragment cdd = new AddDeckDialogFragment();
                cdd.show(getSupportFragmentManager(), "String");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDeckSelect(Deck item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, FlashcardFragment.newInstance(item));
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(Flashcard item) {
        return;
    }
}
