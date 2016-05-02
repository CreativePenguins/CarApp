package comp330.com.carapp.fragments.mileagelog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import comp330.com.carapp.R;

/**
 * Created by Chrissy on 4/15/2016.
 */
public class MileageListViewAdapter extends BaseAdapter {

    public static final String DATE_COLUMN = "Date Column";
    public static final String MILEAGE_COLUMN = "Mileage Column";

    public ArrayList<HashMap<String,String>> list;
    Activity activity;


    public MileageListViewAdapter(Activity activity, ArrayList<HashMap<String,String>> list) {
        super();
        this.activity = activity;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtFirst;
        TextView txtSecond;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater =  activity.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.mileage_row, null);
            holder = new ViewHolder();
            holder.txtFirst = (TextView) convertView.findViewById(R.id.date);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.mileage);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        HashMap<String, String> map = list.get(position);
        String predate = map.get(DATE_COLUMN);
        String date = predate.substring(4,6) + "/" + predate.substring(6,8) + "/" + predate.substring(0,4);
        holder.txtFirst.setText(date);
        holder.txtSecond.setText(map.get(MILEAGE_COLUMN));


        return convertView;
    }
}
