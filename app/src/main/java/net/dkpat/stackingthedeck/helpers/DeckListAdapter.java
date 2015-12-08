package net.dkpat.stackingthedeck.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseQueryAdapter;

import net.dkpat.stackingthedeck.Model.Deck;
import net.dkpat.stackingthedeck.R;

/**
 * Created by Dillion on 12/8/2015.
 */
public class DeckListAdapter extends ParseQueryAdapter<Deck> {

    public DeckListAdapter(Context context,
                                ParseQueryAdapter.QueryFactory<Deck> queryFactory) {
        super(context, queryFactory);
    }

    @Override
    public View getItemView(Deck deck, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_deck_list_item, parent, false);
            holder = new ViewHolder();
            holder.mDeckName = (TextView) view
                    .findViewById(R.id.deck_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        TextView DeckName = holder.mDeckName;
        DeckName.setText(deck.getName());
//        if (flashcard.isDraft()) {
//            todoTitle.setTypeface(null, Typeface.ITALIC);
//        } else {
//            todoTitle.setTypeface(null, Typeface.NORMAL);
//        }
        return view;
    }

    private static class ViewHolder {
        TextView mDeckName;
    }
}
