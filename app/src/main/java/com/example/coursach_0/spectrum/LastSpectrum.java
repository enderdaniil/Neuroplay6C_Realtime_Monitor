package com.example.coursach_0.spectrum;

import java.util.ArrayList;

public class LastSpectrum {
    private String command;
    private int deviceFrequencyHz;
    private Double frequencyStepHz;
    private Double hanningPercent;
    private boolean result;
    private ArrayList<ArrayList<Double>> data;
    private String time;
    private int windowSeconds;
    private Double windowStepSeconds;

    public LastSpectrum(String command, int deviceFrequencyHz, Double frequencyStepHz,
                        Double hanningPercent, boolean result, ArrayList<ArrayList<Double>> data,
                        String time, int windowSeconds, Double windowStepSeconds) {
        this.command = command;
        this.deviceFrequencyHz = deviceFrequencyHz;
        this.frequencyStepHz = frequencyStepHz;
        this.hanningPercent = hanningPercent;
        this.result = result;
        this.data = data;
        this.time = time;
        this.windowSeconds = windowSeconds;
        this.windowStepSeconds = windowStepSeconds;
    }

    @Override
    public String toString(){
        String output = "";

        output += command;
        output += "\n";

        if (data.size() > 0) {
            if (data.get(0).size() > 0) {
                output += data.get(0).get(0);
                output += "\n";
                output += data.get(0).get(1);
            }
        }

        output += result;
        output += "\n";
        output += time;
        output += "\n";

        return output;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<ArrayList<Double>> getData() {
        return data;
    }

    public void setData(ArrayList<ArrayList<Double>> data) {
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getWindowStepSeconds() {
        return windowStepSeconds;
    }

    public void setWindowStepSeconds(Double windowStepSeconds) {
        this.windowStepSeconds = windowStepSeconds;
    }

    public int getWindowSeconds() {
        return windowSeconds;
    }

    public void setWindowSeconds(int windowSeconds) {
        this.windowSeconds = windowSeconds;
    }

    public Double getHanningPercent() {
        return hanningPercent;
    }

    public void setHanningPercent(Double hanningPercent) {
        this.hanningPercent = hanningPercent;
    }

    public Double getFrequencyStepHz() {
        return frequencyStepHz;
    }

    public void setFrequencyStepHz(Double frequencyStepHz) {
        this.frequencyStepHz = frequencyStepHz;
    }

    public int getDeviceFrequencyHz() {
        return deviceFrequencyHz;
    }

    public void setDeviceFrequencyHz(int deviceFrequencyHz) {
        this.deviceFrequencyHz = deviceFrequencyHz;
    }
}
