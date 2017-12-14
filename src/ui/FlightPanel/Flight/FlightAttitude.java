package ui.FlightPanel.Flight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Llfc2Constant.LOFC2Constant;
import utils.Log;

public class FlightAttitude extends JPanel {
    private final String TAG = "FlightAttitude";
    private final Color INACTIVE_COLOR = Color.lightGray;
    private final Color ACTIVE_COLOR = Color.green;
    private boolean mbGearDown = false;
    private boolean mbFlapOn = false;
    private boolean mbAirbrakeOn = false;
    private boolean mbHookDown = false;
    private ImageIcon mIcon = null;
    private ImageIcon mGear = null;
    private ImageIcon mGearOn = null;
    private ImageIcon mFlap = null;
    private ImageIcon mFlapOn = null;
    private ImageIcon mAirbrake = null;
    private ImageIcon mAirbrakeOn = null;

    public FlightAttitude() {
        setOpaque(true);
        mIcon = new ImageIcon(LOFC2Constant.RES_ROOT + "altitude.png");
        mGear = new ImageIcon(LOFC2Constant.RES_ROOT + "gear.png");
        mGearOn = new ImageIcon(LOFC2Constant.RES_ROOT + "gear_on.png");
        mFlap = new ImageIcon(LOFC2Constant.RES_ROOT + "flap.png");
        mFlapOn = new ImageIcon(LOFC2Constant.RES_ROOT + "flap_on.png");
        mAirbrake = new ImageIcon(LOFC2Constant.RES_ROOT + "airbrake.png");
        mAirbrakeOn = new ImageIcon(LOFC2Constant.RES_ROOT + "airbrake_on.png");
    }

    public void setGearDown(int value) {
        mbGearDown = value > 0 ? true : false;
    }

    public void setFlapOn(int value) {
        mbFlapOn = value > 0 ? true : false;
    }

    public void setAirbrakeOn(int value) {
        mbAirbrakeOn = value > 0 ? true : false;
    }

    public void setHookDown(int value) {
        mbHookDown = value > 0 ? true : false;
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, 120, 120);
        int x = 0, y = 0;
        g.drawImage(mIcon.getImage(), x, y, this);

        if (mbGearDown) {
            g.drawImage(mGearOn.getImage(), 56, 72, this);
            g.drawImage(mGearOn.getImage(), 37, 90, this);
            g.drawImage(mGearOn.getImage(), 75, 90, this);
        } else {
            g.drawImage(mGear.getImage(), 56, 72, this);
            g.drawImage(mGear.getImage(), 37, 90, this);
            g.drawImage(mGear.getImage(), 75, 90, this);
        }

        if (mbFlapOn) {
            g.drawImage(mFlapOn.getImage(), 10, 64, this);
            g.drawImage(mFlapOn.getImage(), 88, 64, this);
        } else {
            g.drawImage(mFlap.getImage(), 10, 64, this);
            g.drawImage(mFlap.getImage(), 88, 64, this);
        }

        if (mbAirbrakeOn) {
            g.drawImage(mAirbrakeOn.getImage(), 54, 15, this);
        } else {
            g.drawImage(mAirbrake.getImage(), 54, 15, this);
        }

        if (mbHookDown) {
            g.drawImage(mAirbrakeOn.getImage(), 54, 64, this);
        } else {
            g.drawImage(mAirbrake.getImage(), 54, 64, this);
        }

    }
}
