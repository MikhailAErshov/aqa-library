import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    final Book book = new Book("bookName", "bookAuthor");
    @Test
    public void shouldSetCategory() {
        book.setCategory(new Category("categoryName"));
        assertNotNull(book.getCategory());
    }

    @Test
    public void shouldSetCategoryIsNull(){
        Category category = new Category(null);
        book.setCategory(category);
        assertNull(book.getCategory());
    }

    @Test
    public void shouldGetNameAndGetAutor(){
        assertEquals("bookName", book.getName());
        assertEquals("bookAuthor", book.getAuthor());
    }
}
