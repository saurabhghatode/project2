  import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isBorrowed;

    // Constructor to initialize book details
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false; // By default, the book is available
    }

    // Method to borrow a book
    public void borrowBook() {
        if (isBorrowed) {
            System.out.println("Oops! \"" + title + "\" is already borrowed.");
        } else {
            isBorrowed = true;
            System.out.println("Enjoy reading \"" + title + "\"!");
        }
    }

    // Method to return a book
    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Thank you for returning \"" + title + "\"!");
        } else {
            System.out.println("\"" + title + "\" wasn't borrowed.");
        }
    }

    // Method to display book info
    public void displayInfo() {
        String status = isBorrowed ? "Borrowed" : "Available";
        System.out.println("Title: " + title + " | Author: " + author + " | Status: " + status);
    }
}

public class libraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>(); // A collection to store books
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("Welcome to the Library Management System!");

        while (keepRunning) {
            System.out.println("\nHere’s what you can do:");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // To consume the leftover newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    library.add(new Book(title, author)); // Add the book to the library
                    System.out.println("Great! \"" + title + "\" by " + author + " has been added.");
                    break;

                case 2:
                    if (library.isEmpty()) {
                        System.out.println("The library is currently empty. Add some books first!");
                    } else {
                        System.out.println("Here are the books in the library:");
                        for (Book book : library) {
                            book.displayInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Which book would you like to borrow? Enter the title: ");
                    String borrowTitle = scanner.nextLine();
                    boolean foundBorrow = false;

                    for (Book book : library) {
                        if (book.title.equalsIgnoreCase(borrowTitle)) {
                            book.borrowBook();
                            foundBorrow = true;
                            break;
                        }
                    }

                    if (!foundBorrow) {
                        System.out.println("Sorry, no book with the title \"" + borrowTitle + "\" was found.");
                    }
                    break;

                case 4:
                    System.out.print("Which book are you returning? Enter the title: ");
                    String returnTitle = scanner.nextLine();
                    boolean foundReturn = false;

                    for (Book book : library) {
                        if (book.title.equalsIgnoreCase(returnTitle)) {
                            book.returnBook();
                            foundReturn = true;
                            break;
                        }
                    }

                    if (!foundReturn) {
                        System.out.println("Hmm, couldn't find any book titled \"" + returnTitle + "\" in the library.");
                    }
                    break;

                case 5:
                    System.out.println("Goodbye! Thanks for using the Library Management System.");
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }

        scanner.close(); // Closing the scanner to prevent resource leaks
    }
}