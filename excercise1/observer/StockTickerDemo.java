package observer;

import java.util.ArrayList;
import java.util.List;

interface Trader {
    void notify(String symbol, double price);
}

class StockTicker {
    private List<Trader> traders = new ArrayList<>();

    public void register(Trader t) { traders.add(t); }
    public void unregister(Trader t) { traders.remove(t); }

    public void updatePrice(String symbol, double price) {
        System.out.println("Ticker: " + symbol + " -> " + price);
        for (Trader t : traders) {
            t.notify(symbol, price);
        }
    }
}

class RiskAverseTrader implements Trader {
    private String name;
    private double threshold;

    public RiskAverseTrader(String name, double threshold) {
        this.name = name;
        this.threshold = threshold;
    }

    public void notify(String symbol, double price) {
        if (price < threshold) {
            System.out.println(name + " buys " + symbol + " at " + price + " (below " + threshold + ")");
        }
    }
}

class MomentumTrader implements Trader {
    private String name;
    private Double lastPrice = null;

    public MomentumTrader(String name) { this.name = name; }

    public void notify(String symbol, double price) {
        if (lastPrice != null && price > lastPrice) {
            System.out.println(name + " increases position in " + symbol + " (up from " + lastPrice + " to " + price + ")");
        }
        lastPrice = price;
    }
}

public class StockTickerDemo {
    public static void main(String[] args) {
        StockTicker ticker = new StockTicker();
        ticker.register(new RiskAverseTrader("RA-Trader", 100.0));
        ticker.register(new MomentumTrader("M-Trader"));

        ticker.updatePrice("ACME", 120.0);
        ticker.updatePrice("ACME", 95.0);
        ticker.updatePrice("ACME", 98.0);
    }
}
