package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.Assert.assertEquals;

public class DiscountTest extends BaseTest {

    @Test
    public void dicountTest() throws InterruptedException {
        app.click(app.menu.bakeryLink);

        app.click(app.bakery.pinkFrosted);

        app.click(app.productDetail.addToCartButton);

        app.click(app.productDetail.viewCart);

           // assertEquals(app.cart.checkDiscount(10), Double.valueOf(app.cart.totalAmount.getText().substring(1)));
            //app.click(app.cart.removeDiscountLink);


            for (int i = 1; i <5; i++) {
                while(!app.isElementPresent(app.cart.removeDiscountLink)){
                assertEquals(app.cart.checkDiscount(i * 10), Double.valueOf(app.cart.totalAmount.getText().substring(1)));
                app.click(app.cart.removeDiscountLink);
            }

        }
        /*
        assertEquals(app.cart.checkDiscount(20), Double.valueOf(app.cart.totalAmount.getText().substring(1)));
            app.click(app.cart.removeDiscountLink);
            assertEquals(app.cart.checkDiscount(30), Double.valueOf(app.cart.totalAmount.getText().substring(1)));
            app.click(app.cart.removeDiscountLink);
            assertEquals(app.cart.checkDiscount(40), Double.valueOf(app.cart.totalAmount.getText().substring(1)));

         */

    }
}
