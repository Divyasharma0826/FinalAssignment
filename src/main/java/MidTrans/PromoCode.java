package MidTrans;

import Predefined.Methods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PromoCode extends MidTranBase{
    public PromoCode(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement ContinueButton;
    @FindBy(xpath = "//label[text()='Potongan 10 Rupiah']//input[@type='checkbox']")
    WebElement FirstOption;
    @FindBy(xpath = "//span[@class='text-amount-amount']")
    WebElement AmountAfterTenRupees;
    @FindBy(xpath = "//label[text()='Potongan 10% - Demo Promo Engine']//input[@type='checkbox']")
    WebElement  SecondOption;
    @FindBy(xpath = "//label[text()='Promo Demo MasterCard']//input[@type='checkbox']")
    WebElement ThirdOption;


    public void PromoCodeAmount()
   {
       String ExpectedAfterTenRupee ="19,990";
       String ExpectedAfterTenPercent="18,000";
       String ExpectedAfterThousand ="19,000";
        BuyNowButton.click();
        Methods.holdExecutionForSeconds(2);
        CheckoutButton.click();
        Methods.holdExecutionForSeconds(2);
        driver.switchTo().frame(0);
        ContinueButton.click();
        Methods.holdExecutionForSeconds(2);
        CreditCardButton.click();
        Methods.holdExecutionForSeconds(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,1000)");
        FirstOption.click();

        Assert.assertEquals(AmountAfterTenRupees.getText(),ExpectedAfterTenRupee);
        Methods.holdExecutionForSeconds(2);
        SecondOption.click();
        Methods.holdExecutionForSeconds(2);
        Assert.assertEquals(AmountAfterTenRupees.getText(),ExpectedAfterTenPercent);
        ThirdOption.click();
        Methods.holdExecutionForSeconds(2);
        Assert.assertEquals(AmountAfterTenRupees.getText(),ExpectedAfterThousand);

    }
}
