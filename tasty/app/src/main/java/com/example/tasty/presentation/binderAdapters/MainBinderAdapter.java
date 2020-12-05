package com.example.tasty.presentation.binderAdapters;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;

import com.example.tasty.R;
import com.example.tasty.presentation.fragments.AllRecipesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainBinderAdapter {

    public static final String TAG_MAIN = "MainActivity";

    @BindingAdapter({"fragment"})
    public static void getItem(BottomNavigationView bottomNavigationView, int fragment) {

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_explore:
                        Log.d(TAG_MAIN,"Explore clicked!");
                        AllRecipesFragment allRecipesFragment = new AllRecipesFragment();
                        makeTransaction(bottomNavigationView.getContext(),allRecipesFragment);
                        break;
                    case R.id.action_add:
                        Log.d(TAG_MAIN,"Add Recipe clicked!");
                        break;
                    case R.id.action_my_recipes:
                        Log.d(TAG_MAIN,"My Recipes clicked!");
                        break;
                    case R.id.action_profile:
                        Log.d(TAG_MAIN,"Profile clicked!");
                        break;
                    default:
                        Log.d(TAG_MAIN,"Default case");
                }
                return true;
            }
        });
    }

    private static void makeTransaction(Context context, Fragment fragment) {
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.my_current_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
