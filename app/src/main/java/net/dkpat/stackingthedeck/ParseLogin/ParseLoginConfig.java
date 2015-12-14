package net.dkpat.stackingthedeck.ParseLogin;

/**
 * Created by drclap01 on 12/13/15.
 */
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.util.Log;

import com.parse.Parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Configurations for the ParseLoginActivity.
 */
public class ParseLoginConfig {
    public static final String APP_LOGO = "net.dkpat.stackingthedeck.ParseLogin.ParseLoginActivity.APP_LOGO";
    public static final String PARSE_LOGIN_ENABLED = "net.dkpat.stackingthedeck.ParseLogin.ParseLoginActivity.PARSE_LOGIN_ENABLED";
    public static final String PARSE_LOGIN_BUTTON_TEXT = "net.dkpat.stackingthedeck.ParseLogin.ParseLoginActivity.PARSE_LOGIN_BUTTON_TEXT";
    public static final String PARSE_SIGNUP_BUTTON_TEXT = "net.dkpat.stackingthedeck.ParseLogin.ParseLoginActivity.PARSE_SIGNUP_BUTTON_TEXT";
    public static final String PARSE_LOGIN_HELP_TEXT = "net.dkpat.stackingthedeck.ParseLogin.ParseLoginActivity.PARSE_LOGIN_HELP_TEXT";
    public static final String PARSE_LOGIN_INVALID_CREDENTIALS_TOAST_TEXT = "com.parse.ui.ParseLoginActivity.PARSE_LOGIN_INVALID_CREDENTIALS_TEXT";
    public static final String PARSE_LOGIN_EMAIL_AS_USERNAME = "net.dkpat.stackingthedeck.ParseLogin.ParseLoginActivity.PARSE_LOGIN_EMAIL_AS_USERNAME";
    public static final String PARSE_SIGNUP_MIN_PASSWORD_LENGTH = "net.dkpat.stackingthedeck.ParseLogin.ParseLoginActivity.PARSE_SIGNUP_MIN_PASSWORD_LENGTH";
    public static final String PARSE_SIGNUP_SUBMIT_BUTTON_TEXT = "net.dkpat.stackingthedeck.ParseLogin.ParseLoginActivity.PARSE_SIGNUP_SUBMIT_BUTTON_TEXT";
    public static final String PARSE_SIGNUP_NAME_FIELD_ENABLED = "net.dkpat.stackingthedeck.ParseLogin.ParseLoginActivity.PARSE_SIGNUP_NAME_FIELD_ENABLED";


    // Use boxed types so that we can differentiate between a setting not set,
    // versus its default value.  This is useful for merging options set from code
    // with options set by activity metadata.
    private Integer appLogo;
    private Boolean parseLoginEnabled;
    private CharSequence parseLoginButtonText;
    private CharSequence parseSignupButtonText;
    private CharSequence parseLoginHelpText;
    private CharSequence parseLoginInvalidCredentialsToastText;
    private Boolean parseLoginEmailAsUsername;
    private Integer parseSignupMinPasswordLength;
    private CharSequence parseSignupSubmitButtonText;
    private Boolean parseSignupNameFieldEnabled;

    private Boolean facebookLoginEnabled;
    private CharSequence facebookLoginButtonText;
    private Collection<String> facebookLoginPermissions;

    private Boolean twitterLoginEnabled;
    private CharSequence twitterLoginButtonText;

    public Integer getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(Integer appLogo) {
        this.appLogo = appLogo;
    }

    public boolean isParseLoginEnabled() {
        if (parseLoginEnabled != null) {
            return parseLoginEnabled;
        } else {
            return false;
        }
    }

    public void setParseLoginEnabled(boolean parseLoginEnabled) {
        this.parseLoginEnabled = parseLoginEnabled;
    }

    public CharSequence getParseLoginButtonText() {
        return parseLoginButtonText;
    }

    public void setParseLoginButtonText(CharSequence parseLoginButtonText) {
        this.parseLoginButtonText = parseLoginButtonText;
    }

    public CharSequence getParseSignupButtonText() {
        return parseSignupButtonText;
    }

    public void setParseSignupButtonText(CharSequence parseSignupButtonText) {
        this.parseSignupButtonText = parseSignupButtonText;
    }

    public CharSequence getParseLoginHelpText() {
        return parseLoginHelpText;
    }

    public void setParseLoginHelpText(CharSequence parseLoginHelpText) {
        this.parseLoginHelpText = parseLoginHelpText;
    }

