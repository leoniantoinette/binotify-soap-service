package binotify;

import javax.xml.ws.*;
import binotify.services.*;

public class App {
    public static void main(String[] args) {
        try {
            Endpoint.publish("http://localhost:8081/service/subscription", new SubscriptionServicesImpl());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
