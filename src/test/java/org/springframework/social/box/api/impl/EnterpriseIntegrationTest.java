package org.springframework.social.box.api.impl;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.social.box.api.domain.ItemCollection;
import org.springframework.social.box.api.domain.User;
import org.springframework.social.box.connect.url.CustomizedBoxUrlService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 10/11/2014
 * Time: 5:30 PM
 */
public class EnterpriseIntegrationTest {

    private static final String BOX_API_KEY = "TYPE YOUR KEY HERE";    //PUT YOUR BOX API KEY HERE
    private BoxTemplate boxTemplate;

    @Before
    public void before(){
        boxTemplate = new BoxTemplate(BOX_API_KEY, CustomizedBoxUrlService.API_URL, CustomizedBoxUrlService.UPLOAD_URL);
    }

    @Test
    @Ignore("This test requires a box API key")
    public void testGetAllUsers() throws Exception {

        ItemCollection<User> userItemCollection = boxTemplate.enterpriseUsersOperations().getAllUsers();

        for(User user: userItemCollection.getItems()) {

            assertThat(user, notNullValue());

            printUser(user);
        }
    }

    @Test
    @Ignore("This test requires a box API key")
    public void testGetAUser() throws Exception {

        ItemCollection<User> userItemCollection = boxTemplate.enterpriseUsersOperations().getAllUsers();

        for(User aUser: userItemCollection.getItems()) {

            assertThat(aUser, notNullValue());

            User user = boxTemplate.enterpriseUsersOperations().getUser(aUser.getId());

            assertThat(user, notNullValue());
            assertThat(user.getId(), is(aUser.getId()));
            assertThat(user.getName(), is(aUser.getName()));
            assertThat(user.getLogin(), is(aUser.getLogin()));

            printUser(user);
        }



    }

    private void printUser(User user) {
        System.out.println();
        System.out.print("Name: " + user.getName());
        System.out.print("\t\t");
        System.out.print("Id: " + user.getId());
        System.out.print("\t\t");
        System.out.print("Login: " + user.getLogin());
        System.out.println();
    }

}
