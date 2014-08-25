package org.springframework.social.box.connect;

import org.springframework.social.box.api.Box;
import org.springframework.social.box.api.impl.BoxTemplate;
import org.springframework.social.box.connect.url.BoxUrlService;
import org.springframework.social.box.connect.url.CustomizedBoxUrlService;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 4:00 PM
 */
public class BoxServiceProvider extends AbstractOAuth2ServiceProvider<Box> {

    private final String apiUrl;

    public BoxServiceProvider(String clientId, String clientSecret) {
        this(clientId, clientSecret, new CustomizedBoxUrlService());
    }

    public BoxServiceProvider(String clientId, String clientSecret, String alternateApiBaseUrl, String alternateOAuthBaseUrl) {
        this(clientId, clientSecret, new CustomizedBoxUrlService(alternateApiBaseUrl, alternateOAuthBaseUrl));
    }

    private BoxServiceProvider(String clientId, String clientSecret, BoxUrlService boxUrlService) {
        super(new OAuth2Template(clientId, clientSecret, boxUrlService.getOauth2AuthorizationUrl(), boxUrlService.getOauth2TokenUrl()));
        this.apiUrl = boxUrlService.getApiUrl();
        ((OAuth2Template)getOAuthOperations()).setUseParametersForClientAuthentication(true);
    }

    public Box getApi(String accessToken) {
        return new BoxTemplate(accessToken, apiUrl);
    }

}
