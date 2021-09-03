package MidTrans;

import Predefined.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DebitClass extends MidTranBase{
    public DebitClass(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement ContinueButton;

    @FindBy(xpath = "//input[@name='cardnumber']")
    WebElement CardNumber;
    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    WebElement ExpiryDate;
    @FindBy(xpath = "//input[@placeholder='123']")
    WebElement Cvv;
    @FindBy(xpath = "//div[@class='cart-checkout']")
    WebElement CheckoutButton;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement PayNowButton;
    @FindBy(xpath = "//input[@type='password']")
    WebElement OTP;
    @FindBy(xpath = "//button[@name='cancel']")
    WebElement CancelButton;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SubmitButton;




    public void SelectingCreditCardAsAPayment()
    {
     BuyNowButton.click();
     Methods.holdExecutionForSeconds(2);
     CheckoutButton.click();
     Methods.holdExecutionForSeconds(2);
     driver.switchTo().frame(0);
     ContinueButton.click();
     Methods.holdExecutionForSeconds(2);
     CreditCardButton.click();

     Methods.holdExecutionForSeconds(2);

    }
    public void EnteringCreditCardDetails()
    {
    BuyNowButton.click();
    Methods.holdExecutionForSeconds(2);
    CheckoutButton.click();
    Methods.holdExecutionForSeconds(2);
    driver.switchTo().frame(0);
    ContinueButton.click();
    Methods.holdExecutionForSeconds(2);
    CreditCardButton.click();
    Methods.holdExecutionForSeconds(2);
    CardNumber.sendKeys(MidTranBase.properties.getProperty("cardNumber"));
    Methods.holdExecutionForSeconds(2);
    ExpiryDate.sendKeys(MidTranBase.properties.getProperty("ExpiryDate"));
    Methods.holdExecutionForSeconds(2);
    Cvv.sendKeys(MidTranBase.properties.getProperty("Cvv"));
    Methods.holdExecutionForSeconds(1);
    PayNowButton.click();
    Methods.holdExecutionForSeconds(3);
    }

    public void CheckingPayNowButtonWorking()
    {
        EnteringCreditCardDetails();
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row page-header']")));

    }
}
