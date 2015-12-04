package edu.uri.nuwc.lpwsds.shockdetectorble;

import io.realm.RealmObject;

/**
 * Holds shock data for each data sample
 */
public class EventData extends RealmObject {
    private String timeStamp;
    private String shockLevel;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getShockLevel() {
        return shockLevel;
    }

    public void setShockLevel(String shockLevel) {
        this.shockLevel = shockLevel;
    }
}
