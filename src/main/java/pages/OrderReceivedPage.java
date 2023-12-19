package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class OrderReceivedPage extends SeleniumWrappers {
    public OrderReceivedPage(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "p[class*='order-received']")
    public WebElement confirmOrderText;
}