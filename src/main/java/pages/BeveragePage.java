package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class BeveragePage extends SeleniumWrappers {
    public BeveragePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Zevia Kidz Strawberry Lemonade Zero Calorie Soda")
    public WebElement zeviaKidsStrawberryLemonade;
}
