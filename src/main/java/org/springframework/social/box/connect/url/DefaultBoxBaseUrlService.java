package org.springframework.social.box.connect.url;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 21/08/2014
 * Time: 4:48 PM
 */
public class DefaultBoxBaseUrlService implements BoxBaseUrlService {
    public static final String API_BASE_URL = "https://api.box.com";
    public static final String OAUTH_BASE_URL = "https://www.box.com";

    @Override
    public String getApiBaseUrl() {
        return API_BASE_URL;
    }

    @Override
    public String getOAuthBaseUrl() {
        return OAUTH_BASE_URL;
    }
}
