package com.example.coursach_0.rhythms;

public class Rhythm {
    private Double alpha;
    private Double beta;
    private Double delta;
    private Double gamma;
    private int t;
    private Double theta;

    @Override
    public String toString() {
        String output = "";

        output += alpha;
        output += "\n";
        output += beta;
        output += "\n";
        output += delta;
        output += "\n";
        output += gamma;
        output += "\n";
        output += t;
        output += "\n";
        output += theta;
        output += "\n";

        return output;
    }

    public Double getAlpha() {
        return alpha;
    }

    public void setAlpha(Double alpha) {
        this.alpha = alpha;
    }

    public Double getBeta() {
        return beta;
    }

    public void setBeta(Double beta) {
        this.beta = beta;
    }

    public Double getDelta() {
        return delta;
    }

    public void setDelta(Double delta) {
        this.delta = delta;
    }

    public Double getGamma() {
        return gamma;
    }

    public void setGamma(Double gamma) {
        this.gamma = gamma;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public Double getTheta() {
        return theta;
    }

    public void setTheta(Double theta) {
        this.theta = theta;
    }
}
