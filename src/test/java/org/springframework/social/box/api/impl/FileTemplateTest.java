package org.springframework.social.box.api.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.box.api.domain.File;
import org.springframework.social.box.connect.url.CustomizedBoxUrlService;
import org.springframework.social.test.client.MockRestServiceServer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: greg
 * Date: 30/10/13
 * Time: 11:05 AM
 */
public class FileTemplateTest {

    private static final String FILE_ID = "123456789";
    private BoxTemplate boxTemplate;

    private MockRestServiceServer mockServer;

    @Before
    public void before(){
        boxTemplate = new BoxTemplate("accessToken", CustomizedBoxUrlService.API_URL);

        mockServer = MockRestServiceServer.createServer(boxTemplate.getRestTemplate());
    }

    @Test
    public void testGetFile() throws Exception {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        mockServer.expect(requestTo(CustomizedBoxUrlService.API_URL + "/files/" + FILE_ID))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(getFileTestJson(), responseHeaders));

        File file = boxTemplate.fileOperations().getFile(FILE_ID);

        assertThat(file, is(notNullValue()));
        assertThat(file.getId(), is(equalTo("5000948880")));
        assertThat(file.getName(), is(equalTo("tigers.jpeg")));
    }

    private String getFileTestJson() {
        return "{\n" +
                "    \"type\": \"file\",\n" +
                "    \"id\": \"5000948880\",\n" +
                "    \"sequence_id\": \"3\",\n" +
                "    \"etag\": \"3\",\n" +
                "    \"sha1\": \"134b65991ed521fcfe4724b7d814ab8ded5185dc\",\n" +
                "    \"name\": \"tigers.jpeg\",\n" +
                "    \"description\": \"a picture of tigers\",\n" +
                "    \"size\": 629644,\n" +
                "    \"path_collection\": {\n" +
                "        \"total_count\": 2,\n" +
                "        \"entries\": [\n" +
                "            {\n" +
                "                \"type\": \"folder\",\n" +
                "                \"id\": \"0\",\n" +
                "                \"sequence_id\": null,\n" +
                "                \"etag\": null,\n" +
                "                \"name\": \"All Files\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": \"folder\",\n" +
                "                \"id\": \"11446498\",\n" +
                "                \"sequence_id\": \"1\",\n" +
                "                \"etag\": \"1\",\n" +
                "                \"name\": \"Pictures\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"created_at\": \"2012-12-12T10:55:30-08:00\",\n" +
                "    \"modified_at\": \"2012-12-12T11:04:26-08:00\",\n" +
                "    \"trashed_at\": null,\n" +
                "    \"purged_at\": null,\n" +
                "    \"content_created_at\": \"2013-02-04T16:57:52-08:00\",\n" +
                "    \"content_modified_at\": \"2013-02-04T16:57:52-08:00\",\n" +
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
                "        \"url\": \"https://www.box.com/s/rh935iit6ewrmw0unyul\",\n" +
                "        \"download_url\": \"https://www.box.com/shared/static/rh935iit6ewrmw0unyul.jpeg\",\n" +
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
                "    \"parent\": {\n" +
                "        \"type\": \"folder\",\n" +
                "        \"id\": \"11446498\",\n" +
                "        \"sequence_id\": \"1\",\n" +
                "        \"etag\": \"1\",\n" +
                "        \"name\": \"Pictures\"\n" +
                "    },\n" +
                "    \"item_status\": \"active\"\n" +
                "}";

    }
}
