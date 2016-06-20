package spring.example.logger;

import spring.example.prototype.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CachedFileEventLogger extends FileEventLogger {

    protected int cacheSize;
    protected List<Event> cache = new ArrayList<>();

    public CachedFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
    }

    @Override
    public synchronized void logEvent(Event event) throws IOException {
        cache.add(event);

        if (cache.size() > cacheSize) {
            flushCache();
        }
    }

    protected void flushCache() throws IOException {
        System.out.println("CachedFileEventLogger.cache()");
        for (Event e : cache) {
            super.logEvent(e);
        }

        cache.clear();
    }
}
