package com.example.tiktokappdev.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.tiktokappdev.Adapter.MyCatsGridviewAdapter;
import com.example.tiktokappdev.DataManagers.MyCatsDataManager;
import com.example.tiktokappdev.DataModels.MyCatsDataModel;
import com.example.tiktokappdev.R;

public class MyCatsMasterFragment extends Fragment {

    // DataManager
    MyCatsDataManager MCDM;

    public interface CatsSelectedListener {
        void onCatSelected(MyCatsDataModel cats);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_mycatsmasterfragment, container, false);


        MCDM = new MyCatsDataManager(getActivity());
        final MyCatsDataModel[] cats = MCDM.GetAllCats();


        GridView gridViewCats = view.findViewById(R.id.GridView_MyCats);
        MyCatsGridviewAdapter catGridViewAdapter = new MyCatsGridviewAdapter(this.getContext(), cats);


        gridViewCats.setAdapter(catGridViewAdapter);

        gridViewCats.setOnItemClickListener((parent, view1, position, id) -> {

            MyCatsDataModel selectedCat = cats[position];
            Activity parentActivity = getActivity();
            if (parentActivity instanceof CatsSelectedListener)
            {
                // when gridview is clicked, pass in the equipment id
                ((CatsSelectedListener)parentActivity).onCatSelected(selectedCat);
            }

        });

        return view;

    }

}