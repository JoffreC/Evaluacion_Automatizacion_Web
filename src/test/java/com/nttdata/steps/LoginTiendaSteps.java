package com.nttdata.steps;

import com.nttdata.page.LoginTiendaPage;
import com.nttdata.page.TiendaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTiendaSteps {
    private WebDriver driver;

    private WebDriverWait wait(WebDriver driver, Duration timeout) {
        return new WebDriverWait(driver, timeout);
    };

    public LoginTiendaSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void irLogin(){
        WebElement userInfo = driver.findElement(TiendaPage.userInfo);
        userInfo.click();
        WebDriverWait waitTime = wait(driver, Duration.ofSeconds(5));
        waitTime.until(ExpectedConditions.visibilityOfElementLocated(LoginTiendaPage.title));
    }

    public void login(String username, String clave){
        WebElement email = driver.findElement(LoginTiendaPage.email);
        email.sendKeys(username);
        WebElement password = driver.findElement(LoginTiendaPage.password);
        password.sendKeys(clave);
        WebElement loginButton = driver.findElement(LoginTiendaPage.loginButton);
        loginButton.click();
        WebDriverWait waitTime = wait(driver, Duration.ofSeconds(5));
        waitTime.until(ExpectedConditions.visibilityOfElementLocated(TiendaPage.user));
    }
}
