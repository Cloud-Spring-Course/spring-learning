package spring.example.logger;

import spring.example.prototype.Event;

public interface EventLogger {

    void logEvent(Event event) throws Exception;
}