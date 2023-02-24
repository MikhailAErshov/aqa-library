import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;
import ru.library.Newspaper;
import ru.library.SortOperations;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SortOperationsTest {

    SortOperations sortOperations = new SortOperations();

//    @Test
//    void shouldGetBooksCategoriesIsNewsPapers() {
//        List<Book> books = new ArrayList<>();
//        Book book = new Newspaper("Название книги", Instant.now());
//        Assertions.assertFalse(sortOperations.checkIfBookHasCategory(book));
//    }


    @Test
    void getBooksByCategory() {
        List<Book> books = new ArrayList<>();
        Book book = new Newspaper("Название книги", Instant.now());
        books.add(book);
        Set<Category> categories = SortOperations.getBooksCategories(books);
        Assertions.assertNotNull(categories);
        Assertions.assertEquals(categories.size(), 0);
        books.add(new Book("Название книги2", "Автор книги2"));
        Book book1 = new Book("Название книги3", "Автор книги3");
        book1.setCategory(new Category("Категория1"));
        books.add(book1);
        categories = SortOperations.getBooksCategories(books);
        Assertions.assertEquals(categories.size(), 1);
        String nameCategory = categories.stream().findFirst().orElse(new Category("")).getName();
        Assertions.assertEquals(nameCategory, "Категория1");
    }

    @Test
    void getBooksByCategoryTest() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book("Название книги1", "Автор книги1");
        Category category1 = new Category("Категория1");
        book1.setCategory(category1);
        books.add(book1);

        Book book2 = new Book("Название книги2", "Автор книги2");
        Category category2 = new Category("Категория2");
        book2.setCategory(category2);
        books.add(book2);

        List<Book> booksByCategory = SortOperations.getBooksByCategory(books, category1);

        assert booksByCategory != null;
//        Assertions.assertNotNull(booksByCategory.get(0));

        Assertions.assertEquals(booksByCategory.get(0).getName(), book1.getName());
        Assertions.assertEquals(booksByCategory.get(0).getCategory(), book1.getCategory());

        Assertions.assertNull(SortOperations.getBooksByCategory(books, new Category("")));

    }


    @Test
    void sortNewspapersByDate() throws InterruptedException {
        Newspaper newspaper1 = new Newspaper("Газета1", Instant.now());
        Thread.sleep(2000);
        Newspaper newspaper2 = new Newspaper("Газета2", Instant.now());
        Thread.sleep(2000);
        Newspaper newspaper3 = new Newspaper("Газета3", Instant.now());
        List<Newspaper> newspaperList = new ArrayList<>();
        newspaperList.add(newspaper3);
        newspaperList.add(newspaper2);
        newspaperList.add(newspaper1);
        Assertions.assertEquals(newspaperList.get(0).getName(), "Газета3");

        SortOperations.sortNewspapersByDate(newspaperList);

        Assertions.assertEquals(newspaperList.get(0).getName(), "Газета1");

    }
}