package spring.example;

import spring.example.logger.EventLogger;
import spring.example.prototype.Event;

import java.util.Properties;

public class App {

    protected Client client;
    protected EventLogger eventLogger;
    protected Properties properties;

    public void init() {
        System.out.println("App.init(), client: " + client.getGreeting());
        System.out.println("Properties: " + properties);
    }

    public void logEvent(Event event) throws Exception {
        event.setMsg(event.getMsg().replaceAll(client.getId(), client.getFullName()));
        eventLogger.logEvent(event);
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void setEventLogger(EventLogger eventLogger) {
        this.eventLogger = eventLogger;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}