package edu.uri.nuwc.lpwsds.shockdetectorble;


import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;

import edu.uri.nuwc.lpwsds.shockdetectorble.database.EventData;
import edu.uri.nuwc.lpwsds.shockdetectorble.database.ShockEvent;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;

public class DataBase {
    private BluetoothAdapter mBluetoothAdapter;

    private EventData mEventData;
    private ShockEvent mShockEvent;

    private Realm mData;

    private ServiceConnection onService = null;

    private Handler mHandler;

    public DataBase(Context context){
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(context).build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

}
