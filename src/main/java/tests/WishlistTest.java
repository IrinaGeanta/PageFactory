package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class WishlistTest extends BaseTest {

    public List<String> productsName = new ArrayList<String>();

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
        app.scrollVertically(200);
        app.click(app.productDetail.addToWishlist);
        app.click(app.productDetail.closeButtonOnWishlist);

    }
    @Test(priority = 3)
    public void checkWishlist(){
        app.click(app.menu.wishlistLink);
        List<WebElement> productsInWishlist = app.wishlist.getProductsInWishlistTable();
        productsName.add("Shimmer Pastel Almond Blend");
        productsName.add("Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar");
        productsName.add("Fresh Produce Melons Each");
        productsName.add("Zevia Kidz Strawberry Lemonade Zero Calorie Soda");
        System.out.println("productname " + productsName);
        for (int i = 0; i< productsInWishlist.size(); i++){
            //System.out.println(productsInWishlist.get(i).getText());
            assertTrue(productsName.contains(productsInWishlist.get(i).getText()));
            if(productsInWishlist.get(i).getText().equalsIgnoreCase("Zevia Kidz Strawberry Lemonade Zero Calorie Soda")){
                assertTrue(app.wishlist.getProductAction(i).getText().equalsIgnoreCase("Buy Product"));
            } else {
                assertTrue(app.wishlist.getProductAction(i).getText().equalsIgnoreCase("Add Cart"));
            }
        }
    }

    @Test(priority = 4)
    public void addToCart(){
        app.click(app.wishlist.selectAllCheckbox);
        app.wishlist.selectByValue("add_selected");
        app.click(app.wishlist.applyActionButton);

        assertTrue(app.wishlist.message.getText().equalsIgnoreCase("Product “Zevia Kidz Strawberry Lemonade Zero Calorie Soda” could not be added to cart because some requirements are not met."));
        assertEquals(app.menu.cartItemNumber.getText(),"3");

        app.click(app.menu.shoppingBag);
        app.cart.emptyCart();

    }
}
