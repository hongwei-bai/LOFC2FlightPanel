package model.infoparser;

import java.util.HashMap;

public abstract class InfoParser {
    protected HashMap<String, String> mInfo = new HashMap<String, String>();

    abstract public int getType();

    public void parseLine(String line) {
        // parse line
        String pair[] = line.split(",");
        for (String s : pair) {
            String v[] = s.split("=");
            mInfo.put(v[0].trim(), v[1].trim());
        }
    }
}
