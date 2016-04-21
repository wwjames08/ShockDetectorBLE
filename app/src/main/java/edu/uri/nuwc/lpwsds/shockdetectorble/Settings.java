package edu.uri.nuwc.lpwsds.shockdetectorble;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;

public class Settings extends AppCompatActivity {

    public static final String DEVICE_PREF = "DeviceSettings";

    private EditText thresholdValue;
    private NumberPicker durationValue;

    private boolean mVibrate;
    private boolean mSound;
    private boolean mLed;

    private CheckBox cbVibrate, cbSound, cbLed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setHomeButtonEnabled(true);

        NumberPicker np = (NumberPicker)findViewById(R.id.measurement_value);
        np.setMinValue(1);// restricted number to minimum value i.e 1
        np.setMaxValue(5);// restricted number to maximum value i.e. 5
        np.setWrapSelectorWheel(false);

        // Access the default SharedPreferences
        SharedPreferences settings = getSharedPreferences(DEVICE_PREF, MODE_PRIVATE);
        // The SharedPreferences editor - must use commit() to submit changes
        final SharedPreferences.Editor editor = settings.edit();

        cbVibrate = (CheckBox) findViewById(R.id.cb_vibrate);
        cbSound = (CheckBox) findViewById(R.id.cb_sound);
        cbLed = (CheckBox) findViewById(R.id.cb_led);

        mVibrate = settings.getBoolean("settingVibrate", false);
        mSound = settings.getBoolean("settingSound", false);
        mLed = settings.getBoolean("settingLed", false);

        cbVibrate.setChecked(mVibrate);
        cbSound.setChecked(mSound);
        cbLed.setChecked(mLed);

        cbVibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mVibrate = !mVibrate;
                }
            }
        });
        cbSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mSound = !mSound;
                }
            }
        });
        cbLed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mLed = !mLed;
                }
            }
        });

        //Get references to the text fields
        thresholdValue = (EditText) findViewById(R.id.threshold_value);
        durationValue = (NumberPicker) findViewById(R.id.measurement_value);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public void onPause(){
        super.onPause();
        //Update the shared pref of the values the user entered
        // Access the default SharedPreferences
        SharedPreferences settings = getSharedPreferences(DEVICE_PREF, MODE_PRIVATE);
        // The SharedPreferences editor - must use commit() to submit changes
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("thresholdValue",thresholdValue.getText().toString());
        editor.putInt("durationValue",durationValue.getValue());

        editor.putBoolean("settingVibrate", mVibrate);
        editor.putBoolean("settingSound", mSound);
        editor.putBoolean("settingLed", mLed);

        editor.commit();
    }

}
