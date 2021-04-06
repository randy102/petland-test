package pages;

import utils.Relenium;

public class BasePage {
    public Relenium r;
    final static public String PAGE_URL = System.getProperty("url");

    public BasePage(Relenium r){
        this.r = r;
    }

    public void to(String path){
        r.d.navigate().to(PAGE_URL + path);
    }
}
