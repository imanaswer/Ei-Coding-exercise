package Exercise1.Structural.AdapterPattern;

interface LaptopCharger {
    void chargeLaptop();
}

class PowerBank {
    public void providePower() {
        System.out.println("PowerBank providing power.");
    }
}

class LaptopAdapter implements LaptopCharger {
    private PowerBank powerBank;

    public LaptopAdapter(PowerBank powerBank) {
        this.powerBank = powerBank;
    }

    public void chargeLaptop() {
        powerBank.providePower();
        System.out.println("Laptop is charging using an adapter.");
    }
}

// Main
public class ChargingSystem {
    public static void main(String[] args) {
        PowerBank powerBank = new PowerBank();
        LaptopCharger adapter = new LaptopAdapter(powerBank);

        adapter.chargeLaptop();
    }
}
