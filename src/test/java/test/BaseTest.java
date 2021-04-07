package test;


import org.testng.annotations.AfterClass;
import utils.Relenium;



public abstract class BaseTest {
    public Relenium r;

    public void setup(){
        r = new Relenium();
    }

    @AfterClass
    public void tearDown(){
        r.quit();
    }
}
