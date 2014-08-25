package org.springframework.social.box.api.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.box.api.domain.BoxProfile;
import org.springframework.social.box.connect.url.CustomizedBoxUrlService;
import org.springframework.social.test.client.MockRestServiceServer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 4:45 PM
 */
public class UserTemplateTest {

    private BoxTemplate boxTemplate;

    private MockRestServiceServer mockServer;

    @Before
    public void before(){
        boxTemplate = new BoxTemplate("accessToken", CustomizedBoxUrlService.API_URL);

        mockServer = MockRestServiceServer.createServer(boxTemplate.getRestTemplate());
    }

    @Test
    public void testGetUserProfile() throws Exception {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        mockServer.expect(requestTo(CustomizedBoxUrlService.API_URL + "/users/me"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(getUserJson(), responseHeaders));

        BoxProfile userProfile = boxTemplate.userOperations().getUserProfile();

        assertThat(userProfile.getId(), is(equalTo("17738362")));
    }

    private String getUserJson() {
        return "{\n" +
                "    \"type\": \"user\",\n" +
                "    \"id\": \"17738362\",\n" +
                "    \"name\": \"sean rose\",\n" +
                "    \"login\": \"sean@box.com\",\n" +
                "    \"created_at\": \"2012-03-26T15:43:07-07:00\",\n" +
                "    \"modified_at\": \"2012-12-12T11:34:29-08:00\",\n" +
                "    \"language\": \"en\",\n" +
                "    \"space_amount\": 5368709120,\n" +
                "    \"space_used\": 2377016,\n" +
                "    \"max_upload_size\": 262144000,\n" +
                "    \"status\": \"active\",\n" +
                "    \"job_title\": \"Employee\",\n" +
                "    \"phone\": \"5555555555\",\n" +
                "    \"address\": \"555 Office Drive\",\n" +
                "    \"avatar_url\": \"https://www.box.com/api/avatar/large/17738362\"\n" +
                "}";
    }


}
