package org.springframework.social.box.rest.errorhandling;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 5:54 PM
 */
public class BoxRestTemplateErrorHandler extends DefaultResponseErrorHandler implements ResponseErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(BoxRestTemplateErrorHandler.class.getName());

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if(super.hasError(response)){
            log.info(IOUtils.toString(response.getBody()));
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
