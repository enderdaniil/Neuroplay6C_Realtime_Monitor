package com.example.coursach_0.currentDeviceInfo;

import com.example.coursach_0.api.listDevices.ListDataDevice;
//import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class CurrentDeviceInfo {
    private int BSF;
    private int HPF;
    private int LPF;
    private String command;
    private int currentChannels;
    private ArrayList<String> currentChannelNames;
    private int currentFrequency;
    private CurrentDeviceInfoDevice currentDeviceInfoDevice;
    private boolean isRecording;
    private ArrayList<Integer> quality;
    private boolean isStarted;
    private boolean searching;
    private String time;

    public CurrentDeviceInfo(int BSF, int HPF, int LPF, String command, int currentChannels,
                             ArrayList<String> currentChannelNames, int currentFrequency,
                             CurrentDeviceInfoDevice currentDeviceInfoDevice,
                             boolean isRecording, ArrayList<Integer> quality, boolean isStarted,
                             boolean searching, String time) {
        this.BSF = BSF;
        this.HPF = HPF;
        this.LPF = LPF;
        this.command = command;
        this.currentChannels = currentChannels;
        this.currentChannelNames = currentChannelNames;
        this.currentFrequency = currentFrequency;
        this.currentDeviceInfoDevice = currentDeviceInfoDevice;
        this.isRecording = isRecording;
        this.quality = quality;
        this.isStarted = isStarted;
        this.searching = searching;
        this.time = time;
    }

    public int getBSF() {
        return BSF;
    }

    public void setBSF(int BSF) {
        this.BSF = BSF;
    }

    public int getHPF() {
        return HPF;
    }

    public void setHPF(int HPF) {
        this.HPF = HPF;
    }

    public int getLPF() {
        return LPF;
    }

    public void setLPF(int LPF) {
        this.LPF = LPF;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getCurrentChannels() {
        return currentChannels;
    }

    public void setCurrentChannels(int currentChannels) {
        this.currentChannels = currentChannels;
    }

    public ArrayList<String> getCurrentChannelNames() {
        return currentChannelNames;
    }

    public void setCurrentChannelNames(ArrayList<String> currentChannelNames) {
        this.currentChannelNames = currentChannelNames;
    }

    public int getCurrentFrequency() {
        return currentFrequency;
    }

    public void setCurrentFrequency(int currentFrequency) {
        this.currentFrequency = currentFrequency;
    }

    public CurrentDeviceInfoDevice getCurrentDeviceInfoDevice() {
        return currentDeviceInfoDevice;
    }

    public void setCurrentDeviceInfoDevice(CurrentDeviceInfoDevice currentDeviceInfoDevice) {
        this.currentDeviceInfoDevice = currentDeviceInfoDevice;
    }

    public boolean isRecording() {
        return isRecording;
    }

    public void setRecording(boolean recording) {
        isRecording = recording;
    }

    public ArrayList<Integer> getQuality() {
        return quality;
    }

    public void setQuality(ArrayList<Integer> quality) {
        this.quality = quality;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public boolean isSearching() {
        return searching;
    }

    public void setSearching(boolean searching) {
        this.searching = searching;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        String output = "";

        output += BSF;
        output += "\n";
        output += HPF;
        output += "\n";
        output += LPF;
        output += "\n";

        output += command;
        output += "\n";

        output += currentChannels;
        output += "\n";

        if (currentChannelNames.size() > 0) {
            for (String name: currentChannelNames) {
                output += name.toString();
                output += "\n";
            }
        };

        output += currentFrequency;
        output += "\n";

        output += currentDeviceInfoDevice.toString();
        output += "\n";

        output += isRecording;
        output += "\n";

        if (quality.size() > 0) {
            for (Integer q: quality) {
                output += q.toString();
                output += "\n";
            }
        };

        output += isStarted;
        output += "\n";
        output += searching;
        output += "\n";
        output += time;
        output += "\n";

        return output;
    }
}
