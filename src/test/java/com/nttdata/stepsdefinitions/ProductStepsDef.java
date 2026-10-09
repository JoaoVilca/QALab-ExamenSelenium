package com.nttdata.stepsdefinitions;

import com.nttdata.steps.AssercionsSteps;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.ProductSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import org.junit.jupiter.api.Assertions;

import java.util.Locale;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProductStepsDef {

    private WebDriver driver;
    private ProductSteps productSteps;
    public ProductStepsDef(){
    }

    private AssercionsSteps assercionsSteps(WebDriver driver){
        return new AssercionsSteps(driver);
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        // Write code here that turns the phrase above into concrete actions
        driver = getDriver();

        this.productSteps = new ProductSteps(this.driver);

        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        //ProductSteps productSteps = new ProductSteps(driver);
        productSteps.ingresoUserPassword(user, password);
        screenShot();
        // Write code here that turns the phrase above into concrete actions
    }

    @And("valido que el logeo fue exitoso")
    public void validoQueElLogeoFueExitoso() {
        int item =  assercionsSteps(driver).getUserExist();
        Assertions.assertEquals(1, item);
        screenShot();
        // Write code here that turns the phrase above into concrete actions
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        productSteps.navegarCatSub();
        String itemText =  assercionsSteps(driver).getSubcatText();
        Assertions.assertEquals(subcategoria.toUpperCase(), itemText.toUpperCase());
        screenShot();
        // Write code here that turns the phrase above into concrete actions
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
        productSteps.agregarItemCarrito();
        screenShot();
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        String confirmPopUp = assercionsSteps(driver).getConfirmAdd();
        String textConfirm = "Hay 2 artículos en su carrito.";
        Assertions.assertEquals(textConfirm,confirmPopUp);
        screenShot();
        // Write code here that turns the phrase above into concrete actions
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        boolean confirmPopUp = assercionsSteps(driver).validarTotalCarrito();
        Assertions.assertTrue(confirmPopUp);
        screenShot();
        // Write code here that turns the phrase above into concrete actions
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        productSteps.finalizarCompra();
        screenShot();
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String tituloCarrito = assercionsSteps(driver).tituloCarrito();
        String textTituloCarrito = "CARRITO";
        Assertions.assertEquals(textTituloCarrito,tituloCarrito);
        screenShot();
        // Write code here that turns the phrase above into concrete actions
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        boolean confirmPopUp = assercionsSteps(driver).validarTotalFinal();
        Assertions.assertTrue(confirmPopUp);
        screenShot();
        productSteps.finalizarCompraTotal();
        screenShot();
        // Write code here that turns the phrase above into concrete actions
    }
}
