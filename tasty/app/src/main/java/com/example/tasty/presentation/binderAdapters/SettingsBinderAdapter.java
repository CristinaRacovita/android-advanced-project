package com.example.tasty.presentation.binderAdapters;

import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;

import com.example.tasty.presentation.services.UpdateService;

public class SettingsBinderAdapter {
    @BindingAdapter({"activateService"})
    public static void startService(Button button, String activate) {
        if (activate.equals("true")) {
            button.setOnClickListener(view -> {
                Intent serviceIntent = new Intent(button.getContext(), UpdateService.class);
                button.getContext().startService(serviceIntent);
                Toast.makeText(button.getContext(), "An update will start...", Toast.LENGTH_LONG).show();
            });
        }else{
            Toast.makeText(button.getContext(), "lala", Toast.LENGTH_LONG).show();
        }
    }
}
