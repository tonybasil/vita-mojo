package clients;

import endpoints.V1LoginEndpoint;
import entities.v1login.V1LoginRequestBody;
import entities.v1login.V1LoginResponse;
import httpclient.ApiRequest;

public class V1LoginClient {
    public V1LoginResponse login(ApiRequest<V1LoginRequestBody> v1LoginRequestBody) {
        return new V1LoginEndpoint(v1LoginRequestBody).call();
    }

}
