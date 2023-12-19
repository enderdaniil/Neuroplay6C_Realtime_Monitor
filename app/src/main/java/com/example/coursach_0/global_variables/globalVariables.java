package com.example.coursach_0.global_variables;

public final class globalVariables {
    private static int currentView = -1;
    private static int currentDeviceInfoUpdateMillis ;//= 10000;
    private static int lastSpectrumUpdateMillis ;//= 5;
    private static int rhythmsUpdateMillis ;//= 100;
    public static final String PREFS_NAME = "MyPrefsFile";
    private static String sUrl ;//= "http://10.0.2.2:2336/";

    public static int getCurrentView() {
        return currentView;
    }

    public static void setCurrentView(int currentView) {
        globalVariables.currentView = currentView;
    }

    public static int getCurrentDeviceInfoUpdateMillis() {
        return currentDeviceInfoUpdateMillis;
    }

    public static void setCurrentDeviceInfoUpdateMillis(int currentDeviceInfoUpdateMillis) {
        globalVariables.currentDeviceInfoUpdateMillis = currentDeviceInfoUpdateMillis;
    }

    public static int getLastSpectrumUpdateMillis() {
        return lastSpectrumUpdateMillis;
    }

    public static void setLastSpectrumUpdateMillis(int lastSpectrumUpdateMillis) {
        globalVariables.lastSpectrumUpdateMillis = lastSpectrumUpdateMillis;
    }

    public static int getRhythmsUpdateMillis() {
        return rhythmsUpdateMillis;
    }

    public static void setRhythmsUpdateMillis(int rhythmsUpdateMillis) {
        globalVariables.rhythmsUpdateMillis = rhythmsUpdateMillis;
    }

    public static String getsUrl() {
        return sUrl;
    }

    public static void setsUrl(String sUrl) {
        globalVariables.sUrl = sUrl;
    }
}
