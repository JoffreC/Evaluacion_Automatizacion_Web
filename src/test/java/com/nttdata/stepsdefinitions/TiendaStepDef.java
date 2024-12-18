package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CompraTiendaSteps;
import com.nttdata.steps.LoginTiendaSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class TiendaStepDef {

    private WebDriver driver;

    private CompraTiendaSteps compraTiendaSteps(WebDriver driver) {
        return new CompraTiendaSteps(driver);
    }

    @Given("esoy en la pagina de la tienda")
    public void esoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        LoginTiendaSteps loginTiendaSteps = new LoginTiendaSteps(driver);
        loginTiendaSteps.irLogin();
        loginTiendaSteps.login(usuario, clave);
        screenShot();
    }


    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        compraTiendaSteps(driver).seleccionarCategoria(categoria);
        compraTiendaSteps(driver).seleccionarSubcategoria(subcategoria);
        screenShot();
    }

    @And("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String unidades) {
        compraTiendaSteps(driver).seleccionarProducto();
        compraTiendaSteps(driver).subirUnidadesProducto();
        compraTiendaSteps(driver).anadirCarrito();
        screenShot();
    }

    @Then("valido en el popup la confirmacion del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        compraTiendaSteps(driver).validarProducto();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        compraTiendaSteps(driver).validarPrecio();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        compraTiendaSteps(driver).finalizarCompra();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        compraTiendaSteps(driver).validoShoppingCart();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        compraTiendaSteps(driver).validarPrecioCarrito();
    }
}
