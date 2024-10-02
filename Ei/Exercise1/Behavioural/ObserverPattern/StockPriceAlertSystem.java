package Exercise1.Behavioural.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float price);
}

class MobileApp implements Observer {
    public void update(float price) {
        System.out.println("MobileApp: Stock price updated to " + price);
    }
}

class WebApp implements Observer {
    public void update(float price) {
        System.out.println("WebApp: Stock price updated to " + price);
    }
}

class Stock {
    private List<Observer> observers = new ArrayList<>();
    private float price;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}

// Main
public class StockPriceAlertSystem {
    public static void main(String[] args) {
        Stock googleStock = new Stock();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        googleStock.addObserver(mobileApp);
        googleStock.addObserver(webApp);

        googleStock.setPrice(1200.5f); // Both MobileApp and WebApp get notified
    }
}
