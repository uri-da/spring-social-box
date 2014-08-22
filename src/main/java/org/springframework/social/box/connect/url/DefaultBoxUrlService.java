package org.springframework.social.box.connect.url;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 21/08/2014
 * Time: 4:58 PM
 */
public class DefaultBoxUrlService implements BoxUrlService {

    public static final String API_PATH = "/2.0";
    public static final String OAUTH2_AUTHORIZATION_PATH = "/api/oauth2/authorize";
    public static final String OAUTH2_TOKEN_PATH = "/api/oauth2/token";

    public static final String API_URL = DefaultBoxBaseUrlService.API_BASE_URL + API_PATH;
    public static final String OAUTH2_AUTHORIZATION_URL = DefaultBoxBaseUrlService.OAUTH_BASE_URL + OAUTH2_AUTHORIZATION_PATH;
    public static final String OAUTH2_TOKEN_URL = DefaultBoxBaseUrlService.OAUTH_BASE_URL + OAUTH2_TOKEN_PATH;

    @Override
    public String getApiUrl() {
        return API_URL;
    }

    @Override
    public String getOauth2AuthorizationUrl() {
        return OAUTH2_AUTHORIZATION_URL;
    }

    @Override
    public String getOauth2TokenUrl() {
        return OAUTH2_TOKEN_URL;
    }
}
