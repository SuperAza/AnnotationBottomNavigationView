package com.yy.miyuan.ui.msg;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MsgViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MsgViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is msg fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}