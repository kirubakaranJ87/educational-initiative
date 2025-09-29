package observer;

import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String publisher, String article);
}

class NewsPublisher {
    private String name;
    private List<Subscriber> subscribers = new ArrayList<>();

    public NewsPublisher(String name) {
        this.name = name;
    }

    public void subscribe(Subscriber s) { subscribers.add(s); }
    public void unsubscribe(Subscriber s) { subscribers.remove(s); }

    public void publish(String article) {
        System.out.println("[" + name + "] Publishing article: " + article);
        for (Subscriber s : subscribers) {
            s.update(name, article);
        }
    }
}

class EmailSubscriber implements Subscriber {
    private String email;
    public EmailSubscriber(String email) { this.email = email; }
    public void update(String publisher, String article) {
        System.out.println("Email to " + email + ": New from " + publisher + " -> " + article);
    }
}

class MobileSubscriber implements Subscriber {
    private String phone;
    public MobileSubscriber(String phone) { this.phone = phone; }
    public void update(String publisher, String article) {
        System.out.println("Push to " + phone + ": " + publisher + ": " + article);
    }
}

public class NewsAgencyDemo {
    public static void main(String[] args) {
        NewsPublisher agency = new NewsPublisher("DailyPlanet");
        Subscriber alice = new EmailSubscriber("alice@example.com");
        Subscriber bob = new MobileSubscriber("+1234567890");

        agency.subscribe(alice);
        agency.subscribe(bob);

        agency.publish("Design patterns explained simply.");
        agency.unsubscribe(alice);
        agency.publish("Observer pattern deep dive.");
    }
}
