package httpclient;


import java.util.List;

public class ApiRequestBuilder <T> {
    private ApiRequest<T> request;

    public ApiRequestBuilder() {
        this.request = new ApiRequest<>();
    }

    public ApiRequestBuilder<T> withUrl(String url) {
        this.request.setUrl(url);
        return this;
    }

    public ApiRequestBuilder<T> withBody(T body) {
        this.request.setBody(body);
        return this;
    }

    public ApiRequestBuilder<T> withHeaders(List<Param> requestHeaders) {
        this.request.setHeaders(requestHeaders);
        return this;
    }

    public ApiRequestBuilder<T> withPathParams(List<Param> pathParams) {
        this.request.setPathParams(pathParams);
        return this;
    }

    public ApiRequestBuilder<T> withQueryParams(List<Param> queryParams) {
        this.request.setQueryParams(queryParams);
        return this;
    }

    public ApiRequest<T> build() {
        return this.request;
    }



}
