package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {

    // Method to list the contents of a directory.
    public void listContents(String directory) {
        File dir = new File(directory); // Create a File object representing the directory.
        if (dir.exists() && dir.isDirectory()) { // Check if the directory exists and is a directory.
            File[] files = dir.listFiles(); // Get the list of files in the directory.
            if (files != null) { // Check if the directory is not empty or null.
                for (File file : files) { // Iterate through each file in the directory.
                    // Print the file's name, size, and last modified date.
                    System.out.println(file.getName() + " - " + file.length() + " bytes - Last modified: " + new java.util.Date(file.lastModified()));
                }
            } else {
                // If the directory is empty or could not be accessed.
                System.out.println("Directory is empty or could not be accessed.");
            }
        } else {
            // If the provided path is not a valid directory.
            System.out.println("Invalid directory.");
        }
    }

    // Method to create a new file.
    public void createFile(String filePath) {
        try {
            File file = new File(filePath); // Create a File object for the given file path.
            if (file.exists()) { // Check if the file already exists.
                System.out.println("File already exists."); // Inform the user if the file exists.
            } else {
                // Attempt to create the file and check if it was successful.
                if (file.createNewFile()) {
                    System.out.println("File created successfully."); // Inform the user of success.
                } else {
                    System.out.println("Failed to create file."); // Inform the user of failure.
                }
            }
        } catch (IOException e) { // Handle any IOExceptions that occur.
            // Print the error message to the console.
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

    // Method to copy a file from one location to another.
    public void copyFile(String source, String destination) {
        try {
            Path src = Paths.get(source); // Create a Path object for the source file.
            Path dest = Paths.get(destination); // Create a Path object for the destination file.
            Files.copy(src, dest); // Copy the file from the source to the destination.
            System.out.println("File copied successfully."); // Inform the user of success.
        } catch (IOException e) { // Handle any IOExceptions that occur.
            // Print the error message to the console.
            System.out.println("Failed to copy file: " + e.getMessage());
        }
    }

    // Method to move a file from one location to another.
    public void moveFile(String source, String destination) {
        try {
            Path src = Paths.get(source); // Create a Path object for the source file.
            Path dest = Paths.get(destination); // Create a Path object for the destination file.
            Files.move(src, dest); // Move the file from the source to the destination.
            System.out.println("File moved successfully."); // Inform the user of success.
        } catch (IOException e) { // Handle any IOExceptions that occur.
            // Print the error message to the console.
            System.out.println("Failed to move file: " + e.getMessage());
        }
    }

    // Method to delete a file.
    public void deleteFile(String filePath) {
        File file = new File(filePath); // Create a File object for the given file path.
        if (file.delete()) { // Attempt to delete the file and check if it was successful.
            System.out.println("File deleted successfully."); // Inform the user of success.
        } else {
            System.out.println("Failed to delete file."); // Inform the user of failure.
        }
    }

    // Method to create a new directory.
    public void createDirectory(String directoryPath) {
        File dir = new File(directoryPath); // Create a File object for the directory path.
        if (dir.mkdir()) { // Attempt to create the directory and check if it was successful.
            System.out.println("Directory created successfully."); // Inform the user of success.
        } else {
            System.out.println("Failed to create directory."); // Inform the user of failure.
        }
    }

    // Method to delete a directory.
    public void deleteDirectory(String directoryPath) {
        File dir = new File(directoryPath); // Create a File object for the directory path.
        if (dir.exists() && dir.isDirectory()) { // Check if the directory exists and is a directory.
            // Attempt to delete the directory recursively and check if it was successful.
            if (deleteDirectoryRecursively(dir)) {
                System.out.println("Directory deleted successfully."); // Inform the user of success.
            } else {
                System.out.println("Failed to delete directory."); // Inform the user of failure.
            }
        } else {
            System.out.println("Invalid directory."); // Inform the user if the directory is invalid.
        }
    }

    // Helper method to delete a directory and its contents recursively.
    private boolean deleteDirectoryRecursively(File dir) {
        File[] files = dir.listFiles(); // Get the list of files in the directory.
        if (files != null) { // Check if the directory is not empty or null.
            for (File file : files) { // Iterate through each file in the directory.
                if (file.isDirectory()) { // Check if the current file is a directory.
                    deleteDirectoryRecursively(file); // Recursively delete the subdirectory.
                } else {
                    file.delete(); // Delete the file.
                }
            }
        }
        return dir.delete(); // Finally, delete the directory itself.
    }

    // Method to search for files in a directory that contain a specific search term in their names.
    public void searchFiles(String directory, String searchTerm) {
        File dir = new File(directory); // Create a File object representing the directory.
        if (dir.exists() && dir.isDirectory()) { // Check if the directory exists and is a directory.
            // Filter the files in the directory by those whose names contain the search term.
            File[] files = dir.listFiles((d, name) -> name.contains(searchTerm));
            if (files != null && files.length > 0) { // Check if any files match the search term.
                for (File file : files) { // Iterate through each matching file.
                    System.out.println(file.getName()); // Print the name of the matching file.
                }
            } else {
                System.out.println("No files found matching the search term."); // Inform the user if no matches are found.
            }
        } else {
            System.out.println("Invalid directory."); // Inform the user if the directory is invalid.
        }
    }
}
