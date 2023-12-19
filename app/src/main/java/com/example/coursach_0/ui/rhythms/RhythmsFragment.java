package com.example.coursach_0.ui.rhythms;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.coursach_0.BCI.Bci;
import com.example.coursach_0.R;
import com.example.coursach_0.databinding.FragmentInfoBinding;
import com.example.coursach_0.databinding.FragmentRhythmsBinding;
import com.example.coursach_0.global_variables.globalVariables;
import com.example.coursach_0.network.JsonReader;
import com.example.coursach_0.rhythms.Rhythms;
import com.example.coursach_0.spectrum.LastSpectrum;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class RhythmsFragment extends Fragment {

    private static enum ParamName {
        attention,
        concentration,
        meditation,
        mental_state,
        result,
        smr,
        time
    }

    private FragmentRhythmsBinding binding;
    private PieChart pieChart_O1;
    private PieChart pieChart_O2;
    private PieChart pieChart_T3;
    private PieChart pieChart_T4;
    private PieChart pieChart_Fp1;
    private PieChart pieChart_Fp2;
    private PieChart pieChart_attention;
    private PieChart pieChart_smr;
    private PieChart pieChart_concentration;
    private PieChart pieChart_meditation;

    private PieDataSet getPieDatasetForChannel(Rhythms rhythms, int channelNumber, String pieLabel) {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        try {
            pieEntries.add(new PieEntry(rhythms.getRhythms().get(channelNumber).getAlpha().floatValue(),
                    rhythms.getRhythms().get(channelNumber).getAlpha().floatValue()));
            pieEntries.add(new PieEntry(rhythms.getRhythms().get(channelNumber).getBeta().floatValue(),
                    rhythms.getRhythms().get(channelNumber).getBeta().floatValue()));
            pieEntries.add(new PieEntry(rhythms.getRhythms().get(channelNumber).getGamma().floatValue(),
                    rhythms.getRhythms().get(channelNumber).getGamma().floatValue()));
            pieEntries.add(new PieEntry(rhythms.getRhythms().get(channelNumber).getDelta().floatValue(),
                    rhythms.getRhythms().get(channelNumber).getDelta().floatValue()));
            pieEntries.add(new PieEntry(rhythms.getRhythms().get(channelNumber).getTheta().floatValue(),
                    rhythms.getRhythms().get(channelNumber).getTheta().floatValue()));
        } catch (Exception e) {
            pieEntries.add(new PieEntry(0f));
            pieEntries.add(new PieEntry(0f));
            pieEntries.add(new PieEntry(0f));
            pieEntries.add(new PieEntry(0f));
            pieEntries.add(new PieEntry(0f));
        }

        PieDataSet pieDataSet = new PieDataSet(pieEntries, pieLabel);
        int[] colors = new int[] {Color.parseColor("#49DBFC"),
                Color.parseColor("#2F34E7"), Color.parseColor("#55EA00"),
                Color.parseColor("#F41100"), Color.parseColor("#FFE200")};

        pieDataSet.setColors(colors);

        return pieDataSet;
    }

    private PieDataSet getPieDatasetForBci(Bci bci, ParamName paramName, String pieLabel) {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        try {
            if (paramName == ParamName.attention) {
                pieEntries.add(new PieEntry(bci.getAttention().floatValue(), bci.getAttention().floatValue()));
                pieEntries.add(new PieEntry((100f - bci.getAttention().floatValue())));
            } else if (paramName == ParamName.smr) {
                pieEntries.add(new PieEntry(bci.getSmr().floatValue(), bci.getSmr().floatValue()));
                pieEntries.add(new PieEntry((100f - bci.getSmr().floatValue())));
            } else if (paramName == ParamName.concentration) {
                pieEntries.add(new PieEntry(bci.getConcentration().floatValue(), bci.getConcentration().floatValue()));
                pieEntries.add(new PieEntry((100f - bci.getConcentration().floatValue())));
            } else if (paramName == ParamName.meditation) {
                pieEntries.add(new PieEntry(bci.getMeditation().floatValue(), bci.getMeditation().floatValue()));
                pieEntries.add(new PieEntry((100f - bci.getMeditation().floatValue())));
            }
        } catch (Exception e) {
            pieEntries.add(new PieEntry(0f));
            pieEntries.add(new PieEntry(100f));
        }

        int[] colors_attention = new int[] {Color.parseColor("#FF00FF"), Color.parseColor("#708090")};
        int[] colors_smr = new int[] {Color.parseColor("#FF8C00"), Color.parseColor("#708090")};
        int[] colors_concentration= new int[] {Color.parseColor("#800000"), Color.parseColor("#708090")};
        int[] colors_meditation = new int[] {Color.parseColor("#32CD32"), Color.parseColor("#708090")};

        PieDataSet pieDataSet = new PieDataSet(pieEntries, pieLabel);

        if (paramName == ParamName.attention) {
            pieDataSet.setColors(colors_attention);
        } else if (paramName == ParamName.smr) {
            pieDataSet.setColors(colors_smr);
        } else if (paramName == ParamName.concentration) {
            pieDataSet.setColors(colors_concentration);
        } else if (paramName == ParamName.meditation) {
            pieDataSet.setColors(colors_meditation);
        }

        return pieDataSet;
    }

    private void changeBciPieChart(Bci bci, PieChart pieChart, String pieLabel, ParamName paramName, String description) {
        pieChart.setData(new PieData(getPieDatasetForBci(bci, paramName, pieLabel)));
        pieChart.getDescription().setText(description);
        pieChart.getDescription().setTextSize(12f);
        pieChart.notifyDataSetChanged();
        pieChart.invalidate();
    }

    private void changeChannelPieChart(Rhythms rhythms, PieChart pieChart, String text, String pieLabel, int channelNumber) {
        pieChart.setData(new PieData(getPieDatasetForChannel(rhythms, channelNumber, pieLabel)));
        pieChart.getDescription().setText(text);
        pieChart.getDescription().setTextSize(12f);
        pieChart.notifyDataSetChanged();
        pieChart.invalidate();
    }

    public void changeContent() {

        while (globalVariables.getCurrentView() == R.id.rhythms_view) {
            Rhythms rhythms = null;
            rhythms = JsonReader.rhythms();

            changeChannelPieChart(rhythms, pieChart_O1, "O1 channel", "O1", 0);
            changeChannelPieChart(rhythms, pieChart_O2, "O2 channel", "O2", 5);
            changeChannelPieChart(rhythms, pieChart_T3, "T3 channel", "T3", 1);
            changeChannelPieChart(rhythms, pieChart_T4, "T4 channel", "T4", 4);
            changeChannelPieChart(rhythms, pieChart_Fp1, "Fp1 channel", "Fp1", 2);
            changeChannelPieChart(rhythms, pieChart_Fp2, "Fp2 channel", "Fp2", 3);

            Bci bci = null;
            bci = JsonReader.bci();
            changeBciPieChart(bci, pieChart_attention, "Attention", ParamName.attention, "Attention");
            changeBciPieChart(bci, pieChart_smr, "Smr", ParamName.smr, "Smr");
            changeBciPieChart(bci, pieChart_meditation, "Meditation", ParamName.meditation, "Meditation");
            changeBciPieChart(bci, pieChart_concentration, "Concentration", ParamName.concentration, "Concentration");

            try {
                Thread.sleep(globalVariables.getRhythmsUpdateMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RhythmsViewModel rhythmsViewModel =
                new ViewModelProvider(this).get(RhythmsViewModel.class);

        binding = FragmentRhythmsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textInfo;

        globalVariables.setCurrentView(binding.getRoot().getId());

        //rhythmsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        pieChart_O1 = binding.getRoot().findViewById(R.id.rhythms_pie_chart_O1);
        pieChart_O2 = binding.getRoot().findViewById(R.id.rhythms_pie_chart_O2);
        pieChart_T3 = binding.getRoot().findViewById(R.id.rhythms_pie_chart_T3);
        pieChart_T4 = binding.getRoot().findViewById(R.id.rhythms_pie_chart_T4);
        pieChart_Fp1 = binding.getRoot().findViewById(R.id.rhythms_pie_chart_Fp1);
        pieChart_Fp2 = binding.getRoot().findViewById(R.id.rhythms_pie_chart_Fp2);

        pieChart_attention = binding.getRoot().findViewById(R.id.rhythms_pie_chart_attention);
        pieChart_smr = binding.getRoot().findViewById(R.id.rhythms_pie_chart_smr);
        pieChart_concentration = binding.getRoot().findViewById(R.id.rhythms_pie_chart_concentration);
        pieChart_meditation = binding.getRoot().findViewById(R.id.rhythms_pie_chart_meditation);

        new Thread(this::changeContent).start();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}