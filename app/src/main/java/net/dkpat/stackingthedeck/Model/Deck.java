package net.dkpat.stackingthedeck.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by drclap01 on 11/30/15.
 */

@ParseClassName("Deck")
public class Deck extends ParseObject {

    //Default Constructor
    public Deck() {
        super();
    }

    public Deck(String deckID, String deckName, ParseUser creator) {
        super();

        setName(deckName);
        setOwner(creator);
    }

    // Use getString and others to access fields
    public String getName() {
        return getString("name");
    }

    // Use put to modify field values
    public void setName(String value) {
        put("name", value);
    }

    // Get the user for this item
    public ParseUser getOwner()  {
        return getParseUser("owner");
    }

    // Associate each item with a user
    public void setOwner(ParseUser user) {
        put("owner", user);
    }

    //Published to Parse yet?
    public boolean isDraft() {
        return getBoolean("isDraft");
    }

    public void setDraft(boolean isDraft) {
        put("isDraft", isDraft);
    }

}
