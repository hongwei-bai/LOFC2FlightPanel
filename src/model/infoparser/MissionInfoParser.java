package model.infoparser;

import Llfc2Constant.LOFC2Constant;

public class MissionInfoParser extends InfoParser {
    private static MissionInfoParser mSingleton = null;

    public static MissionInfoParser getInstance() {
        if (null == mSingleton) {
            synchronized (MissionInfoParser.class) {
                if (null == mSingleton) {
                    mSingleton = new MissionInfoParser();
                }
            }
        }
        return mSingleton;
    }

    private MissionInfoParser() {

    }

    @Override
    public int getType() {
        return LOFC2Constant.CLASS_ID_KEY.CLASS_ID_MISSION;
    }

    public Integer getPlayerPlaneId() {
        return Integer.valueOf((String) mInfo.get(LOFC2Constant.MISSION_KEY.PLAYER_PLANE_ID));
    }

    public Integer getPlayerPlaneCountry() {
        return Integer.valueOf((String) mInfo.get(LOFC2Constant.MISSION_KEY.MYPLANE_OBJ_COUNTRY));
    }

    public Integer getPlayerPlaneObjLevel1() {
        return Integer.valueOf((String) mInfo.get(LOFC2Constant.MISSION_KEY.MYPLANE_OBJ_LEVEL1));
    }

    public Integer getPlayerPlaneObjLevel2() {
        return Integer.valueOf((String) mInfo.get(LOFC2Constant.MISSION_KEY.MYPLANE_OBJ_LEVEL2));
    }

    public Integer getPlayerPlaneObjLevel3() {
        return Integer.valueOf((String) mInfo.get(LOFC2Constant.MISSION_KEY.MYPLANE_OBJ_LEVEL3));
    }

    public Integer getPlayerPlaneObjLevel4() {
        return Integer.valueOf((String) mInfo.get(LOFC2Constant.MISSION_KEY.MYPLANE_OBJ_LEVEL4));
    }
}
