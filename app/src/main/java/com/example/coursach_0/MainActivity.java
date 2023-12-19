package com.example.coursach_0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.coursach_0.global_variables.globalVariables;
import com.example.coursach_0.network.JsonReader;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.coursach_0.databinding.ActivityMainBinding;

import java.util.concurrent.CompletableFuture;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    public static String myPref = "myPref";

    public int getCurrentDeviceInfoUpdateMillisPreferencesValue()
    {
        SharedPreferences sp = getSharedPreferences(myPref, Context.MODE_PRIVATE);
        int currentDeviceInfoUpdateMillis = sp.getInt("currentDeviceInfoUpdateMillis", 10000);
        return currentDeviceInfoUpdateMillis;
    }

    public int getLastSpectrumUpdateMillisPreferencesValue()
    {
        SharedPreferences sp = getSharedPreferences(myPref, Context.MODE_PRIVATE);
        int lastSpectrumUpdateMillis = sp.getInt("lastSpectrumUpdateMillis", 100);
        return lastSpectrumUpdateMillis;
    }

    public int getRhythmsUpdateMillisPreferencesValue()
    {
        SharedPreferences sp = getSharedPreferences(myPref, Context.MODE_PRIVATE);
        int rhythmsUpdateMillis = sp.getInt("rhythmsUpdateMillis", 100);
        return rhythmsUpdateMillis;
    }

    public String getNeuroplayProServerconnectionString()
    {
        SharedPreferences sp = getSharedPreferences(myPref, Context.MODE_PRIVATE);
        String rhythmsUpdateMillis = sp.getString("sUrl", "http://10.0.2.2:2336/");
        return rhythmsUpdateMillis;
    }

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        globalVariables.setCurrentDeviceInfoUpdateMillis(getCurrentDeviceInfoUpdateMillisPreferencesValue());
        globalVariables.setLastSpectrumUpdateMillis(getLastSpectrumUpdateMillisPreferencesValue());
        globalVariables.setRhythmsUpdateMillis(getRhythmsUpdateMillisPreferencesValue());
        globalVariables.setsUrl(getNeuroplayProServerconnectionString());

        CompletableFuture.runAsync(() -> {
            JsonReader.startZeroDevice();
        });

        CompletableFuture.runAsync(() -> {
            JsonReader.enableDataGrabMode();
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_info, R.id.navigation_rhythms, R.id.navigation_filters, R.id.navigation_help, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}