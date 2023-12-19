package com.example.coursach_0.currentDeviceInfo;

public class CurrentDeviceInfoDevice {
    private int battery;
    //private List<ChannelMode> ChannelModes;
    private int maxChannels;
    private String model;
    private String name;
    private int preferredChannelCount;
    private String serialNumber;

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

 /*   public List<ChannelMode> getChannelModes() {
        return ChannelModes;
    }

    public void setChannelModes(List<ChannelMode> ChannelModes) {
        this.ChannelModes = ChannelModes;
    }*/

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getPreferredChannelCount() {
        return preferredChannelCount;
    }

    public void setPreferredChannelCount(int preferredChannelCount) {
        this.preferredChannelCount = preferredChannelCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxChannels() {
        return maxChannels;
    }

    public void setMaxChannels(int maxChannels) {
        this.maxChannels = maxChannels;
    }

    @Override
    public String toString() {
        /*String channelModesString = "";
        if (ChannelModes.size() > 0) {
            for (ChannelMode i: ChannelModes) {
                channelModesString += i;
            }
        }*/

        return "battery: " + battery + "," + "\n" +
                //        "channelModes: " + "\n" +
                //        channelModesString + "\n" +
                "maxChannels: " + maxChannels + "\n" +
                "model: " + model + "\n" +
                "name: " + name + "\n" +
                "preferredChannelCount" + preferredChannelCount + "\n" +
                "serialNumber" + serialNumber + "\n";

    }
}
