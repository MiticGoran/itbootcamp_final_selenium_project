package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
    @Test(priority = 1)
    @Description("Test #1: Visits the login page")
    public void visitTheLoginPage(){
        driver.get(baseUrl);
        navPage.changeLanguageButton().click();
        navPage.enLanguage().click();
        navPage.loginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page!");
    }
    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checkInputTypes(){
        navPage.loginButton().click();
        Assert.assertEquals(loginPage.emailInput().getAttribute("type"), "email",
                "Wrong email type.");
        Assert.assertEquals(loginPage.passwordInput().getAttribute("type"), "password",
                "Wrong password type.");
    }
}
