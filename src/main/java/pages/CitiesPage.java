package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement newItemButton(){
        return driver.findElement(By.xpath("//div[@class='text-right']/button"));
    }
    public WebElement searchInput(){
        return driver.findElement(By.id("search"));
    }
    public WebElement deleteButton(){
        return driver.findElement(By.id("delete"));
    }
    public WebElement editButton(){
        return driver.findElement(By.id("edit"));
    }
    public WebElement waitForEditCreateDialogueVisibility(){
        return wait.until
                (ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'dlgNewEditItem')]")));
    }
    public WebElement waitForDeleteDialogueVisibility(){
        return wait.until
                (ExpectedConditions.visibilityOfElementLocated
                (By.xpath
                ("//div[contains(@class, 'v-dialog')]//header[contains(@class, 'warning')]")));
    }
    public WebElement saveButtonFromDialogue(){
        return driver.findElement(By.className("btnSave"));
    }
    public WebElement deleteButtonFromDialogue(){
        return driver.findElement
                (By.xpath("//div[2]/button[2]"));
    }

}
