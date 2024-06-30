package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrincipalQLStorePage {

    private WebDriver driver;
    private WebDriverWait wait;
    public static By titautnicacion = By.xpath("//a[@class='logout hidden-sm-down']");
    public static By btnclothes = By.xpath("//li[@id='category-3']//a[@class='dropdown-item']");
    public static By btnMen = By.xpath("//a[@class='subcategory-name'][normalize-space()='Men']");
    public static By productoUno = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[2]/section[1]/section[1]/div[3]/div[1]/div[1]/article[1]/div[1]/div[1]/a[1]/picture[1]/img[1]");
    public static By adicionarCarrito = By.xpath("//input[@id='quantity_wanted']");
    public static By btnCarrito = By.xpath("//button[@class='btn btn-primary add-to-cart']");
    public static By titValidadCompra = By.xpath("//h4[@id='myModalLabel']");
    public static By precioUnitariopopup = By.xpath("//p[@class='product-price']");
    public static By cantidadpopup = By.xpath("//strong[contains(text(),'2')]");
    public static By totalpopu = By.xpath("//body/div[@id='blockcart-modal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/p[4]/span[2]");
    public static By btnFinaCompra = By.xpath("//body/div[@id='blockcart-modal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]");
    public static By titCarrito = By.xpath("//h1[contains(text(),'Carrito')]");
    public static By precioUnitarioFinal = By.xpath("//span[@class='price']");
    public static By cantidadFinal = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]");
    public static By totalFinal = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");



    public PrincipalQLStorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void verificarAutenticacion(){
        try {
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(titautnicacion));
            if (logoutButton.isDisplayed()) {
                System.out.println("Autenticación validada exitosamente.");
            } else {
                System.out.println("Error en la autenticación.");
            }
        } catch (Exception e) {
            System.out.println("Error en la autenticación: " + e.getMessage());
        }
    }

    public void navegarAChothes(){
        wait.until(ExpectedConditions.elementToBeClickable(btnclothes));
        WebElement clothes = driver.findElement(btnclothes);
        clothes.click();
    }
    public void navegarAMen(){
        wait.until(ExpectedConditions.elementToBeClickable(btnMen));
        WebElement men = driver.findElement(btnMen);
        men.click();
    }
    public void clickPrimerProducto(){
        wait.until(ExpectedConditions.elementToBeClickable(productoUno));
        WebElement productouno = driver.findElement(productoUno);
        productouno.click();
    }
    public void agregarUnidadesAlCarrito(String cant){

        //Jean Karlo este método no funciona en este caso, automáticamente se colocaba 12, se tuvo que usar js para validar
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(adicionarCarrito));
        WebElement cantidad =driver.findElement(adicionarCarrito);
        cantidad.clear();
        cantidad.sendKeys(cant);*/

        wait.until(ExpectedConditions.visibilityOfElementLocated(adicionarCarrito));
        WebElement cantidad = driver.findElement(adicionarCarrito);
        cantidad.clear();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + cant + "';", cantidad);
        wait.until(ExpectedConditions.attributeToBe(cantidad, "value", cant));
        System.out.println("Unidades agregadas a carrito");
    }
    public void clickAnadirAlCarrito(){
        wait.until(ExpectedConditions.elementToBeClickable(btnCarrito));
        WebElement carrito = driver.findElement(btnCarrito);
        carrito.click();
    }
    public void validacionDeProductoAgregado(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(titValidadCompra));
        WebElement Validadcion = driver.findElement(titValidadCompra);
        Validadcion.getText();
        System.out.println(Validadcion.getText());
    }
    public void validadcionDePrecioPopup(){
        WebElement precioPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(precioUnitariopopup));
        double precio = Double.parseDouble(precioPopup.getText().replace("S/ ", ""));
        System.out.println(precio);
        WebElement cantidadPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(cantidadpopup));
        int cantidad = Integer.parseInt(cantidadPopup.getText());
        System.out.println(cantidad);
        WebElement totalPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(totalpopu));
        double total = Double.parseDouble(totalPopup.getText().replace("S/ ", ""));
        System.out.println(total);

        if (total == precio * cantidad) {
            System.out.println("El monto total en el popup es correcto.");
        } else {
            System.out.println("Error en el cálculo del monto total en el popup.");
        }
    }

    public void clickFinalizarCompra(){
        wait.until(ExpectedConditions.elementToBeClickable(btnFinaCompra));
        WebElement finCompra = driver.findElement(btnFinaCompra);
        finCompra.click();
        System.out.println("Compra Finalizada");
    }

    public void validacionTituloCarrito(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(titCarrito));
        WebElement titulo = driver.findElement(titCarrito);
        titulo.getText();
        System.out.println(titulo.getText());
    }

    public void validadcionfinalDePrecio(){
        WebElement precioFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(precioUnitarioFinal));
        double precio = Double.parseDouble(precioFinal.getText().replace("S/ ", ""));
        System.out.println(precio);

        WebElement cantFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(cantidadFinal));
        int cantidad = Integer.parseInt(cantFinal.getAttribute("value"));
        System.out.println(cantidad);

        WebElement totFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(totalFinal));
        double total = Double.parseDouble(totFinal.getText().replace("S/ ", ""));
        System.out.println(total);

        if (total == precio * cantidad) {
            System.out.println("El monto total final es el correcto.");
        } else {
            System.out.println("Error en el cálculo del monto total.");
        }

    }









}
