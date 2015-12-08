package net.dkpat.stackingthedeck.helpers;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseQueryAdapter;

import net.dkpat.stackingthedeck.Model.Flashcard;
import net.dkpat.stackingthedeck.R;

/**
 * Created by Dillion on 12/8/2015.
 */
public class FlashcardListAdapter extends ParseQueryAdapter<Flashcard> {

    public FlashcardListAdapter(Context context,
                                ParseQueryAdapter.QueryFactory<Flashcard> queryFactory) {
        super(context, queryFactory);
    }

    @Override
    public View getItemView(Flashcard flashcard, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_flashcard_list_item, parent, false);
            holder = new ViewHolder();
            holder.mflashcardTerm = (TextView) view
                    .findViewById(R.id.flashcard_term);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        TextView FlashcardTerm = holder.mflashcardTerm;
        FlashcardTerm.setText(flashcard.getTerm());
//        if (flashcard.isDraft()) {
//            todoTitle.setTypeface(null, Typeface.ITALIC);
//        } else {
//            todoTitle.setTypeface(null, Typeface.NORMAL);
//        }
        return view;
    }

    private static class ViewHolder {
        TextView mflashcardTerm;
    }
}
