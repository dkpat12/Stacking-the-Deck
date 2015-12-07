package net.dkpat.stackingthedeck;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by Dillion on 12/7/2015.
 */
public class StackDeckApp extends Application {
    //public static final String TODO_GROUP_NAME = "ALL_TODOS";

    @Override
    public void onCreate() {
        super.onCreate();

        // add Todo subclass
        //ParseObject.registerSubclass(Todo.class);

        // enable the Local Datastore
        Parse.enableLocalDatastore(getApplicationContext());
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key));
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);
    }
}