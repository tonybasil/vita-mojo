package httpclient;


import endpoint.IServiceEndpoint;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;

import java.util.List;

public class RequestHandler {

    public Response processRequest(IServiceEndpoint iServiceEndpoint) {
        RequestSpecification req = prepareRequestSpecification(iServiceEndpoint);
        printRequest(iServiceEndpoint);
        Response response = null;
        switch (iServiceEndpoint.httpMethod()) {
            case GET:
                response = req.get(iServiceEndpoint.url());
                break;
            case POST:
                response =  req.post(iServiceEndpoint.url());
                break;
            case PUT:
                response =  req.put(iServiceEndpoint.url());
                break;
            case DELETE:
                response = req.delete(iServiceEndpoint.url());
                break;
            default:
                throw new RuntimeException("Invalid HTTP Method");
        }
        printResponse(response);
        return response;
    }

    public void printRequest(IServiceEndpoint iServiceEndpoint) {
        Reporter.log("API Request...", true);
        Reporter.log("URL: " + iServiceEndpoint.url(), true);
        Reporter.log("HTTP Method: " + iServiceEndpoint.httpMethod(), true);
        Reporter.log("Headers: " + printParams(iServiceEndpoint.headers()), true);
        Reporter.log("Path Parameters: " + printParams(iServiceEndpoint.pathParameters()), true);
        Reporter.log("Query Parameters: " + printParams(iServiceEndpoint.queryParameters()), true);
        Reporter.log("Request Body: " + iServiceEndpoint.body(), true);
    }

    public String printParams(List<Param> paramList) {
        if (paramList == null)
            return "None";
        StringBuilder sb = new StringBuilder();
        for (Param param : paramList) {
            sb.append(param.getKey()).append("=").append(param.getValue()).append(";");
        }
        return sb.toString();
    }

    public void printResponse(Response response) {
        Reporter.log("API Response...", true);
        Reporter.log("Status Code: " + response.getStatusCode(), true);
        Reporter.log("Status Line: " + response.getStatusLine(), true);
        Reporter.log("Response Body: " + response.getBody().asString(), true);
    }

    public RequestSpecification prepareRequestSpecification(IServiceEndpoint iServiceEndpoint) {
        RestAssuredConfig config = RestAssured.config()
                .encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        RequestSpecification requestSpecification = RestAssured.given().config(config);

        if (iServiceEndpoint.headers() != null) {
            iServiceEndpoint.headers().forEach(header -> requestSpecification.header(header.getKey(), header.getValue()));
        }
        if (iServiceEndpoint.pathParameters() != null) {
            iServiceEndpoint.pathParameters().forEach(pathParameter -> requestSpecification.pathParam(pathParameter.getKey(), pathParameter.getValue()));
        }
        if (iServiceEndpoint.queryParameters() != null) {
            iServiceEndpoint.queryParameters().forEach(queryParameter -> requestSpecification.queryParam(queryParameter.getKey(), queryParameter.getValue()));
        }

        if (iServiceEndpoint.body() != null) {
            requestSpecification.body(iServiceEndpoint.body());
        }

        return requestSpecification;
    }

}
