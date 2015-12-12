package net.dkpat.stackingthedeck.helpers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.parse.ParseQueryAdapter;

import net.dkpat.stackingthedeck.EditDeckActivity;
import net.dkpat.stackingthedeck.Model.Deck;
import net.dkpat.stackingthedeck.R;

/**
 * Created by Dillion on 12/8/2015.
 */
public class DeckListAdapter extends ParseQueryAdapter<Deck> {

    private Context mContext;

    public DeckListAdapter(Context context,
                           ParseQueryAdapter.QueryFactory<Deck> queryFactory) {
        super(context, queryFactory);
        mContext = context;
    }

    @Override
    public View getItemView(Deck deck, View view, ViewGroup parent) {
        final ViewHolder holder;
        final Deck mDeck = deck;

        if (view == null) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_deck_list_item, parent, false);
            holder = new ViewHolder();
            holder.mDeckName = (TextView) view.findViewById(R.id.deck_name);
            holder.mDeckMenu = (ImageView) view.findViewById(R.id.deck_menu);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        TextView DeckName = holder.mDeckName;
        DeckName.setText(deck.getName());

//        holder.mDeckMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final PopupMenu popmenu = new PopupMenu(mContext, holder.mDeckMenu);
//                popmenu.getMenuInflater().inflate(R.menu.menu_deck_context, popmenu.getMenu());
//
//                popmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        switch (item.getItemId()) {
//                            case R.id.action_delete:
//                                return true;
//                            case R.id.action_edit_deck:
//                                /********** MAY NOT WORK ************/
//                                OnDeckMenuSelect();
//
//                                return true;
//                            case R.id.action_rename:
//                                return true;
//                            case R.id.action_share:
//                                return true;
//                            default:
//                                return false;
//                        }
//                    }
//                });
//            }
//        });
//        if (flashcard.isDraft()) {
//            todoTitle.setTypeface(null, Typeface.ITALIC);
//        } else {
//            todoTitle.setTypeface(null, Typeface.NORMAL);
//        }
        return view;
    }

    private static class ViewHolder {
        TextView mDeckName;
        ImageView mDeckMenu;
    }
}
