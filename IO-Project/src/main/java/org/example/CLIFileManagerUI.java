package org.example;

import org.example.FileOperations;
import java.util.Scanner;

public class CLIFileManagerUI implements FileManagerUI {
    private final FileOperations fileOperations;

    public CLIFileManagerUI() {
        this.fileOperations = new FileOperations();
    }

    @Override
    public void start() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            handleChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("1. Display Directory Contents");
        System.out.println("2. Create File");
        System.out.println("3. Copy File");
        System.out.println("4. Move File");
        System.out.println("5. Delete File");
        System.out.println("6. Create Directory");
        System.out.println("7. Delete Directory");
        System.out.println("8. Search Files");
        System.out.println("9. Exit");
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Invalid input. Please enter a number.");
            return -1; // Handle invalid input appropriately
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                listContents();
                break;
            case 2:
                createFile();
                break;
            case 3:
                copyFile();
                break;
            case 4:
                moveFile();
                break;
            case 5:
                deleteFile();
                break;
            case 6:
                createDirectory();
                break;
            case 7:
                deleteDirectory();
                break;
            case 8:
                searchFiles();
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void listContents() {
        String directory = getDirectoryPath();
        fileOperations.listContents(directory);
    }

    private void createFile() {
        String filePath = getFilePath("Enter the file path to create: ");
        fileOperations.createFile(filePath);
    }
    private void copyFile() {
        String source = getFilePath("Enter the source file path: ");
        String destination = getFilePath("Enter the destination file path: ");
        fileOperations.copyFile(source, destination);
    }

    private void moveFile() {
        String source = getFilePath("Enter the source file path: ");
        String destination = getFilePath("Enter the destination file path: ");
        fileOperations.moveFile(source, destination);
    }

    private void deleteFile() {
        String filePath = getFilePath("Enter the file path to delete: ");
        fileOperations.deleteFile(filePath);
    }

    private void createDirectory() {
        String directoryPath = getDirectoryPath();
        fileOperations.createDirectory(directoryPath);
    }

    private void deleteDirectory() {
        String directoryPath = getDirectoryPath();
        fileOperations.deleteDirectory(directoryPath);
    }

    private void searchFiles() {
        String directory = getDirectoryPath();
        String searchTerm = getSearchTerm();
        fileOperations.searchFiles(directory, searchTerm);
    }

    private String getDirectoryPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path (e.g., C:\\Users\\YourUsername\\Documents): ");
        return scanner.nextLine();
    }

    private String getFilePath(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt + " (e.g., C:\\Users\\YourUsername\\Documents\\file.txt): ");
        return scanner.nextLine();
    }

    private String getSearchTerm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name or extension to search for (e.g., file.txt or *.txt): ");
        return scanner.nextLine();
    }
}