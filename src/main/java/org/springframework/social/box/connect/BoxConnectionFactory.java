package org.springframework.social.box.connect;

import org.springframework.social.box.api.Box;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 5:40 PM
 */
public class BoxConnectionFactory extends OAuth2ConnectionFactory<Box> {

    public static final String BOX_PROVIDER_NAME = "box";

    public BoxConnectionFactory(String clientId, String clientSecret) {
        super(BOX_PROVIDER_NAME, new BoxServiceProvider(clientId, clientSecret), new BoxAdapter());
    }
}
