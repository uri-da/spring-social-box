package org.springframework.social.box.connect;

import org.springframework.social.box.api.Box;
import org.springframework.social.box.api.impl.BoxTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 4:00 PM
 */
public class BoxServiceProvider  extends AbstractOAuth2ServiceProvider<Box> {


    public BoxServiceProvider(String clientId, String clientSecret) {
        super(new OAuth2Template(clientId, clientSecret,
                "https://www.box.com/api/oauth2/authorize",
                "https://www.box.com/api/oauth2/token"));
        ((OAuth2Template)getOAuthOperations()).setUseParametersForClientAuthentication(true);
    }

    public Box getApi(String accessToken) {
        return new BoxTemplate(accessToken);
    }

}
