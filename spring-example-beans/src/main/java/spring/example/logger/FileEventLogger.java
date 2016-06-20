package spring.example.logger;

import org.apache.commons.io.FileUtils;
import spring.example.prototype.Event;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    protected String filename;
    protected File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void init() throws IOException {
        System.out.println("FileEventLogger.init()");

        file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        if (!file.canWrite()) {
            throw new IOException("File " + filename + " is not available for writing");
        }
    }

    @Override
    public void logEvent(Event event) throws IOException {
        FileUtils.writeStringToFile(new File(filename), "\n" + event.getMsg(), true);
    }
}