package org.springframework.social.box.api.impl;

import org.springframework.social.MissingAuthorizationException;

/**
 * User: greg
 * Date: 29/10/13
 * Time: 4:59 PM
 */
public abstract class AbstractTemplate {

    public void checkAuthorization(boolean isAuthorized){
        if (!isAuthorized) {
            throw new MissingAuthorizationException();
        }
    }
}
