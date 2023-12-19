package com.example.coursach_0.ui.info;

import android.os.Debug;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.coursach_0.network.JsonReader;

import org.json.JSONException;

import java.util.concurrent.CompletableFuture;

public class InfoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public InfoViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue(JsonReader.listDevices().toString());
        //mText.setValue("help");
        CompletableFuture.runAsync(() -> {
            mText.setValue(String.valueOf(CompletableFuture.runAsync(() -> {
                    JsonReader.currentDeviceInfo().toString();
                }))
            );
        });

        new Thread(() -> {
            try {
                run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }



    public LiveData<String> getText() {
        return mText;
    }

    private void run() throws InterruptedException {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            CompletableFuture.runAsync(() -> {
                mText.setValue(String.valueOf(CompletableFuture.runAsync(() -> {
                        JsonReader.currentDeviceInfo().toString();
                    }))
                );
            });
        }
    }
}