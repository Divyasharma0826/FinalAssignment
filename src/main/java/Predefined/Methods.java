package Predefined;

import DriverSetup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Methods extends Setup {
    public static boolean isDisplayedElement(String xpath){
        boolean flag =false;
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            if(element.isDisplayed())
            {
                flag=true;
            }
        }catch (NoSuchElementException e){
            flag = false;
        }
        return flag;
    }

    public static void holdExecutionForSeconds(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
