package entities.v1login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class V1LoginRequestBody {
    private String email;
    private String password;
}
