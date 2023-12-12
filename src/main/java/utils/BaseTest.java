package utils;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.BasePage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot poza = (TakesScreenshot) driver;
            File picture = poza.getScreenshotAs(OutputType.FILE);
            try{
                String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
                Files.copy(picture, new File("poze/"+result.getName()+"-"+timestamp+".png"));
                System.out.println("Saved picture " + result.getName()+"-"+timestamp+".png");

            }catch (Exception e){
                System.out.println("Could not save picture.");
                System.out.println(e.getMessage());
            }
        }
    }
}
