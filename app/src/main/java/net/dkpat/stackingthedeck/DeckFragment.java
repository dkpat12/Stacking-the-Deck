package net.dkpat.stackingthedeck;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

import net.dkpat.stackingthedeck.Model.Deck;
import net.dkpat.stackingthedeck.Model.Flashcard;
import net.dkpat.stackingthedeck.helpers.DeckListAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Items.
 * <p>
 * Activities containing this fragment MUST implement the {@link OnDeckFragmentListener}
 * interface.
 */
public class DeckFragment extends Fragment {

    private OnDeckFragmentListener mListener;
    private DeckListAdapter adapter;
    private ImageView imageView;
    private ActionMode mActionMode;
    private LayoutInflater inflater;
    private ParseQueryAdapter<Deck> DeckListAdapter;
    private ArrayList<Deck> arrayOfDecks;
    private int currentI;

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
        Log.d("Task", "OnCreateView");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deck_list, container, false);
        ListView mList = (ListView) view.findViewById(R.id.deck_list);
        arrayOfDecks = new ArrayList<Deck>();


        //Set up the Parse query to use in the adapter
        ParseQueryAdapter.QueryFactory<Deck> factory = new ParseQueryAdapter.QueryFactory<Deck>() {
            public ParseQuery<Deck> create() {
                ParseQuery<Deck> query = ParseQuery.getQuery(Deck.class);
                query.whereEqualTo("owner", ParseUser.getCurrentUser());
                query.orderByDescending("name");
                return query;
            }
        };

        Context context = view.getContext();
        adapter = new DeckListAdapter(context, factory);
        // Set the adapter
        mList.setAdapter(adapter);

        Log.d("Count", String.valueOf(mList.getCount()));
        Log.d("Count", String.valueOf(adapter.getCount()));

//        ParseQuery<Deck> query = ParseQuery.getQuery("Deck");
//        query.whereEqualTo("owner", ParseUser.getCurrentUser());
//        query.findInBackground(new FindCallback<Deck>() {
//            @Override
//            public void done(List<Deck> objects, ParseException e) {
//                if (e == null) {
//                    adapter.addAll(objects);
//                    Log.d("Task", "Got to add all");
//                    Log.d("Count", String.valueOf(adapter.getCount()));
//
//                } else {
//                    Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
//                }
//            }
//        });

//        //Set Click listener
//        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //Get the clicked deck object
//                Log.d("Task", "OnItemClick");
//                Deck deck = adapter.getItem(position);
//                //Pass the deck object
//                //mListener.onDeckSelect(deck);
//
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragmentContainer, FlashcardFragment.newInstance(deck));
//                fragmentTransaction.commit();
//            }
//        });

        //I'm so sorry. I have not found any other way to do this >_<
        for (int i = 0; i < mList.getAdapter().getCount(); i++) {
            //For menu's sake
            currentI = i;
            Log.d("Task", "Loop");
            View deckItem = mList.getChildAt(i);

            ImageView menu = (ImageView) deckItem.findViewById(R.id.deck_menu);

            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Creating the instance of PopupMenu
                    Log.d("Task", "OnMenuClick");
                    PopupMenu popup = new PopupMenu(getActivity(), v);
                    popup.setOnMenuItemClickListener(new onMenuItemClickListener_View(v));
                    //Inflating the Popup using xml file
                    popup.getMenuInflater().inflate(R.menu.menu_deck_context, popup.getMenu());
                    popup.show();
                }
            });
            menu.setId(i);
        }

        Log.d("Count", String.valueOf(adapter.getCount()));

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

    private class onMenuItemClickListener_View implements PopupMenu.OnMenuItemClickListener {
        View mView;

        public onMenuItemClickListener_View(View v) {
            mView = v;
        }

        int i = mView.getId();

        //registering popup with OnMenuItemClickListener
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_delete:
                    Log.i("ContextMenu", "Item 1a was chosen");
                    return true;
                case R.id.action_edit_deck:
                    Log.i("ContextMenu", "Item 1b was chosen");
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, FlashcardFragment.newInstance(adapter.getItem(i)));
                    fragmentTransaction.commit();
                    return true;
                case R.id.action_rename:
                    Log.i("ContextMenu", "Item 1b was chosen");
                    return true;
                case R.id.action_share:
                    Log.i("ContextMenu", "Item 1b was chosen");
                    return true;
                default:
                    Log.i("ContextMenu", "Item 1b was chosen");
                    return false;
            }
        }
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

