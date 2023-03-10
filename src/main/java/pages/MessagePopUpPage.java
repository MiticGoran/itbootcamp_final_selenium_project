package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div/div[1]/ul/li")));
    }

    public String popUpText() {
        return driver.findElement(By.xpath("//div/div[1]/ul/li")).getText();
    }

    public void waitForPopUpSaved() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//div[contains(text(),'Saved successfully')]"))));
    }

    public String popUpSavedText() {
        return driver.findElement
                (By.xpath("//div[contains(text(),'Saved successfully')]")).getText();
    }
    public void waitForPopUpDeleted() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//div[contains(text(),'Deleted successfully')]"))));
    }

    public String popUpDeletedText() {
        return driver.findElement
                (By.xpath("//div[contains(text(),'Deleted successfully')]")).getText();
    }

    public void waitForPopUpSavedProfile() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//*[contains(text(),'Profile saved successfuly')]"))));
    }

    public String popUpSavedProfileText() {
        return driver.findElement
                (By.xpath("//*[contains(text(),'Profile saved successfuly')]")).getText();
    }

    public void waitForVerifyYourAccountPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("dlgVerifyAccount")));
    }

    public String verifyPopUpText() {
        return driver.findElement(By.className("dlgVerifyAccount")).getText();
    }

    public WebElement getCloseButtonVerifyPopUp() {
        return driver.findElement(By.xpath("//div/div/div[3]/button"));
    }

    public WebElement getCloseButton() {
        return driver.findElement(By.xpath("//div[1]/button"));
    }

}
