package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class ProductDetailPage extends SeleniumWrappers {
    public ProductDetailPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "button[name='add-to-cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement addToCartMessage;

    @FindBy(xpath = "(//a[text()='View cart'])[2]")
    public WebElement viewCart;

    @FindBy(xpath = "(//span[contains(@class,'add_to_wishlist')])[2]")
    public WebElement addToWishlist;

    @FindBy(xpath = "//button[contains(text(),'Close')]")
    public WebElement closeButtonOnWishlist;

}
