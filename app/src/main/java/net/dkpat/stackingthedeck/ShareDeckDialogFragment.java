package net.dkpat.stackingthedeck;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseUser;

import net.dkpat.stackingthedeck.Model.Deck;

/**
 * Created by C-Wo on 12/13/2015.
 */
public class ShareDeckDialogFragment extends android.support.v4.app.DialogFragment {

    public ShareDeckDialogFragment() {

    }

    static ShareDeckDialogFragment newInstance(int num) {
        ShareDeckDialogFragment s = new ShareDeckDialogFragment();

        Bundle args = new Bundle();
        args.putInt("num", num);

        return s;
    }

    public Spinner mDecksSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
//
//    // Wigets - GUI
//    Spinner spinnerDeckNames;
//
//    // Adapter
//    ArrayAdapter<String> adapterDeckName;
//
//    // Get Deck Title..
////    private void openShareView(Deck deck) {
////        Intent i = new Intent(this, ShareDeckDialogFragment.class);
////        startActivityForResult(i, EDIT_ACTIVITY_CODE);
////    }
//
//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(R.layout.dialog_fragment_share_deck);
//
//        // Initialize Spinner
//        spinnerDeckNames = (Spinner) spinnerDeckNames.findViewById(R.id.spinnerDeckNames);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//                this, R.array.deck_name_arrays, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerDeckNames.setAdapter(adapter);


//        // Deck Item Selected Listener
//        spinnerDeckNames.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapter, View view,
//                                       int position, long id) {
//                // On selecting a spinner item
//                String item = adapter.getItemAtPosition(position).toString();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//        builder.setMessage("Share a Deck")
//                .setPositiveButton("Share", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        // Select Deck Title
//
//
//                        Dialog s = (Dialog) dialog;
//                        EditText eMailShare = (EditText) s.findViewById(R.id.editTextEMail);
//
//                        //Share Deck through Parse..
//
//                        Deck deck = new Deck();
//
//                        deck.setName(spinnerDeckNames.getSelectedItem().toString());
//                        deck.setOwner(ParseUser.getCurrentUser());
//                        deck.setDraft(true);
//
//                        //Share Deck through Parse..
//
//                        deck.saveEventually();


//                        // Toast if successfully shared
//                        Toast.makeText(getActivity(), "Deck Shared!", Toast.LENGTH_SHORT).show();
//                        // Toast if cannot find user to share with
//                        Toast.makeText(getActivity(), "User Not Found", Toast.LENGTH_SHORT.show();

//                    }
//                })
//                .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
//                    public void onClick (DialogInterface dialog,int id){
//                        // User cancelled the dialog
//                }
//            });

                // Create the AlertDialog object and return it
                return builder.create();
            }
}


