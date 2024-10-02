package commands;

import logging.Logger;
import satellite.Satellite;

public class DeactivatePanelsCommand implements Command {
    private Satellite satellite;

    public DeactivatePanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
        satellite.deactivatePanels();
        Logger.log("Solar panels deactivated. Data collection reset to 0.");
    }
}

