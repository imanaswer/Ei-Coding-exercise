package satellite;

public class OrientationState implements SatelliteState {
    private Satellite satellite;

    public OrientationState(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void rotate(String direction) {
        satellite.rotate(direction);
    }

    @Override
    public void activatePanels() {
        throw new UnsupportedOperationException("Cannot activate panels in orientation state.");
    }

    @Override
    public void deactivatePanels() {
        throw new UnsupportedOperationException("Cannot deactivate panels in orientation state.");
    }

    @Override
    public void collectData() {
        throw new UnsupportedOperationException("Cannot collect data in orientation state.");
    }
}
