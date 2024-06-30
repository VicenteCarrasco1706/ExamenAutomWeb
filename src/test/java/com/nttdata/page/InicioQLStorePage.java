package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InicioQLStorePage {

    private WebDriver driver;
    private WebDriverWait wait;
    public static By btnIniciarSesion = By.xpath("//span[contains(text(),'Iniciar sesión')]");

    public InicioQLStorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickAccederAlLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(btnIniciarSesion));
        WebElement clickAcceder =driver.findElement(btnIniciarSesion);
        clickAcceder.click();
    }
}
