package edu.uri.nuwc.lpwsds.shockdetectorble.database;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * This Realm Object will hold the data for each shock
 * event sent from the remote device.
 * The data will consist of timestamp of the data was
 * received, the peak shock level detected of the shock
 * event and the total detected shock level samples of
 * the shock event.
 */
public class ShockEvent extends RealmObject {

    @PrimaryKey
    private String eventTimeStampPeak;
    private String eventShockLevelPeak;

    // Holds each data sample for the Shock event
    private RealmList<EventData> eventData;

    public String getEventShockLevelPeak() {
        return eventShockLevelPeak;
    }
    public void setEventShockLevelPeak(String eventShockLevelPeak) {
        this.eventShockLevelPeak = eventShockLevelPeak;
    }

    public String getEventTimeStampPeak() {
        return eventTimeStampPeak;
    }
    public void setEventTimeStampPeak(String eventTimeStampPeak) {
        this.eventTimeStampPeak = eventTimeStampPeak;
    }

    public RealmList<EventData> getEventData() {
        return eventData;
    }
    public void setEventData(RealmList<EventData> eventData) {
        this.eventData = eventData;
    }
}
