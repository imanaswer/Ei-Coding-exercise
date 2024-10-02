package Exercise1.Creational.FactoryPattern;

interface Coffee {
    void brew();
}

class Espresso implements Coffee {
    public void brew() {
        System.out.println("Brewing an Espresso.");
    }
}

class Cappuccino implements Coffee {
    public void brew() {
        System.out.println("Brewing a Cappuccino.");
    }
}

class Latte implements Coffee {
    public void brew() {
        System.out.println("Brewing a Latte.");
    }
}

class CoffeeFactory {
    public static Coffee getCoffee(String type) {
        switch (type.toLowerCase()) {
            case "espresso": return new Espresso();
            case "cappuccino": return new Cappuccino();
            case "latte": return new Latte();
            default: throw new IllegalArgumentException("Unknown coffee type");
        }
    }
}

// Main
public class CoffeeShop {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.getCoffee("espresso");
        coffee.brew();
    }
}
