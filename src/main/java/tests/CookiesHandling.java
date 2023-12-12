package tests;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.HashSet;
import java.util.Set;

public class CookiesHandling extends BaseTest {

    @Test(priority = 1)
    public void readAllCookies(){
        driver.get("https://keybooks.ro");
        //add cookie
        driver.manage().addCookie(new Cookie("My cookie","My cookie value"));

        //get all cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);

        //get cookie named
        Cookie cookie = driver.manage().getCookieNamed("PHPSESSID");
        System.out.println(cookie);

        //delete cookie
        driver.manage().deleteCookieNamed("PHPSESSID");
        driver.manage().deleteAllCookies();

    }
}
