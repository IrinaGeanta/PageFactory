package pages;

import org.openqa.selenium.WebDriver;
import utils.SeleniumWrappers;

public class BasePage extends SeleniumWrappers {

    public BasePage(WebDriver driver){
        super(driver);
    }

    public MenuPage menu = new MenuPage(driver);
    public MyAccountPage myAccount = new MyAccountPage(driver);
    public ProductDetailPage productDetail = new ProductDetailPage(driver);
    public CartPage cart = new CartPage(driver);
    public CheckoutPage checkout = new CheckoutPage(driver);
    public OrderReceivedPage orderReceived = new OrderReceivedPage(driver);
    public BakeryPage bakery = new BakeryPage(driver);
    public FruitsVegetablesPage fruitsVegetables = new FruitsVegetablesPage(driver);
    public BreakfastDiaryPage breakfastDiary = new BreakfastDiaryPage(driver);
    public BiscuitsSnacksPage biscuitsSnacks= new BiscuitsSnacksPage(driver);
    public BeveragePage beverage = new BeveragePage(driver);
    public WishlistPage wishlist = new WishlistPage(driver);
}
