package com.nttdata.page;

import org.openqa.selenium.By;

public class CategoryTiendaPage {
    public static By categoryTitle = By.xpath("//*[@id=\"js-product-list-header\"]/div/h1");
    public static By subcategory = By.cssSelector("ul.category-sub-menu li[data-depth='0']");
    public static By subcategoryName = By.tagName("a");

}
