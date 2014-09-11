package org.springframework.social.box.api.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.box.api.domain.Entry;
import org.springframework.social.box.api.domain.Folder;
import org.springframework.social.box.api.domain.ItemCollection;
import org.springframework.social.box.connect.url.CustomizedBoxUrlService;
import org.springframework.social.test.client.MockRestServiceServer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: greg
 * Date: 29/10/13
 * Time: 5:42 PM
 */
public class FolderTemplateTest {

    private BoxTemplate boxTemplate;

    private MockRestServiceServer mockServer;

    @Before
    public void before(){
        boxTemplate = new BoxTemplate("accessToken", CustomizedBoxUrlService.API_URL, CustomizedBoxUrlService.UPLOAD_URL);

        mockServer = MockRestServiceServer.createServer(boxTemplate.getRestTemplate());
    }

    private final String FILE_ID = "123456789";
    @Test
    public void testGetFolder() throws Exception {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        mockServer.expect(requestTo(CustomizedBoxUrlService.API_URL + "/folders/" + FILE_ID))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(getFolderTestJson(), responseHeaders));

        Folder folder = boxTemplate.folderOperations().getFolder(FILE_ID);

        assertThat(folder.getId(), is("11446498"));
        assertThat(folder.getItemCollection().getEntries().size(), is(1));

    }

    @Test
    public void testGetRootFolder() throws Exception {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        mockServer.expect(requestTo("https://api.box.com/2.0/folders/0"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(getFolderTestJson(), responseHeaders));

        Folder folder = boxTemplate.folderOperations().getRootFolder();

        assertThat(folder.getId(), is(equalTo("11446498")));
        assertThat(folder.getItemCollection().getEntries().size(), is(1));

    }

    @Test
    public void testGetFolderItems() throws Exception {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        mockServer.expect(requestTo("https://api.box.com/2.0/folders/" + FILE_ID + "/items"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(getTestFolderItemJson(), responseHeaders));

        ItemCollection folderItems = boxTemplate.folderOperations().getFolderItems(FILE_ID);

        assertThat(folderItems, notNullValue());
        assertThat(folderItems.getEntries().size(), is(2));
        assertThat(folderItems.getEntries().get(0).getType(), is(equalTo(Entry.Type.FOLDER.toString()))) ;
        assertThat(folderItems.getEntries().get(1).getType(), is(equalTo(Entry.Type.FILE.toString()))) ;

    }

    @Test
    public void testGetRootFolderItems() throws Exception {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        mockServer.expect(requestTo("https://api.box.com/2.0/folders/0/items"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(getTestFolderItemJson(), responseHeaders));

        ItemCollection folderItems = boxTemplate.folderOperations().getRootFolderItems();

        assertThat(folderItems, notNullValue());
        assertThat(folderItems.getEntries().size(), is(2));
    }


    private static String getTestFolderItemJson(){
        return "{\n" +
                "    \"total_count\": 24,\n" +
                "    \"entries\": [\n" +
                "        {\n" +
                "            \"type\": \"folder\",\n" +
                "            \"id\": \"192429928\",\n" +
                "            \"sequence_id\": \"1\",\n" +
                "            \"etag\": \"1\",\n" +
                "            \"name\": \"Stephen Curry Three Pointers\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"file\",\n" +
                "            \"id\": \"818853862\",\n" +
                "            \"sequence_id\": \"0\",\n" +
                "            \"etag\": \"0\",\n" +
                "            \"name\": \"Warriors.jpg\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"offset\": 0,\n" +
                "    \"limit\": 2,\n" +
                "    \"order\": [\n" +
                "        {\n" +
                "            \"by\": \"type\",\n" +
                "            \"direction\": \"ASC\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"by\": \"name\",\n" +
                "            \"direction\": \"ASC\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    private static String getFolderTestJson(){
        return "{\n" +
                "    \"type\": \"folder\",\n" +
                "    \"id\": \"11446498\",\n" +
                "    \"sequence_id\": \"1\",\n" +
                "    \"etag\": \"1\",\n" +
                "    \"name\": \"Pictures\",\n" +
                "    \"created_at\": \"2012-12-12T10:53:43-08:00\",\n" +
                "    \"modified_at\": \"2012-12-12T11:15:04-08:00\",\n" +
                "    \"description\": \"Some pictures I took\",\n" +
                "    \"size\": 629644,\n" +
                "    \"path_collection\": {\n" +
                "        \"total_count\": 1,\n" +
                "        \"entries\": [\n" +
                "            {\n" +
                "                \"type\": \"folder\",\n" +
                "                \"id\": \"0\",\n" +
                "                \"sequence_id\": null,\n" +
                "                \"etag\": null,\n" +
                "                \"name\": \"All Files\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"created_by\": {\n" +
                "        \"type\": \"user\",\n" +
                "        \"id\": \"17738362\",\n" +
                "        \"name\": \"sean rose\",\n" +
                "        \"login\": \"sean@box.com\"\n" +
                "    },\n" +
                "    \"modified_by\": {\n" +
                "        \"type\": \"user\",\n" +
                "        \"id\": \"17738362\",\n" +
                "        \"name\": \"sean rose\",\n" +
                "        \"login\": \"sean@box.com\"\n" +
                "    },\n" +
                "    \"owned_by\": {\n" +
                "        \"type\": \"user\",\n" +
                "        \"id\": \"17738362\",\n" +
                "        \"name\": \"sean rose\",\n" +
                "        \"login\": \"sean@box.com\"\n" +
                "    },\n" +
                "    \"shared_link\": {\n" +
                "        \"url\": \"https://www.box.com/s/vspke7y05sb214wjokpk\",\n" +
                "        \"download_url\": \"https://www.box.com/shared/static/vspke7y05sb214wjokpk\",\n" +
                "        \"vanity_url\": null,\n" +
                "        \"is_password_enabled\": false,\n" +
                "        \"unshared_at\": null,\n" +
                "        \"download_count\": 0,\n" +
                "        \"preview_count\": 0,\n" +
                "        \"access\": \"open\",\n" +
                "        \"permissions\": {\n" +
                "            \"can_download\": true,\n" +
                "            \"can_preview\": true\n" +
                "        }\n" +
                "    },\n" +
                "    \"folder_upload_email\": {\n" +
                "        \"access\": \"open\",\n" +
                "        \"email\": \"upload.Picture.k13sdz1@u.box.com\"\n" +
                "    },\n" +
                "    \"parent\": {\n" +
                "        \"type\": \"folder\",\n" +
                "        \"id\": \"0\",\n" +
                "        \"sequence_id\": null,\n" +
                "        \"etag\": null,\n" +
                "        \"name\": \"All Files\"\n" +
                "    },\n" +
                "    \"item_status\": \"active\",\n" +
                "    \"item_collection\": {\n" +
                "        \"total_count\": 1,\n" +
                "        \"entries\": [\n" +
                "            {\n" +
                "                \"type\": \"file\",\n" +
                "                \"id\": \"5000948880\",\n" +
                "                \"sequence_id\": \"3\",\n" +
                "                \"etag\": \"3\",\n" +
                "                \"sha1\": \"134b65991ed521fcfe4724b7d814ab8ded5185dc\",\n" +
                "                \"name\": \"exampleFile.jpeg\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"offset\": 0,\n" +
                "        \"limit\": 100\n" +
                "    }\n" +
                "}";
    }
}
