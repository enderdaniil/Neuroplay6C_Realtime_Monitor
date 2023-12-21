package com.example.coursach_0.ui.info;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.coursach_0.BCI.Bci;
import com.example.coursach_0.R;
import com.example.coursach_0.currentDeviceInfo.CurrentDeviceInfo;
import com.example.coursach_0.databinding.FragmentInfoBinding;
import com.example.coursach_0.global_variables.globalVariables;
import com.example.coursach_0.network.JsonReader;
import com.example.coursach_0.rhythms.Rhythms;
import com.example.coursach_0.spectrum.LastSpectrum;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

public class InfoFragment extends Fragment {

    private FragmentInfoBinding binding;
    //private TextView textView;
    private TextView textViewBSF;
    private TextView textViewHPF;
    private TextView textViewLPF;
    private TextView textViewO1;
    private TextView textViewT3;
    private TextView textViewFp1;
    private TextView textViewFp2;
    private TextView textViewT4;
    private TextView textViewO2;
    private TextView textViewBattery;
    private TextView textViewModel;
    private TextView textViewName;
    private TextView textViewSerialNumber;
    private TextView textViewTime;

    public void changeContent() {

        while (globalVariables.getCurrentView() == R.id.info_view) {
        //while (true) {
            CurrentDeviceInfo currentDeviceInfo = null;
            currentDeviceInfo = JsonReader.currentDeviceInfo();

            ///*
            try {
                textViewBSF.setText(String.valueOf(currentDeviceInfo.getBSF()));
            } catch (Exception e) {
                textViewBSF.setText("failed");
            }
            try {
                textViewHPF.setText(String.valueOf(currentDeviceInfo.getHPF()));
            } catch (Exception e) {
                textViewHPF.setText("failed");
            }
            try {
                textViewLPF.setText(String.valueOf(currentDeviceInfo.getLPF()));
            } catch (Exception e) {
                textViewLPF.setText("failed");
            }

            try {
                textViewO1.setText(String.valueOf(currentDeviceInfo.getQuality().get(0)));
            }catch (Exception e) {
                textViewO1.setText("failed");
            }
            try {
                textViewO2.setText(String.valueOf(currentDeviceInfo.getQuality().get(5)));
            }catch (Exception e) {
                textViewO2.setText("failed");
            }
            try {
                textViewFp1.setText(String.valueOf(currentDeviceInfo.getQuality().get(1)));
            }catch (Exception e) {
                textViewFp1.setText("failed");
            }
            try {
                textViewFp2.setText(String.valueOf(currentDeviceInfo.getQuality().get(2)));
            }catch (Exception e) {
                textViewFp2.setText("failed");
            }
            try {
                textViewT3.setText(String.valueOf(currentDeviceInfo.getQuality().get(3)));
            }catch (Exception e) {
                textViewT3.setText("failed");
            }
            try {
                textViewT4.setText(String.valueOf(currentDeviceInfo.getQuality().get(4)));
            }catch (Exception e) {
                textViewT4.setText("failed");
            }

            try {
                textViewBattery.setText(String.valueOf(currentDeviceInfo.getCurrentDeviceInfoDevice().getBattery()));
            }catch (Exception e) {
                textViewBattery.setText("failed");
            }
            try {
                textViewModel.setText(String.valueOf(currentDeviceInfo.getCurrentDeviceInfoDevice().getModel()));
            }catch (Exception e) {
                textViewModel.setText("failed");
            }
            try {
                textViewName.setText(String.valueOf(currentDeviceInfo.getCurrentDeviceInfoDevice().getName()));
            }catch (Exception e) {
                textViewName.setText("failed");
            }
            try {
                textViewSerialNumber.setText(String.valueOf(currentDeviceInfo.getCurrentDeviceInfoDevice().getSerialNumber()));
            }catch (Exception e) {
                textViewSerialNumber.setText("failed");
            }

            try {
                textViewTime.setText(String.valueOf(currentDeviceInfo.getTime()));
            }catch (Exception e) {
                textViewTime.setText("failed");
            }
            try {
                Thread.sleep(globalVariables.getCurrentDeviceInfoUpdateMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //textView.setText(JsonReader.listDevices().toString());
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InfoViewModel infoViewModel =
                new ViewModelProvider(this).get(InfoViewModel.class);

        binding = FragmentInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //textView = binding.textInfo;
        textViewBSF = binding.textInfoBSF;
        textViewHPF = binding.textInfoHPF;
        textViewLPF = binding.textInfoLPF;
        textViewO1 = binding.textInfoChannelsDynamicO1;
        textViewT3 = binding.textInfoChannelsDynamicT3;
        textViewFp1 = binding.textInfoChannelsDynamicFp1;
        textViewFp2 = binding.textInfoChannelsDynamicFp2;
        textViewT4 = binding.textInfoChannelsDynamicT4;
        textViewO2 = binding.textInfoChannelsDynamicO2;
        textViewBattery = binding.textInfoDeviceDynamicBattery;
        textViewModel = binding.textInfoDeviceDynamicModel;
        textViewName = binding.textInfoDeviceDynamicName;
        textViewSerialNumber = binding.textInfoDeviceDynamicSerialNumber;
        textViewTime = binding.textInfoTime;

        //infoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        globalVariables.setCurrentView(binding.getRoot().getId());
        //Log.d(String.valueOf(LOG), String.valueOf(binding.getRoot().getId()));

        new Thread(this::changeContent).start();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}