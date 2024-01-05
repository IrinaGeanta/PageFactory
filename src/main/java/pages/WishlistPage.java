package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class WishlistPage extends SeleniumWrappers {
    public WishlistPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    
}
