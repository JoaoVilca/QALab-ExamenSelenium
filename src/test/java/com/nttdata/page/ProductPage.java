package com.nttdata.page;

import com.nttdata.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    //Login de usuario
    public static By loginButton = By.className("user-info");
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By submitButton = By.id("submit-login");
    public static By logoutButton = By.className("logout");
    public static By pageWrapper = By.id("wrapper");
    public static By userAccount = By.className("account");

    //Navegar a categoria
    public static By clothesButton = By.id("category-3");
    public static By menButton = By.xpath("(//a[@href='https://qalab.bensg.com/store/es/4-men'])[2]");
    public static By menTitle = By.xpath("//h1[@class='h1']");

    //Agregar productos al carrito
    public static By productPoloMen = By.xpath("//div[@class='thumbnail-top']");
    public static By addToCart = By.className("add-to-cart");
    public static By addAmount = By.className("bootstrap-touchspin-up");
    public static By amountItem = By.id("quantity_wanted");
    public static By modalDialog = By.xpath("(//div[@class='modal-dialog'])[2]");
    public static By amountPopupCart = By.xpath("//p[@class='cart-products-count']");

    //Validar total
    public static By amountItemPopup = By.xpath("//span[@class='product-quantity']/strong");
    public static By preciounitario = By.xpath("//p[@class='product-price']");
    public static By totalCarrito = By.xpath("(//span[@class='value'])[1]");

    //Finalizar compra
    public static By finalizarButtonCarrito = By.xpath("(//a[@class='btn btn-primary'])[2]");
    public static By finalizarButton = By.xpath("(//a[@class='btn btn-primary'])[1]");

    //Ultimas validaciones
    public static By tituloCarrito = By.xpath("//div/h1[@class='h1']");
    public static By precioUnCart = By.xpath("//span[@class='price']");
    public static By precioFinal = By.xpath("(//span[@class='value'])[5]");
    public static By amountFinal = By.xpath("//input[@class='js-cart-line-product-quantity form-control']");
}
