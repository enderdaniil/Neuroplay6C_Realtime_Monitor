package com.example.coursach_0.api.listDevices;

public class ChannelMode {
    private int channels;

    private int frequency;

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "{\nchannels: " + channels + "," + "\n" +
                "frequency: " + frequency + "\n}";
    }
}
