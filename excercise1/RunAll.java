import observer.NewsAgencyDemo;
import observer.StockTickerDemo;
import strategy.PaymentDemo;
import strategy.SortingDemo;
import factory.LoggerFactoryDemo;
import singleton.DbSingletonDemo;

public class RunAll {
    public static void main(String[] args) {
        System.out.println("===== Observer Pattern (News Agency) =====");
        NewsAgencyDemo.main(args);

        System.out.println("\n===== Observer Pattern (Stock Ticker) =====");
        StockTickerDemo.main(args);

        System.out.println("\n===== Strategy Pattern (Payment) =====");
        PaymentDemo.main(args);

        System.out.println("\n===== Strategy Pattern (Sorting) =====");
        SortingDemo.main(args);

        System.out.println("\n===== Factory Pattern (Logger) =====");
        LoggerFactoryDemo.main(args);

        System.out.println("\n===== Singleton Pattern (DB Connection) =====");
        DbSingletonDemo.main(args);
    }
}
