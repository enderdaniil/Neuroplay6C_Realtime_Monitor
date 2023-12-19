package com.example.coursach_0.api.listDevices;

import java.util.List;

public class ListDeviceCommandResult {
    private String command;
    private List<ListDataDevice> devices;
    private boolean result;
    private String time;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<ListDataDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<ListDataDevice> devices) {
        this.devices = devices;
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

    @Override
    public String toString() {
        String output = "";

        output += command;
        output += "\n";

        if (devices.size() > 0) {
            for (ListDataDevice device: devices) {
                output += devices.toString();
                output += "\n";
            }
        };

        output += result;
        output += "\n";
        output += time;
        output += "\n";

        return output;
    }

}
