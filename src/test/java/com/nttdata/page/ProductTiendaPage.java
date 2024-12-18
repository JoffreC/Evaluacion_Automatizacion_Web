package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductTiendaPage {
    public static By productTitle = By.xpath("//*[@id=\"main\"]/div[1]/div[2]/h1");
    public static By precio = By.cssSelector("span.current-price-value");
    public static By masUnidadesButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]");
    public static By addToCartButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By product = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/h6");
    public static By spanQuantity = By.cssSelector("span.product-quantity");
    public static By quantity = By.tagName("strong");
    public static By totalPrice = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By btnFinalizar = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
}
