package net.dkpat.stackingthedeck.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dillion on 12/2/2015.
 */
/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Flashcard {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<FlashcardItem> ITEMS = new ArrayList<FlashcardItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, FlashcardItem> ITEM_MAP = new HashMap<String, FlashcardItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(FlashcardItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static FlashcardItem createDummyItem(int position) {
        return new FlashcardItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class FlashcardItem {
        public final String id;
        public final String term;
        public final String definition;

        public FlashcardItem(String id, String term, String definition) {
            this.id = id;
            this.term = term;
            this.definition = definition;
        }

        @Override
        public String toString() {
            return term;
        }
    }
}