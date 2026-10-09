package com.nttdata.steps;

import static com.nttdata.core.DriverManager.esperaImplicita;
import com.nttdata.core.DriverManager;
import com.nttdata.page.InventoryPage;
import com.nttdata.page.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.*;

public class ProductSteps {
    private WebDriver driver;
    public ProductSteps(WebDriver driver){
        this.driver = driver;
    }

    private AssercionsSteps assercionsSteps(WebDriver driver){
        return new AssercionsSteps(driver);
    }

    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(ProductPage.userInput);
        userInputElement.sendKeys(user);
        //this.driver.findElement(ProductPage.passInput).sendKeys(user);
    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(ProductPage.passInput).sendKeys(password);
    }

    public void login(){
        this.driver.findElement(ProductPage.submitButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        //Espera explicita
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.pageWrapper));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.userAccount));
    }

    public void clicIniciarSesion(){
        this.driver.findElement(ProductPage.loginButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        //Espera explicita
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.submitButton));
    }

    public void ingresoUserPassword(String user, String password) {
        clicIniciarSesion();
        typeUser(user);
        typePassword(password);
        esperaImplicita();
        login();
        esperaImplicita();
    }

    ///Navegar hasta la subcategoria MEN -----------------------------------------------------

    public void navegarCatSub(){
        this.driver.findElement(ProductPage.clothesButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        //Espera explicita
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.menButton));
        this.driver.findElement(ProductPage.menButton).click();
    }

    ///Añadir 2 items al carrito------------------------------------------------------------

    public void accederItem(){
        this.driver.findElement(ProductPage.productPoloMen).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        //Espera explicita
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.addToCart));
    }

    public void agregarCantidadItem(){
        this.driver.findElement(ProductPage.addAmount).click();
        int amountItem =  assercionsSteps(driver).getAmountValue();
        Assertions.assertEquals(2, amountItem);
        esperaImplicita();
    }

    public void clicAddCarrito(){
        this.driver.findElement(ProductPage.addToCart).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        //Espera explicita
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.modalDialog));
    }

    public void agregarItemCarrito(){
        accederItem();
        agregarCantidadItem();
        clicAddCarrito();
    }

    ///Finalizar compra del carrito

    public void finalizarCompraCarrito(){
        this.driver.findElement(ProductPage.finalizarButtonCarrito).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        //Espera explicita
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.finalizarButton));
    }
    public void finalizarCompraTotal(){
        this.driver.findElement(ProductPage.finalizarButton).click();
    }
    public void finalizarCompra(){
        finalizarCompraCarrito();
        //finalizarCompraTotal();
    }
}
