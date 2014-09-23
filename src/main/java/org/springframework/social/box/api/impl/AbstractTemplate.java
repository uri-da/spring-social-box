package org.springframework.social.box.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.box.api.Box;

/**
 * User: greg
 * Date: 29/10/13
 * Time: 4:59 PM
 */
public abstract class AbstractTemplate {

    public void checkAuthorization(boolean isAuthorized){
        if (!isAuthorized) {
            throw new MissingAuthorizationException(Box.BOX_PROVIDER_NAME);
        }
    }
}
