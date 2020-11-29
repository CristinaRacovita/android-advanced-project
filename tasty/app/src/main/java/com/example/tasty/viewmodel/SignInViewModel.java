package com.example.tasty.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.work.WorkManager;

public class SignInViewModel extends ViewModel {

    public static final String LOG_TAG = "SignInActivity";

    public final WorkManager workManager;

    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    public SignInViewModel(WorkManager workManager) {
        this.workManager = workManager;
    }
}
