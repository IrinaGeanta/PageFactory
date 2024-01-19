package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

import java.util.List;

public class BlogPage extends SeleniumWrappers {
    public BlogPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

public int getNumberOfArticles(){
      List<WebElement> articles = driver.findElements(By.xpath("//div[@class='site-posts']/article" ));
      return articles.size();
}

public WebElement getArticle(int i){
        WebElement article = driver.findElement(By.xpath("(//div[@class='site-posts']/article)["+i+"]" ));
        return article;
}

}
