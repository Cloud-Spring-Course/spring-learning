package spring.example.logger;

import spring.example.prototype.Event;

public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(Event msg) {
        System.out.println(msg);
    }
}
