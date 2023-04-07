package httpclient;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Param {
    private String key;
    private String value;
}
