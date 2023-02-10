package tests;

import com.sun.org.glassfish.gmbal.Description;
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
}
