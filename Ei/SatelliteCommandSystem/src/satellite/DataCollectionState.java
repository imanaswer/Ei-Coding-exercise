package satellite;

public class DataCollectionState implements SatelliteState {
    private Satellite satellite;

    public DataCollectionState(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void rotate(String direction) {
        throw new UnsupportedOperationException("Cannot rotate while collecting data.");
    }

    @Override
    public void activatePanels() {
        throw new UnsupportedOperationException("Cannot activate panels while collecting data.");
    }

    @Override
    public void deactivatePanels() {
        throw new UnsupportedOperationException("Cannot deactivate panels while collecting data.");
    }

    @Override
    public void collectData() {
        satellite.collectData();
    }
}
