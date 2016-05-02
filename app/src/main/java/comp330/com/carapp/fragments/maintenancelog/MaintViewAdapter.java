package comp330.com.carapp.fragments.maintenancelog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import comp330.com.carapp.R;
import comp330.com.carapp.model.MaintenanceInterface;

/**
 * Maintenance View Adapter for the maintenance cards.
 */

public class MaintViewAdapter extends RecyclerView.Adapter<MaintViewAdapter.MaintViewHolder> {
    private ArrayList<MaintenanceInterface> maintList;
    public MaintViewAdapter(ArrayList<MaintenanceInterface> maintList) {
        this.maintList = maintList;
    }
    @Override
    public MaintViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.maint_card_layout, parent, false);

        return new MaintViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MaintViewHolder holder, int position) {
        MaintenanceInterface mi = maintList.get(position);
        holder.maintTitle.setText(mi.getType());
        String predate = mi.getMileage().getDate();
        String date = predate.substring(4,6) + "/" + predate.substring(6,8) + "/" + predate.substring(0,4);
        holder.maintDate.setText(date);
        holder.maintMileage.setText(Integer.valueOf(mi.getMileage().getMileage()).toString() + " miles");
    }

    @Override
    public int getItemCount() {
        return maintList.size();
    }

    public class MaintViewHolder extends RecyclerView.ViewHolder {
        protected TextView maintTitle;
        protected TextView maintDate;
        protected TextView maintMileage;
        public MaintViewHolder(View v) {
            super(v);
            maintTitle = (TextView) v.findViewById(R.id.maintTitle);
            maintDate = (TextView) v.findViewById(R.id.txtDate);
            maintMileage = (TextView) v.findViewById(R.id.txtMileage);
        }
    }
}
