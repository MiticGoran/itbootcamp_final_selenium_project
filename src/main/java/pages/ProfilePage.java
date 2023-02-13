package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForMyProfilePage() {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[1]/h1")));
    }
    public WebElement getEmailInput() {
        return driver.findElement(By.id("email"));
    }
    public WebElement getNameInput() {
        return driver.findElement(By.id("name"));
    }
    public WebElement getPhoneInput() {
        return driver.findElement(By.id("phone"));
    }
    public WebElement getCityInput() {
        return driver.findElement(By.id("city"));
    }
    public WebElement getCountryInput() {
        return driver.findElement(By.id("country"));
    }
    public WebElement getUrlTwitterInput() {
        return driver.findElement(By.id("urlTwitter"));
    }
    public WebElement getUrlGithubInput() {
        return driver.findElement(By.id("urlGitHub"));
    }
    public WebElement getSaveButton() {
        return driver.findElement(By.className("btnSave"));
    }
    public WebElement getClearPhoneInputButton() {
        return driver.findElement(By.xpath("//div[3]/span/div/div/div[1]/div[2]/div/button"));
    }
    public void waitProgressBarInvisibility() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(
                By.xpath("//div[@role='progressbar']"))));
    }
}
