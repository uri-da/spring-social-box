package org.springframework.social.box.api;

import org.springframework.social.box.api.domain.ItemCollection;
import org.springframework.social.box.api.domain.User;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 10/11/2014
 * Time: 5:30 PM
 */
public interface EnterpriseUsersOperations {

    ItemCollection<User> getAllUsers();

    User getUser(String userId);

}
