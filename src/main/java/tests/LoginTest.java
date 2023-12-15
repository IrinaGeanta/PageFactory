package tests;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.TestNgListener;

import static org.testng.Assert.assertTrue;
//@Listeners(TestNgListener.class)
public class LoginTest extends BaseTest {

    @Parameters({"user","pass"})
    @Test(priority = 1)
    public void validLogin(String user, String pass){
        app.click(app.menu.myAccountLink);
        app.myAccount.loginInApp(user, pass);
        assertTrue(app.isDisplayed(app.myAccount.myAccountContent));
        app.click(app.myAccount.logoutButton);
        assertTrue(app.isDisplayed(app.myAccount.usernameField));
    }

    @Test(priority = 2)
    public void invalidLogin(){
        app.click(app.menu.myAccountLink);
        app.myAccount.loginInApp("blabla", "blabla");
        assertTrue(app.isDisplayed(app.myAccount.myAccountContent));
        app.click(app.myAccount.logoutButton);
        assertTrue(app.isDisplayed(app.myAccount.usernameField));
    }
}
