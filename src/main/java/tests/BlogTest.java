package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BlogTest extends BaseTest {
    @Test
    public void blog(){
        app.click(app.menu.blogLink);
        assertEquals(app.blog.getNumberOfArticles(),4);
        for(int i = 1; i <= app.blog.getNumberOfArticles(); i++){
            app.click(app.blog.getArticle(i));
            app.sendKeys(app.blogDetail.commentText,"Great article!" + Math.random());
            app.sendKeys(app.blogDetail.email,"irina@irina.com");
            app.sendKeys(app.blogDetail.name,"Irina");
            app.click(app.blogDetail.postCommentButton);

            assertTrue(app.isDisplayed(app.blogDetail.getNameUrlLinkPostComment("Irina")));

            assertTrue(app.isDisplayed(app.blogDetail.messageAfterComment));

            app.click(app.menu.blogLink);
        }

    }
}
