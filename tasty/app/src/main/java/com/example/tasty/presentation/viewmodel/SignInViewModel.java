package com.example.tasty.presentation.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import androidx.work.WorkManager;

public class SignInViewModel extends ViewModel {

    public static final String LOG_TAG = "SignInActivity";

    public final WorkManager workManager;

    public ObservableField<String> username;
    public ObservableField<String> password;

    public SignInViewModel(WorkManager workManager) {
        username = new ObservableField<>();
        password = new ObservableField<>();

        this.workManager = workManager;
    }
}
