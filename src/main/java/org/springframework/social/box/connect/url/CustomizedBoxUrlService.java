package org.springframework.social.box.connect.url;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 21/08/2014
 * Time: 4:58 PM
 */
public class CustomizedBoxUrlService extends DefaultBoxUrlService {

    private final String apiUrl;
    private final String oAuth2AuthorizationUrl;
    private final String oAuth2TokenUrl;

    public CustomizedBoxUrlService(BoxBaseUrlService boxBaseUrlService) {
        apiUrl = boxBaseUrlService.getApiBaseUrl() + API_PATH;
        oAuth2AuthorizationUrl = boxBaseUrlService.getOAuthBaseUrl() + OAUTH2_AUTHORIZATION_PATH;
        oAuth2TokenUrl = boxBaseUrlService.getOAuthBaseUrl() + OAUTH2_TOKEN_PATH;
    }

    @Override
    public String getApiUrl() {
        return apiUrl;
    }

    @Override
    public String getOauth2AuthorizationUrl() {
        return oAuth2AuthorizationUrl;
    }

    @Override
    public String getOauth2TokenUrl() {
        return oAuth2TokenUrl;
    }
}
