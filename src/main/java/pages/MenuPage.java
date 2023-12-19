package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers {

    public MenuPage(){
        PageFactory.initElements(driver,this);
    }
    //public By myAccountLink = By.linkText("My account");
    //driver.findElement(By.linkedText)
    @FindBy(linkText = "My account")
    public WebElement myAccountLink;

    @FindBy(css = "input[type='search']")
    public WebElement searchField;

    @FindBy(css = "i[class*='shopping-bag']")
    public WebElement shoppingBag;

    @FindBy(css = "span[class='cart-count-icon']")
    public WebElement cartItemNumber;

    @FindBy(linkText = "BAKERY")
    public WebElement bakeryLink;

}
