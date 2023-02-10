package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
    @Test(priority = 10)
    @Description("Test #1: Visits the login page")
    public void visitTheLoginPage(){
        navPage.changeLanguageButton().click();
        navPage.enLanguage().click();
        navPage.loginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page!");
    }
    @Test(priority = 20)
    @Description("Test #2: Checks input types")
    public void checkInputTypes(){
        navPage.loginButton().click();
        Assert.assertEquals(loginPage.emailInput().getAttribute("type"), "email",
                "Wrong email type.");
        Assert.assertEquals(loginPage.passwordInput().getAttribute("type"), "password",
                "Wrong password type.");
    }
    @Test(priority = 30)
    @Description("Test #3: Displays errors when user does not exist")
    public void errorWhenUserDoesNotExist(){
        navPage.loginButton().click();
        loginPage.emailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.passwordInput().sendKeys("password123");
        loginPage.loginButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.popUpText().contains("User does not exists"),
                "Error notification doesn't contain 'User does not exists' text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page!");
    }
    @Test(priority = 40)
    @Description("Test #4: Displays errors when password is wrong")
    public void errorWhenPasswordIsWrong(){
        navPage.loginButton().click();
        loginPage.emailInput().sendKeys("admin@admin.com");
        loginPage.passwordInput().sendKeys("password123");
        loginPage.loginButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.popUpText().contains("Wrong password"),
                "Error notification doesn't contain 'Wrong password' text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page!");
    }
    @Test(priority = 50)
    @Description("Test #5: Login")
    public void login() throws InterruptedException {
        navPage.loginButton().click();
        loginPage.emailInput().sendKeys("admin@admin.com");
        loginPage.passwordInput().sendKeys("12345");
        loginPage.loginButton().click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "Wrong URL, not on home page!");
    }
    @Test(priority = 60)
    @Description("Test #6: Logout")
    public void logout(){
        Assert.assertTrue(navPage.logoutButton().isDisplayed(), "Logout button is not visible");
        navPage.logoutButton().click();
    }
}
