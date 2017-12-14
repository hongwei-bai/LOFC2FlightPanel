package Llfc2Constant;

public class LOFC2Constant {
    public static final String RES_ROOT = "./res/";

    public static interface CLASS_KEY {
        public static final String CLASS = "class";
        public static final String CLASS_MISSION = "mission";
        public static final String CLASS_FLIGHT = "flight";
    }

    public static interface CLASS_ID_KEY {
        public static final int CLASS_ID_MISSION = 0;
        public static final int CLASS_ID_FLIGHT = 1;
    }

    public static interface MISSION_KEY {
        public static final String PLAYER_PLANE_ID = "playerPlaneId";
        public static final String MYPLANE_OBJ_COUNTRY = "country";
        public static final String MYPLANE_OBJ_LEVEL1 = "level1";
        public static final String MYPLANE_OBJ_LEVEL2 = "level2";
        public static final String MYPLANE_OBJ_LEVEL3 = "level3";
        public static final String MYPLANE_OBJ_LEVEL4 = "level4";
    }

    public static interface FLIGHT_KEY {
        public static final String TRUE_AIR_SPEED = "trueAirSpeed";
        public static final String INDICATED_AIR_SPEED = "indAirSpeed";
        public static final String ALTITUDE_ABOVE_SEALEVEL = "altBar";
        public static final String ENGINE_RPM_LEFT = "engineLeft";
        public static final String ENGINE_RPM_RIGHT = "engineRight";
        public static final String PITCH = "pitch";
        public static final String VERTICAL_SPEED = "verticalSpeed";
    };

    public static interface ATTITUDE_KEY {
        public static final String GEAR = "gear";
        public static final String FLAP = "flaps";
        public static final String AIRBRAKE = "speedbrakes";
        public static final String HOOK = "hook";
    };

    public static interface OBJ_COUNTRY {
        public static final int RUS = 0;
        public static final int USA = 2;
    }
}
