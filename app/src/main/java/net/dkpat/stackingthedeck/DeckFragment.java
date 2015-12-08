package net.dkpat.stackingthedeck;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import net.dkpat.stackingthedeck.Model.Deck;
import net.dkpat.stackingthedeck.Model.Flashcard;
import net.dkpat.stackingthedeck.helpers.DeckListAdapter;


/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnDeckListFragmentInteractionListener}
 * interface.
 */
public class DeckFragment extends Fragment {

    private OnDeckListFragmentInteractionListener mListener;

    private LayoutInflater inflater;
    private ParseQueryAdapter<Deck> DeckListAdapter;

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


//        public interface OnDeckListFragmentInteractionListener {
//            // TODO: Update argument type and name
//            void onListFragmentInteraction(Deck item);
//        }




        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){
            View view = inflater.inflate(R.layout.fragment_deck_list, container, false);



            //Set up the Parse query to use in the adapter
            ParseQueryAdapter.QueryFactory<Deck> factory = new ParseQueryAdapter.QueryFactory<Deck>() {
                public  ParseQuery<Deck> create() {
                    ParseQuery<Deck> query = ParseQuery.getQuery(Deck.class);
                    query.orderByDescending("createdBy");
                    query.fromLocalDatastore();
                    return query;
                }
            };


            // Set the adapter
            // Parse does not support RecyclerView adapters currently. Should switch code to use Listview
            if (view instanceof ListView) {
                Context context = view.getContext();
                ListView mList = (ListView) view;
                mList.setAdapter(new DeckListAdapter(this.getContext(), factory));
            }
            return view;
        }


        @Override
        public void onAttach (Context context){
            super.onAttach(context);
            if (context instanceof OnDeckListFragmentInteractionListener) {
                mListener = (OnDeckListFragmentInteractionListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement OnListFragmentInteractionListener");
            }
        }

        @Override
        public void onDetach () {
            super.onDetach();
            mListener = null;
        }

        /**
         * This interface must be implemented by activities that contain this
         * fragment to allow an interaction in this fragment to be communicated
         * to the activity and potentially other fragments contained in that
         * activity.
         * <p/>
         * See the Android Training lesson <a href=
         * "http://developer.android.com/training/basics/fragments/communicating.html"
         * >Communicating with Other Fragments</a> for more information.
         */
        public interface OnDeckListFragmentInteractionListener {
            // TODO: Update argument type and name
            void onListFragmentInteraction(Deck item);
        }
}
