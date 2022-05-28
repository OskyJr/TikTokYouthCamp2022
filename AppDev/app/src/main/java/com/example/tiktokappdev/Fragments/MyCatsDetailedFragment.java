package com.example.tiktokappdev.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiktokappdev.DataManagers.MyCatsDataManager;
import com.example.tiktokappdev.DataModels.MyCatsDataModel;
import com.example.tiktokappdev.R;

public class MyCatsDetailedFragment extends Fragment {

    // DataManager
    MyCatsDataManager MCDM;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_mycatsdetailedfragment, container, false);


        //Passing in the selected product ID
        Bundle params = this.getArguments();
        assert params != null;
        final String selectedCatID = params.getString("CatID");

        MCDM = new MyCatsDataManager(getActivity());
        final MyCatsDataModel cats = MCDM.GetCatsInformationByID(selectedCatID);


        if(cats != null)
        {
            ImageView imageView = view.findViewById((R.id.imageView_CatImage));
            imageView.setImageResource(cats.getImage());

            TextView textViewCatName = view.findViewById(R.id.textView_CatName);
            textViewCatName.setText(cats.getName());

            TextView textViewCatAge = view.findViewById(R.id.textView_CatAge);
            textViewCatAge.setText(cats.getAge());

            TextView textViewCatBreed = view.findViewById(R.id.textView_CatBreed);
            textViewCatBreed.setText(cats.getBreed());

            TextView textViewCatDescription = view.findViewById(R.id.textView_CatDescription);
            textViewCatDescription.setText(cats.getDescription());
        }

        return view;

    }

}