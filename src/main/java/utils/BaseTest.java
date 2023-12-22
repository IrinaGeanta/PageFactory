package utils;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BasePage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest extends Driver{
    public WebDriver driver;
    public BasePage app;
    @Parameters({"url", "browser"})
    @BeforeClass(alwaysRun = true)
    public void setup(String url, String browser){
        //driver = new ChromeDriver();
        driver = initBrowser(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        app = new BasePage(driver);
    }

    @AfterClass(alwaysRun = true)

    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        //driver.close(); // inchide tabu
        driver.quit(); // inchide browseru
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot poza = (TakesScreenshot) driver;
            File picture = poza.getScreenshotAs(OutputType.FILE);
            try{
                String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
                Files.copy(picture, new File("poze/"+result.getName()+"-"+timestamp+".png"));
                Log.info("Saved picture " + result.getName()+"-"+timestamp+".png");

            }catch (Exception e){
                Log.error("Could not save picture.");
                Log.error(e.getMessage());
            }
        }
    }
}
