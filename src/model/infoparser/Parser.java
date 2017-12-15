package model.infoparser;

import java.util.HashMap;

import org.json.JSONException;
import json.JsonHelper;

public class Parser {
    // private final String TAG = "Parser";
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
