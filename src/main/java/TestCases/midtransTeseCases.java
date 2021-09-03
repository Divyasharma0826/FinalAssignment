package TestCases;

import DriverSetup.Setup;
import MidTrans.*;
import Predefined.Methods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class midtransTeseCases {

    public WebDriver driver;
    MidTranBase midTranBase;
    Checkout Checkout;
    OrderSummary OrderSummary;
    Payment Payment;
    DebitClass DebitClass;
    PromoCode PromoCode;


    @BeforeClass
    public void tearUp() {
        driver = Setup.LaunchBrowser("chrome");
        midTranBase = new MidTranBase(driver);

        Checkout = new Checkout(driver);
        OrderSummary = new OrderSummary(driver);
        Payment = new Payment(driver);
        DebitClass = new DebitClass(driver);
        PromoCode = new PromoCode(driver);


    }

    @BeforeMethod
    public void startup() {
        driver.get(midTranBase.properties.getProperty("url"));
    }

    //
    @Test(priority = 1)
    public void MidTransPillow() {
        driver.get(MidTranBase.properties.getProperty("url"));
        midTranBase.BuyNowButtonFunction();
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//td[text()='Midtrans Pillow']"));
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//td[text()='20,000']"));
    }

    @Test(priority = 2)
    public void BuyNowRedirectToCheckoutPopUp() {
        midTranBase.BuyNowButtonFunction();
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//div[@class='cart-content buying']"));
        Methods.holdExecutionForSeconds(2);

    }
}