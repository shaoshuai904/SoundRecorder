package com.maple.soundrecorder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class SoundRecorderPreferenceActivity extends PreferenceActivity {
    private static final String RECORD_TYPE = "pref_key_record_type";

    private static final String ENABLE_HIGH_QUALITY = "pref_key_enable_high_quality";

    private static final String ENABLE_SOUND_EFFECT = "pref_key_enable_sound_effect";

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.layout.preferences);
    }

    public static String getRecordType(Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getString(RECORD_TYPE, context.getString(R.string.prefDefault_recordType));
    }

    public static boolean isHighQuality(Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getBoolean(ENABLE_HIGH_QUALITY, true);
    }

    public static boolean isEnabledSoundEffect(Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getBoolean(ENABLE_SOUND_EFFECT, true);
    }
}
