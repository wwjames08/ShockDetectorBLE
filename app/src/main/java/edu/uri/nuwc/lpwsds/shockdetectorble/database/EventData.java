package edu.uri.nuwc.lpwsds.shockdetectorble.database;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Holds shock data samples for each shock event
 */
public class EventData extends RealmObject {

    @PrimaryKey
    private String id;
    private String timeStamp;
    private String shockLevel;

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

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
