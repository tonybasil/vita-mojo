package logintests;

import controllers.VitaMojoController;
import entities.v1login.V1LoginResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import testgroups.VitaMojoCategories;

public class LoginTest extends VitaMojoController {
    @Test(groups = {VitaMojoCategories.LOGIN_SMOKE})
    public void v1LoginApiSuccessTest() {
        String email = "ddsdsadas@outlook.com";

        V1LoginResponse v1LoginResponse = login(email, "12345678");
        v1LoginResponse.assertLoginApiSuccess(email);
        // OTP flow can be added here by simply calling the relevant API client. Each api call represents a single line step, followed by appropriate assertions
    }

    @Test(groups = {VitaMojoCategories.LOGIN_SMOKE})
    public void v1LoginApiFailureTest() {
        String email = RandomStringUtils.randomAlphanumeric(10).toUpperCase() + "@gmail.com";

        V1LoginResponse v1LoginResponse = login(email, "12345678");
        v1LoginResponse.assertLoginApiFailureDueToExistingEmail();
    }


    // E2E tests with larger functional flows can be added here
}
