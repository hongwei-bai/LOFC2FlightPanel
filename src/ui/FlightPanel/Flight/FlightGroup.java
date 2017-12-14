package ui.FlightPanel.Flight;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import utils.Log;

public class FlightGroup extends JPanel {
    private FlightAttitude mFlightAttitude = new FlightAttitude();
    private FlightInfoPanel mFlightInfoPanel = new FlightInfoPanel();

    public FlightGroup() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(mFlightAttitude);
        add(mFlightInfoPanel);
    }

    public void setFlightAttitude(int gear, int flap, int airbrake, int hook) {
        mFlightAttitude.setGearDown(gear);
        mFlightAttitude.setFlapOn(flap);
        mFlightAttitude.setAirbrakeOn(airbrake);
        mFlightAttitude.setHookDown(hook);
        mFlightAttitude.repaint();
    }

    public void setFlightInfo(Double speed, Double alt, int engineL, int engineR, int country, Double verticalSpeed, Double pitch) {
        mFlightInfoPanel.setAirSpeed(speed, country);
        mFlightInfoPanel.setAltitudeAboveSeaLevel(alt, country);
        mFlightInfoPanel.setEngineInfoRPMLeft(engineL);
        mFlightInfoPanel.setEngineInfoRPMRight(engineR);
        mFlightInfoPanel.setVerticalSpeed(verticalSpeed);
        mFlightInfoPanel.setPitch(pitch);
        Log.d("FlightGroup", "pitch = " + pitch);
    }
}