    public CharSequence getParseLoginInvalidCredentialsToastText() {
        return parseLoginInvalidCredentialsToastText;
    }

    public void setParseLoginInvalidCredentialsToastText(
            CharSequence parseLoginInvalidCredentialsToastText) {
        this.parseLoginInvalidCredentialsToastText = parseLoginInvalidCredentialsToastText;
    }

    public boolean isParseLoginEmailAsUsername() {
        if (parseLoginEmailAsUsername != null) {
            return parseLoginEmailAsUsername;
        } else {
            return false;
        }
    }

    public void setParseLoginEmailAsUsername(boolean parseLoginEmailAsUsername) {
        this.parseLoginEmailAsUsername = parseLoginEmailAsUsername;
    }

    public Integer getParseSignupMinPasswordLength() {
        return parseSignupMinPasswordLength;
    }

    public void setParseSignupMinPasswordLength(Integer parseSignupMinPasswordLength) {
        this.parseSignupMinPasswordLength = parseSignupMinPasswordLength;
    }

    public CharSequence getParseSignupSubmitButtonText() {
        return parseSignupSubmitButtonText;
    }

    public void setParseSignupSubmitButtonText(
            CharSequence parseSignupSubmitButtonText) {
        this.parseSignupSubmitButtonText = parseSignupSubmitButtonText;
    }

    public Boolean isParseSignupNameFieldEnabled() {
        if (parseSignupNameFieldEnabled != null) {
            return parseSignupNameFieldEnabled;
        } else {
            return true;
        }
    }

    public void setParseSignupNameFieldEnabled(Boolean parseSignupNameFieldEnabled) {
        this.parseSignupNameFieldEnabled = parseSignupNameFieldEnabled;
    }

    public boolean isFacebookLoginEnabled() {
        if (facebookLoginEnabled != null) {
            return facebookLoginEnabled;
        } else {
            return false;
        }
    }

    public void setFacebookLoginEnabled(boolean facebookLoginEnabled) {
        this.facebookLoginEnabled = facebookLoginEnabled;
    }

    public CharSequence getFacebookLoginButtonText() {
        return facebookLoginButtonText;
    }

    public void setFacebookLoginButtonText(CharSequence facebookLoginButtonText) {
        this.facebookLoginButtonText = facebookLoginButtonText;
    }

    public Collection<String> getFacebookLoginPermissions() {
        if (facebookLoginPermissions != null) {
            return Collections.unmodifiableCollection(facebookLoginPermissions);
        } else {
            return null;
        }
    }

    public void setFacebookLoginPermissions(Collection<String> permissions) {
        if (permissions != null) {
            facebookLoginPermissions = new ArrayList<String>(permissions.size());
            facebookLoginPermissions.addAll(permissions);
        }
    }

    /* package */ boolean isFacebookLoginNeedPublishPermissions() {
        if (facebookLoginPermissions != null) {
            return facebookLoginPermissions.contains("publish_actions") ||
                    facebookLoginPermissions.contains("publish_pages");
        } else {
            return false;
        }
    }

    public boolean isTwitterLoginEnabled() {
        if (twitterLoginEnabled != null) {
            return twitterLoginEnabled;
        } else {
            return false;
        }
    }

    public void setTwitterLoginEnabled(boolean twitterLoginEnabled) {
        this.twitterLoginEnabled = twitterLoginEnabled;
    }

    public CharSequence getTwitterLoginButtonText() {
        return twitterLoginButtonText;
    }

    public void setTwitterLoginButtonText(CharSequence twitterLoginButtonText) {
        this.twitterLoginButtonText = twitterLoginButtonText;
    }

