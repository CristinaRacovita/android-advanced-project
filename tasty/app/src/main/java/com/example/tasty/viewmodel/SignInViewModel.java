package com.example.tasty.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tasty.model.User;

public class SignInViewModel extends ViewModel {

    public static final String LOG_TAG = "SignInActivity";
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    private MutableLiveData<User> userMutableLiveData;

    private MutableLiveData<Boolean> isGuest = new MutableLiveData<>();

    public MutableLiveData<User> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public MutableLiveData<Boolean> getIsGuest() {
        return isGuest;
    }

    public void loginHit() {
        Log.d(LOG_TAG, "Login Button was hit!");

        isGuest.setValue(false);

        Log.d(LOG_TAG, "Username: " + username.getValue());
        Log.d(LOG_TAG, "Password: " + password.getValue());

        User loginUser = new User(username.getValue(), password.getValue());

        userMutableLiveData.setValue(loginUser);

    }


    public void loginGuestHit() {
        isGuest.setValue(true);
        Log.d(LOG_TAG, "Login as Guest Button was hit! "+isGuest.getValue());
    }
}
