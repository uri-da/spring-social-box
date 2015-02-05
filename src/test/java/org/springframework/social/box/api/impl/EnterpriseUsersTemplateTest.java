package org.springframework.social.box.api.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.box.api.domain.ItemCollection;
import org.springframework.social.box.api.domain.User;
import org.springframework.social.box.rest.RestService;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;


/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 10/11/2014
 * Time: 5:33 PM
 */

@RunWith(MockitoJUnitRunner.class)
public class EnterpriseUsersTemplateTest {

    @Mock
    private RestService restService;
    @Mock
    private ItemCollection<User> users;
    @Mock
    private User user;

    private String dummyUrl = "dummyUrl";
    private String dummyUserId = "dummyUserId";

    private ParameterizedTypeReference<ItemCollection<User>> multipleUsersResponseType= new ParameterizedTypeReference<ItemCollection<User>>() {};
    private Class<User> singleUserResponseType = User.class;


    @Test
    public void whenGettingAllUsersButWithoutBeingAuthorizedThenAMissingAuthorizationExceptionIsThrown(){
        final EnterpriseUsersTemplate classUnderTest = new EnterpriseUsersTemplate(restService, false, dummyUrl);
        final String usersUrl = classUnderTest.buildUsersUrl(dummyUrl);

        when(restService.getFrom(usersUrl, multipleUsersResponseType)).thenReturn(users);

        try{


            classUnderTest.getAllUsers();


            fail("Should have thrown an exception");
        }
        catch (MissingAuthorizationException mae){
        }
    }

    @Test
    public void whenGettingAllUsersThenTheyAreReturned(){
        final EnterpriseUsersTemplate classUnderTest = new EnterpriseUsersTemplate(restService, true, dummyUrl);
        final String usersUrl = classUnderTest.buildUsersUrl(dummyUrl);

        when(restService.getFrom(usersUrl, multipleUsersResponseType)).thenReturn(users);


        ItemCollection<User> actualUserItemCollection = classUnderTest.getAllUsers();


        assertThat(actualUserItemCollection, notNullValue());
    }

    @Test
    public void whenGettingOneUserButWithoutBeingAuthorizedThenAMissingAuthorizationExceptionIsThrown(){
        final EnterpriseUsersTemplate classUnderTest = new EnterpriseUsersTemplate(restService, false, dummyUrl);
        final String userId = dummyUserId;
        final String userUrl = classUnderTest.buildUsersUrl(dummyUrl) + "/" + userId;

        when(restService.getFrom(userUrl, singleUserResponseType)).thenReturn(user);

        try{


            classUnderTest.getUser(userId);


            fail("Should have thrown an exception");
        }
        catch (MissingAuthorizationException mae){
        }
    }

    @Test
    public void whenGettingOneUserThenItIsReturned(){
        final EnterpriseUsersTemplate classUnderTest = new EnterpriseUsersTemplate(restService, true, dummyUrl);
        final String userId = dummyUserId;
        final String userUrl = classUnderTest.buildUsersUrl(dummyUrl) + "/" + userId;

        when(restService.getFrom(userUrl, singleUserResponseType)).thenReturn(user);


        User actualUser = classUnderTest.getUser(userId);


        assertThat(actualUser, notNullValue());
    }

}