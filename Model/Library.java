package Model;

import java.util.*;

public class Library {
    private TreeSet<Book> books = new TreeSet<>();
    private HashMap<String, String> borrowedBooks = new HashMap<>();
    private HashSet<User> users = new HashSet<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public boolean borrowedBook(String userId,String bookId){
        for(Book book:books){
            if(book.getId().equals(bookId) && !borrowedBooks.containsValue(bookId)){
                borrowedBooks.put(userId, bookId);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String userId){
        return borrowedBooks.remove(userId)!=null;
    }

    public TreeSet<Book> getAvailableBooks(){
        TreeSet<Book>availableBook = new TreeSet<>(books);
        borrowedBooks.values().forEach(bookId->availableBook.removeIf(b->b.getId().equals(bookId)));
        return availableBook;
    }

    public List<Book>searchBooks(String keyword){
        List<Book> result = new ArrayList<>();
        for(Book book:books){
            if(book.getTitle().toLowerCase().contains(keyword.toLowerCase())){
                result.add(book);
            }
        }
        return result;
    }

}
