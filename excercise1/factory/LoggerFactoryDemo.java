package factory;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

interface Logger {
    void log(String message);
}

class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println("[Console " + LocalDateTime.now() + "] " + message);
    }
}

class FileLogger implements Logger {
    private String filename;
    public FileLogger(String filename) { this.filename = filename; }
    public void log(String message) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write("[File " + LocalDateTime.now() + "] " + message + "\n");
            System.out.println("Logged to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class LoggerFactory {
    public static Logger createLogger(String type) {
        switch (type) {
            case "console": return new ConsoleLogger();
            case "file": return new FileLogger("app.log");
            default: throw new IllegalArgumentException("Unknown logger type");
        }
    }
}

public class LoggerFactoryDemo {
    public static void main(String[] args) {
        Logger c = LoggerFactory.createLogger("console");
        c.log("This is a console log entry.");
        Logger f = LoggerFactory.createLogger("file");
        f.log("This is a file log entry.");
    }
}
