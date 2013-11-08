package org.springframework.social.box.api;

import org.springframework.social.box.api.domain.File;

/**
 * User: greg
 * Date: 30/10/13
 * Time: 9:53 AM
 */
public interface FileOperations {

    File getFile(String fileId);

    byte[] getFileData(String fileId);
}
