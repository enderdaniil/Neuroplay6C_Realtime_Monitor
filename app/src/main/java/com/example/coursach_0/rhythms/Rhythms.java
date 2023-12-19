package com.example.coursach_0.rhythms;

import com.example.coursach_0.api.listDevices.ListDataDevice;

import java.util.ArrayList;

public class Rhythms {
    private String command;
    private boolean result;
    private ArrayList<Rhythm> rhythms;
    private String time;

    public Rhythms(String command, boolean result, ArrayList<Rhythm> rhythms, String time) {
        this.command = command;
        this.result = result;
        this.rhythms = rhythms;
        this.time = time;
    }

    @Override
    public String toString() {
        String output = "";

        output += command;
        output += "\n";
        output += result;
        output += "\n";

        if (rhythms.size() > 0) {
            for (Rhythm rhythm: rhythms) {
                output += rhythm.toString();
                output += "\n";
            }
        };

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

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public ArrayList<Rhythm> getRhythms() {
        return rhythms;
    }

    public void setRhythms(ArrayList<Rhythm> rhythms) {
        this.rhythms = rhythms;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
