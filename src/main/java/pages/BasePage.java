package pages;

import utils.SeleniumWrappers;

public class BasePage extends SeleniumWrappers {

    public MenuPage menu = new MenuPage();
    public MyAccountPage myAccount = new MyAccountPage();
    public ProductDetailPage productDetail = new ProductDetailPage();
    public CartPage cart = new CartPage();
    public CheckoutPage checkout = new CheckoutPage();
    public OrderReceivedPage orderReceived = new OrderReceivedPage();
    public BakeryPage bakery = new BakeryPage();
}
