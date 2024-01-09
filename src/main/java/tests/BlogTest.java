package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.Assert.assertEquals;

public class BlogTest extends BaseTest {
    @Test
    public void blog(){
        app.click(app.menu.blogLink);
        assertEquals(app.blog.articleItems().size(),4);
        for(WebElement element : app.blog.articleItems()){
            app.click(element);
            app.sendKeys(app.blogDetail.commentText,"Great article!" + Math.random());
            app.sendKeys(app.blogDetail.email,"irina@irina.com");
            app.sendKeys(app.blogDetail.name,"Irina");
            app.click(app.blogDetail.postCommentButton);

        }

    }
}
