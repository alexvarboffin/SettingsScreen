package com.walhalla.settingsscreen.preference;

import android.os.Bundle;
import android.util.Log;

import com.walhalla.settingsscreen.R;

import androidx.fragment.app.DialogFragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat {
    private static final String TAG = "@@@";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.app_preferences, rootKey);
    }

    @Override
    public void onDisplayPreferenceDialog(Preference preference) {
        Log.i(TAG, "onDisplayPreferenceDialog: " + preference.getClass().getSimpleName());
        // Try if the preference is one of our custom Preferences
        DialogFragment dialogFragment = null;
        if (preference instanceof TimePreference) {
            // Create a new instance of TimePreferenceDialogFragment with the key of the related
            // Preference
            dialogFragment = TimePreferenceDialogFragmentCompat
                    .newInstance(preference.getKey());
        }

        // If it was one of our cutom Preferences, show its dialog
        if (dialogFragment != null) {
            dialogFragment.setTargetFragment(this, 0);
            if (getFragmentManager() != null) {
                dialogFragment.show(this.getFragmentManager(),
                        "androidx.preference" +
                                ".PreferenceFragment.DIALOG");
            }
        }
//        // Could not be handled here. Try with the super method.
//        else {
//            super.onDisplayPreferenceDialog(preference);
//        }
    }
}
