package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class FruitsVegetablesPage extends SeleniumWrappers {
    public FruitsVegetablesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Fresh Produce Melons Each")
    public WebElement melons;
}
