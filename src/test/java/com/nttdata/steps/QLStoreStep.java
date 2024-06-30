package com.nttdata.steps;

import com.nttdata.page.InicioQLStorePage;
import com.nttdata.page.LoginQLStorePage;
import com.nttdata.page.PrincipalQLStorePage;
import org.openqa.selenium.WebDriver;

public class QLStoreStep {
    WebDriver driver;
    InicioQLStorePage inicioQLStorePage;
    LoginQLStorePage loginQLStorePage;
    PrincipalQLStorePage principalQLStorePage;

    public QLStoreStep(WebDriver driver) {
        this.driver = driver;
        inicioQLStorePage = new InicioQLStorePage(driver);
        loginQLStorePage = new LoginQLStorePage(driver);
        principalQLStorePage = new PrincipalQLStorePage(driver);
    }
    public void navegarA(String url){
        driver.get(url);
    }

    public  void ingresarAlLogin(){
        inicioQLStorePage.clickAccederAlLogin();
    }
    public void iniciarSesion(String user, String password){
        loginQLStorePage.ingresarCorreo(user);
        loginQLStorePage.ingresarPassword(password);
        loginQLStorePage.clickIniciarSesion();
    }
    public void verificarAutenticacionLogin(){
        principalQLStorePage.verificarAutenticacion();
    }

    public void navegarAClothesYMen(){
        principalQLStorePage.navegarAChothes();
        principalQLStorePage.navegarAMen();
    }

    public void agregarPrimerProducto(String cant){
        principalQLStorePage.clickPrimerProducto();
        principalQLStorePage.agregarUnidadesAlCarrito(cant);
    }

    public void validacionDeCompraEnPopup(){
        principalQLStorePage.clickAnadirAlCarrito();
        principalQLStorePage.validacionDeProductoAgregado();
    }

    public void validacionDePrecioPopup(){
        principalQLStorePage.validadcionDePrecioPopup();
    }
    public void finalizarCompra(){
        principalQLStorePage.clickFinalizarCompra();
    }
    public void validarTituloCarrito(){
        principalQLStorePage.validacionTituloCarrito();
    }
    public void validacionPrecios(){
        principalQLStorePage.validadcionfinalDePrecio();
    }
}
