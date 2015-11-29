package edu.uri.nuwc.lpwsds.shockdetectorble;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 *
 */
public class ShockEvent extends RealmObject {

    @PrimaryKey
    private String eventID;

    private String eventTimestamp;
    private int eventShockLevel;
}
