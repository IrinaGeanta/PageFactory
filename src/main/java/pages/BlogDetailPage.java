package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class BlogDetailPage extends SeleniumWrappers {
    public BlogDetailPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//textarea[@id='comment']")
    public WebElement commentText;

    @FindBy(xpath = "//input[@id='author']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='submit']")
    public WebElement postCommentButton;

    public WebElement getNameUrlLinkPostComment(String name){
        WebElement nameAfterComment = driver.findElement(By.xpath("//a[text()='" + name + "']"));
        return nameAfterComment;
    }
}
