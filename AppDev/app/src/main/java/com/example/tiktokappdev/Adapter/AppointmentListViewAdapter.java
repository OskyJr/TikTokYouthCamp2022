package com.example.tiktokappdev.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tiktokappdev.DataManagers.UserDetailsDataManager;
import com.example.tiktokappdev.DataModels.AppointmentDataModel;
import com.example.tiktokappdev.DataModels.UserDetailsDataModel;
import com.example.tiktokappdev.R;

public class AppointmentListViewAdapter extends ArrayAdapter {


    private AppointmentDataModel[] data;



    public AppointmentListViewAdapter(Context context, AppointmentDataModel[] data)
    {
        super(context, 0, data);
        this.data = data;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;


        if (itemView == null)
            itemView = ((Activity)this.getContext()).getLayoutInflater().inflate(R.layout.listview_apptcontentlayout, null);

        TextView tv_apptlocation = itemView.findViewById(R.id.tv_apptlocation);
        tv_apptlocation.setText(data[position].getLocation());

        TextView tv_apptdate = itemView.findViewById(R.id.tv_apptdate);
        tv_apptdate.setText(data[position].getDate());

        TextView tv_appttime = itemView.findViewById(R.id.tv_appttime);
        tv_appttime.setText(data[position].getTime());

        TextView tv_apptnoofpax = itemView.findViewById(R.id.tv_apptnoofpax);
        tv_apptnoofpax.setText(data[position].getNoOfPax());

        TextView tv_totalcost = itemView.findViewById(R.id.tv_totalcost);
        tv_totalcost.setText(data[position].getTotalCost());


        return itemView;

    }

}
