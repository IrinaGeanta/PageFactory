package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class CheckoutPage extends SeleniumWrappers {

    public CheckoutPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "place_order")
    public WebElement checkoutButton;

    @FindBy(id = "terms")
    public WebElement termsAndConditionsCheckbox;
}
