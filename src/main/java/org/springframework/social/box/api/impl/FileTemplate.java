package org.springframework.social.box.api.impl;

import org.springframework.social.box.api.FileOperations;
import org.springframework.social.box.api.domain.File;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * User: greg
 * Date: 30/10/13
 * Time: 11:02 AM
 */
public class FileTemplate extends AbstractTemplate implements FileOperations {

    private final RestTemplate restTemplate;

    private boolean isAuthorized;

    private String url;


    public FileTemplate(RestTemplate restTemplate, boolean authorized, String baseUrl) {
        this.restTemplate = restTemplate;
        this.isAuthorized = authorized;
        this.url = baseUrl + "/files";
    }


    public File getFile(String fileId) {
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "/" + fileId), File.class);
    }

    @Override
    public byte[] getFileData(String fileId) {

        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "/" + fileId + "/content"), byte[].class);
    }
}