    /**
     * Converts this object into a Bundle object. For options that are not
     * explicitly set, we do not include them in the Bundle so that this bundle
     * can be merged with any default configurations and override only those keys
     * that are explicitly set.
     *
     * @return The Bundle object containing configurations.
     */
    public Bundle toBundle() {
        Bundle bundle = new Bundle();

        if (appLogo != null) {
            bundle.putInt(APP_LOGO, appLogo);
        }

        if (parseLoginEnabled != null) {
            bundle.putBoolean(PARSE_LOGIN_ENABLED, parseLoginEnabled);
        }
        if (parseLoginButtonText != null) {
            bundle.putCharSequence(PARSE_LOGIN_BUTTON_TEXT, parseLoginButtonText);
        }
        if (parseSignupButtonText != null) {
            bundle.putCharSequence(PARSE_SIGNUP_BUTTON_TEXT, parseSignupButtonText);
        }
        if (parseLoginHelpText != null) {
            bundle.putCharSequence(PARSE_LOGIN_HELP_TEXT, parseLoginHelpText);
        }
        if (parseLoginInvalidCredentialsToastText != null) {
            bundle.putCharSequence(PARSE_LOGIN_INVALID_CREDENTIALS_TOAST_TEXT,
                    parseLoginInvalidCredentialsToastText);
        }
        if (parseLoginEmailAsUsername != null) {
            bundle.putBoolean(PARSE_LOGIN_EMAIL_AS_USERNAME,
                    parseLoginEmailAsUsername);
        }
        if (parseSignupMinPasswordLength != null) {
            bundle.putInt(PARSE_SIGNUP_MIN_PASSWORD_LENGTH,
                    parseSignupMinPasswordLength);
        }
        if (parseSignupSubmitButtonText != null) {
            bundle.putCharSequence(PARSE_SIGNUP_SUBMIT_BUTTON_TEXT,
                    parseSignupSubmitButtonText);
        }
        if (parseSignupNameFieldEnabled != null) {
            bundle.putBoolean(PARSE_SIGNUP_NAME_FIELD_ENABLED, parseSignupNameFieldEnabled);
        }

        return bundle;
    }

    /**
     * Constructs a ParseLoginConfig object from a bundle. Unrecognized keys are
     * ignored.
     * <p/>
     * This can be used to pass an ParseLoginConfig object between activities, or
     * to read settings from an activity's meta-data in Manefest.xml.
     *
     * @param bundle
     *     The Bundle representation of the ParseLoginConfig object.
     * @param context
     *     The context for resolving resource IDs.
     * @return The ParseLoginConfig instance.
     */
    public static ParseLoginConfig fromBundle(Bundle bundle, Context context) {
        ParseLoginConfig config = new ParseLoginConfig();
        Set<String> keys = bundle.keySet();

        if (keys.contains(APP_LOGO)) {
            config.setAppLogo(bundle.getInt(APP_LOGO));
        }

        if (keys.contains(PARSE_LOGIN_ENABLED)) {
            config.setParseLoginEnabled(bundle.getBoolean(PARSE_LOGIN_ENABLED));
        }
        if (keys.contains(PARSE_LOGIN_BUTTON_TEXT)) {
            config.setParseLoginButtonText(bundle.getCharSequence(PARSE_LOGIN_BUTTON_TEXT));
        }
        if (keys.contains(PARSE_SIGNUP_BUTTON_TEXT)) {
            config.setParseSignupButtonText(bundle.getCharSequence(PARSE_SIGNUP_BUTTON_TEXT));
        }
        if (keys.contains(PARSE_LOGIN_HELP_TEXT)) {
            config.setParseLoginHelpText(bundle.getCharSequence(PARSE_LOGIN_HELP_TEXT));
        }
        if (keys.contains(PARSE_LOGIN_INVALID_CREDENTIALS_TOAST_TEXT)) {
            config.setParseLoginInvalidCredentialsToastText(bundle
                    .getCharSequence(PARSE_LOGIN_INVALID_CREDENTIALS_TOAST_TEXT));
        }
        if (keys.contains(PARSE_LOGIN_EMAIL_AS_USERNAME)) {
            config.setParseLoginEmailAsUsername(bundle.getBoolean(PARSE_LOGIN_EMAIL_AS_USERNAME));
        }
        if (keys.contains(PARSE_SIGNUP_MIN_PASSWORD_LENGTH)) {
            config.setParseSignupMinPasswordLength(bundle.getInt(PARSE_SIGNUP_MIN_PASSWORD_LENGTH));
        }
        if (keys.contains(PARSE_SIGNUP_SUBMIT_BUTTON_TEXT)) {
            config.setParseSignupSubmitButtonText(bundle.getCharSequence(PARSE_SIGNUP_SUBMIT_BUTTON_TEXT));
        }
        if (keys.contains(PARSE_SIGNUP_NAME_FIELD_ENABLED)) {
            config.setParseSignupNameFieldEnabled(bundle.getBoolean(PARSE_SIGNUP_NAME_FIELD_ENABLED));
        }

        return config;
    }

    private static Collection<String> stringArrayToCollection(String[] array) {
        if (array == null) {
            return null;
        }
        return Arrays.asList(array);
    }
}