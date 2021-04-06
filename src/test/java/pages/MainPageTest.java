package pages;

import com.google.common.truth.Truth;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import utils.Relenium;

import static com.google.common.truth.Truth.*;
import static java.lang.System.getProperty;

public class MainPageTest {
    private Relenium s;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        String url = getProperty("url");
        s = new Relenium(url);
    }

    @Test
    public void testTitle() {
        String currentTitle = s.d.getTitle();
        Truth.assertThat(currentTitle).isEqualTo("Tiki");
    }

    @Test
    public void testFail(){
        Truth.assertThat(1).isEqualTo(2);
    }
}
