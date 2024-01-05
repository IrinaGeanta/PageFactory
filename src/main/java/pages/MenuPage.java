package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers {

    public MenuPage(WebDriver driver){
        super(driver);
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

    @FindBy(xpath = "//span[contains(text(),'CATEGORIES')]")
    public WebElement allCategoriesMenu;

    @FindBy(linkText = "Fruits & Vegetables")
    public WebElement fruitsAndVegetables;

    @FindBy(linkText = "Breakfast & Dairy")
    public WebElement breakfastAndDiary;

    @FindBy(linkText = "Biscuits & Snacks")
    public WebElement biscuitsAndSnacks;

    @FindBy(linkText = "Beverages")
    public WebElement beverages;

    @FindBy(linkText = "Wishlist")
    public WebElement wishlistLink;

}
