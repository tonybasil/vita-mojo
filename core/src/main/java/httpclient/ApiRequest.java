package httpclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import jsonprocessor.JacksonMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ApiRequest<T> {
    private String url;
    private T body;
    private List<Param> headers;
    private List<Param> pathParams;
    private List<Param> queryParams;

    public String getRequestBody() throws JsonProcessingException {
        return body == null ? null : new JacksonMapper().getMapper().writeValueAsString(body);
    }

}
