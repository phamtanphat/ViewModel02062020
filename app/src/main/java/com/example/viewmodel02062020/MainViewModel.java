package com.example.viewmodel02062020;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> mText = new MutableLiveData<>();

    public void setText(String text){
        mText.setValue(text);
    }
    public LiveData<String> getText(){
        return mText;
    }
}
