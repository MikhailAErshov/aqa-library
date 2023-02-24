import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Newspaper;

import java.time.Instant;

public class NewspaperTest {

    @Test
    public void shouldNewspaper(){
        Instant instant = Instant.now();
        Newspaper newspaper = new Newspaper("Журнал", instant);
        Assertions.assertEquals(instant, newspaper.getDate());
    }
}
