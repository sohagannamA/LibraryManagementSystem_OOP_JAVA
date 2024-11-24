package View;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import Controller.LibraryController;
import Model.Book;

public class LibraryView {
    private LibraryController controller;
    private Scanner scanner;

    public LibraryView() {
        this.controller = new LibraryController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Available Books");
            System.out.println("6. Search Books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> registerUser();
                case 3 -> borrowBook();
                case 4 -> returnBook();
                case 5 -> listAvailableBooks();
                case 6 -> searchBooks();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }

    }

    private void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();
        controller.addBook(id, title, author);
        System.out.println("Book added successfully!");
    }

    private void registerUser() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter User Name: ");
        String name = scanner.nextLine();
        controller.registerUser(userId, name);
        System.out.println("User registered successfully!");
    }

    private void borrowBook() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        if (controller.borrowBook(userId, bookId)) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Borrowing failed! Book might not be available.");
        }
    }

    private void returnBook() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        if (controller.returnBook(userId)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Return failed! No borrowed book found.");
        }
    }

    private void listAvailableBooks() {
        TreeSet<Book> books = controller.getAvailableBooks();
        System.out.println("\n--- Available Books ---");
        books.forEach(System.out::println);
    }

    private void searchBooks() {
        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine();
        List<Book> results = controller.searchBook(keyword);
        System.out.println("\n--- Search Results ---");
        results.forEach(System.out::println);
    }
}
