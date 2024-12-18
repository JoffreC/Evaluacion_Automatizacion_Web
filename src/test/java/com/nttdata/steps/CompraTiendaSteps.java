package com.nttdata.steps;

import com.nttdata.page.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CompraTiendaSteps {
    WebDriver driver;
    private static double precio;
    private static String producto;

    private WebDriverWait wait(WebDriver driver, Duration timeout) {
        return new WebDriverWait(driver, timeout);
    }

    public CompraTiendaSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void seleccionarCategoria(String categoria) {
        WebElement categoryUl = driver.findElement(TiendaPage.categoriesUl);
        List<WebElement> mainCategories = categoryUl.findElements(TiendaPage.categories);
        for (WebElement mainCategory : mainCategories) {
            String mainCategoryName = mainCategory.findElement(TiendaPage.categoryName).getText().trim();
            if (mainCategoryName.equalsIgnoreCase(categoria)) {
                mainCategory.click();
                WebDriverWait waitTime = wait(driver, Duration.ofSeconds(2));
                waitTime.until(ExpectedConditions.visibilityOfElementLocated(CategoryTiendaPage.categoryTitle));
                return;
            }
        }
        Assert.fail("La categoria " + categoria + " no existe.");
    }

    public void seleccionarSubcategoria(String subcategoria) {
        List<WebElement> subcategories = driver.findElements(CategoryTiendaPage.subcategory);
        for (WebElement subcategory : subcategories) {
            String subcategoryName = subcategory.findElement(CategoryTiendaPage.subcategoryName).getText().trim();
            if (subcategoryName.equalsIgnoreCase(subcategoria)) {
                subcategory.click();
                WebDriverWait waitTime = wait(driver, Duration.ofSeconds(2));
                waitTime.until(ExpectedConditions.visibilityOfElementLocated(SubcategoryTiendaPage.subcategoryTitle));
                return;
            }
        }
        Assert.fail("La subcategoria " + subcategoria + " no existe.");
    }

    public void seleccionarProducto(){
        WebElement firstProduct = driver.findElement(SubcategoryTiendaPage.firstProduct);
        firstProduct.click();
        WebDriverWait waitTime = wait(driver, Duration.ofSeconds(2));
        waitTime.until(ExpectedConditions.visibilityOfElementLocated(ProductTiendaPage.productTitle));
        WebElement product = driver.findElement(ProductTiendaPage.productTitle);
        this.producto = product.getText();
        WebElement precio = driver.findElement(ProductTiendaPage.precio);
        String price = precio.getAttribute("content");
        this.precio = Double.parseDouble(price);
    }


    public void subirUnidadesProducto(){
        WebElement masUnidadesButton = driver.findElement(ProductTiendaPage.masUnidadesButton);
        masUnidadesButton.click();
    }

    public void anadirCarrito(){
        WebElement anadirCarritoButton = driver.findElement(ProductTiendaPage.addToCartButton);
        anadirCarritoButton.click();
        WebDriverWait waitTime = wait(driver, Duration.ofSeconds(2));
        waitTime.until(ExpectedConditions.visibilityOfElementLocated(ProductTiendaPage.product));
    }

    public void validarProducto(){
        WebElement product = driver.findElement(ProductTiendaPage.product);
        String productName = product.getText();
        WebElement spanCantidad = driver.findElement(ProductTiendaPage.spanQuantity);
        WebElement cantidad = spanCantidad.findElement(ProductTiendaPage.quantity);
        if(productName.equalsIgnoreCase(this.producto) && Integer.parseInt(cantidad.getText().trim()) == 2 ){
            return;
        }
        Assert.fail("El producto a comprar no coincide con lo solicitado ");
    }

    public void validarPrecio(){
        precio *= 2;
        String precioTotal = "PEN"+ String.format("%.2f", precio);
        WebElement totalPrice = driver.findElement(ProductTiendaPage.totalPrice);

        if(precioTotal.equalsIgnoreCase(totalPrice.getText().trim())){
            return;
        }

        Assert.fail("El precio esta mal calculado " );
    }

    public void finalizarCompra(){
        WebElement btnFinalizar = driver.findElement(ProductTiendaPage.btnFinalizar);
        btnFinalizar.click();
        WebDriverWait waitTime = wait(driver, Duration.ofSeconds(2));
        waitTime.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartTiendaPage.title));
    }

    public void validoShoppingCart(){
        WebElement title = driver.findElement(ShoppingCartTiendaPage.title);
        if(title.getText().equalsIgnoreCase("SHOPPING CART")){
            return;
        }
        Assert.fail("El titulo del shopping cart no es valido");
    }

    public void validarPrecioCarrito(){
        WebElement precioCart = driver.findElement(ShoppingCartTiendaPage.price);
        String precioTotal = "PEN"+String.format("%.2f", precio);
        if(precioTotal.equalsIgnoreCase(precioCart.getText().trim())){
            return;
        }
        Assert.fail("El precio del shopping cart no es valido");
    }

//    public void seleccionarSubcategoriaMen() {
//        WebElement subcategory = driver.findElement(TiendaPage.subcategoryMen);
//        subcategory.click();
//        WebDriverWait waitTime = wait(driver, Duration.ofSeconds(2));
//        waitTime.until(ExpectedConditions.visibilityOfElementLocated(TiendaPage.clothesTitle));
//    }


}
