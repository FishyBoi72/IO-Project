
package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {

    public void listContents(String directory) {
        File dir = new File(directory);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName() + " - " + file.length() + " bytes - Last modified: " + new java.util.Date(file.lastModified()));
                }
            } else {
                System.out.println("Directory is empty or could not be accessed.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }

    public void createFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                System.out.println("File already exists.");
            } else {
                if (file.createNewFile()) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("Failed to create file.");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }
    public void copyFile(String source, String destination) {
        try {
            Path src = Paths.get(source);
            Path dest = Paths.get(destination);
            Files.copy(src, dest);
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Failed to copy file: " + e.getMessage());
        }
    }

    public void moveFile(String source, String destination) {
        try {
            Path src = Paths.get(source);
            Path dest = Paths.get(destination);
            Files.move(src, dest);
            System.out.println("File moved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to move file: " + e.getMessage());
        }
    }

    public void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete file.");
        }
    }

    public void createDirectory(String directoryPath) {
        File dir = new File(directoryPath);
        if (dir.mkdir()) {
            System.out.println("Directory created successfully.");
        } else {
            System.out.println("Failed to create directory.");
        }
    }

    public void deleteDirectory(String directoryPath) {
        File dir = new File(directoryPath);
        if (dir.exists() && dir.isDirectory()) {
            if (deleteDirectoryRecursively(dir)) {
                System.out.println("Directory deleted successfully.");
            } else {
                System.out.println("Failed to delete directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }

    private boolean deleteDirectoryRecursively(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectoryRecursively(file);
                } else {
                    file.delete();
                }
            }
        }
        return dir.delete();
    }

    public void searchFiles(String directory, String searchTerm) {
        File dir = new File(directory);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((d, name) -> name.contains(searchTerm));
            if (files != null && files.length > 0) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No files found matching the search term.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}
