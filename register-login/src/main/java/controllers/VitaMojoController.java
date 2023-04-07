package controllers;

import clients.V1LoginClient;
import clients.V1SignupClient;
import entities.v1login.V1LoginRequestBody;
import entities.v1login.V1LoginResponse;
import entities.v1signup.V1SignUpRequestBody;
import entities.v1signup.V1SignUpResponse;
import httpclient.ApiRequest;
import httpclient.ApiRequestBuilder;
import httpclient.Param;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class VitaMojoController {

    private V1SignupClient v1SignupClient;
    private V1LoginClient v1LoginClient;

    public VitaMojoController() {
        v1SignupClient = new V1SignupClient();
        v1LoginClient = new V1LoginClient();
    }
    public V1SignUpResponse register(String email, String password, String phone) {

        V1SignUpRequestBody v1SignUpRequestBody = V1SignUpRequestBody.builder()
                .email(email)
                .locale("en-GB")
                .password(password)
                .storeUUID("5aecf3f7-a566-454c-a7ec-" + RandomStringUtils.randomAlphanumeric(12).toUpperCase())
                .profile(V1SignUpRequestBody.Profile.builder()
                        .firstName("Test")
                        .phone(phone)
                        .birthDate("1990-01-01")
                        .build())
                .build();

        List<Param> headers = new ArrayList<>();
        headers.add(new Param("content-type", "application/json"));
        headers.add(new Param("referer", "https://fego.vmos-demo.com"));
        headers.add(new Param("origin", "https://fego.vmos-demo.com"));
        headers.add(new Param("tenant", "695a1486-80e7-4ee6-bc55-f4911944ef2a"));


        ApiRequest<V1SignUpRequestBody> v1SignUpRequest = new ApiRequestBuilder<V1SignUpRequestBody>()
                .withBody(v1SignUpRequestBody)
                .withHeaders(headers)
                .build();

        return v1SignupClient.signup(v1SignUpRequest);

    }

    public V1LoginResponse login(String email, String password) {

        V1LoginRequestBody v1LoginRequestBody = V1LoginRequestBody.builder()
                .email(email)
                .password(password)
                .build();

        List<Param> headers = new ArrayList<>();
        headers.add(new Param("content-type", "application/json"));
        headers.add(new Param("referer", "https://fego.vmos-demo.com"));
        headers.add(new Param("origin", "https://fego.vmos-demo.com"));
        headers.add(new Param("tenant", "695a1486-80e7-4ee6-bc55-f4911944ef2a"));


        ApiRequest<V1LoginRequestBody> v1SignUpRequest = new ApiRequestBuilder<V1LoginRequestBody>()
                .withBody(v1LoginRequestBody)
                .withHeaders(headers)
                .build();

        return v1LoginClient.login(v1SignUpRequest);

    }

}
