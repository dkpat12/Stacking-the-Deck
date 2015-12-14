package net.dkpat.stackingthedeck;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import net.dkpat.stackingthedeck.Model.Deck;
import net.dkpat.stackingthedeck.Model.Flashcard;
import net.dkpat.stackingthedeck.helpers.DeckListAdapter;

import java.util.Stack;

/**
 * Created by cewon_000 on 12/8/2015.
 */
public class AddDeckDialogFragment extends android.support.v4.app.DialogFragment {

//        implements
//        android.view.View.OnClickListener {

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





//    public AddDeckDialogFragment(Context context) {
//        super(context);
////        mEditText = EditText;
//    }
//
//    ;
//
//    public static int newInstance(String blah) {
//        return 0;
//    }
//
//
//    // Use this instance of the interface to deliver action events
//    AddDeckDialogFragment mListener;
////    final EditText mEditText;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(R.layout.add_deck_dialog);
        builder.setMessage("Create a New Deck")
                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!

                        Dialog f = (Dialog) dialog;
                        /* ERROR HERE! */
                        EditText deckName = (EditText) f.findViewById(R.id.editText);

                        Deck deck = new Deck();

                        deck.setName(deckName.getText().toString());
                        deck.setOwner(ParseUser.getCurrentUser());
                        deck.setDraft(true);
                        deck.saveEventually();
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

//        // 1. Instantiate an AlertDialog.Builder with its constructor
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        // Get the layout inflater
//        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(
//                Context.LAYOUT_INFLATER_SERVICE);
//
//        builder.setView(inflater.inflate(R.layout.add_deck_dialog, null));
//        // 2. Chain together various setter methods to set the dialog characteristics
//        builder.setMessage("Create")
//                .setTitle("Create a New Deck");
//
////        int btn_yes = BUTTON_POSITIVE;
////        int btn_no = BUTTON_NEGATIVE;
//
//        builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
////                 User clicked OK button
////                mEditText.getText().toString()
//
//                Button btnYes = (Button)findViewById(R.id.btn_yes);
//
//
//                View view ;
//
//
////                Intent intent = new Intent(Intent.ACTION_MAIN);
////                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                intent.addCategory(Intent.CATEGORY_HOME);
////                AddDeckDialogFragment.this.onDialogPositiveClick(intent);
//
//
////                android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
////                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////                fragmentTransaction.replace(R.id.fragmentContainer, EditDeckActivity.newInstance(adapter.getItem(currentI)));
////                fragmentTransaction.commit();
//
//
////                Intent intent =  new Intent(AddDeckDialogFragment.this, EditDeckActivity.class);
////                startActivity(intent);
//
//            }
//        });
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                // User cancelled the dialog
//
//                Button btnNo = (Button)findViewById(R.id.btn_no);
//
//                dialog.dismiss();
//            }
//        });
//        // 3. Get the AlertDialog from create()
//        // (Create the Alert Dialog)
//        AlertDialog dialog = builder.create();
//    }
//
//
//    private void onDialogPositiveClick(Intent addDeckDialogFragment) {
//    }
//    private void onDialogNegativeClick(AddDeckDialogFragment addDeckDialogFragment) {
//    }
//
//    @Override
//    public void onClick(View v) {
//        final AddDeckDialogFragment newFragment;
//    }


//    @Override
//    protected View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.add_deck_dialog, container, false);
//        ImageView imageView = (ImageView) view.findViewById(R.id.btn_yes);
//        return view;
//    }
























////    private CreateDeck mCreateText;
////
////    public AddDeckDialogFragment(Context context) {
////        super(context);
////    }
////
////    public static AddDeckDialogFragment newInstance(String title) {
////        AddDeckDialogFragment frag = new AddDeckDialogFragment();
////        Bundle args = new Bundle();
////        args.putString("Create a new Deck", title);
////        frag.setArguements(args);
////        return frag;
////    }
//
//    public Activity c;
//    public Dialog d;
//    public Button yes, no;
//
//    public AddDeckDialogFragment(Context context) {
//        super(context);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.add_deck_dialog);
//        yes = (Button) findViewById(R.id.btn_yes);
//        no = (Button) findViewById(R.id.btn_no);
//        yes.setOnClickListener(this);
//        no.setOnClickListener(this);
//
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_yes:
//
//                c.finish();
//                break;
//            case R.id.btn_no:
//                dismiss();
//                break;
//            default:
//                break;
//        }
//        dismiss();
//    }
//
//
////    @Override
////    public void onCreateBtnSelect(Deck item) {
////        FragmentManager fragmentManager = getSupportFragmentManager();
////        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////        fragmentTransaction.replace(R.id.fragmentContainer, DeckFragment.instantiate(this.getContext(), DeckListAdapter));
////        fragmentTransaction.commit();
////    }
//
//}
////FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
////fab.setOnClickListener(new View.OnClickListener() {
////@Override
////public void onClick(View view) {
////        AddDeckDialogFragment cdd=new AddDeckDialogFragment(view.getContext());
////        cdd.show();