package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumWrappers;

import java.time.Duration;

public class CartPage extends SeleniumWrappers {
    public CartPage(WebDriver driver){
        super(driver);
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

    @FindBy(id = "coupon_code")
    public WebElement discountField;

    @FindBy(name = "apply_coupon")
    public WebElement applyDiscountButton;

    @FindBy(css = "button[name='apply_coupon'][clicked='true']")
    public WebElement applyDiscountButtonAfterClick;

    @FindBy(xpath = "//div/span[contains(@class,\"Price-amount\")]/bdi")
    public WebElement initialPrice;

    @FindBy(linkText = "[Remove]")
    public WebElement removeDiscountLink;


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

    public Double checkDiscount(int discount) throws InterruptedException {

        click(discountField);
        sendKeys(discountField, "Discount" + discount);
        click(applyDiscountButton);

        //String a = initialPrice.getText(); // $15.00
        //a= a.substring(1); //          012345  --> 15.00
        Double initialAmount = Double.valueOf(initialPrice.getText().substring(1));
        //Double finalAmount = Double.valueOf(totalAmount.getText().substring(1));
        Double calculatedValue = initialAmount-(initialAmount * discount/100);
        System.out.println(calculatedValue);
        waitForElementToBeClickable(applyDiscountButton);
        //Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(applyDiscountButtonAfterClick));
        return calculatedValue;
    }
}
