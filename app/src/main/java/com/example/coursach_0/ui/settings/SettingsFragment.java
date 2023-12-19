package com.example.coursach_0.ui.settings;

import static com.example.coursach_0.MainActivity.myPref;
import static java.lang.Integer.parseInt;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.coursach_0.MainActivity;
import com.example.coursach_0.R;
import com.example.coursach_0.databinding.FragmentInfoBinding;
import com.example.coursach_0.global_variables.globalVariables;

public class SettingsFragment extends Fragment {
    private SettingsViewModel mViewModel;

    private EditText currentDeviceInfoUpdateMillisEditText;
    private EditText lastSpectrumUpdateMillisEditText;
    private EditText rhythmsUpdateMillisEditText;
    private EditText neuroplayIp;
    private Button submitButton;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    public void writeCurrentDeviceInfoUpdateMillisToPreference(int currentDeviceInfoUpdateMillis)
    {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(MainActivity.myPref, Context.MODE_PRIVATE).edit();
        editor.putInt("currentDeviceInfoUpdateMillis", currentDeviceInfoUpdateMillis);
        editor.apply();
    }

    public void writeLastSpectrumUpdateMillisToPreference(int lastSpectrumUpdateMillis)
    {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(MainActivity.myPref,Context.MODE_PRIVATE).edit();
        editor.putInt("lastSpectrumUpdateMillis", lastSpectrumUpdateMillis);
        editor.apply();
    }

    public void writeRhythmsUpdateMillisToPreference(int rhythmsUpdateMillis)
    {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(MainActivity.myPref,Context.MODE_PRIVATE).edit();
        editor.putInt("rhythmsUpdateMillis", rhythmsUpdateMillis);
        editor.apply();
    }

    public void writeNeuroplayProServerconnectionString(String connectionString)
    {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(MainActivity.myPref,Context.MODE_PRIVATE).edit();
        editor.putString("sUrl", connectionString);
        editor.apply();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        globalVariables.setCurrentView(R.layout.fragment_settings);

        View root = inflater.inflate(R.layout.fragment_settings, container, false).getRootView();

        currentDeviceInfoUpdateMillisEditText = root.findViewById(R.id.currentDeviceInfoUpdateMillis_dynamic);
        lastSpectrumUpdateMillisEditText = root.findViewById(R.id.lastSpectrumUpdateMillis_dynamic);
        rhythmsUpdateMillisEditText = root.findViewById(R.id.rhythmsUpdateMillis_dynamic);
        neuroplayIp = root.findViewById(R.id.ipAdress_dynamic);

        submitButton = root.findViewById(R.id.submit_button);

        getGlobalSettings();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (parseInt(currentDeviceInfoUpdateMillisEditText.getText().toString()) > 0 & Integer.parseInt(currentDeviceInfoUpdateMillisEditText.getText().toString()) < 99999) {
                    globalVariables.setCurrentDeviceInfoUpdateMillis(Integer.parseInt(currentDeviceInfoUpdateMillisEditText.getText().toString()));
                }
                else {
                    globalVariables.setCurrentDeviceInfoUpdateMillis(10000);
                }
                if (parseInt(lastSpectrumUpdateMillisEditText.getText().toString()) > 0 & Integer.parseInt(lastSpectrumUpdateMillisEditText.getText().toString()) < 99999) {
                    globalVariables.setLastSpectrumUpdateMillis(Integer.parseInt(lastSpectrumUpdateMillisEditText.getText().toString()));
                }
                else {
                    globalVariables.setLastSpectrumUpdateMillis(10000);
                }
                if (parseInt(rhythmsUpdateMillisEditText.getText().toString()) > 0 & Integer.parseInt(rhythmsUpdateMillisEditText.getText().toString()) < 99999) {
                    globalVariables.setRhythmsUpdateMillis(Integer.parseInt(rhythmsUpdateMillisEditText.getText().toString()));
                }
                else {
                    globalVariables.setRhythmsUpdateMillis(10000);
                }
                if (neuroplayIp.getText().toString().length() > 0) {
                    String s = neuroplayIp.getText().toString();
                    String s1 = "http://" + neuroplayIp.getText().toString() + "/";
                    globalVariables.setsUrl(s1);
                    neuroplayIp.setText(s);
                }
                else {
                    globalVariables.setsUrl("http://10.0.2.2:2336/");
                    neuroplayIp.setText("10.0.2.2:2336");
                }

                currentDeviceInfoUpdateMillisEditText.setText(String.valueOf(globalVariables.getCurrentDeviceInfoUpdateMillis()));
                lastSpectrumUpdateMillisEditText.setText(String.valueOf(globalVariables.getLastSpectrumUpdateMillis()));
                rhythmsUpdateMillisEditText.setText(String.valueOf(globalVariables.getRhythmsUpdateMillis()));

                writeCurrentDeviceInfoUpdateMillisToPreference(globalVariables.getCurrentDeviceInfoUpdateMillis());
                writeLastSpectrumUpdateMillisToPreference(globalVariables.getLastSpectrumUpdateMillis());
                writeRhythmsUpdateMillisToPreference(globalVariables.getRhythmsUpdateMillis());
                writeNeuroplayProServerconnectionString(globalVariables.getsUrl());
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        // TODO: Use the ViewModel
    }

    private void getGlobalSettings() {
        currentDeviceInfoUpdateMillisEditText.setText(String.valueOf(globalVariables.getCurrentDeviceInfoUpdateMillis()));
        lastSpectrumUpdateMillisEditText.setText(String.valueOf(globalVariables.getLastSpectrumUpdateMillis()));
        rhythmsUpdateMillisEditText.setText(String.valueOf(globalVariables.getRhythmsUpdateMillis()));
    }


}