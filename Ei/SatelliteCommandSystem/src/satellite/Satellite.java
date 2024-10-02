package satellite;

import exceptions.InvalidStateException;
import logging.Logger;

public class Satellite {
    private String orientation = "North";
    private String solarPanelStatus = "Inactive";
    private int dataCollected = 0;

    public void rotate(String direction) {
        this.orientation = direction;
        Logger.log("Rotated to " + direction);
    }

    public void activatePanels() {
        this.solarPanelStatus = "Active";
        Logger.log("Solar panels activated.");
    }

    public void deactivatePanels() {
        this.solarPanelStatus = "Inactive";
        Logger.log("Solar panels deactivated.");
    }

    public void collectData() {
        if ("Active".equals(solarPanelStatus)) {
            dataCollected += 10;
            Logger.log("Data collected: " + dataCollected);
        } else {
            throw new InvalidStateException("Cannot collect data, solar panels are inactive.");
        }
    }

    public String getState() {
        return "Orientation: " + orientation + ", Solar Panels: " + solarPanelStatus + ", Data Collected: " + dataCollected;
    }
}
