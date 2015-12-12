package net.dkpat.stackingthedeck.ParseLogin;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;
import com.parse.ui.ParseLoginBuilder;
import com.parse.ui.ParseSignupFragment;

import net.dkpat.stackingthedeck.R;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener {

    private static final int LOGIN_REQUEST = 0;

    private TextView titleTextView;
    private TextView emailTextView;
    private TextView nameTextView;
    private Button loginOrLogoutButton;

    private ParseUser currentUser;

    private final int fragmentContainer = android.R.id.content;
    private Bundle configOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    @Override
    public void onSignUpClicked(String username, String password) {
        // Show the signup form, but keep the transaction on the back stack
        // so that if the user clicks the back button, they are brought back
        // to the login form.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(fragmentContainer,
                SignupFragment.newInstance(configOptions, username, password));
        transaction.addToBackStack(null);
        transaction.commit();
    }
}