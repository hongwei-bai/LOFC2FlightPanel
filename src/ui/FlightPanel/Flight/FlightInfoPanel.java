package ui.FlightPanel.Flight;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Llfc2Constant.DisplayString;
import Llfc2Constant.LOFC2Constant;

public class FlightInfoPanel extends JPanel {
    private static final long serialVersionUID = 2197146502505417104L;
    private final JLabel mAltitudeAboveSeaLevel = new JLabel();
    private final JLabel mTrueAirSpeed = new JLabel();
    private final JLabel mEngineLeft = new JLabel();
    private final JLabel mEngineRight = new JLabel();
    private final JLabel mVerticalSpeed = new JLabel();
    private final JLabel mPitch = new JLabel();

    private int mPreviousAirSPeed = -1;
    private int mPreviousAltitudeAboveSeaLevel = -1;
    private int mPreviousEngineLeft = -1;
    private int mPreviousEngineRight = -1;
    private int mPreviousVerticalSpeed = -1;
    private int mPreviousPitch = -1;

    public FlightInfoPanel() {
        setLayout(new GridLayout(3, 2));
        mAltitudeAboveSeaLevel.setText(DisplayString.ALTITUDE_SEA_LEVEL);
        mTrueAirSpeed.setText(DisplayString.AIR_SPEED);
        mEngineLeft.setText(DisplayString.LEFT_ENGINE + "0");
        mEngineRight.setText(DisplayString.RIGHT_ENGINE + "0");
        mVerticalSpeed.setText(DisplayString.VERTICAL_SPEED);
        mPitch.setText(DisplayString.PITCH + "0");
        // row 1
        add(mAltitudeAboveSeaLevel);
        add(mTrueAirSpeed);

        // row 2
        add(mVerticalSpeed);
        add(mPitch);

        // row 3
        add(mEngineLeft);
        add(mEngineRight);
    }

    public void setAirSpeed(Double speed, int country) {
        if (Math.abs(speed.intValue() - mPreviousAirSPeed) >= 1) {
            mPreviousAirSPeed = speed.intValue();
            switch (country) {
            case LOFC2Constant.OBJ_COUNTRY.USA:
                mTrueAirSpeed.setText(DisplayString.AIR_SPEED + (int) (speed * 1.9438) + " n");
                return;
            case LOFC2Constant.OBJ_COUNTRY.RUS:
            default:
                mTrueAirSpeed.setText(DisplayString.AIR_SPEED + (int) (speed * 3.6) + " Km/h");
                return;
            }
        }
    }

    public void setAltitudeAboveSeaLevel(Double altSea, int country) {
        if (Math.abs(altSea.intValue() - mPreviousAltitudeAboveSeaLevel) >= 1) {
            mPreviousAltitudeAboveSeaLevel = altSea.intValue();
            switch (country) {
            case LOFC2Constant.OBJ_COUNTRY.USA:
                mAltitudeAboveSeaLevel.setText(DisplayString.ALTITUDE_SEA_LEVEL + (int) (altSea * 3.2808399) + " inch");
                return;
            case LOFC2Constant.OBJ_COUNTRY.RUS:
            default:
                mAltitudeAboveSeaLevel.setText(DisplayString.ALTITUDE_SEA_LEVEL + altSea.intValue() + " m");
                return;
            }
        }
    }

    public void setEngineInfoRPMLeft(int rpm) {
        if (Math.abs(rpm - mPreviousEngineLeft) >= 1) {
            mPreviousEngineLeft = rpm;
            mEngineLeft.setText(DisplayString.LEFT_ENGINE + rpm + "%");
        }
    }

    public void setEngineInfoRPMRight(int rpm) {
        if (Math.abs(rpm - mPreviousEngineRight) >= 1) {
            mPreviousEngineRight = rpm;
            mEngineRight.setText(DisplayString.RIGHT_ENGINE + rpm + "%");
        }
    }

    public void setVerticalSpeed(Double vs) {
        if (Math.abs(vs - mPreviousVerticalSpeed) >= 1) {
            mPreviousVerticalSpeed = vs.intValue();
            mVerticalSpeed.setText(DisplayString.VERTICAL_SPEED + vs.intValue() + " m/s");
        }
    }

    public void setPitch(Double pitch) {
        if (Math.abs(pitch - mPreviousPitch) >= 1) {
            mPreviousPitch = pitch.intValue();
            mPitch.setText(DisplayString.PITCH + pitch.intValue() + " rad");
        }
    }
}
