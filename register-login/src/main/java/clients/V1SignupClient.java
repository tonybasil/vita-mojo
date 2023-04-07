package clients;

import endpoints.V1SignupEndpoint;
import entities.v1signup.V1SignUpRequestBody;
import entities.v1signup.V1SignUpResponse;
import httpclient.ApiRequest;

public class V1SignupClient {
    public V1SignUpResponse signup(ApiRequest<V1SignUpRequestBody> v1SignUpRequest) {
        return new V1SignupEndpoint(v1SignUpRequest).call();
    }

}
