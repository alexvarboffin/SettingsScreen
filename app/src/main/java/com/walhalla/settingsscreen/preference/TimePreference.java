package com.walhalla.settingsscreen.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;

import android.util.AttributeSet;

import com.walhalla.settingsscreen.R;

import androidx.annotation.RequiresApi;
import androidx.preference.DialogPreference;

public class TimePreference extends DialogPreference {

    private int mTime = 0;
    private int mDialogLayoutResId = R.layout.pref_dialog_time;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TimePreference(Context context) {
        this(context, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TimePreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TimePreference(Context context, AttributeSet attrs,
                          int defStyleAttr) {
        this(context, attrs, defStyleAttr, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TimePreference(Context context, AttributeSet attrs,
                          int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        // Do custom stuff here
        // ...
        // read attributes etc.
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        // Default value from attribute. Fallback value is set to 0.
        return a.getInt(index, 0);
    }

//    deprecated
//    @Override
//    protected void onSetInitialValue(boolean restorePersistedValue,
//                                     Object defaultValue) {
//        // Read the value. Use the default value if it is not possible.
//        setTime(restorePersistedValue ?
//                getPersistedInt(mTime) : (int) defaultValue);
//    }


    @Override
    protected void onSetInitialValue(Object defaultValue) {
        // Read the value. Use the default value if it is not possible.
        setTime(getPersistedInt(mTime));
    }

    public int getTime() {
        return mTime;
    }

    public void setTime(int time) {
        mTime = time;

        // Save to Shared Preferences
        persistInt(time);
    }

    @Override
    public int getDialogLayoutResource() {
        return mDialogLayoutResId;
    }


}
