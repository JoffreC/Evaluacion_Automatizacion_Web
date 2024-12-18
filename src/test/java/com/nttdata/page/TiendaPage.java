package com.nttdata.page;

import org.openqa.selenium.By;

public class TiendaPage {
    public static By userInfo = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a");
    public static By user = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span");
    public static By categoriesUl = By.cssSelector("ul.top-menu[data-depth='0']");
    public static By categories = By.cssSelector("li.category");
    public static By categoryName = By.cssSelector("a.dropdown-item");
}
