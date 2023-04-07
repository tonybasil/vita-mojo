package endpoint;

import baseresponse.BaseResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import httpclient.ApiRequest;
import httpclient.Param;
import httpclient.RequestHandler;
import io.restassured.response.Response;
import jsonprocessor.JacksonMapper;

import java.util.List;

public abstract class BaseApiEndpoint<T extends BaseResponse> implements IServiceEndpoint {

    // This is the class where most of the api instrumentation would happen
    ApiRequest request;
    private final Class<T> responseClass;

    public BaseApiEndpoint(ApiRequest request, Class<T> responseClass) {
        this.request = request;
        this.responseClass = responseClass;
    }

    @Override
    public List<Param> queryParameters() {
        return request.getQueryParams();
    }

    @Override
    public List<Param> pathParameters() {
        return request.getPathParams();
    }

    @Override
    public List<Param> headers() {
        return request.getHeaders();
    }

    @Override
    public String body() {
        try {
            return new JacksonMapper().getMapper().writeValueAsString(request.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public T call() {
        Response response = new RequestHandler().processRequest(this);
        measureAPIStability();
        T deserialisedResponse = response.as(responseClass);
        deserialisedResponse.setHttpStatusCode(response.getStatusCode());
        return deserialisedResponse;
    }

    public void measureAPIStability() {
        // This is where the API stability would be measured and stored in db for reporting purpose
    }

}
