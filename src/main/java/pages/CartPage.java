package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class CartPage extends SeleniumWrappers {
    public CartPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "td[class='product-remove']")
    public WebElement productRemove;

    @FindBy(css = "p[class*='cart-empty']")
    public WebElement cartEmptyMessage;

    @FindBy(className = "plus")
    public WebElement quantityPlusButton;

    @FindBy(css = "td[data-title='Total'] span[class*='amount']")
    public WebElement totalAmount;

    @FindBy(xpath = "//button[@name='update_cart']")
    public WebElement updateCartButton;

    @FindBy(linkText = "Proceed to checkout")
    public WebElement proceedToCheckout;


    public void emptyCart() {
            while(!isElementPresent(cartEmptyMessage)){
                waitForElementToBeClickable(productRemove);
                click(productRemove);
            }
    }

    public void updateCart() throws InterruptedException {
        while (updateCartButton.getAttribute("aria-disabled").equals("false")){
            Thread.sleep(1000);
        }
    }
}
