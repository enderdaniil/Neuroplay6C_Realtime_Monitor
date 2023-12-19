package com.example.coursach_0.BCI;

public class Bci {
    private Double attention;
    private String command;
    private Double concentration;
    private Double meditation;
    private int mental_state;
    private boolean result;
    private Double smr;
    private String time;

    public Bci (Double attention, String command, Double concentration, Double meditation,
                int mental_state, boolean result, Double smr, String time) {
        this.attention = attention;
        this.command = command;
        this.concentration = concentration;
        this.meditation = meditation;
        this.mental_state = mental_state;
        this.result = result;
        this.smr = smr;
        this.time = time;
    }

    public static enum paramName {
        attention,
        concentration,
        meditation,
        mental_state,
        result,
        smr,
        time
    }

    @Override
    public String toString() {
        String output = "";

        output += attention;
        output += "\n";
        output += command;
        output += "\n";
        output += concentration;
        output += "\n";
        output += meditation;
        output += "\n";
        output += mental_state;
        output += "\n";
        output += result;
        output += "\n";
        output += smr;
        output += "\n";
        output += time;
        output += "\n";

        return output;
    }


    public Double getAttention() {
        return attention;
    }

    public void setAttention(Double attention) {
        this.attention = attention;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Double getConcentration() {
        return concentration;
    }

    public void setConcentration(Double concentration) {
        this.concentration = concentration;
    }

    public Double getMeditation() {
        return meditation;
    }

    public void setMeditation(Double meditation) {
        this.meditation = meditation;
    }

    public int getMental_state() {
        return mental_state;
    }

    public void setMental_state(int mental_state) {
        this.mental_state = mental_state;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Double getSmr() {
        return smr;
    }

    public void setSmr(Double smr) {
        this.smr = smr;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
