package Model;

public class Book implements Comparable<Book> {
    private String id;
    private String title;
    private String author;

    public Book(String id, String title, String author) {

        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return String.format("Book[ID=%s, Title=%s, Author=%s]", id,title,author);
    }

}
