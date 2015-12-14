package net.dkpat.stackingthedeck;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import net.dkpat.stackingthedeck.Model.Deck;
import net.dkpat.stackingthedeck.Model.Flashcard;
import net.dkpat.stackingthedeck.helpers.DeckListAdapter;
import net.dkpat.stackingthedeck.helpers.FlashcardListAdapter;

public class QuizActivity extends AppCompatActivity {

    private DeckFragment.OnDeckFragmentListener mListener;
    private ParseQueryAdapter<Flashcard> flashcardListAdapter;
    private Deck deck;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    // TODO: Customize parameter initialization
    public static QuizActivity newInstance(Deck deck) {
        QuizActivity fragment = new QuizActivity();
        fragment.deck = deck;
        return fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_quiz, container, false);


        // Set up the Parse query to use in the adapter
        ParseQueryAdapter.QueryFactory<Flashcard> factory = new ParseQueryAdapter.QueryFactory<Flashcard>() {
            public ParseQuery<Flashcard> create() {
                ParseQuery<Flashcard> query = ParseQuery.getQuery(Flashcard.class);
                query.whereEqualTo("deck", deck);
                query.orderByDescending("createdAt");
                query.fromLocalDatastore();
                return query;
            }
        };

        // Set the adapter
        // Parse does not support RecyclerView adapters currently. Should switch code to use Listview
        if (view instanceof ListView) {
            Context context = view.getContext();
            ListView mList = (ListView) view;
            mList.setAdapter(new DeckListAdapter(this.getContext(), factory ));
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDeck) {
            mListener = (DeckFragment.OnDeckFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
