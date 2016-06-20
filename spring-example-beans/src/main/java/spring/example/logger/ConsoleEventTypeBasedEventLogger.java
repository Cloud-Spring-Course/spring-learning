package spring.example.logger;

import spring.example.prototype.Event;
import spring.example.prototype.EventType;

import java.util.Map;

public class ConsoleEventTypeBasedEventLogger implements EventLogger {

    protected final Map<EventType, EventLogger> typesToLoggers;

    public ConsoleEventTypeBasedEventLogger(Map<EventType, EventLogger> typesToLoggers) {
        this.typesToLoggers = typesToLoggers;
    }

    @Override
    public void logEvent(Event event) throws Exception {
        EventLogger logger = typesToLoggers.get(event.getType());
        if (logger != null) {
            System.out.println("Choose logger " + logger + " for event " + event);
            logger.logEvent(event);
        } else {
            System.out.println("Event does not have type");
        }
    }
}