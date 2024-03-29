package org.springframework.social.box.connect;

import org.springframework.social.box.api.Box;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 5:40 PM
 */
public class BoxConnectionFactory extends OAuth2ConnectionFactory<Box> {

    public BoxConnectionFactory(String clientId, String clientSecret) {
        this(new BoxServiceProvider(clientId, clientSecret));
    }

    public BoxConnectionFactory(String clientId, String clientSecret, String alternateApiBaseUrl, String alternateOAuthBaseUrl, String alternateUploadBaseUrl) {
        this(new BoxServiceProvider(clientId, clientSecret, alternateApiBaseUrl, alternateOAuthBaseUrl, alternateUploadBaseUrl));
    }

    private BoxConnectionFactory(BoxServiceProvider boxServiceProvider) {
        super(Box.BOX_PROVIDER_NAME, boxServiceProvider, new BoxAdapter());
    }
}
