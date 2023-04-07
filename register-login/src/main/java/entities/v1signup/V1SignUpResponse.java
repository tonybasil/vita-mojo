package entities.v1signup;

import baseresponse.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class V1SignUpResponse extends BaseResponse {
    private List<Message> message;
    private PayLoad payload;
    private Integer statusCode;
    private String timestamp;
    private String path;
    private String vmosCode;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Message {
        private String value;
        private List<String> constraints;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PayLoad {
        private User user;

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class User {
            private String uuid;
            private String storeUUID;
            private String tenantUUID;
            private String email;
            private Boolean active;
            private String createdAt;
            private String updatedAt;
            private Role role;
            private Profile profile;
            private String locale;
            private Boolean hasLinkedComoAccount;

            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Role {
                private String uuid;
                private Integer rank;
                private String slug;
                private String displayName;
                private String description;
            }

            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Profile {
                private String firstName;
                private String phone;
                private Boolean invoicePayment;
            }

        }
    }

    public void assertSignupApiSuccess(String email, String phone) {
        Assert.assertEquals(this.getHttpStatusCode(), 201, "Status code of signup api is not 201");
        Assert.assertEquals(this.getPayload().getUser().getEmail(), email, "Email of created user doesnt match with the input email");
        Assert.assertTrue(this.getPayload().getUser().getActive(), "User is not active");
        Assert.assertEquals(this.getPayload().getUser().getProfile().getPhone(), phone, "Phone number of created user doesnt match with the input phone number");
        // More assertions as per the requirement to be added here
    }

    public void assertSignupApiFailureDueToExistingEmail() {
        Assert.assertEquals(this.getHttpStatusCode(), 400, "Status code is not 400 bad request");
        Assert.assertEquals(this.getMessage().get(0).getConstraints().get(0), "This email is already connected to an account");
        // More assertions as per the requirement to be added here
    }

}
