package Controller;

import java.util.List;
import java.util.TreeSet;

import Model.*;

public class LibraryController {
    private Library library;

    public LibraryController() {
        this.library = new Library();
    }

    public void addBook(String id, String title, String author) {
        library.addBook(new Book(id, title, author));
    }

    public void registerUser(String userId, String name) {
        library.registerUser(new User(userId, name));
    }

    public boolean borrowBook(String userId, String bookId) {
        return library.borrowedBook(userId, bookId);
    }

    public boolean returnBook(String userId){
        return library.returnBook(userId);
    }
    public TreeSet<Book>getAvailableBooks(){
        return library.getAvailableBooks();
    }
    public List <Book> searchBook(String keyword){
        return library.searchBooks(keyword);
    }
}
