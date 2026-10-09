package com.nttdata.steps;

import com.nttdata.page.InventoryPage;
import com.nttdata.page.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AssercionsSteps {
    private WebDriver driver;

    public AssercionsSteps(WebDriver driver){
        this.driver = driver;
    }

    public int getUserExist(){
        List<WebElement> item = this.driver.findElements(ProductPage.userAccount);
        return item.size();
    }

    public String getSubcatText(){
        return this.driver.findElement(ProductPage.menTitle).getText();
    }

    public int getAmountValue(){
        return Integer.parseInt(this.driver.findElement(ProductPage.amountItem).getAttribute("value"));
    }

    public String getConfirmAdd(){
        return this.driver.findElement(ProductPage.amountPopupCart).getText();
    }

    /**
     * Validar total del popup: comparando precioUnitario * cantidad = totalCarrito
     */
    public boolean validarTotalCarrito(){
        double precio = Double.parseDouble(this.driver.findElement(ProductPage.preciounitario).getText().split("PEN")[0].replace(",", "."));
        double cantidad = Double.parseDouble(this.driver.findElement(ProductPage.amountItemPopup).getText());

        double total = Double.parseDouble(this.driver.findElement(ProductPage.totalCarrito).getText().split("PEN")[0].replace(",", "."));

        double totalCart = precio * cantidad;
        boolean validado = false;

        if (total == totalCart){
            validado = true;
        }
        return validado;
    }

    /**
     * Validacion de titulo del carrito luego de pasar el popup
     */
    public String tituloCarrito(){
        return this.driver.findElement(ProductPage.tituloCarrito).getText();
    }

    /**
     * Validar total: comparando precioUnitario * cantidad = totalCarrito
     */
    public boolean validarTotalFinal(){
        double precio = Double.parseDouble(this.driver.findElement(ProductPage.precioUnCart).getText().split("PEN")[0].replace(",", "."));
        double cantidad = Double.parseDouble(this.driver.findElement(ProductPage.amountFinal).getAttribute("value"));

        System.out.println(">>> TEXTO CAPTURADO: [" + precio + "]");

        System.out.println(">>> TEXTO CAPTURADO: [" + cantidad + "]");

        double total = Double.parseDouble(this.driver.findElement(ProductPage.precioFinal).getText().split("PEN")[0].replace(",", "."));

        System.out.println(">>> TEXTO CAPTURADO: [" + total + "]");

        double totalCart = precio * cantidad;
        boolean validado = false;

        if (total == totalCart){
            validado = true;
        }
        return validado;
    }
}
