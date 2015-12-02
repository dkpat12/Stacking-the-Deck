package net.dkpat.stackingthedeck.Model;

/**
 * Created by drclap01 on 11/30/15.
 */
public class FlashCard {

    public String fcID;
    public String fcName;

    public FlashCard(){
        this.fcID="";
        this.fcName="";
    }

    public void setFlashCardID (String fcID){
        this.fcID = fcID;
    }

    public String getFlashCardID(){
        return fcID;
    }

    public void setFlashCardName(String flashCardName){
        this.fcName = flashCardName;
    }

    public String getDeckName(){
        return fcName;
    }
}
