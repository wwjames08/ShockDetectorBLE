package edu.uri.nuwc.lpwsds.shockdetectorble;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 *
 */
public class ShockEvent extends RealmObject {

    @PrimaryKey
    private String eventID;

    // Holds each data sample for the Shock event
    private RealmList<EventData> eventData;

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public RealmList<EventData> getEventData() {
        return eventData;
    }

    public void setEventData(RealmList<EventData> eventData) {
        this.eventData = eventData;
    }
}
