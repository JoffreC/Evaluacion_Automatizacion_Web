package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginTiendaPage {
    public static By title = By.xpath("//*[@id=\"main\"]/header/h1");
    public static By email = By.id("field-email");
    public static By password = By.id("field-password");
    public static By loginButton = By.id("submit-login");
}
