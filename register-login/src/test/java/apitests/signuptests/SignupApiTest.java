package apitests.signuptests;

import base.ApiBaseTest;
import controllers.VitaMojoController;
import entities.v1signup.V1SignUpResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import testgroups.VitaMojoCategories;

import java.util.Random;

public class SignupApiTest extends ApiBaseTest {

    @Test(groups = {VitaMojoCategories.REGISTRATION_API_SMOKE})
    public void v1SignupApiSuccessTest() {
        long num = new Random().nextInt(999999999) + 1000000000L;
        String email = RandomStringUtils.randomAlphanumeric(10).toUpperCase() + "@gmail.com";
        String phone = "+91 " + num;

        V1SignUpResponse v1SignUpResponse = register(email, "12345678", phone);
        v1SignUpResponse.assertSignupApiSuccess(email, phone);
        // OTP flow can be added here by simply calling the relevant API client. Each api call represents a single line step, followed by appropriate assertions
    }

    @Test(groups = {VitaMojoCategories.REGISTRATION_API_SMOKE})
    public void v1SignupApiFailureTest() {
        long num = new Random().nextInt(999999999) + 1000000000L;
        String email = "ddsadas@outlook.com";
        String phone = "+91 " + num;

        V1SignUpResponse v1SignUpResponse = register(email, "12345678", phone);
        v1SignUpResponse.assertSignupApiFailureDueToExistingEmail();
    }


    // E2E tests with larger functional flows can be added here

}
