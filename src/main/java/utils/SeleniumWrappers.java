package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import java.time.Duration;

public class SeleniumWrappers extends BaseTest{
    /**
     * Custom click method, that waits for element to visible before triggering a click from
     * Selenium
     * @param element --> WebElement to act on
     */
    public void click(WebElement element){
        Log.info("Called method <click> on element " + element.getAttribute("outerHTML"));
        try{
            waitForElementToBeVisible(element);
            element.click();
            Log.info("click() performed successfully!");
        }
        catch (StaleElementReferenceException e){
            Log.error("StaleElement occured on element " + element.getAttribute("outerHTML"));
            Log.info("attempting retry on click()");
            element.click();
            Log.info("click() performed successfully!");
        }
        catch (Exception e){
            Log.error("Error on method <click()> on element " + element.getAttribute("outerHTML"));
            Log.error(e.getMessage());
            throw new TestException(e.getMessage());
        }
    }

    public void sendKeys(WebElement element, String text){
        Log.info("called method <sendKeys()> on element " + element.getAttribute("outerHTML"));
        try {
            waitForElementToBeVisible(element);
            Log.info("called method <clear()> " + element.getAttribute("outerHTML"));
            element.clear();
            element.sendKeys(text);
            Log.info("<sendKeys()> performed successfully!");
        }catch(Exception e){
            Log.error("Error in method <sendKeys()> on element " + element.getAttribute("outerHTML"));
            Log.error(e.getMessage());
            throw new TestException(e.getMessage());
        }

    }

    public WebElement returnElement(By locator){
       // waitForElementToBeVisible(locator);
        return driver.findElement(locator);
    }

    public void waitForElementToBeVisible(WebElement element){
        try {
            Log.info("called <waitForElementToBeVisible()> on " + element.getAttribute("outerHTML"));
            Log.info("wait duration: 10 seconds with condition visibilityOf");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e){
            Log.error("Error in method <waitForElementToBeVisible()> on element " + element.getAttribute("outerHTML"));
            Log.error(e.getMessage());
            throw new TestException(e.getMessage());
        }
    }

    public void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isDisplayed(WebElement element){
        waitForElementToBeVisible(element);
        return element.isDisplayed();
    }

    public String getText(WebElement element){
        Log.info("Called method <getText()> on element " + element.getAttribute("outerHTML"));
        try {
            waitForElementToBeVisible(element);
            Log.info("<getText()> performed successfully!");
            return element.getText();
        }catch (Exception e){
            Log.error("Error in method <getText()> on element " + element.getAttribute("outerHTML"));
            Log.error(e.getMessage());
            throw new TestException(e.getMessage());
        }

    }

    public void hoverElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

    }

    public void dragAndDrop(WebElement element, int x, int y){
        Actions action = new Actions(driver);
       // action.dragAndDropBy(returnElement(locator),x,y).perform();
        action.moveToElement(element).clickAndHold().moveByOffset(x,y).release().perform();
    }

    public void scrollVertically(int pixels){
        Actions action = new Actions(driver);
        action.scrollByAmount(0,pixels).perform();
    }
    public void scrollHorizontally(int pixels){
        Actions action = new Actions(driver);
        action.scrollByAmount(pixels,0).perform();
    }
    public void jsScrollVertically(int pixels){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, " + pixels + ")");
    }


    public boolean isElementPresent(WebElement element){
        boolean isPresent = true;
        try{
            element.isDisplayed();
        }catch (NoSuchElementException e){
            isPresent = false;
        }
        return isPresent;
    }
}
