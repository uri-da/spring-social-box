package org.springframework.social.box.api;

import org.springframework.social.ApiBinding;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 3:50 PM
 */
public interface Box extends ApiBinding {

    UserOperations userOperations();

    FolderOperations folderOperations();

    FileOperations fileOperations();
}
