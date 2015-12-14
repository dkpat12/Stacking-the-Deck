package net.dkpat.stackingthedeck;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import net.dkpat.stackingthedeck.Model.Deck;
import net.dkpat.stackingthedeck.Model.Flashcard;
import net.dkpat.stackingthedeck.helpers.DeckListAdapter;
import net.dkpat.stackingthedeck.helpers.FlashcardListAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private Deck mDeck;
    private ViewPager mPager;
    private List<Flashcard> mFlashcards;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //Get Extra (Deck id)
        String deckId = getIntent().getStringExtra("deck_id");
        ParseQuery<Deck> query = ParseQuery.getQuery(Deck.class);
        //Get Deck Object
        query.getInBackground(deckId, new GetCallback<Deck>() {
            public void done(Deck deck, ParseException e) {
                //Deck object retrieved
                if (e == null) {
                    mDeck = deck;
                    //set Action Bar Title to deckname
                    //getActionBar().setTitle(deck.getName());

                    // Define the class we would like to query
                    ParseQuery<Flashcard> query = ParseQuery.getQuery(Flashcard.class);
                    // Define our query conditions
                    query.whereEqualTo("deck", mDeck);
                    query.orderByDescending("createdAt");
                    // Execute the find asynchronously
                    query.findInBackground(new FindCallback<Flashcard>() {
                        public void done(List<Flashcard> itemList, ParseException e) {
                            if (e == null) {
                                mFlashcards = itemList;
                            } else {
                                Log.d("item", "Error: " + e.getMessage());
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Something went wrong",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //Create new Card fragment
            Flashcard mFlashcard = mFlashcards.get(position);
            return CardFragment.newInstance(mFlashcard);
        }

        @Override
        public int getCount() {
            return mFlashcards.size();
        }
    }


}
