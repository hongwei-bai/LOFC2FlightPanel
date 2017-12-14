package model.infoparser;

import java.awt.RenderingHints.Key;
import java.util.HashMap;

import javax.sound.midi.MidiDevice.Info;
import javax.xml.bind.ValidationEvent;

import org.json.JSONException;
import org.omg.CORBA.portable.ValueBase;

import Llfc2Constant.LOFC2Constant;
import json.JsonHelper;
import socket.server.SocketServerHelper;
import utils.Log;

public class Parser {
    private final String TAG = "Parser";
    private static Parser mSingleton = null;
    private static HashMap<String, String> mInfo = null;

    public static Parser getInstance() {
        if (null == mSingleton) {
            synchronized (Parser.class) {
                if (null == mSingleton) {
                    mSingleton = new Parser();
                }
            }
        }
        return mSingleton;
    }

    private Parser() {

    }

    public void parse(String line) {
        HashMap<String, String> classinfo = null;
        try {
            mInfo = (HashMap<String, String>) JsonHelper.toMap(line);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return mInfo.get(key);
    }
}
