package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class OrderReceivedPage extends SeleniumWrappers {
    public OrderReceivedPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "p[class*='order-received']")
    public WebElement confirmOrderText;

    @FindBy(xpath = "//li[contains(text(),'Order number:')]/strong")
    public WebElement orderNumber;
}
