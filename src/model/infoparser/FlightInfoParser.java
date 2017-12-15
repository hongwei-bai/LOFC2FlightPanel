package model.infoparser;

import Llfc2Constant.LOFC2Constant;

public class FlightInfoParser extends InfoParser {
    private static FlightInfoParser mSingleton = null;

    public static FlightInfoParser getInstance() {
        if (null == mSingleton) {
            synchronized (FlightInfoParser.class) {
                if (null == mSingleton) {
                    mSingleton = new FlightInfoParser();
                }
            }
        }
        return mSingleton;
    }

    private FlightInfoParser() {

    }

    @Override
    public int getType() {
        return LOFC2Constant.CLASS_ID_KEY.CLASS_ID_FLIGHT;
    }

    public Double getTrueAirSpeed() {
        return Double.valueOf((String) mInfo.get(LOFC2Constant.FLIGHT_KEY.TRUE_AIR_SPEED));
    }

    public Double getAirSpeed() {
        return Double.valueOf((String) mInfo.get(LOFC2Constant.FLIGHT_KEY.INDICATED_AIR_SPEED));
    }

    public Double getAltitudeAboveSealevel() {
        return Double.valueOf((String) mInfo.get(LOFC2Constant.FLIGHT_KEY.ALTITUDE_ABOVE_SEALEVEL));
    }

    public Integer getEngineInfoRPMLeft() {
        return Integer.valueOf((String) mInfo.get(LOFC2Constant.FLIGHT_KEY.ENGINE_RPM_LEFT));
    }

    public Integer getEngineInfoRPMRight() {
        return Integer.valueOf((String) mInfo.get(LOFC2Constant.FLIGHT_KEY.ENGINE_RPM_RIGHT));
    }
}
