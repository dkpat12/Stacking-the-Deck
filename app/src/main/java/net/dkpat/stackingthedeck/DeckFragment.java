package net.dkpat.stackingthedeck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

import net.dkpat.stackingthedeck.Model.Deck;

import net.dkpat.stackingthedeck.helpers.DeckListAdapter;

import java.util.ArrayList;



/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnDeckFragmentListener}
 * interface.
 */
public class DeckFragment extends Fragment {

    private OnDeckFragmentListener mListener;
    private DeckListAdapter adapter;
    private ParseQueryAdapter<Deck> DeckListAdapter;
    private ArrayList<Deck> arrayOfDecks;

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
        registerForContextMenu(mList);

        //Set Click listener for Quiz Activity
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get the clicked deck object
                Log.d("Task", "OnItemClick");
                Deck deck = adapter.getItem(position);
                Intent intent = new Intent(getActivity().getBaseContext(), QuizActivity.class);
                //Pass Deck id
                intent.putExtra("deck_id", deck.getObjectId());
                //Start Quiz Activity
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddDeckDialogFragment cdd = new AddDeckDialogFragment();
                cdd.show(getActivity().getSupportFragmentManager(), "DeckDialogFragment");
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.menu_deck_context, menu);
    }

    /**
     * This will be invoked when a menu item is selected
     */

    public void refresh (){
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;


        switch (item.getItemId()) {
            case R.id.action_delete:
                Log.i("ContextMenu", "Item 1a was chosen");
                Deck deck = adapter.getItem(position);
                deck.deleteInBackground();
                FragmentManager fManager = getFragmentManager();
                FragmentTransaction fTransaction = fManager.beginTransaction();
                fTransaction.replace(R.id.fragmentContainer, DeckFragment.newInstance(), "DeckFragment");
                fTransaction.commit();
                return true;
            case R.id.action_edit_deck:
                Log.i("ContextMenu", "Item 1b was chosen");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, FlashcardFragment.newInstance(adapter.getItem(position)));
                fragmentTransaction.commit();
                return true;
            case R.id.action_rename:
                Log.i("ContextMenu", "Item 1c was chosen");
                return true;
            case R.id.action_share:
                Log.i("ContextMenu", "Item 1d was chosen");

                ShareDeckDialogFragment cdd = new ShareDeckDialogFragment();
                cdd.show(getActivity().getSupportFragmentManager(), "ShareDeckDialogFragment");
            default:
                Log.i("ContextMenu", "Item 1e was chosen");
                return false;
        }
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
    public interface OnDeckFragmentListener {
        // TODO: Update argument type and name
        void onDeckSelect(Deck item);
    }
}

