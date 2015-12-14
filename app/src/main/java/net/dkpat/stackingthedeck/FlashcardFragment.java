package net.dkpat.stackingthedeck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private FlashcardListAdapter adapter;
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
        ListView mList = (ListView) view.findViewById(R.id.flashcard_list);


        // Set up the Parse query to use in the adapter
        ParseQueryAdapter.QueryFactory<Flashcard> factory = new ParseQueryAdapter.QueryFactory<Flashcard>() {
            public ParseQuery<Flashcard> create() {
                ParseQuery<Flashcard> query = ParseQuery.getQuery(Flashcard.class);
                query.whereEqualTo("deck", deck);
                return query;
            }
        };

        Context context = view.getContext();
        adapter = new FlashcardListAdapter(context, factory);
        // Set the adapter
        mList.setAdapter(adapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Flashcard flashcard = adapter.getItem(position);

                Intent intent = new Intent(getActivity().getBaseContext(), EditFlashcardActivity.class);
                intent.putExtra("flashcardId", flashcard.getObjectId());
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.flashcardfab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getBaseContext(), CreateFlashcardActivity.class);
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
