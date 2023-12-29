package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.Assert.*;

public class PlaceAnOrderTest extends BaseTest {
    @Parameters({"user","pass"})
    @Test (priority = 1)
    public void login(String user, String pass){
        app.click(app.menu.myAccountLink);
        app.myAccount.loginInApp(user, pass);
        assertTrue(app.isDisplayed(app.myAccount.myAccountContent));
    }

    @Parameters
    @Test(priority = 2)
    public void placeAnOrder() throws InterruptedException {
        app.click(app.menu.shoppingBag);
        app.cart.emptyCart();

        app.sendKeys(app.menu.searchField, "Pretzels");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        app.click(app.productDetail.addToCartButton);
        assertEquals(app.getText(app.productDetail.addToCartMessage).substring(10),"“Rold Gold Tiny Twists Pretzels” has been added to your cart.");

        app.click(app.menu.shoppingBag);
        String amount = app.cart.totalAmount.getText();
        Double amount2 = Double.parseDouble(amount.substring(1))*2;
        app.click(app.cart.quantityPlusButton);
        app.cart.updateCart();
        assertEquals(app.cart.totalAmount.getText().substring(1), amount2.toString());

        app.click(app.cart.proceedToCheckout);
        app.click(app.checkout.termsAndConditionsCheckbox);
        app.click(app.checkout.checkoutButton);

        assertEquals(app.orderReceived.confirmOrderText.getText(), "Thank you. Your order has been received.");
        assertFalse(app.orderReceived.orderNumber.getText().equals(null));

    }
}
