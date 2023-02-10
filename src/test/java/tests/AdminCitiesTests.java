package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 10)
    @Description("Test #1: Visits the admin cities page and list cities")
    public void visitTheSignupPage() throws InterruptedException {
        navPage.loginButton().click();
        loginPage.emailInput().sendKeys("admin@admin.com");
        loginPage.passwordInput().sendKeys("12345");
        loginPage.loginButton().click();
        navPage.adminButton().click();
        navPage.cities().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "Wrong URL, not on cities page!");
    }
    @Test(priority = 20)
    @Description("Test #2: Checks input types for create/edit new city")
    public void checkInputTypes() throws InterruptedException {
        navPage.adminButton().click();
        navPage.cities().click();
        citiesPage.newItemButton().click();
        citiesPage.waitForEditCreateDialogueVisibility();
        Assert.assertEquals(citiesPage.cityNameInput().getAttribute("type"), "text",
                "Wrong city name input type.");
    }
    @Test(priority = 30)
    @Description("Test #3: Create new city")
    public void createNewCity() {
        navPage.adminButton().click();
        navPage.cities().click();
        citiesPage.newItemButton().click();
        citiesPage.waitForEditCreateDialogueVisibility();
        citiesPage.cityNameInput().sendKeys("Goran Mitic's city");
        citiesPage.saveButtonFromDialogue().click();
        messagePopUpPage.waitForPopUpSaved();
        Assert.assertTrue(messagePopUpPage.popUpTextSaved().contains("Saved successfully"),
                "Error notification doesn't contain 'Saved successfully' text");
    }
    @Test(priority = 40)
    @Description("Test #4: Edit city")
    public void editCity() throws InterruptedException {
        navPage.adminButton().click();
        navPage.cities().click();
        citiesPage.searchInput().sendKeys("Goran Mitic's city");
        citiesPage.waitForNoRows(1);
        citiesPage.editButtonForRow(1).click();
        citiesPage.cityNameInput().click();
        citiesPage.cityNameInput().sendKeys(Keys.CONTROL + "a");
        citiesPage.cityNameInput().sendKeys(Keys.BACK_SPACE);
        citiesPage.cityNameInput().sendKeys("Goran Mitic's city edited");
        citiesPage.saveButtonFromDialogue().click();
        messagePopUpPage.waitForPopUpSaved();
        Assert.assertTrue(messagePopUpPage.popUpTextSaved().contains("Saved successfully"),
                "Error notification doesn't contain 'Saved successfully' text");
    }

}
