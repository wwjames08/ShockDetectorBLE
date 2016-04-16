package edu.uri.nuwc.lpwsds.shockdetectorble.database;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
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

    private RealmList<EventData> eventDatas;

    // Holds each data sample for the Shock event
    //private EventData eventData;

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

    public RealmResults<EventData> getEventDatas(){
        Realm realm = Realm.getDefaultInstance();
        // Build the query looking at all users:
        RealmQuery<EventData> query = realm.where(EventData.class);
        RealmResults<EventData> results = realm.where(EventData.class)
                .equalTo("id", eventTimeStampPeak)
                .findAll();
        return results;
    }

    public void setEventData(String[] timeStamps, String[] shockLevels){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        for (int i = 0; i<timeStamps.length; i++){
            EventData eventData = realm.createObject(EventData.class);
            eventData.setId(eventTimeStampPeak);
            eventData.setTimeStamp(timeStamps[i]);
            eventData.setShockLevel(shockLevels[i]);
        }
        realm.commitTransaction();
    }

}
