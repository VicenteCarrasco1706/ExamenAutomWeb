package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginQLStorePage {
    private WebDriver driver;
    private WebDriverWait wait;
    public static By txtcorreo = By.xpath("//input[@id='field-email']");
    public static By txtpassword = By.xpath("//input[@id='field-password']");
    public static By btniniciosesion = By.xpath("//button[@id='submit-login']");

    public LoginQLStorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void ingresarCorreo(String user){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtcorreo));
        WebElement correo =driver.findElement(txtcorreo);
        correo.sendKeys(user);
    }

    public void ingresarPassword(String user){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtpassword));
        WebElement password =driver.findElement(txtpassword);
        password.sendKeys(user);
    }

    public void clickIniciarSesion(){
        wait.until(ExpectedConditions.elementToBeClickable(btniniciosesion));
        WebElement clickIniSesion =driver.findElement(btniniciosesion);
        clickIniSesion.click();
    }
}
