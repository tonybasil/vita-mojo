package httpclient;

import baseresponse.BaseResponse;
import jsonprocessor.JacksonMapper;

import java.io.IOException;
import java.net.URISyntaxException;

public class ApacheHttpClient<T extends BaseResponse> {

//    public T post(ApiRequest apiRequest, Class<T> responseClass) throws URISyntaxException, IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost request = new HttpPost(apiRequest.getUrl());
//        if (apiRequest.getHeaders() != null) {
//            for (int i = 0 ; i < apiRequest.getHeaders().size(); i++)
//                request.addHeader(((ApiParam)apiRequest.getHeaders().get(i)).getKey(), ((ApiParam)apiRequest.getHeaders().get(i)).getValue());
//
//        }
//        request.setEntity(new StringEntity(apiRequest.getRequestBody()));
//        CloseableHttpResponse response = httpClient.execute(request);
//        T deserialisedResponse = new JacksonMapper().getMapper().readValue(response.getEntity().getContent(), responseClass);
//        deserialisedResponse.setHttpStatusCode(response.getStatusLine().getStatusCode());
//        return deserialisedResponse;
//    }

}
