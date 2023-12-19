package com.example.coursach_0.ui.rhythms;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RhythmsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RhythmsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}