package net.dkpat.stackingthedeck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import net.dkpat.stackingthedeck.Model.Deck;
import net.dkpat.stackingthedeck.Model.Flashcard;
import net.dkpat.stackingthedeck.helpers.FlashcardListAdapter;

import java.util.List;


/**
 * A fragment representing a list of Items.
 * <p>
 * Activities containing this fragment MUST implement the {@link OnFlashCardListFragmentInteractionListener}
 * interface.
 */
public class FlashcardFragment extends Fragment {

    private LayoutInflater inflater;
    private OnFlashCardListFragmentInteractionListener mListener;
    private ParseQueryAdapter<Flashcard> flashcardListAdapter;
    private Deck deck;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FlashcardFragment() {
    }

    // TODO: Customize parameter initialization
    public static FlashcardFragment newInstance(Deck deck) {
        FlashcardFragment fragment = new FlashcardFragment();
        fragment.deck = deck;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flashcard_list, container, false);


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
            mList.setAdapter(new FlashcardListAdapter(this.getContext(), factory ));
        }

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getBaseContext(), EditFlashcardActivity.class);
                intent.putExtra("DeckId", deck.getObjectId());
                startActivity(intent);
            }

        });

        return view;
    }



    public interface OnFlashCardListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Flashcard item);
    }
}
