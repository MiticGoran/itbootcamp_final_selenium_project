package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement homeLink() {
        return driver.findElement(By.xpath("//a[@href='/']"));
    }
    public WebElement aboutButton(){
        return driver.findElement(By.className("btnAbout"));
    }
    public WebElement myProfileButton() {
        return driver.findElement(By.className("btnProfile"));
    }
    public WebElement adminButton() {
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement cities() {
        return driver.findElement(By.xpath("//a[@href='/admin/cities']"));
    }
    public WebElement users() {
        return driver.findElement(By.xpath("//a[@href='/admin/users']"));
    }
    public WebElement loginButton(){
        return driver.findElement(By.xpath("//a[@href='/login']"));
    }
    public WebElement signUpButton(){
        return driver.findElement(By.xpath("//a[@href='/signup']"));
    }
    public WebElement logoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }
    public WebElement changeLanguageButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
    }
    public WebElement enLanguage(){
        return driver.findElement(By.id("list-item-73"));
    }
    public WebElement esLanguage(){
        return driver.findElement(By.id("list-item-75"));
    }
    public WebElement frLanguage(){
        return driver.findElement(By.id("list-item-77"));
    }
    public WebElement cnLanguage(){
        return driver.findElement(By.id("list-item-79"));
    }
    public WebElement uaLanguage(){
        return driver.findElement(By.id("list-item-81"));
    }

}