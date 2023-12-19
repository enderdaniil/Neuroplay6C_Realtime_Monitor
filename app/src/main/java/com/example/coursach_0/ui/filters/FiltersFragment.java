package com.example.coursach_0.ui.filters;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.coursach_0.R;
import com.example.coursach_0.databinding.FragmentFiltersBinding;
import com.example.coursach_0.global_variables.globalVariables;
import com.example.coursach_0.network.JsonReader;
import com.example.coursach_0.spectrum.LastSpectrum;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class FiltersFragment extends Fragment {

    private FragmentFiltersBinding binding;
    private BarChart barChart_O1;
    private BarChart barChart_T3;
    private BarChart barChart_Fp1;
    private BarChart barChart_Fp2;
    private BarChart barChart_T4;
    private BarChart barChart_O2;

    private BarDataSet getBarDatasetForChannel(LastSpectrum lastSpectrum, int channelNumber,
                                               String barLabel) {
        ArrayList<BarEntry> barEntries = new ArrayList<BarEntry>();
        Float currentXValue = 0.0F;
///*
        try {
            for (int i = 0; i < 257; i += 1) {
                barEntries.add(new BarEntry(currentXValue,
                        lastSpectrum.getData().get(channelNumber).get(i).floatValue()));
                currentXValue += lastSpectrum.getFrequencyStepHz().floatValue();
            }
        } catch (Exception e) {
            for (int i = 0; i < 257; i += 1) {
                barEntries.add(new BarEntry(currentXValue, 0f));
                currentXValue += lastSpectrum.getFrequencyStepHz().floatValue();
            }
        }//*/
        /*
        for (int i = 0; i < 257; i += 1) {
            barEntries.add(new BarEntry(currentXValue,
                    lastSpectrum.getData().get(channelNumber).get(i).floatValue()));
            currentXValue += lastSpectrum.getFrequencyStepHz().floatValue();
        }*/

        try {
            Thread.sleep(globalVariables.getLastSpectrumUpdateMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, barLabel);
        int[] colors = new int[257];
        for (int i = 0; i < 257; i++) {
            if (i <= 17) {
                colors[i] = Color.parseColor("#49DBFC");
            }
            else {
                if (i <= 33) {
                    colors[i] = Color.parseColor("#2F34E7");
                }
                else {
                    if (i <= 58) {
                        colors[i] = Color.parseColor("#55EA00");
                    }
                    else {
                        if (i <= 144) {
                            colors[i] = Color.parseColor("#F41100");
                        }
                        else {
                            colors[i] = Color.parseColor("#FFE200");
                        }
                    }
                }
            }
        }

        barDataSet.setColors(colors);

        return barDataSet;
    }

    public void changeContent() {

        while (globalVariables.getCurrentView() == R.id.spectrum_view) {
            LastSpectrum lastSpectrum = null;
            lastSpectrum = JsonReader.lastSpectrum();

            barChart_O1.setData(new BarData(getBarDatasetForChannel(lastSpectrum, 0, "O1")));
            barChart_O1.notifyDataSetChanged();
            barChart_O1.invalidate();

            barChart_T3.setData(new BarData(getBarDatasetForChannel(lastSpectrum, 1, "T3")));
            barChart_T3.notifyDataSetChanged();
            barChart_T3.invalidate();

            barChart_Fp1.setData(new BarData(getBarDatasetForChannel(lastSpectrum, 2, "Fp1")));
            barChart_Fp1.notifyDataSetChanged();
            barChart_Fp1.invalidate();

            barChart_Fp2.setData(new BarData(getBarDatasetForChannel(lastSpectrum, 3, "Fp2")));
            barChart_Fp2.notifyDataSetChanged();
            barChart_Fp2.invalidate();

            barChart_T4.setData(new BarData(getBarDatasetForChannel(lastSpectrum, 4, "T4")));
            barChart_T4.notifyDataSetChanged();
            barChart_T4.invalidate();

            barChart_O2.setData(new BarData(getBarDatasetForChannel(lastSpectrum, 5, "O2")));
            barChart_O2.notifyDataSetChanged();
            barChart_O2.invalidate();

            try {
                Thread.sleep(globalVariables.getLastSpectrumUpdateMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FiltersViewModel filtersViewModel =
                new ViewModelProvider(this).get(FiltersViewModel.class);

        binding = FragmentFiltersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFilters;

        globalVariables.setCurrentView(binding.getRoot().getId());

        barChart_O1 = binding.getRoot().findViewById(R.id.spectrum_bar_chart_O1);
        barChart_O1.getDescription().setText("O1 channel");
        barChart_O1.getDescription().setTextSize(16f);

        barChart_T3 = binding.getRoot().findViewById(R.id.spectrum_bar_chart_T3);
        barChart_T3.getDescription().setText("T3 channel");
        barChart_T3.getDescription().setTextSize(16f);

        barChart_Fp1 = binding.getRoot().findViewById(R.id.spectrum_bar_chart_Fp1);
        barChart_Fp1.getDescription().setText("Fp1 channel");
        barChart_Fp1.getDescription().setTextSize(16f);

        barChart_Fp2 = binding.getRoot().findViewById(R.id.spectrum_bar_chart_Fp2);
        barChart_Fp2.getDescription().setText("Fp2 channel");
        barChart_Fp2.getDescription().setTextSize(16f);

        barChart_T4 = binding.getRoot().findViewById(R.id.spectrum_bar_chart_T4);
        barChart_T4.getDescription().setText("T4 channel");
        barChart_T4.getDescription().setTextSize(16f);

        barChart_O2 = binding.getRoot().findViewById(R.id.spectrum_bar_chart_O2);
        barChart_O2.getDescription().setText("O2 channel");
        barChart_O2.getDescription().setTextSize(16f);

        //filtersViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        new Thread(this::changeContent).start();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}