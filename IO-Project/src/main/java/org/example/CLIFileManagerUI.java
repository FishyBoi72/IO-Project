package org.example;

import org.example.FileOperations;
import java.util.Scanner;

public class CLIFileManagerUI implements FileManagerUI { // Declares the CLIFileManagerUI class that implements the FileManagerUI interface.
    private final FileOperations fileOperations; // Declares a private final variable for handling file operations.

    public CLIFileManagerUI() { // Constructor for CLIFileManagerUI.
        this.fileOperations = new FileOperations(); // Initializes fileOperations with a new instance of FileOperations.
    }

    @Override
    public void start() { // Overrides the start method from the FileManagerUI interface.
        while (true) { // Starts an infinite loop to keep the UI running.
            displayMenu(); // Calls the method to display the menu options.
            int choice = getUserChoice(); // Gets the user's choice from the menu.
            handleChoice(choice); // Handles the user's choice with the appropriate method.
        }
    }

    private void displayMenu() { // Method to display the menu options to the user.
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

    private int getUserChoice() { // Method to get the user's choice from the menu.
        Scanner scanner = new Scanner(System.in); // Creates a new Scanner object for reading input.
        System.out.print("Enter your choice: "); // Prompts the user to enter their choice.
        if (scanner.hasNextInt()) { // Checks if the next input is an integer.
            return scanner.nextInt(); // Returns the integer input by the user.
        } else {
            System.out.println("Invalid input. Please enter a number."); // Informs the user of invalid input.
            return -1; // Returns -1 to indicate an invalid choice.
        }
    }

    private void handleChoice(int choice) { // Method to handle the user's choice based on the menu option selected.
        switch (choice) { // Switch statement to execute the appropriate method based on the user's choice.
            case 1:
                listContents(); // Calls method to list directory contents.
                break;
            case 2:
                createFile(); // Calls method to create a file.
                break;
            case 3:
                copyFile(); // Calls method to copy a file.
                break;
            case 4:
                moveFile(); // Calls method to move a file.
                break;
            case 5:
                deleteFile(); // Calls method to delete a file.
                break;
            case 6:
                createDirectory(); // Calls method to create a directory.
                break;
            case 7:
                deleteDirectory(); // Calls method to delete a directory.
                break;
            case 8:
                searchFiles(); // Calls method to search for files.
                break;
            case 9:
                System.exit(0); // Exits the application.
                break;
            default:
                System.out.println("Invalid choice. Please try again."); // Informs the user of an invalid choice.
        }
    }

    private void listContents() { // Method to list the contents of a directory.
        String directory = getDirectoryPath(); // Gets the directory path from the user.
        fileOperations.listContents(directory); // Calls the listContents method from FileOperations with the provided directory.
    }

    private void createFile() { // Method to create a file.
        String filePath = getFilePath("Enter the file path to create: "); // Gets the file path from the user.
        fileOperations.createFile(filePath); // Calls the createFile method from FileOperations with the provided file path.
    }

    private void copyFile() { // Method to copy a file.
        String source = getFilePath("Enter the source file path: "); // Gets the source file path from the user.
        String destination = getFilePath("Enter the destination file path: "); // Gets the destination file path from the user.
        fileOperations.copyFile(source, destination); // Calls the copyFile method from FileOperations with the provided paths.
    }

    private void moveFile() { // Method to move a file.
        String source = getFilePath("Enter the source file path: "); // Gets the source file path from the user.
        String destination = getFilePath("Enter the destination file path: "); // Gets the destination file path from the user.
        fileOperations.moveFile(source, destination); // Calls the moveFile method from FileOperations with the provided paths.
    }

    private void deleteFile() { // Method to delete a file.
        String filePath = getFilePath("Enter the file path to delete: "); // Gets the file path from the user.
        fileOperations.deleteFile(filePath); // Calls the deleteFile method from FileOperations with the provided file path.
    }

    private void createDirectory() { // Method to create a directory.
        String directoryPath = getDirectoryPath(); // Gets the directory path from the user.
        fileOperations.createDirectory(directoryPath); // Calls the createDirectory method from FileOperations with the provided path.
    }

    private void deleteDirectory() { // Method to delete a directory.
        String directoryPath = getDirectoryPath(); // Gets the directory path from the user.
        fileOperations.deleteDirectory(directoryPath); // Calls the deleteDirectory method from FileOperations with the provided path.
    }

    private void searchFiles() { // Method to search for files in a directory.
        String directory = getDirectoryPath(); // Gets the directory path from the user.
        String searchTerm = getSearchTerm(); // Gets the search term from the user.
        fileOperations.searchFiles(directory, searchTerm); // Calls the searchFiles method from FileOperations with the provided directory and search term.
    }

    private String getDirectoryPath() { // Method to get a directory path from the user.
        Scanner scanner = new Scanner(System.in); // Creates a new Scanner object for reading input.
        System.out.print("Enter the directory path (e.g., C:\\Users\\YourUsername\\Documents): "); // Prompts the user to enter a directory path.
        return scanner.nextLine(); // Returns the inputted directory path.
    }

    private String getFilePath(String prompt) { // Method to get a file path from the user.
        Scanner scanner = new Scanner(System.in); // Creates a new Scanner object for reading input.
        System.out.print(prompt + " (e.g., C:\\Users\\YourUsername\\Documents\\file.txt): "); // Prompts the user to enter a file path with a custom message.
        return scanner.nextLine(); // Returns the inputted file path.
    }

    private String getSearchTerm() { // Method to get a search term from the user.
        Scanner scanner = new Scanner(System.in); // Creates a new Scanner object for reading input.
        System.out.print("Enter the file name or extension to search for (e.g., file.txt or *.txt): "); // Prompts the user to enter a search term.
        return scanner.nextLine(); // Returns the inputted search term.
    }
}
