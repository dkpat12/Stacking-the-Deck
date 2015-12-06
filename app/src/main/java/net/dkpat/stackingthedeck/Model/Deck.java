package net.dkpat.stackingthedeck.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by drclap01 on 11/30/15.
 */
public class Deck {

    public static class DeckItem {

        public String deckID;
        public String deckName;
        public String createdBy;

        public DeckItem(String deckID, String deckName, String createdBy) {
            this.deckID = deckID;
            this.deckName = deckName;
            this.createdBy = createdBy;
        }

        @Override
        public String toString() {
            return deckName;
        }

        public String getDeckId(){
            return deckID;
        }

        public void setDeckId (String deckID){
            this.deckID = deckID;
        }

        public void setDeckName(String deckName){
            this.deckName = deckName;
        }

        public String getDeckName(){
            return deckName;
        }

        public String getCreatedBy() { return createdBy; }

        public void setCreatedBy(String createdBy){
            this.createdBy = createdBy;
        }
    }


    /**
     * An array of sample (dummy) items.
     */
    public static final List<DeckItem> ITEMS = new ArrayList<DeckItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
//    public static final Map<String, DeckItem> ITEM_MAP = new HashMap<String, DeckItem>();
//
//    private static final int COUNT = 25;
//
//    static {
//        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDeckItem(i));
//        }
//    }
//
//    private static void addItem(DeckItem item) {
//        ITEMS.add(item);
//        ITEM_MAP.put(item.deckID, item);
//    }
//
//    private static DeckItem createDeckItem(int position) {
//        return new DeckItem(String.valueOf(position), "Item " + position, makeDetails(position));
//    }
//
//    private static String makeDetails(int position) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }
}
