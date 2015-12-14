package net.dkpat.stackingthedeck.ParseLogin;

/**
 * Created by drclap01 on 12/13/15.
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;
import com.parse.ui.ParseLoginConfig;
import net.dkpat.stackingthedeck.R;
import com.parse.ui.ParseOnLoadingListener;

/**
 * Fragment for the login help screen for resetting the user's password.
 */
public class ParseLoginHelpFragment extends com.parse.ui.ParseLoginFragmentBase implements OnClickListener {

    public interface ParseOnLoginHelpSuccessListener {
        public void onLoginHelpSuccess();
    }

    private TextView instructionsTextView;
    private EditText emailField;
    private Button submitButton;
    private boolean emailSent = false;
    private ParseOnLoginHelpSuccessListener onLoginHelpSuccessListener;

    private com.parse.ui.ParseLoginConfig config;

    private static final String LOG_TAG = "ParseLoginHelpFragment";

    public static ParseLoginHelpFragment newInstance(Bundle configOptions) {
        ParseLoginHelpFragment loginHelpFragment = new ParseLoginHelpFragment();
        loginHelpFragment.setArguments(configOptions);
        return loginHelpFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        config = ParseLoginConfig.fromBundle(getArguments(), getActivity());

        View v = inflater.inflate(R.layout.com_parse_ui_parse_login_help_fragment,
                parent, false);
        ImageView appLogo = (ImageView) v.findViewById(R.id.app_logo);
        instructionsTextView = (TextView) v
                .findViewById(R.id.login_help_instructions);
        emailField = (EditText) v.findViewById(R.id.login_help_email_input);
        submitButton = (Button) v.findViewById(R.id.login_help_submit);

        if (appLogo != null && config.getAppLogo() != null) {
            appLogo.setImageResource(config.getAppLogo());
        }

        submitButton.setOnClickListener(this);
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof ParseOnLoadingListener) {
            onLoadingListener = (ParseOnLoadingListener) activity;
        } else {
            throw new IllegalArgumentException(
                    "Activity must implemement ParseOnLoadingListener");
        }

        if (activity instanceof ParseOnLoginHelpSuccessListener) {
            onLoginHelpSuccessListener = (ParseOnLoginHelpSuccessListener) activity;
        } else {
            throw new IllegalArgumentException(
                    "Activity must implemement ParseOnLoginHelpSuccessListener");
        }
    }

    @Override
    public void onClick(View v) {
        if (!emailSent) {
            String email = emailField.getText().toString();
            if (email.length() == 0) {
                showToast(R.string.com_parse_ui_no_email_toast);
            } else {
                loadingStart();
                ParseUser.requestPasswordResetInBackground(email,
                        new RequestPasswordResetCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (isActivityDestroyed()) {
                                    return;
                                }

                                loadingFinish();
                                if (e == null) {
                                    instructionsTextView
                                            .setText(R.string.com_parse_ui_login_help_email_sent);
                                    emailField.setVisibility(View.INVISIBLE);
                                    submitButton
                                            .setText(R.string.com_parse_ui_login_help_login_again_button_label);
                                    emailSent = true;
                                } else {
                                    debugLog(getString(R.string.com_parse_ui_login_warning_password_reset_failed) +
                                            e.toString());
                                    if (e.getCode() == ParseException.INVALID_EMAIL_ADDRESS ||
                                            e.getCode() == ParseException.EMAIL_NOT_FOUND) {
                                        showToast(R.string.com_parse_ui_invalid_email_toast);
                                    } else {
                                        showToast(R.string.com_parse_ui_login_help_submit_failed_unknown);
                                    }
                                }
                            }
                        });
            }
        } else {
            onLoginHelpSuccessListener.onLoginHelpSuccess();
        }
    }

    @Override
    protected String getLogTag() {
        return LOG_TAG;
    }
}
