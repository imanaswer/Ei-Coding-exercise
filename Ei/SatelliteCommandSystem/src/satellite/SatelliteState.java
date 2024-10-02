package satellite;

public interface SatelliteState {
    void rotate(String direction);
    void activatePanels();
    void deactivatePanels();
    void collectData();
}
