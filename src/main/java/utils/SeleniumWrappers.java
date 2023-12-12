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
        System.out.println("Called method <click> on element " + element.getAttribute("outerHTML"));
        try{
            waitForElementToBeVisible(element);
            element.click();
        }
        catch (StaleElementReferenceException e){
            System.out.println("StaleElement occured on element " + element.getAttribute("outerHTML"));
            element.click();
        }
        catch (Exception e){
            System.out.println("Error on element " + element.getAttribute("outerHTML"));
            throw new TestException(e.getMessage());
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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e){
            System.out.println("Element not found in method <waitForElementToBeVisible>" + element.getAttribute("outerHTML"));
        }
    }

    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isDisplayed(WebElement element){
        waitForElementToBeVisible(element);
        return element.isDisplayed();
    }

    public String getText(WebElement element){
        waitForElementToBeVisible(element);
        return element.getText();
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
