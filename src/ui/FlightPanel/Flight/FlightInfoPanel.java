package ui.FlightPanel.Flight;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RowFilter;

import Llfc2Constant.LOFC2Constant;
import utils.Log;

public class FlightInfoPanel extends JPanel {
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
        mAltitudeAboveSeaLevel.setText("Altitude:");
        mTrueAirSpeed.setText("Air speed:");
        mEngineLeft.setText("L Engine: 0");
        mEngineRight.setText("R Engine: 0");
        mVerticalSpeed.setText("Vertical speed:");
        mPitch.setText("Pitch: 0");
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
                mTrueAirSpeed.setText("Air speed: " + (int) (speed * 1.9438) + " n");
                return;
            case LOFC2Constant.OBJ_COUNTRY.RUS:
            default:
                mTrueAirSpeed.setText("Air speed: " + (int) (speed * 3.6) + " Km/h");
                return;
            }
        }
    }

    public void setAltitudeAboveSeaLevel(Double altSea, int country) {
        if (Math.abs(altSea.intValue() - mPreviousAltitudeAboveSeaLevel) >= 1) {
            mPreviousAltitudeAboveSeaLevel = altSea.intValue();
            switch (country) {
            case LOFC2Constant.OBJ_COUNTRY.USA:
                mAltitudeAboveSeaLevel.setText("Altitude: " + (int) (altSea * 3.2808399) + " inch");
                return;
            case LOFC2Constant.OBJ_COUNTRY.RUS:
            default:
                mAltitudeAboveSeaLevel.setText("Altitude: " + altSea.intValue() + " m");
                return;
            }
        }
    }

    public void setEngineInfoRPMLeft(int rpm) {
        if (Math.abs(rpm - mPreviousEngineLeft) >= 1) {
            mPreviousEngineLeft = rpm;
            mEngineLeft.setText("L Engine: " + rpm + "%");
        }
    }

    public void setEngineInfoRPMRight(int rpm) {
        if (Math.abs(rpm - mPreviousEngineRight) >= 1) {
            mPreviousEngineRight = rpm;
            mEngineRight.setText("R Engine: " + rpm + "%");
        }
    }

    public void setVerticalSpeed(Double vs) {
        if (Math.abs(vs - mPreviousVerticalSpeed) >= 1) {
            mPreviousVerticalSpeed = vs.intValue();
            mVerticalSpeed.setText("Vertical speed: " + vs.intValue() + " m/s");
        }
    }

    public void setPitch(Double pitch) {
        if (Math.abs(pitch - mPreviousPitch) >= 1) {
            mPreviousPitch = pitch.intValue();
            mPitch.setText("Pitch: " + pitch.intValue() + " rad");
        }
    }
}
