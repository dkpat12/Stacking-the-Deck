package net.dkpat.stackingthedeck;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import net.dkpat.stackingthedeck.Model.Deck;
import net.dkpat.stackingthedeck.Model.Flashcard;


public class MainMenuActivity extends AppCompatActivity implements DeckFragment.OnDeckFragmentListener,
        FlashcardFragment.OnFlashCardListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Animation transition
        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment currentFragment = getFragmentManager().findFragmentById(R.id.fragmentContainer);
//                Fragment deckFragment = getFragmentManager().findFragmentByTag("DeckFragment");
//                Fragment flashcardFragment = getFragmentManager().findFragmentByTag("FlashcardFragment");
//
//                if (deckFragment != null && deckFragment.isVisible()) {
//                    AddDeckDialogFragment cdd = new AddDeckDialogFragment();
//                    cdd.show(getSupportFragmentManager(), "DeckDialogFragment");
//                }
//                if (flashcardFragment != null && flashcardFragment.isVisible()) {
//                    Intent intent = new Intent(getBaseContext(), EditFlashcardActivity.class);
//                    startActivity(intent);
//                }
////                if (myFragment != null && myFragment.isVisible()) {
////                    if (currentFragment instanceof (Fragment) DeckFragment){
////                        AddDeckDialogFragment cdd = new AddDeckDialogFragment();
////                        cdd.show(getSupportFragmentManager(), "String");
////                    }
////                    if (currentFragment instanceof CardFragment) {
////                        EditFlashcardActivity cdd = new EditFlashcardActivity();
////                        Intent intent = new Intent(getBaseContext(), EditFlashcardActivity.class);
////                    startActivity(intent);
////                }
//            }
//
//        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, new DeckFragment(), "DeckFragment");
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDeckSelect(Deck item) {

    }

    @Override
    public void onListFragmentInteraction(Flashcard item) {
        return;
    }


}
