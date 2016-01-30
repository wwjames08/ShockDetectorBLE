package edu.uri.nuwc.lpwsds.shockdetectorble;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.NumberPicker;

public class Settings extends AppCompatActivity {

    public static final String DEVICE_PREF = "DeviceSettings";

    private EditText thresholdValue;
    private NumberPicker durationValue;

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
        SharedPreferences.Editor editor = settings.edit();

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

    }

}
