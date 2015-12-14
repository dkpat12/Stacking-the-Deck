package net.dkpat.stackingthedeck.ParseLogin;

/**
 * Created by drclap01 on 12/13/15.
 */
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ui.*;

/**
 * Base class with helper methods for fragments in ParseLoginUI.
 */
public class ParseLoginFragmentBase extends Fragment {
    protected ParseOnLoadingListener onLoadingListener;

    protected String getLogTag() {
        return null;
    }

    protected void showToast(int id) {
        showToast(getString(id));
    }

    protected void showToast(CharSequence text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    protected void loadingStart() {
        loadingStart(true);
    }

    protected void loadingStart(boolean showSpinner) {
        if (onLoadingListener != null) {
            onLoadingListener.onLoadingStart(showSpinner);
        }
    }

    protected void loadingFinish() {
        if (onLoadingListener != null) {
            onLoadingListener.onLoadingFinish();
        }
    }

    protected void debugLog(int id) {
        debugLog(getString(id));
    }

    protected void debugLog(String text) {
        if (Parse.getLogLevel() <= Parse.LOG_LEVEL_DEBUG &&
                Log.isLoggable(getLogTag(), Log.WARN)) {
            Log.w(getLogTag(), text);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    protected boolean isActivityDestroyed() {
        FragmentActivity activity = getActivity();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return activity == null || activity.isDestroyed();
        } else {
            return activity == null || ((com.parse.ui.ParseLoginActivity) activity).isDestroyed();
        }
    }
}

