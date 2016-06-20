package spring.example.logger;

import spring.example.prototype.Event;

import java.util.List;

public class CombinedEventLogger implements EventLogger {

    protected final List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) throws Exception {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}