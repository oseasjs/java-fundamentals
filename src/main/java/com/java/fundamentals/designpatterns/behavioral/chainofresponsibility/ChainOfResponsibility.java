package com.java.fundamentals.designpatterns.behavioral.chainofresponsibility;

/**
 * As the name suggests, the chain of responsibility pattern creates a chain of receiver objects for a request.
 * This pattern decouples sender and receiver of a request based on type of request.
 * This pattern comes under behavioral patterns.
 * In this pattern, normally each receiver contains reference to another receiver.
 * If one object cannot handle the request then it passes the same to the next receiver and so on.
 */
public class ChainOfResponsibility {

    public static void main(String[] args) {
        AbstractLogger logger = ChainLog.getChainOfLoggers();
        logger.logMessage(AbstractLogger.INFO, "Info message");
        logger.logMessage(AbstractLogger.DEBUG, "Debug message");
        logger.logMessage(AbstractLogger.ERROR, "Error message");
    }

}

abstract class AbstractLogger {
    protected static int INFO = 1;
    protected static int DEBUG = 2;
    protected static int ERROR = 3;
    protected int level;

    // Next Element in chain or responsibility
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            this.nextLogger.logMessage(level, message);
        }
    }
    protected abstract void write(String message);

}

class ConsoleLog extends AbstractLogger {
    public ConsoleLog(int level) {
        this.level = level;
    }
    @Override
    protected void write(String message) {
        System.out.println("Standard Log::Logger: " + message);
    }
}

class FileLog extends AbstractLogger {
    public FileLog(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File Log::Logger: " + message);
    }
}

class ErrorLog extends AbstractLogger {
    public ErrorLog(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Log::message: " + message);
    }
}

class ChainLog {
    public static AbstractLogger getChainOfLoggers() {

        // Create different types of loggers. Assign them error levels and set next logger in each logger.
        AbstractLogger errorLogger = new ErrorLog(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLog(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLog(AbstractLogger.INFO);

        // Next logger in each logger represents the part of the chain.
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;

    }
}
