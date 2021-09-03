package MidTrans;

import Predefined.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary extends MidTranBase{
    public OrderSummary(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//td[@class='table-amount text-body']")
    WebElement Price;
    @FindBy(xpath = "//span[@class='item-name']")
    WebElement ProductName;
    @FindBy(xpath = "//div[text()='CHECKOUT']")
    WebElement CheckoutButton;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement ContinueButton;
    public void orderSummaryElement()
    {
    BuyNowButton.click();
    Methods.holdExecutionForSeconds(2);
    CheckoutButton.click();

    }
    public void ClickingOnContinueButton()
    {
        BuyNowButton.click();
        Methods.holdExecutionForSeconds(2);
        CheckoutButton.click();
        driver.switchTo().frame(0);
        Methods.holdExecutionForSeconds(2);
        ContinueButton.click();

    }
}
