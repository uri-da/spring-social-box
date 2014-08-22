package org.springframework.social.box.connect;

import org.springframework.social.box.api.Box;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 5:40 PM
 */
public class BoxConnectionFactory extends OAuth2ConnectionFactory<Box> {

    // TODO: We may remove it. It is defined in Box interface.
    public static final String BOX_PROVIDER_NAME = "box";

    public BoxConnectionFactory(String clientId, String clientSecret) {
        this(new BoxServiceProvider(clientId, clientSecret));
    }

    protected BoxConnectionFactory(BoxServiceProvider boxServiceProvider) {
        super(BOX_PROVIDER_NAME, boxServiceProvider, new BoxAdapter());
    }
}
