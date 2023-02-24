import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import ru.library.Book;
import ru.library.GenerateUtils;
import ru.library.Newspaper;

import java.util.ArrayList;
import java.util.List;

public class GeneraleUtilsTest {
    @Test
    public void shouldGenerateSomeBooks() {
        Assertions.assertNotNull(GenerateUtils.generateSomeBooks(1));
    }

    @Test
    public void shouldGenerateSomeNewsPapers() {
        Assertions.assertNotNull(GenerateUtils.generateSomeNewsPapers(1));
    }

    @Test
    public void shouldGenerateSomeBooksIsCountZero() {
        List<Book> books = GenerateUtils.generateSomeBooks(0);
        Assertions.assertEquals(books.size(), 0);
    }

    @Test
    public void shouldGenerateSomeNewsPaperssIsCountZero() {
        List<Newspaper> newspapers = GenerateUtils.generateSomeNewsPapers(0);
        Assertions.assertEquals(newspapers.size(), 0);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource (ints = {1,2,3,4,5})
    public void shouldGenerateSomeBooksIsSize(int number) {
        Assertions.assertEquals(GenerateUtils.generateSomeBooks(number).size(), number);

    }

    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource (ints = {11,21,300,404,505})
    public void shouldGenerateSomeNewsPapersIsSize(int number) {
        Assertions.assertEquals(GenerateUtils.generateSomeNewsPapers(number).size(), number);

    }


}
