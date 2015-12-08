//package net.dkpat.stackingthedeck;
//
//import android.app.AlertDialog;
//import android.app.Dialog;
//import android.app.DialogFragment;
//import android.content.DialogInterface;
//import android.os.Bundle;
//
///**
// * Created by cewon_000 on 12/8/2015.
// */
//public class AddDeckDialogFragment extends DialogFragment {
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        // Use the Builder class for convenient dialog construction
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setMessage("New Deck")
//                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //User created a new deck
//                    }
//                })
//                .setNegativeButton("Cacnel", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // User cancelled creating a new deck
//                    }
//                });
//        // Create the AlertDialog object and return it
//        return builder.create();
//    }
//}
