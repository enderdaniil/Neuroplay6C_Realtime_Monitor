package com.example.coursach_0.ui.filters;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FiltersViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FiltersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("_");
    }

    public LiveData<String> getText() {
        return mText;
    }
}