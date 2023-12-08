package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.BasePage;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public BasePage app;
    @Parameters({"url"})
    @BeforeClass(alwaysRun = true)
    public void setup(String url){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        app = new BasePage();
    }

    @AfterClass(alwaysRun = true)

    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        //driver.close(); // inchide tabu
        driver.quit(); // inchide browseru
    }
}
