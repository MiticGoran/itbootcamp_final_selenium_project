package tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest {
    @Test(priority = 10)
    @Description("Test #1: Visits the profile page")
    public void visitTheProfilePage() {
        navPage.getLoginButtonLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getMyProfileLink().click();
        profilePage.waitForMyProfilePage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"),
                "Wrong URL, not on 'My profile' page!");
    }

    @Test(priority = 20)
    @Description("Test #2: Checks input types")
    public void checkInputTypes() {
        navPage.getMyProfileLink().click();
        profilePage.waitForMyProfilePage();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        profilePage.waitProgressBarInvisibility();
        String attrDisabled = (String) js.executeScript
                ("return arguments[0].getAttribute('disabled');", profilePage.getEmailInput());
        Assert.assertEquals(profilePage.getEmailInput().getAttribute("type"), "email",
                "Wrong email type!");
        Assert.assertEquals(attrDisabled, "disabled",
                "Value is not disabled!");
        Assert.assertEquals(profilePage.getNameInput().getAttribute("type"), "text",
                "Wrong name type!");
        Assert.assertEquals(profilePage.getCityInput().getAttribute("type"), "text",
                "Wrong city type!");
        Assert.assertEquals(profilePage.getCountryInput().getAttribute("type"), "text",
                "Wrong country type!");
        Assert.assertEquals(profilePage.getUrlTwitterInput().getAttribute("type"), "url",
                "Wrong URL Twitter type!");
        Assert.assertEquals(profilePage.getUrlGithubInput().getAttribute("type"), "url",
                "Wrong URL GitHub type!");
        Assert.assertEquals(profilePage.getPhoneInput().getAttribute("type"), "tel",
                "Wrong phone type!");
        navPage.getLogoutButton().click();
    }

    @Test(priority = 20)
    @Description("Test #3: Edits profile")
    public void editProfile() throws InterruptedException {
        navPage.getLoginButtonLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getMyProfileLink().click();
        profilePage.waitForMyProfilePage();

        profilePage.getNameInput().click();
        profilePage.getNameInput().sendKeys(Keys.CONTROL + "a");
        profilePage.getNameInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getNameInput().sendKeys("Goran Mitic");

        profilePage.getClearPhoneInputButton().click();
        profilePage.getPhoneInput().sendKeys("+38161283229");

        profilePage.getCityInput().click();
        profilePage.getCityInput().sendKeys(Keys.CONTROL + "a");
        profilePage.getCityInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getCityInput().sendKeys("Bucaramanga");

        profilePage.getCountryInput().click();
        profilePage.getCountryInput().sendKeys(Keys.CONTROL + "a");
        profilePage.getCountryInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getCountryInput().sendKeys("Spain");

        profilePage.getUrlTwitterInput().click();
        profilePage.getUrlTwitterInput().sendKeys(Keys.CONTROL + "a");
        profilePage.getUrlTwitterInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getUrlTwitterInput().sendKeys("https://twitter.com/profile/milan1232");

        profilePage.getUrlGithubInput().click();
        profilePage.getUrlGithubInput().sendKeys(Keys.CONTROL + "a");
        profilePage.getUrlGithubInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getUrlGithubInput().sendKeys("https://github.com/miticgoran");

        profilePage.getSaveButton().click();
        messagePopUpPage.waitForPopUpSavedProfile();
        Assert.assertTrue(messagePopUpPage.popUpSavedProfileText().contains("Profile saved successfuly"),
                "Notification doesn't contain 'Profile saved successfuly' text!");

        Assert.assertEquals(profilePage.getNameInput().getAttribute("value"),
                "Goran Mitic",
                "Wrong name value!");
        Assert.assertEquals(profilePage.getPhoneInput().getAttribute("value"),
                "+38161283229",
                "Wrong phone value!");
        Assert.assertEquals(profilePage.getCityInput().getAttribute("value"),
                "Bucaramanga",
                "Wrong city value!");
        Assert.assertEquals(profilePage.getCountryInput().getAttribute("value"),
                "Spain",
                "Wrong country value!");
        Assert.assertEquals(profilePage.getUrlTwitterInput().getAttribute("value"),
                "https://twitter.com/profile/milan1232",
                "Wrong URL Twitter value!");
        Assert.assertEquals(profilePage.getUrlGithubInput().getAttribute("value"),
                "https://github.com/miticgoran",
                "Wrong URL GitHub value!");

        navPage.getLogoutButton().click();

    }
}
