package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;


public class LoggerUtil { 
    // Declares a public class named LoggerUtil. This class is designed to provide logging utilities.

    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());
    // Creates a private static final Logger instance named 'logger'.
    // This logger is associated with the LoggerUtil class and uses the class name as its identifier.
    // 'Logger.getLogger()' retrieves a logger for the specified class name.

    public static void logInfo(String message) {
        // Declares a public static method named 'logInfo' that takes a single String parameter 'message'.
        // This method is used to log informational messages.

        logger.info(message);
        // Logs the provided message at the INFO level using the logger instance.
    }

    public static void logError(String message, Throwable throwable) {
        // Declares a public static method named 'logError' that takes two parameters:
        // - a String 'message' (the error message to be logged)
        // - a Throwable 'throwable' (the exception or error that occurred).
        // This method is used to log error messages along with the associated exception.

        logger.log(Level.SEVERE, message, throwable);
        // Logs the provided message and the associated Throwable at the SEVERE level using the logger instance.
    }
}
