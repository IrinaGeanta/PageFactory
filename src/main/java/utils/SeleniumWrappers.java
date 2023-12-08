package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWrappers extends BaseTest{

    public void click(WebElement element){
        try{
            //WebElement element = driver.findElement(locator);
            waitForElementToBeVisible(element);
            element.click();
        }
        catch (StaleElementReferenceException e){
            element.click();
        }
    }

    public void sendKeys(WebElement element, String text){
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public WebElement returnElement(By locator){
       // waitForElementToBeVisible(locator);
        return driver.findElement(locator);
    }

    public void waitForElementToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isDisplayed(By locator){
        //waitForElementToBeVisible(locator);
        return returnElement(locator).isDisplayed();
    }

    public String getText(By locator){
       // waitForElementToBeVisible(locator);
        return returnElement(locator).getText();
    }

    public void hoverElement(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(returnElement(locator)).perform();

    }

    public void dragAndDrop(By locator, int x, int y){
        Actions action = new Actions(driver);
       // action.dragAndDropBy(returnElement(locator),x,y).perform();
        action.moveToElement(returnElement(locator)).clickAndHold().moveByOffset(x,y).release().perform();
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


    public boolean isElementPresent(By locator){
        boolean isPresent = true;
        try{
            driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            isPresent = false;
        }
        return isPresent;
    }
}
