package com.example.tasty.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.work.WorkManager;

public class SettingsViewModel extends ViewModel {
    public final WorkManager workManager;

    public SettingsViewModel(WorkManager workManager) {
        this.workManager = workManager;
    }
}
