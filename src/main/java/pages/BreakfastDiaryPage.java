package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class BreakfastDiaryPage extends SeleniumWrappers {
    public BreakfastDiaryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar")
    public WebElement eggBites;
}
