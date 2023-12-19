package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class FindBrokenLinks extends BaseTest {
    List<String> brokenURLs = new ArrayList<String>();
    @Test
    public void testBrokenLinks(){
        List<WebElement> links = driver.findElements(By.cssSelector("a[href*='http']"));
        System.out.println(links.size());
        for (int i=0;i<links.size();i++){
            WebElement element = links.get(i);
            String url = element.getAttribute("href");

            checkLinks(url);
        }
        assertTrue(brokenURLs.size()==0);

    }

    public void checkLinks(String linkUrl){

        try{
            URL url = new URL(linkUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setConnectTimeout(3000);
            httpUrlConn.connect();

            if(httpUrlConn.getResponseCode() == 200){
                System.out.println(linkUrl + " --> " + httpUrlConn.getResponseCode());
            }
            if (httpUrlConn.getResponseCode() == 404){
                System.out.println(linkUrl + " --> " + httpUrlConn.getResponseCode());
                brokenURLs.add(linkUrl);
            }

        }catch (Exception e){


        }
    }
}
