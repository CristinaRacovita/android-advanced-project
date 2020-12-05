package com.example.tasty.presentation.viewmodel;

import java.lang.reflect.Field;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public ObservableField<Field> menuSelectedOption = new ObservableField<>();

    public ObservableField<Field> getMenuSelectedOption() {
        return menuSelectedOption;
    }

    public void setMenuSelectedOption(ObservableField<Field> menuSelectedOption) {
        this.menuSelectedOption = menuSelectedOption;
    }

    public MainViewModel() {
    }
}
