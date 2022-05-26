package com.example.tiktokappdev.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.tiktokappdev.Adapter.MenuGridviewAdaptor;
import com.example.tiktokappdev.DataModels.MenuDataModel;
import com.example.tiktokappdev.DataModels.MyCatsDataModel;
import com.example.tiktokappdev.Network.Methods;
import com.example.tiktokappdev.Network.MyCallback;
import com.example.tiktokappdev.Network.RetrofitClient;
import com.example.tiktokappdev.SessionManager.SessionManager;
import com.example.tiktokappdev.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuMasterFragment extends Fragment {
    // session
    SessionManager sessionManager;
    private static final String TAG = "MenuMasterFragment";

    ArrayList<MenuDataModel.data> drinksData;
    ArrayList<MenuDataModel.data> foodData;

    public interface CatsSelectedListener {
        void onCatSelected(MyCatsDataModel cats);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_mycatsmasterfragment, container, false);

        // retrieve the food and drinks data from pinata cloud
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<MenuDataModel> call = methods.getAllData();

        Context menuContext = this.getContext();

        call.enqueue(new MyCallback<MenuDataModel>(menuContext) {

            public void onResponse(Call<MenuDataModel> call, Response<MenuDataModel> response) {
                Log.e(TAG, "onResponse: code: " +response.code() );

                drinksData = response.body().getDrinks();
                foodData = response.body().getFood();

                //TODO: change R.id.GridView_MyCats?
                GridView gridViewMenu = view.findViewById(R.id.GridView_MyCats);
                MenuGridviewAdaptor menuGridviewAdaptor = new MenuGridviewAdaptor(menuContext, drinksData);
                gridViewMenu.setAdapter(menuGridviewAdaptor);
            }

            public void onFailure(Call<MenuDataModel> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }

        });

//        gridViewCats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                MyCatsDataModel selectedCat = cats[position];
//                Activity parentActivity = getActivity();
//                if (parentActivity instanceof CatsSelectedListener)
//                {
//                    // when gridview is clicked, pass in the equipment id
//                    ((CatsSelectedListener)parentActivity).onCatSelected(selectedCat);
//                }
//
//            }
//        });

        return view;

    }

}