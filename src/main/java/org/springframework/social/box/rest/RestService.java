package org.springframework.social.box.rest;

import java.net.URI;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 12/11/2014
 * Time: 4:54 PM
 */
public class RestService {

    private RestTemplate restTemplate;

    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T getFrom(String url, ParameterizedTypeReference<T> responseType) {
        return restTemplate.exchange(URI.create(url), HttpMethod.GET, null, responseType).getBody();
    }

    public <T> T getFrom(String url, Class<T> responseType) {
        return restTemplate.exchange(URI.create(url), HttpMethod.GET, null, responseType).getBody();
    }

    public <T> T postTo(String url, ParameterizedTypeReference<T> responseType) {
        return restTemplate.exchange(URI.create(url), HttpMethod.POST, null, responseType).getBody();
    }

    public <T> T postTo(String url, Class<T> responseType) {
        return restTemplate.exchange(URI.create(url), HttpMethod.POST, null, responseType).getBody();
    }

}
