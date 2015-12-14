package net.dkpat.stackingthedeck;

import android.content.Context;
import android.os.Bundle;
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

<<<<<<< HEAD:app/src/main/java/net/dkpat/stackingthedeck/FlashCardFragment.java
=======
    private LayoutInflater inflater;
>>>>>>> master:app/src/main/java/net/dkpat/stackingthedeck/FlashcardFragment.java
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

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFlashCardListFragmentInteractionListener) {
            mListener = (OnFlashCardListFragmentInteractionListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFlashCardListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Flashcard item);
    }
}
