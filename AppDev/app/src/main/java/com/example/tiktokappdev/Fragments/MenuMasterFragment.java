package com.example.tiktokappdev.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.tiktokappdev.Adapter.MenuGridviewAdaptor;
import com.example.tiktokappdev.DataModels.MenuDataModel;
import com.example.tiktokappdev.Network.Methods;
import com.example.tiktokappdev.Network.MyCallback;
import com.example.tiktokappdev.Network.RetrofitClient;
import com.example.tiktokappdev.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class MenuMasterFragment extends Fragment {
    private static final String TAG = "MenuMasterFragment";
    private  static final String imageNamePrefix = "image_menu";
    ArrayList<MenuDataModel.data> drinksData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_mycatsmasterfragment, container, false);

        // retrieve the food and drinks data from pinata cloud
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<MenuDataModel> call = methods.getAllData();

        Context menuContext = this.getContext();

        call.enqueue(new MyCallback<MenuDataModel>(menuContext) {

            public void onResponse(@NonNull Call<MenuDataModel> call, @NonNull Response<MenuDataModel> response) {
                Log.e(TAG, "onResponse: code: " +response.code() );

                assert response.body() != null;
                drinksData = response.body().getDrinks();

                for(int i = 0; i < drinksData.size(); i++) {
                    // image is a .png or .jpg
                    String Image = imageNamePrefix + i;
                    int ImageInt = requireActivity().getResources().getIdentifier(Image, "drawable", requireActivity().getPackageName());
                    if (ImageInt != 0) {
                        drinksData.get(i).setImage(ImageInt);
                    }
                }

                GridView gridViewMenu = view.findViewById(R.id.GridView_MyCats);
                MenuGridviewAdaptor menuGridviewAdaptor = new MenuGridviewAdaptor(menuContext, drinksData);
                gridViewMenu.setAdapter(menuGridviewAdaptor);
            }

            public void onFailure(@NonNull Call<MenuDataModel> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }

        });

        return view;

    }

}