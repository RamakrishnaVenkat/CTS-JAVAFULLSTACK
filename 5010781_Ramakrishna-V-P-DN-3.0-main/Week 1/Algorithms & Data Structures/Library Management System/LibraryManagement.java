// LibraryManagement.java
import java.util.ArrayList;
import java.util.Collections;

public class LibraryManagement {
    private ArrayList<Book> books;

    public LibraryManagement() {
        books = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to perform linear search by title
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Method to perform binary search by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        Collections.sort(books);
        int left = 0;
        int right = books.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int comparison = midBook.getTitle().compareToIgnoreCase(title);
            
            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(4, "Moby-Dick", "Herman Melville"));
        
        System.out.println("Linear Search for '1984':");
        Book book1 = library.linearSearchByTitle("1984");
        System.out.println(book1 != null ? book1 : "Book not found.");

        System.out.println("\nBinary Search for '1984':");
        Book book2 = library.binarySearchByTitle("1984");
        System.out.println(book2 != null ? book2 : "Book not found.");
    }
}
