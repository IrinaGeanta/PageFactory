package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class BiscuitsSnacksPage extends SeleniumWrappers {

    public BiscuitsSnacksPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Shimmer Pastel Almond Blend")
    public WebElement shimmerPastel;
}
