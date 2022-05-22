package com.example.tiktokappdev.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tiktokappdev.DataModels.MyCatsDataModel;
import com.example.tiktokappdev.R;


public class MyCatsGridviewAdapter extends ArrayAdapter {


    private MyCatsDataModel[] data;

    public MyCatsGridviewAdapter(Context context, MyCatsDataModel[] data) {
        super(context, 0, data);
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View itemView = convertView;

        if (itemView == null) {
            itemView = ((Activity) this.getContext()).getLayoutInflater().inflate(R.layout.gridview_mycats, null);
        }

        final MyCatsDataModel MyCatsDataModel = data[position];

        ImageView imageView = itemView.findViewById(R.id.imageView_mycatsimage);
        imageView.setImageResource(MyCatsDataModel.getImage());


        TextView txtView = itemView.findViewById(R.id.textViewMCName);
        txtView.setText(MyCatsDataModel.getName());

        return itemView;
    }


}
