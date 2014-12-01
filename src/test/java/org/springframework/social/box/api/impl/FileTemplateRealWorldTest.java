package org.springframework.social.box.api.impl;

import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.social.box.api.domain.Entry;
import org.springframework.social.box.api.domain.ItemCollection;
import org.springframework.social.box.connect.url.CustomizedBoxUrlService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * WARNING: This is not a test which is meant to be executed every time, it is simply a convenient way to keep debugging
 * code available when investigating an issue against the real Box.com System.
 *
 * Created by mpoitras on 01/12/14.
 */
public class FileTemplateRealWorldTest {

    public static final String YOUR_API_KEY_GOES_HERE = "NDrmIShRZcEMY277OogD4Wc8Hstun5IB";
    public static final String YOUR_ACCESS_TOKEN_GOES_HERE = "uK2uSvsAPSkjOqNBbBoUi3xbbctADIxI";
    public static final String ROOT_FOLDER = "0";
    public static final String DESTINATION_FOLDER = ROOT_FOLDER;

    private BoxTemplate boxTemplate;

    @Test
    @Ignore
    public void sendingAJpegToBoxWithDeveloperTokenWorks() throws IOException {
        boxTemplate = new BoxTemplate(YOUR_API_KEY_GOES_HERE, CustomizedBoxUrlService.API_URL, CustomizedBoxUrlService.UPLOAD_URL);

        final String destinationFilename = RandomStringUtils.randomAlphabetic(15) + ".jpeg";
        final byte[] fileContent = IOUtils.toByteArray(FileTemplateRealWorldTest.class.getResourceAsStream("exampleFile.jpeg"));


        final ItemCollection<Entry> entryItemCollection = boxTemplate.fileOperations().sendFile(DESTINATION_FOLDER, destinationFilename, fileContent);


        assertThat(entryItemCollection.getTotalCount(), greaterThan(0l));
    }

    @Test
    @Ignore
    public void sendingAPdfToWithDeveloperTokenBoxWorks() throws IOException {
        boxTemplate = new BoxTemplate(YOUR_API_KEY_GOES_HERE, CustomizedBoxUrlService.API_URL, CustomizedBoxUrlService.UPLOAD_URL);

        final String destinationFilename = RandomStringUtils.randomAlphabetic(15) + ".pdf";
        final byte[] fileContent = IOUtils.toByteArray(FileTemplateRealWorldTest.class.getResourceAsStream("exampleFile.pdf"));


        final ItemCollection<Entry> entryItemCollection = boxTemplate.fileOperations().sendFile(DESTINATION_FOLDER, destinationFilename, fileContent);


        assertThat(entryItemCollection.getTotalCount(), greaterThan(0l));
    }

    @Test
    @Ignore
    public void sendingASignedPdfToBoxWithDeveloperTokenWorks() throws IOException {
        boxTemplate = new BoxTemplate(YOUR_API_KEY_GOES_HERE, CustomizedBoxUrlService.API_URL, CustomizedBoxUrlService.UPLOAD_URL);

        final String destinationFilename = RandomStringUtils.randomAlphabetic(15) + "signed.pdf";
        final byte[] fileContent = IOUtils.toByteArray(FileTemplateRealWorldTest.class.getResourceAsStream("exampleSignedFile.pdf"));


        final ItemCollection<Entry> entryItemCollection = boxTemplate.fileOperations().sendFile(DESTINATION_FOLDER, destinationFilename, fileContent);


        assertThat(entryItemCollection.getTotalCount(), greaterThan(0l));
    }

    @Test
    @Ignore
    public void sendingASignedPdfToBoxWithAccessTokenWorks() throws IOException {
        boxTemplate = new BoxTemplate(YOUR_ACCESS_TOKEN_GOES_HERE, CustomizedBoxUrlService.API_URL, CustomizedBoxUrlService.UPLOAD_URL);

        final String destinationFilename = RandomStringUtils.randomAlphabetic(15) + "signed.pdf";
        final byte[] fileContent = IOUtils.toByteArray(FileTemplateRealWorldTest.class.getResourceAsStream("exampleSignedFile.pdf"));


        final ItemCollection<Entry> entryItemCollection = boxTemplate.fileOperations().sendFile(DESTINATION_FOLDER, destinationFilename, fileContent);


        assertThat(entryItemCollection.getTotalCount(), greaterThan(0l));
    }
}
