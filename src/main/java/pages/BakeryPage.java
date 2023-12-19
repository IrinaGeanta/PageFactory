package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class BakeryPage extends SeleniumWrappers {

    public BakeryPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[title*='Valentine']")
    public WebElement pinkFrosted;

}
