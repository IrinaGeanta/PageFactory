package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumWrappers;

import java.util.ArrayList;
import java.util.List;

public class WishlistPage extends SeleniumWrappers {
    public WishlistPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//th/input[@title='Select all for bulk action']")
    public WebElement selectAllCheckbox;

    @FindBy(xpath = "//select[@name='product_actions']")
    public WebElement actionDropDown;

    @FindBy(xpath = "//button[@title='Apply Action']")
    public WebElement applyActionButton;

    @FindBy(xpath = "//ul[@role='alert']/li")
    public WebElement message;
/*
    @FindBy(xpath = "//tr[@class='wishlist_item']")
    public WebElement wishlistItem;
*/
    public void selectByValue(String value){
    Select select = new Select(actionDropDown);
    select.selectByValue(value);
}

    public List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='wishlist_item']"));
    public List<WebElement> getProductsInWishlistTable(){

        List<WebElement> wishlistItems = new ArrayList<WebElement>();
        for(int i = 1; i<= rows.size(); i++){
            WebElement wishlistProduct = driver.findElement(By.xpath("(" + "//tr[@class='wishlist_item']" + ")" + "["+i+"]"+"/td[@class='product-name']"));
            wishlistItems.add(wishlistProduct);
            System.out.println("wishlist: " + wishlistProduct.getText());
        }
       // System.out.println("wishlist: " + wishlistItems);
        return wishlistItems;
    }

    public WebElement getProductAction(int row){
        WebElement productAction = driver.findElement(By.xpath("(" + "//tr[@class='wishlist_item']" + ")" + "["+row+"]"+ "/td[@class='product-action']/button/span"));
        return  productAction;
    }

}
