package satellite;

public class SolarPanelState implements SatelliteState {
    private Satellite satellite;

    public SolarPanelState(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void rotate(String direction) {
        throw new UnsupportedOperationException("Cannot rotate while managing solar panels.");
    }

    @Override
    public void activatePanels() {
        satellite.activatePanels();
    }

    @Override
    public void deactivatePanels() {
        satellite.deactivatePanels();
    }

    @Override
    public void collectData() {
        throw new UnsupportedOperationException("Cannot collect data in solar panel state.");
    }
}
