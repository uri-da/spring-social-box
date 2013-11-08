package org.springframework.social.box.api;

import org.springframework.social.box.api.domain.Folder;
import org.springframework.social.box.api.domain.ItemCollection;

/**
 * User: greg
 * Date: 29/10/13
 * Time: 3:16 PM
 */
public interface FolderOperations {

    Folder getFolder(String folderId);

    Folder getRootFolder();

    ItemCollection getFolderItems(String folderId);

    ItemCollection getRootFolderItems();
}
