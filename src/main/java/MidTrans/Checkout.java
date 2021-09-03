package MidTrans;

import Predefined.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Checkout extends  MidTranBase{
    public Checkout(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//td[@class='input-label'][normalize-space()='Name']")
    WebElement NameField;
    @FindBy(xpath = "//td[@class='input-label'][normalize-space()='Email']")
    WebElement EmailField;
    @FindBy(xpath = "//td[@class='input-label'][normalize-space()='Phone no']")
    WebElement phoneField;
    @FindBy(xpath = "//td[@class='input-label'][normalize-space()='City']")
    WebElement CityField;
    @FindBy(xpath = "//td[@class='input-label'][normalize-space()='Address']")
    WebElement AddressField;
    @FindBy(xpath = "//td[@class='input-label'][normalize-space()='Postal Code']")
    WebElement PostalCodeField;
    @FindBy(xpath = "//tr[@class='table-content']//input[@value='Budi']")
    WebElement NameInput;
    @FindBy(xpath = "//tr[@class='table-content']//input[@value='budi@utomo.com']")
    WebElement EmailInput;
    @FindBy(xpath = "//tr[@class='table-content']//input[@value='081808466410']")
    WebElement PhoneInput;
    @FindBy(xpath = "//tr[@class='table-content']//input[@value='Jakarta']")
    WebElement CityInput;
    @FindBy(xpath = "//tr[@class='table-content']//textarea")
    WebElement AddressInput;
    @FindBy(xpath = "//tr[@class='table-content']//input[@value='10220']")
    WebElement PostalCodeInput;

    @FindBy(xpath = "//p[text()='Order Summary']")
    WebElement OrderSummaryPopUp;


   public void CheckoutPopDetails()
   {
       BuyNowButton.click();
       NameInput.clear();
       NameInput.sendKeys(MidTranBase.properties.getProperty("Name"));
       EmailInput.clear();
       EmailInput.sendKeys(MidTranBase.properties.getProperty("email"));
       PhoneInput.clear();
       PhoneInput.sendKeys(MidTranBase.properties.getProperty("mobile"));
       CityInput.clear();
       CityInput.sendKeys(MidTranBase.properties.getProperty("city"));
       AddressInput.clear();
       AddressInput.sendKeys(MidTranBase.properties.getProperty("address"));
       PostalCodeInput.clear();
       PostalCodeInput.sendKeys(MidTranBase.properties.getProperty("postal"));

   }
   public void ClickingCheckOutButton()
   {
       BuyNowButton.click();
       Methods.holdExecutionForSeconds(2);
       CheckoutButton.click();

       int size = driver.findElements(By.tagName("iframe")).size();
       System.out.println(size);
       driver.switchTo().frame(0);

   }
    public void CheckoutPopUpElementsVisibility() {
        Methods.holdExecutionForSeconds(1);
        BuyNowButton.click();

    }



}
