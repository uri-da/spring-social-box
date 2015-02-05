package org.springframework.social.box.api;

import org.springframework.social.ApiBinding;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 3:50 PM
 */
public interface Box extends ApiBinding {
    public static final String BOX_PROVIDER_NAME = "box";

    UserOperations userOperations();

    FolderOperations folderOperations();

    FileOperations fileOperations();

    EnterpriseUsersOperations enterpriseUsersOperations();
}
