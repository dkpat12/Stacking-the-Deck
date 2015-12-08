package net.dkpat.stackingthedeck.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by Dillion on 12/2/2015.
 */

@ParseClassName("Flashcard")
public class Flashcard extends ParseObject {

    //Default Constructor
    public Flashcard() {
        super();
    }

    //Constructor for setting properties
    public Flashcard(String id, String term, String definition) {
        super();

        //setUUID(id);
        setTerm(term);
        setDefinition(definition);
    }

    // Use getString and others to access fields
    public String getTerm() {
        return getString("term");
    }

    // Use put to modify field values
    public void setTerm(String value) {
        put("term", value);
    }

    // Use getString and others to access fields
    public String getDefintion() {
        return getString("definition");
    }

    // Use put to modify field values
    public void setDefinition(String value) {
        put("definition", value);
    }

    // Get the user for this item
    public ParseUser getUser()  {
        return getParseUser("owner");
    }

    // Associate each item with a user
    public void setOwner(ParseUser user) {
        put("owner", user);
    }
}