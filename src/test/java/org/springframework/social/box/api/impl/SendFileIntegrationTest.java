package org.springframework.social.box.api.impl;

import java.util.List;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.social.box.api.domain.Entry;
import org.springframework.social.box.api.domain.ItemCollection;
import org.springframework.social.box.connect.url.CustomizedBoxUrlService;

import java.io.InputStream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by whou on 25/08/14.
 */
public class SendFileIntegrationTest {

    public static final String BOX_API_KEY = "TYPE YOUR KEY HERE";    //PUT YOUR BOX API KEY HERE
    public static final String BOX_ROOT_FOLDER_ID = "0";
    private BoxTemplate boxTemplate;

    @Before
    public void before(){
        boxTemplate = new BoxTemplate(BOX_API_KEY, CustomizedBoxUrlService.API_URL, CustomizedBoxUrlService.UPLOAD_URL);
    }

    @Test
    @Ignore("This test requires a box API key")
    public void testSendFile() throws Exception {
        final String filename = "exampleFile.jpeg";
        final InputStream fileToSendInputStream = FileTemplateTest.class.getResourceAsStream(filename);
        byte[] fileContent = IOUtils.toByteArray(fileToSendInputStream);

        ItemCollection fileList = boxTemplate.fileOperations().sendFile(BOX_ROOT_FOLDER_ID, filename, fileContent);

        final List<Entry> resultEntries = fileList.getEntries();
        for (Entry resultEntry : resultEntries) {
            if(resultEntry.getName().equals(filename)){
                assertThat(resultEntry, is(notNullValue()));
                assertThat(resultEntry.getParent().getId(), is(equalTo(BOX_ROOT_FOLDER_ID)));
                assertThat(resultEntry.getName(), is(equalTo(filename)));
            }
        }
    }
}
