package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

public class PlaceAnOrderTest extends BaseTest {
    @Parameters
    @Test
    public void placeAnOrder(){
        app.sendKeys(app.menu.searchField, "Pretzels");
    }
}
