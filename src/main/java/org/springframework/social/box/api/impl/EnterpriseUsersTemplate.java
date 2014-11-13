package org.springframework.social.box.api.impl;

import java.net.URI;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.social.box.api.EnterpriseUsersOperations;
import org.springframework.social.box.api.domain.ItemCollection;
import org.springframework.social.box.api.domain.User;
import org.springframework.social.box.rest.RestService;
import org.springframework.web.client.RestTemplate;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 10/11/2014
 * Time: 5:33 PM
 */
public class EnterpriseUsersTemplate extends AbstractTemplate implements EnterpriseUsersOperations {

    private final RestService restService;

    private boolean isAuthorized;

    private String url;

    public EnterpriseUsersTemplate(RestService restService, boolean isAuthorized, String baseUrl){
        this.restService = restService;
        this.isAuthorized = isAuthorized;
        this.url = buildUsersUrl(baseUrl);
    }

    String buildUsersUrl(String baseUrl) {
        return baseUrl + "/users";
    }

    @Override
    public ItemCollection<User> getAllUsers() {
        checkAuthorization(isAuthorized);

        return restService.getFrom(url, new ParameterizedTypeReference<ItemCollection<User>>() {});
    }

    @Override
    public User getUser(String userId) {
        checkAuthorization(isAuthorized);

        return restService.getFrom(url + "/" + userId, User.class);
    }
}
