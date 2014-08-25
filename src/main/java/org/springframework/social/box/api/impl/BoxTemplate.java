package org.springframework.social.box.api.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.box.api.Box;
import org.springframework.social.box.api.FileOperations;
import org.springframework.social.box.api.FolderOperations;
import org.springframework.social.box.api.UserOperations;
import org.springframework.social.box.rest.errorhandling.BoxRestTemplateErrorHandler;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.web.client.RestTemplate;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 3:57 PM
 */
public class BoxTemplate  extends AbstractOAuth2ApiBinding implements Box {

    private FileOperations fileOperations;
    private UserOperations userOperations;
    private FolderOperations folderOperations;

    public BoxTemplate(String accessToken, String baseUrl) {
        super(accessToken);
        this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized(), baseUrl);
        this.folderOperations = new FolderTemplate(getRestTemplate(), isAuthorized(), baseUrl);
        this.fileOperations = new FileTemplate(getRestTemplate(), isAuthorized(), baseUrl);
    }

    public UserOperations userOperations() {
        return userOperations;
    }

    @Override
    public FolderOperations folderOperations() {
        return folderOperations;
    }

    @Override
    public FileOperations fileOperations() {
        return fileOperations;
    }

    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(getFormMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        ByteArrayHttpMessageConverter byteArrayMessageConverter = getByteArrayMessageConverter();
        byteArrayMessageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(byteArrayMessageConverter);
        return messageConverters;
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new BoxRestTemplateErrorHandler());
    }
}
