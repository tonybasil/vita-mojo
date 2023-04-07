package endpoints;

import endpoint.BaseApiEndpoint;
import entities.v1signup.V1SignUpResponse;
import httpclient.ApiRequest;
import properties.VitaMojoApiProperties;
import restmodel.HttpMethod;

public class V1SignupEndpoint extends BaseApiEndpoint<V1SignUpResponse> {

    public V1SignupEndpoint(ApiRequest apiRequest) {
        super(apiRequest, V1SignUpResponse.class);
    }
    @Override
    public String url() {
        return VitaMojoApiProperties.v1SignupUrl;
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.POST;
    }

}
