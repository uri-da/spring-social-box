package org.springframework.social.box.rest.errorhandling;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 5:54 PM
 */
public class BoxRestTemplateErrorHandler extends DefaultResponseErrorHandler implements ResponseErrorHandler {

    private static final Logger log = Logger.getLogger(BoxRestTemplateErrorHandler.class.getName());

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if(super.hasError(response)){
            log.log(Level.SEVERE, IOUtils.toString(response.getBody()));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        super.handleError(response);
    }
}
