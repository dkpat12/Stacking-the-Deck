package net.dkpat.stackingthedeck.ParseLogin;

/**
 * Created by drclap01 on 12/13/15.
 */
public interface ParseOnLoadingListener {
    public void onLoadingStart(boolean showSpinner);

    public void onLoadingFinish();
}