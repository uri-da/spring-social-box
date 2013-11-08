package org.springframework.social.box.api.impl;

import org.springframework.social.box.api.domain.BoxProfile;
import org.springframework.social.box.api.UserOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 4:35 PM
 */
public class UserTemplate extends AbstractTemplate implements UserOperations {

    private final RestTemplate restTemplate;

    private boolean isAuthorized;

    private String url;

    public UserTemplate(RestTemplate restTemplate, boolean isAuthorized, String baseUrl){
        this.restTemplate = restTemplate;
        this.isAuthorized = isAuthorized;
        this.url = baseUrl + "/users";
    }

    public BoxProfile getUserProfile() {
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "/me"), BoxProfile.class);
    }
}
