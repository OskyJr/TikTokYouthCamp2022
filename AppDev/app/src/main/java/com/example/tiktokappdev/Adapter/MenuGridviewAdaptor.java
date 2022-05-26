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

import com.example.tiktokappdev.DataModels.MenuDataModel;
import com.example.tiktokappdev.DataModels.MyCatsDataModel;
import com.example.tiktokappdev.R;

import java.util.ArrayList;


public class MenuGridviewAdaptor extends ArrayAdapter {


    private ArrayList<MenuDataModel.data> data;

    public MenuGridviewAdaptor(Context context, ArrayList<MenuDataModel.data> data) {
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

        final MenuDataModel.data MyCatsDataModel = data.get(position);

        //ImageView imageView = itemView.findViewById(R.id.imageView_mycatsimage);
        //imageView.setImageResource(MyCatsDataModel.getImage());


        TextView txtView = itemView.findViewById(R.id.textViewMCName);
        txtView.setText(MyCatsDataModel.getName());

        return itemView;
    }


}
