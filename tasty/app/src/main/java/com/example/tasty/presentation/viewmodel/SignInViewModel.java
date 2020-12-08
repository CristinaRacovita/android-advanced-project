package com.example.tasty.presentation.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import androidx.work.WorkManager;

public class SignInViewModel extends ViewModel {

    public static final String LOG_TAG = "SignInActivity";

    public final WorkManager workManager;

    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    public SignInViewModel(WorkManager workManager) {
        this.workManager = workManager;
    }
}
