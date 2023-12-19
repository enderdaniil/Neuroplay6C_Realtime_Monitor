package com.example.coursach_0.network;

import static android.app.PendingIntent.getActivity;

import android.widget.Toast;

import com.example.coursach_0.BCI.Bci;
import com.example.coursach_0.api.listDevices.ListDeviceCommandResult;
import com.example.coursach_0.currentDeviceInfo.CurrentDeviceInfo;
import com.example.coursach_0.currentDeviceInfo.CurrentDeviceInfoDevice;
import com.example.coursach_0.global_variables.globalVariables;
import com.example.coursach_0.rhythms.Rhythm;
import com.example.coursach_0.rhythms.Rhythms;
import com.example.coursach_0.spectrum.LastSpectrum;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public final class JsonReader {
    //private static String sUrl = "http://10.0.2.2:2336/";

    public static ListDeviceCommandResult listDevices() {
        ListDeviceCommandResult result = null;
        String urlString = globalVariables.getsUrl() + "listDevices";

        try {
            URL url = new URL(urlString);
            URLConnection request = url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser(); //from gson
            JsonElement json = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
            Gson gson = new Gson();
            result = gson.fromJson(json, ListDeviceCommandResult.class);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static CurrentDeviceInfo currentDeviceInfo() {
        CurrentDeviceInfo result = null;

        String urlString = globalVariables.getsUrl() + "currentDeviceInfo";
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection request = null;
        try {
            request = url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            request.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonParser jp = new JsonParser(); //from gson
        JsonElement json = null; //Convert the input stream to a json element
        try {
            json = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JsonObject jsonObject = json.getAsJsonObject();

        Gson gson = new Gson();
        //Type typeToken = new TypeToken<CurrentDeviceInfo>() { }.getType();

        JsonArray jsonArrayOfChannelNames = jsonObject.get("currentChannelsNames").getAsJsonArray();
        ArrayList<String> currentChannelsNames = new ArrayList<String>();
        if (jsonArrayOfChannelNames != null) {
            for (int i = 0; i < jsonArrayOfChannelNames.size(); i++) {
                currentChannelsNames.add(jsonArrayOfChannelNames.get(i).getAsString());
            }
        }

        JsonArray jsonArrayOfChannelQuality= jsonObject.get("quality").getAsJsonArray();
        ArrayList<Integer> quality = new ArrayList<Integer>();
        if (jsonArrayOfChannelQuality != null) {
            for (int i = 0; i < jsonArrayOfChannelQuality.size(); i++) {
                quality.add(jsonArrayOfChannelQuality.get(i).getAsInt());
            }
        }

        result = new CurrentDeviceInfo(
                jsonObject.get("BSF").getAsInt(),
                jsonObject.get("HPF").getAsInt(),
                jsonObject.get("LPF").getAsInt(),
                jsonObject.get("command").getAsString(),
                jsonObject.get("currentChannels").getAsInt(),
                currentChannelsNames,
                jsonObject.get("currentFrequency").getAsInt(),
                gson.fromJson(jsonObject.get("device"), CurrentDeviceInfoDevice.class),
                jsonObject.get("isRecording").getAsBoolean(),
                quality,
                jsonObject.get("result").getAsBoolean(),
                jsonObject.get("searching").getAsBoolean(),
                jsonObject.get("time").getAsString()
        );

        return result;
    }

    public static Rhythms rhythms() {
        Rhythms result = null;

        String urlString = globalVariables.getsUrl()  + "rhythms";
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection request = null;
        try {
            request = url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            request.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonParser jp = new JsonParser(); //from gson
        JsonElement json = null; //Convert the input stream to a json element
        try {
            json = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JsonObject jsonObject = json.getAsJsonObject();

        Gson gson = new Gson();

        JsonArray jsonArrayOfRhythms = jsonObject.get("rhythms").getAsJsonArray();
        ArrayList<Rhythm> rhythms = new ArrayList<Rhythm>();
        if (jsonArrayOfRhythms != null) {
            for (int i = 0; i < jsonArrayOfRhythms.size(); i++) {
                //currentChannelsNames.add(jsonArrayOfRhythms.get(i).getAsString());
                rhythms.add(gson.fromJson(jsonArrayOfRhythms.get(i), Rhythm.class));
            }
        }

        result = new Rhythms(
                jsonObject.get("command").getAsString(),
                jsonObject.get("result").getAsBoolean(),
                rhythms,
                jsonObject.get("time").getAsString()
        );

        return result;
    }

    public static LastSpectrum lastSpectrum() {
        LastSpectrum result = null;

        String urlString = globalVariables.getsUrl() + "lastSpectrum";
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection request = null;
        try {
            request = url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            request.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonParser jp = new JsonParser(); //from gson
        JsonElement json = null; //Convert the input stream to a json element
        try {
            json = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JsonObject jsonObject = json.getAsJsonObject();

        Gson gson = new Gson();

        JsonArray jsonArrayOfSpectrum = jsonObject.get("spectrum").getAsJsonArray();
        ArrayList<ArrayList<Double>> spectrum = new ArrayList<ArrayList<Double>>();
        if (jsonArrayOfSpectrum != null) {
            for (int i = 0; i < jsonArrayOfSpectrum.size(); i++) {
                //currentChannelsNames.add(jsonArrayOfRhythms.get(i).getAsString());
                //spectrum.add(gson.fromJson(jsonArrayOfSpectrum.get(i), Rhythm.class));
                ArrayList<Double> arr = new ArrayList<Double>();
                for (int j = 0; j < jsonArrayOfSpectrum.get(i).getAsJsonArray().size(); j++) {
                    arr.add(jsonArrayOfSpectrum.get(i).getAsJsonArray().get(j).getAsDouble());
                }
                spectrum.add(arr);
            }
        }

        result = new LastSpectrum(
                jsonObject.get("command").getAsString(),
                jsonObject.get("deviceFrequencyHz").getAsInt(),
                jsonObject.get("frequencyStepHz").getAsDouble(),
                jsonObject.get("hanningPercent").getAsDouble(),
                jsonObject.get("result").getAsBoolean(),
                spectrum,
                jsonObject.get("time").getAsString(),
                jsonObject.get("windowSeconds").getAsInt(),
                jsonObject.get("windowStepSeconds").getAsDouble()
        );

        return result;
    }

    public static Bci bci() {
        Bci result = null;

        String urlString = globalVariables.getsUrl() + "bci";
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection request = null;
        try {
            request = url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            request.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonParser jp = new JsonParser(); //from gson
        JsonElement json = null; //Convert the input stream to a json element
        try {
            json = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JsonObject jsonObject = json.getAsJsonObject();

        Gson gson = new Gson();

        result = new Bci(
                jsonObject.get("attention").getAsDouble(),
                jsonObject.get("command").getAsString(),
                jsonObject.get("concentration").getAsDouble(),
                jsonObject.get("meditation").getAsDouble(),
                jsonObject.get("mental_state").getAsInt(),
                jsonObject.get("result").getAsBoolean(),
                jsonObject.get("smr").getAsDouble(),
                jsonObject.get("time").getAsString()
        );

        return result;
    }

    public static void startZeroDevice() {
        String urlString = globalVariables.getsUrl() + "startDevice?id=0";
        try {
            URL url = new URL(urlString);
            URLConnection request = url.openConnection();
            request.connect();
        }
        catch (MalformedURLException e) {
            //int duration = Toast.LENGTH_SHORT;
            //Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            //toast.show();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void enableDataGrabMode() {
        String urlString = globalVariables.getsUrl() + "enableDataGrabMode";
        try {
            URL url = new URL(urlString);
            URLConnection request = url.openConnection();
            request.connect();
        }
        catch (MalformedURLException e) {
            //int duration = Toast.LENGTH_SHORT;
            //Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            //toast.show();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/*
    public static String getsUrl() {
        return sUrl;
    }

    public static void setsUrl(String sUrl) {
        JsonReader.sUrl = sUrl;
    }
*/
}
