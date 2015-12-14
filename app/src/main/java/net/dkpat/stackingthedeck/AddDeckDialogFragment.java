package net.dkpat.stackingthedeck;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.EditText;

import com.parse.ParseUser;

import net.dkpat.stackingthedeck.Model.Deck;

/**
 * Created by cewon_000 on 12/8/2015.
 */
public class AddDeckDialogFragment extends android.support.v4.app.DialogFragment {

    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     */
    static AddDeckDialogFragment newInstance(int num) {
        AddDeckDialogFragment f = new AddDeckDialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(R.layout.dialog_fragment_add_deck);
        builder.setMessage("Create a New Deck")
                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!

                        Dialog f = (Dialog) dialog;
                        /* ERROR HERE! */
                        EditText deckName = (EditText) f.findViewById(R.id.editTextAddDeck);

                        Deck deck = new Deck();

                        deck.setName(deckName.getText().toString());
                        deck.setOwner(ParseUser.getCurrentUser());
                        deck.setDraft(true);
                        //Save to Parse immediately - deck.saveEventually saves the data on the device first then pushes to Parse
                        deck.saveInBackground();

                        //Rebuilds the fragment with new Decks
                        FragmentManager fManager = getFragmentManager();
                        FragmentTransaction fTransaction = fManager.beginTransaction();
                        fTransaction.replace(R.id.fragmentContainer, DeckFragment.newInstance(), "DeckFragment");
                        fTransaction.commit();

//                                (StackDeckApp.DECK_GROUP_NAME);

//                                new SaveCallback() {
//                                    @Override
//                                    public void done(ParseException e) {
//                                        if ()) {
//                                            return;
//                                        }
//                                        if (e == null) {
//                                            setResult(Activity.RESULT_OK);
//                                            finish();
//                                        } else {
//                                            Toast.mak
//                                        }
//                                    }
//                                })

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}






