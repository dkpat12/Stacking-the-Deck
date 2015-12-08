package net.dkpat.stackingthedeck;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import net.dkpat.stackingthedeck.Model.Deck;
import net.dkpat.stackingthedeck.helpers.DeckListAdapter;


/**
 * A fragment representing a list of Items.
 * <p>
 * Activities containing this fragment MUST implement the {@link OnDeckFragmentListener}
 * interface.
 */
public class DeckFragment extends Fragment {

    private OnDeckFragmentListener mListener;
    private DeckListAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DeckFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static DeckFragment newInstance() {
        DeckFragment fragment = new DeckFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deck_list, container, false);
        ListView mList = (ListView) view;

        // Set up the Parse query to use in the adapter
        ParseQueryAdapter.QueryFactory<Deck> factory = new ParseQueryAdapter.QueryFactory<Deck>() {
            public ParseQuery<Deck> create() {
                ParseQuery<Deck> query = ParseQuery.getQuery(Deck.class);
                query.orderByDescending("name");
                query.fromLocalDatastore();
                return query;
            }
        };

        Context context = view.getContext();
        adapter = new DeckListAdapter(context, factory);

        // Set the adapter
        mList.setAdapter(adapter);

        //Set Click listener
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Get the clicked deck object
                Deck deck = adapter.getItem(position);
                //Pass the deck object
                mListener.onDeckSelect(deck);
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDeckFragmentListener) {
            mListener = (OnDeckFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDeckFragmentListener");
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
    public interface OnDeckFragmentListener {
        // TODO: Update argument type and name
        void onDeckSelect(Deck item);
    }
}
