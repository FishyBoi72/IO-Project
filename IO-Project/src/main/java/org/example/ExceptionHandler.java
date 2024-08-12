package org.example;

public class ExceptionHandler {

    public static void handle(Exception e) {
        LoggerUtil.logError("An error occurred", e);
        System.out.println("An error occurred: " + e.getMessage());
    }
}