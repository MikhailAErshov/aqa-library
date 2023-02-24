import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.SearchOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchOperationsTest {

    @Test
    public void shouldGetBookByNameIsEmpty() {
        List<Book> books = new ArrayList<>();
        Optional<Book> book = SearchOperations.getBookByName("Книга1", books);
        Assertions.assertNull(book.orElse(null));
    }

    @Test
    public void shouldGetBookByNameAndAuthorIsEmpty() {
        List<Book> books = new ArrayList<>();
        Optional<Book> book = SearchOperations.getBookByNameAndAuthor("Книга1", "Автор1", books);
        Assertions.assertNull(book.orElse(null));
    }

    @Test
    public void shouldGetBookByName() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Название книги", "Автор книги"));
        Optional<Book> book = SearchOperations.getBookByName("Название книги", books);
        Assertions.assertNotNull(book.orElse(null));
    }

    @Test
    public void shouldGetBookByNameAndAuthor() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Название книги", "Автор книги"));
        Optional<Book> book = SearchOperations.getBookByNameAndAuthor("Название книги", "Автор книги", books);
        Assertions.assertNotNull(book.orElse(null));
    }
}
