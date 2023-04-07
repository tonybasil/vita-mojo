package uitests.logintests;

import base.UIBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginVerificationPage;
import properties.VitaMojoUIProperties;
import testgroups.VitaMojoCategories;

public class LoginUITest extends UIBaseTest {

    @Test(groups = {VitaMojoCategories.LOGIN_UI_SMOKE})
    public void loginTest() {
        driver.get().get(VitaMojoUIProperties.vitaMojoWebUrl);
        LandingPage landingPage = new LandingPage(driver.get());
        LoginVerificationPage loginVerificationPage = landingPage.clickLoginButton()
                .sendEmail("ddsdsadas@outlook.com")
                .sendPassword("12345678")
                .clickLoginButton();
        Assert.assertEquals(loginVerificationPage.fetchPhone(), "9995085432");
        // More steps can be added here depending on the scope of the test case
    }

}
