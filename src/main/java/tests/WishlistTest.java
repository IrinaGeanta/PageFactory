package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.Assert.*;

public class WishlistTest extends BaseTest {

    @DataProvider(name = "foodToAdd")
    public Object[][] loginTestData(){

        Object[][] data = new Object[4][2];

        data[0][0] = app.menu.fruitsAndVegetables;
        data[0][1] = app.fruitsVegetables.melons;

        data[1][0] = app.menu.breakfastAndDiary;
        data[1][1] = app.breakfastDiary.eggBites;

        data[2][0] = app.menu.biscuitsAndSnacks;
        data[2][1] = app.biscuitsSnacks.shimmerPastel;

        data[3][0] = app.menu.beverages;
        data[3][1] = app.beverage.zeviaKidsStrawberryLemonade;

        return data;
    }
    @Parameters({"user","pass"})
    @Test(priority = 1)
    public void login(String user, String pass){
        app.click(app.menu.myAccountLink);
        app.myAccount.loginInApp(user, pass);
        assertTrue(app.isDisplayed(app.myAccount.myAccountContent));
    }


    @Parameters
    @Test(priority = 2, dataProvider = "foodToAdd")
    public void addToWishlist(WebElement foodCategory, WebElement food){

        app.click(app.menu.allCategoriesMenu);
        app.click(foodCategory);
        app.click(food);
        app.click(app.productDetail.addToWishlist);

        app.click(app.productDetail.closeButtonOnWishlist);
    }
    @Test(priority = 3)
    public void checkWishlist(){
        app.click(app.menu.wishlistLink);

    }
}
