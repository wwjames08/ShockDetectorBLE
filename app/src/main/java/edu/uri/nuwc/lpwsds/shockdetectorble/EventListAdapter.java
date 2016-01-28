package edu.uri.nuwc.lpwsds.shockdetectorble;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.uri.nuwc.lpwsds.shockdetectorble.database.ShockEvent;

/**
 * Recyclerview adapter for the event history list
 */
public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder>{

    private List<ShockEvent> shockEventList = null;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;
        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public EventListAdapter(List<ShockEvent> shockEventList){
        this.shockEventList = shockEventList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public EventListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_entry_layout, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        EventData eventData = eventDataList.get(position);
//
//        if(eventData != null){
//            TextView tv1 = (TextView) holder.mView.findViewById(R.id.timestamp);
//            TextView tv2 = (TextView) holder.mView.findViewById(R.id.shockLevel);
//        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if(shockEventList == null){
            return 0;
        }
        return shockEventList.size();
    }

}
