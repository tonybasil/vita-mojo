package endpoints;

import endpoint.BaseApiEndpoint;
import entities.v1login.V1LoginResponse;
import httpclient.ApiRequest;
import properties.VitaMojoApiProperties;
import restmodel.HttpMethod;

public class V1LoginEndpoint extends BaseApiEndpoint<V1LoginResponse> {

    public V1LoginEndpoint(ApiRequest apiRequest) {
        super(apiRequest, V1LoginResponse.class);
    }
    @Override
    public String url() {
        return VitaMojoApiProperties.v1LoginUrl;
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.POST;
    }

}
