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
        DebitClass =new DebitClass(driver);
        PromoCode =new PromoCode(driver);


    }
    @BeforeMethod
    public void startup()
    {
        driver.get(midTranBase.properties.getProperty("url"));
    }
//


    @Test(priority = 10)
    public void PromoCodeAmountCheck()
    {
        PromoCode.PromoCodeAmount();
    }
    @Test(priority = 2)
    public void BuyNowRedirectToCheckoutPopUp() {
        midTranBase.BuyNowButtonFunction();
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//div[@class='cart-content buying']"));
        Methods.holdExecutionForSeconds(2);

    }

    @Test(priority = 4)
    public void FillingDetails() {

        driver.get(MidTranBase.properties.getProperty("url"));
        Checkout.CheckoutPopDetails();
        Methods.holdExecutionForSeconds(3);

    }
    //
    @Test(priority = 5)
    public void CheckOutButton() {
        Checkout.ClickingCheckOutButton();
        Methods.holdExecutionForSeconds(2);
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//p[text()='Order Summary']"));
        Methods.holdExecutionForSeconds(2);
    }
    //
    @Test(priority = 6)
    public void OrderSummaryProductDetail() {
        driver.get(MidTranBase.properties.getProperty("url"));
        Methods.holdExecutionForSeconds(2);
        OrderSummary.orderSummaryElement();
        Methods.holdExecutionForSeconds(2);
        driver.switchTo().frame(0);
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//td[@class='table-amount text-body']"));
        Assert.assertTrue(Methods.isDisplayedElement("//span[@class='item-name']"));
    }
    //
    @Test(priority = 7)
    public void ContinueButton() {
        driver.get(MidTranBase.properties.getProperty("url"));
        OrderSummary.ClickingOnContinueButton();
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//p[@class='text-page-title-content']"));
    }

    @Test(priority = 9)
    public void CheckingSelectingPaymentOptionRedirectToCardDetailScreen()
    {
        DebitClass.SelectingCreditCardAsAPayment();
        Assert.assertTrue(Methods.isDisplayedElement("//input[@name='cardnumber']"));
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//input[@placeholder='MM / YY']"));
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//input[@placeholder='123']"));
    }
    //
    @Test(priority = 7)
    public void paymentOptionsAvailable() {
        {
            midTranBase.BuyNowButtonFunction();
            Methods.holdExecutionForSeconds(2);
            driver.findElement(By.xpath("//div[@class='cart-checkout']")).click();
            Methods.holdExecutionForSeconds(2);
            driver.switchTo().frame(0);
            driver.findElement(By.xpath("//a[@class='button-main-content']")).click();


            List<WebElement> options = driver.findElements(By.xpath("//div[@class='content-list']"));
            //System.out.println(options.size());
            List actualDropDownValues = new ArrayList();
            for (WebElement e2 : options) {
                actualDropDownValues.add(e2.getTagName());
                System.out.println(e2.getText());

            }


            List expectedOptions = new ArrayList();
            expectedOptions.add("Credit/Debit Card");
            expectedOptions.add("ATM/Bank Transfer");
            expectedOptions.add("GoPay/other e-Wallets");
            expectedOptions.add("ShopeePay/other e-Wallets");
            expectedOptions.add("KlikBCA");
            expectedOptions.add("BCA KlikPay");
            expectedOptions.add("OCTO Clicks");
            expectedOptions.add("Danamon Online Banking");
            expectedOptions.add("e-Pay BRI");
            expectedOptions.add("LINE Pay e-cash | mandiri e-cash");
            expectedOptions.add("Telkomsel Cash");
            expectedOptions.add("Indomaret");
            expectedOptions.add("Alfa Group");
            expectedOptions.add("Akulaku");

            for (int i = 0; i < expectedOptions.size(); i++) {

                //System.out.println("Actual: \n" + actualDropDownValues.get(i));
                System.out.println(" & Expected: \n" + expectedOptions.get(i));
                // Assert.assertTrue(actualDropDownValues.get(i).equals(expectedOptions.get(i)));

            }
        }
    }


    @Test(priority = 1)
    public void MidTransPillow() {
        driver.get(MidTranBase.properties.getProperty("url"));
        midTranBase.BuyNowButtonFunction();
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//td[text()='Midtrans Pillow']"));
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//td[text()='20,000']"));
    }
    @Test(priority = 11)
    public void EnteringCardDetails()
    {
        // DebitClass.SelectingCreditCardAsAPayment();
        DebitClass.EnteringCreditCardDetails();
    }

    @Test(priority = 12)
    public void ActionAfterClickingOnPayNowButton()
    {
        DebitClass.CheckingPayNowButtonWorking();
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//label[text()='Merchant Name:']"));
        Methods.holdExecutionForSeconds(2);
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//label[text()='Amount:']"));
        Methods.holdExecutionForSeconds(2);
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//label[text()='Transaction Time:']"));
        Methods.holdExecutionForSeconds(2);
        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//label[text()='Card Number:']"));
        Methods.holdExecutionForSeconds(2);
    }

    @Test(priority = 8)
    public void FetchingLinksOfPayment()
    {
        // driver.get(midTranBase.properties.getProperty("url"));
        driver.findElement(By.xpath("//a[@class='btn buy']")).click();
        Methods.holdExecutionForSeconds(2);
        driver.findElement(By.xpath("//div[@class='cart-checkout']")).click();

        int size = driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().frame(0);
        Methods.holdExecutionForSeconds(2);
        driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
        Methods.holdExecutionForSeconds(2);
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println(allLinks.size());

        //Traversing through the list and printing its text along with link address
        for(WebElement link:allLinks){
            System.out.println(link.getText());
        }
    }
    @Test(priority = 15)
    public void ClickOnCancelButton()
    {
        driver.get(midTranBase.properties.getProperty("url"));
        Payment.ClickOnCancelButton();

        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//div[@class='text-failed text-bold']"));
        Methods.holdExecutionForSeconds(2);

    }
    @Test(priority = 14)
    public  void clickOkWithRightOtp()
    {
        driver.get(midTranBase.properties.getProperty("url"));

        Payment.ClickOnOkButton();

        WebDriverWait wait = new WebDriverWait(driver, 30);

        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//div[@class='trans-status trans-success']"));
        Methods.holdExecutionForSeconds(2);

    }
    @Test(priority = 13)
    public void ClickOkButtonWrongPasskey()
    {
        driver.get(MidTranBase.properties.getProperty("url"));
        Payment.ClickOnOkButtonWithWrongOtp();

        Methods.holdExecutionForSeconds(2);
        Assert.assertTrue(Methods.isDisplayedElement("//div[@class='final-panel failed']//div[@class='text-failed text-bold']"));
        Methods.holdExecutionForSeconds(2);
    }
    @Test(priority = 8)
    public void VisibilityOfCheckoutPopUp()
    {
        driver.get(MidTranBase.properties.getProperty("url"));
        Checkout.CheckoutPopUpElementsVisibility();
        Assert.assertTrue(Methods.isDisplayedElement("//td[@class='input-label'][normalize-space()='Name']"));
        Methods.holdExecutionForSeconds(1);
        Assert.assertTrue(Methods.isDisplayedElement("//td[@class='input-label'][normalize-space()='Email']"));
        Methods.holdExecutionForSeconds(1);
        Assert.assertTrue(Methods.isDisplayedElement("//td[@class='input-label'][normalize-space()='Phone no']"));
        Methods.holdExecutionForSeconds(1);
        Assert.assertTrue(Methods.isDisplayedElement("//td[@class='input-label'][normalize-space()='City']"));
        Methods.holdExecutionForSeconds(1);
        Assert.assertTrue(Methods.isDisplayedElement("//td[@class='input-label'][normalize-space()='Address']"));
        Methods.holdExecutionForSeconds(1);
        Assert.assertTrue(Methods.isDisplayedElement("//td[@class='input-label'][normalize-space()='Postal Code']"));
        Methods.holdExecutionForSeconds(1);
    }

}


