package com.yy.miyuan.ui.blind;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BlindViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BlindViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is blind fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}