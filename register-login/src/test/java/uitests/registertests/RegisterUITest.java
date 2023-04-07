package uitests.registertests;

import base.UIBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import properties.VitaMojoUIProperties;
import testgroups.VitaMojoCategories;

public class RegisterUITest extends UIBaseTest {

    // I am not familiar with cucumber. Since the learning curve for cucumber would be non-trivial, I went ahead with TestNG based implementation of the test case
    @Test(groups = {VitaMojoCategories.REGISTRATION_UI_SMOKE})
    public void registerTest() {
        driver.get().get(VitaMojoUIProperties.vitaMojoWebUrl);
        LandingPage landingPage = new LandingPage(driver.get());
        LoginPage loginPage = landingPage.clickLoginButton()
                .clickCreateAccountTab()
                .fillRegistrationForm("dsadsadsa@gmail.com", "12345678", "abcd", "9988772233");

        Assert.assertEquals(loginPage.fetchCountryCode(), "+44");
        // More steps can be added here depending on the scope of the test case
    }

}
