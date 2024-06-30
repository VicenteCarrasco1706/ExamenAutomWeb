package com.nttdata.stepsdefinitions;

import com.nttdata.steps.QLStoreStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QLStoreSD {
    private WebDriver driver;
    private QLStoreStep qlStoreStep;
    private Scenario scenario;
    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }
    @After
    public void quitDriver(){
        driver.quit();
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        qlStoreStep = new QLStoreStep(driver);
        qlStoreStep.navegarA("https://qalab.bensg.com/store/pe/");
        qlStoreStep.ingresarAlLogin();
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String arg0, String arg1) {
        qlStoreStep.iniciarSesion(arg0, arg1);
        qlStoreStep.verificarAutenticacionLogin();
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String arg0, String arg1) {
        qlStoreStep.navegarAClothesYMen();
        screenShot();
    }

    @And("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String arg0) {
        qlStoreStep.agregarPrimerProducto(arg0);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        qlStoreStep.validacionDeCompraEnPopup();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        qlStoreStep.validacionDePrecioPopup();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        qlStoreStep.finalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        qlStoreStep.validarTituloCarrito();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        qlStoreStep.validacionPrecios();
        screenShot();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
}
