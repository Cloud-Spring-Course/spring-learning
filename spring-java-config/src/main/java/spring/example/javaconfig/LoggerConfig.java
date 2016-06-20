package spring.example.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.example.logger.*;
import spring.example.prototype.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class LoggerConfig {

    @Bean
    public ConsoleEventLogger createConsoleEventLogger() {
        return new ConsoleEventLogger();
    }

    @Bean(initMethod = "init")
    public FileEventLogger createFileEventLogger() {
        return new FileEventLogger("C:\\Work\\spring-file-event-logger.txt");
    }

    @Bean(initMethod = "init")
    public CachedFileEventLogger createCachedFileEventLogger() {
        return new CachedFileEventLogger("C:\\Work\\spring-file-event-logger.txt", 10);
    }

    @Bean
    public CombinedEventLogger createCombinedEventLogger(CachedFileEventLogger cachedFileEventLogger, ConsoleEventLogger consoleEventLogger) {
        List<EventLogger> loggers = new ArrayList<>();
        loggers.add(cachedFileEventLogger);
        loggers.add(consoleEventLogger);
        return new CombinedEventLogger(loggers);
    }

    @Bean(name = "eventLogger")
    public ConsoleEventTypeBasedEventLogger consoleEventTypeBasedEventLogger(CachedFileEventLogger cachedFileEventLogger, ConsoleEventLogger consoleEventLogger) {
        Map<EventType, EventLogger> typesToLoggers = new HashMap<>();
        typesToLoggers.put(EventType.ERROR, cachedFileEventLogger);
        typesToLoggers.put(EventType.INFO, consoleEventLogger);
        return new ConsoleEventTypeBasedEventLogger(typesToLoggers);
    }
}