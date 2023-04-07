package entities.v1signup;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class V1SignUpRequestBody {
    private Profile profile;
    private String email;
    private String password;
    private String storeUUID;
    private String locale;


    @Getter
    @Setter
    @Builder
    public static class Profile {
        private String firstName;
        private String phone;
        private String birthDate;
    }
}
