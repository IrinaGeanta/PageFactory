package tests;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Parameters({"user","pass"})
    @Test
    public void validLogin(String user, String pass){
        app.click(app.menu.myAccountLink);
        app.myAccount.loginInApp(user, pass);
        assertTrue(app.isDisplayed(app.myAccount.myAccountContent));
        app.click(app.myAccount.logoutButton);
        assertTrue(app.isDisplayed(app.myAccount.usernameField));
    }
}
