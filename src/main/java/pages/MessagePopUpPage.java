package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
    }
    public void waitForVerifyYourAccountPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgVerifyAccount")));
    }
    public String verifyPopUpText(){
        return driver.findElement(By.className("dlgVerifyAccount")).getText();
    }
    public String popUpText(){
        return driver.findElement(By.className("v-snack__content")).getText();
    }
    public WebElement closeButtonVerifyPopUp(){
        return driver.findElement(By.xpath("//div/div/div[3]/button"));
    }
    public WebElement CloseButton(){
        return driver.findElement(By.xpath("//div[1]/button"));
    }

}
