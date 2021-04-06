package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import utils.Relenium;
import utils.TestListener;

@Listeners({TestListener.class})
public class BaseTest {
    public Relenium r;

    public BaseTest(){
        r = new Relenium();
    }

    @AfterClass
    public void tearDown(){
        r.quit();
    }
}
