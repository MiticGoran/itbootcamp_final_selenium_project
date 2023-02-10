package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    @Test(priority = 1)
    @Description("Test #1: Visits the signup page")
    public void visitTheSignupPage(){
        navPage.signUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Wrong URL, not on signup page!");
    }
    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checkInputTypes(){
        navPage.signUpButton().click();
        Assert.assertEquals(signupPage.emailInput().getAttribute("type"), "email",
                "Wrong email type.");
        Assert.assertEquals(signupPage.passwordInput().getAttribute("type"), "password",
                "Wrong password type.");
        Assert.assertEquals(signupPage.confirmPasswordInput().getAttribute("type"), "password",
                "Wrong confirm password type");
    }
    @Test(priority = 3)
    @Description("Test #3: Displays errors when user already exists")
    public void errorWhenUserAlreadyExists(){
        navPage.signUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Wrong URL, not on signup page!");
        signupPage.nameInput().sendKeys("Another User");
        signupPage.emailInput().sendKeys("admin@admin.com");
        signupPage.passwordInput().sendKeys("12345");
        signupPage.confirmPasswordInput().sendKeys("12345");
        signupPage.signMeUpButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.popUpText().contains("E-mail already exists"),
                "Error notification doesn't contain 'E-mail already exists' text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Wrong URL, not on signup page!");
    }
    @Test(priority = 4)
    @Description("Test #4: Signup")
    public void signUp() throws InterruptedException {
        navPage.signUpButton().click();
        signupPage.nameInput().sendKeys("Goran Mitic");
        signupPage.emailInput().sendKeys("goran23@itbootcamp.rs");
        signupPage.passwordInput().sendKeys("12345");
        signupPage.confirmPasswordInput().sendKeys("12345");
        signupPage.signMeUpButton().click();
        messagePopUpPage.waitForVerifyYourAccountPopUp();
        Thread.sleep(1000);
        Assert.assertTrue(messagePopUpPage.verifyPopUpText().contains("IMPORTANT: Verify your account"),
                "Notification doesn't contain 'IMPORTANT: Verify your account' text");
        messagePopUpPage.closeButtonVerifyPopUp().click();
        navPage.logoutButton().click();
    }
}
