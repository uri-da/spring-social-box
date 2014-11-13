package org.springframework.social.box.api.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.social.box.api.FileOperations;
import org.springframework.social.box.api.domain.Entry;
import org.springframework.social.box.api.domain.File;
import org.springframework.social.box.api.domain.ItemCollection;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * User: gregorg.apache.commons.httpclient.methods.multipart.Part
 * Date: 30/10/13
 * Time: 11:02 AM
 */
public class FileTemplate extends AbstractTemplate implements FileOperations {

    public static final String BOX_KEY_FILENAME = "filename";
    public static final String BOX_KEY_PARENT_ID = "parent_id";

    private final RestTemplate restTemplate;

    private boolean isAuthorized;

    private String url;
    private String uploadUrl;


    public FileTemplate(RestTemplate restTemplate, boolean authorized, String baseUrl, String baseUploadUrl) {
        this.restTemplate = restTemplate;
        this.isAuthorized = authorized;
        this.url = baseUrl + "/files";
        this.uploadUrl = baseUploadUrl + "/files";
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

    @Override
    public ItemCollection<Entry> sendFile(String parentFolderId, String fileName, byte[] fileContent) {

        checkAuthorization(isAuthorized);

        HttpEntity request = configureRequest(parentFolderId, fileName, fileContent);
        return restTemplate.exchange(URI.create(uploadUrl + "/content"), HttpMethod.POST, request,
                new ParameterizedTypeReference<ItemCollection<Entry>>() {}).getBody();
    }

    private HttpEntity configureRequest(String parentFolderId, final String filename, final byte[] fileContent) {
        MultiValueMap<String,Object> formParams = new LinkedMultiValueMap<String,Object>();
        formParams.add(BOX_KEY_PARENT_ID, parentFolderId);
        formParams.add(BOX_KEY_FILENAME, buildResourceForFile(filename, fileContent));
        return new HttpEntity(formParams, configureMultipartFormData());
    }

    private HttpEntity buildResourceForFile(final String filename, final byte[] fileContent) {
        final ByteArrayResource fileResource = new ByteArrayResource(fileContent) {
            @Override
            public String getFilename() {
                return filename;
            }
        };
        return new HttpEntity(fileResource);
    }

    private HttpHeaders configureMultipartFormData() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        return headers;
    }


}
