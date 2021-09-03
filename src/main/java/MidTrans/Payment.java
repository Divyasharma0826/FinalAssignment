package MidTrans;

import Predefined.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Payment extends MidTranBase{
    public Payment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='cardnumber']")
    WebElement CardNumber;
    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    WebElement ExpiryDate;
    @FindBy(xpath = "//input[@placeholder='123']")
    WebElement Cvv;
    @FindBy(xpath = "//div[@class='cart-checkout']")
    WebElement CheckoutButton;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement ContinueButton;
    @FindBy(xpath = "//a[@class='list with-promo']")
    WebElement CreditCardButton;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement PayNowButton;
    @FindBy(xpath = "//input[@type='password']")
    WebElement OTP;
    @FindBy(xpath = "//button[@name='cancel']")
    WebElement CancelButton;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SubmitButton;

    public void ClickOnCancelButton()
    {
        BuyNowButton.click();
        Methods.holdExecutionForSeconds(2);
        CheckoutButton.click();

        int size = driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().frame(0);
        Methods.holdExecutionForSeconds(2);
        ContinueButton.click();
        CreditCardButton.click();
        Methods.holdExecutionForSeconds(3);
        CardNumber.sendKeys(MidTranBase.properties.getProperty("cardNumber"));
        Methods.holdExecutionForSeconds(2);

        Methods.holdExecutionForSeconds(2);
        ExpiryDate.clear();
        ExpiryDate.sendKeys(MidTranBase.properties.getProperty("ExpiryDate"));
        Methods.holdExecutionForSeconds(2);

        Cvv.clear();
        Cvv.sendKeys(MidTranBase.properties.getProperty("Cvv"));
        Methods.holdExecutionForSeconds(2);
        PayNowButton.click();
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row page-header']")));
       // OTP.sendKeys("112233");
        Methods.holdExecutionForSeconds(2);
        CancelButton.click();
        Methods.holdExecutionForSeconds(3);
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-failed text-bold']")));

    }
    public void ClickOnOkButton()
    {
        BuyNowButton.click();
        Methods.holdExecutionForSeconds(2);
        CheckoutButton.click();

        int size = driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().frame(0);
        Methods.holdExecutionForSeconds(2);
        ContinueButton.click();
        CreditCardButton.click();
        Methods.holdExecutionForSeconds(3);
        CardNumber.sendKeys(MidTranBase.properties.getProperty("cardNumber"));
        Methods.holdExecutionForSeconds(2);

        Methods.holdExecutionForSeconds(2);
        ExpiryDate.clear();
        ExpiryDate.sendKeys(MidTranBase.properties.getProperty("ExpiryDate"));
        Methods.holdExecutionForSeconds(2);

        Cvv.clear();
        Cvv.sendKeys(MidTranBase.properties.getProperty("Cvv"));
        Methods.holdExecutionForSeconds(2);
        PayNowButton.click();
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row page-header']")));
        Methods.holdExecutionForSeconds(2);
        OTP.sendKeys(MidTranBase.properties.getProperty("ValidOtp"));
        Methods.holdExecutionForSeconds(2);
        SubmitButton.click();
        Methods.holdExecutionForSeconds(3);
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='trans-status trans-success']")));
        Assert.assertTrue(Methods.isDisplayedElement("//div[@class='trans-status trans-success']"));

    }

    public void ClickOnOkButtonWithWrongOtp()
    {
        BuyNowButton.click();
        Methods.holdExecutionForSeconds(2);
        CheckoutButton.click();

        int size = driver.findElements(By.tagName("iframe")).size();
       System.out.println(size);
        driver.switchTo().frame(0);
        Methods.holdExecutionForSeconds(2);
        ContinueButton.click();
        CreditCardButton.click();
        Methods.holdExecutionForSeconds(3);
        CardNumber.sendKeys(MidTranBase.properties.getProperty("cardNumber"));
        Methods.holdExecutionForSeconds(2);

        Methods.holdExecutionForSeconds(2);
        ExpiryDate.clear();
        ExpiryDate.sendKeys(MidTranBase.properties.getProperty("ExpiryDate"));
        Methods.holdExecutionForSeconds(2);

        Cvv.clear();
        Cvv.sendKeys(MidTranBase.properties.getProperty("Cvv"));
        Methods.holdExecutionForSeconds(2);
        PayNowButton.click();
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row page-header']")));
        Methods.holdExecutionForSeconds(2);
        OTP.sendKeys(MidTranBase.properties.getProperty("InvalidOtp"));
        Methods.holdExecutionForSeconds(2);
        SubmitButton.click();
        Methods.holdExecutionForSeconds(3);
        driver.switchTo().frame(0);
        Assert.assertTrue(Methods.isDisplayedElement("//div[@class='final-panel failed']//div[@class='text-failed text-bold']"));

    }
}

