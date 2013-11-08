package org.springframework.social.box.api.impl;

import org.springframework.social.box.api.FolderOperations;
import org.springframework.social.box.api.domain.Folder;
import org.springframework.social.box.api.domain.ItemCollection;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * User: greg
 * Date: 29/10/13
 * Time: 4:56 PM
 */
public class FolderTemplate extends AbstractTemplate implements FolderOperations {


    private final RestTemplate restTemplate;

    private boolean isAuthorized;

    private String url;

    public FolderTemplate(RestTemplate restTemplate, boolean authorized, String baseUrl) {
        this.restTemplate = restTemplate;
        this.isAuthorized = authorized;
        this.url = baseUrl + "/folders";
    }


    public Folder getFolder(String folderId) {
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "/" + folderId), Folder.class);
    }

    public Folder getRootFolder(){
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "/0" ), Folder.class);
    }

    public ItemCollection getFolderItems(String folderId){
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "/" + folderId + "/items"), ItemCollection.class);

    }
    public ItemCollection getRootFolderItems(){
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "/0/items"), ItemCollection.class);

    }
}
