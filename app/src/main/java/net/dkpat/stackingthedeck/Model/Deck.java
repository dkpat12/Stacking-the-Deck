package net.dkpat.stackingthedeck.Model;

/**
 * Created by drclap01 on 11/30/15.
 */
public class Deck {

    public String deckID;
    public String deckName;

    public Deck(){
        this.deckID="";
        this.deckName="";
    }

    public void setDeckId (String deckID){
        this.deckID = deckID;
    }

    public String getDeckId(){
        return deckID;
    }

    public void setDeckName(String deckName){
        this.deckName = deckName;
    }

    public String getDeckName(){
        return deckName;
    }
}
