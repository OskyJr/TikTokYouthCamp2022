package com.example.tiktokappdev.Network;
import android.content.Context;
import retrofit2.Callback;

public abstract class MyCallback<T> implements Callback<T> {
    Context arg;

    protected MyCallback(Context arg) {
        this.arg = arg;
    }

    protected MyCallback() {
    }
}
