package edu.uri.nuwc.lpwsds.shockdetectorble.database;


import io.realm.RealmObject;

/**
 * Holds shock data samples for each shock event
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
