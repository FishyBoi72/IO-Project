package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;


public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logError(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }
}