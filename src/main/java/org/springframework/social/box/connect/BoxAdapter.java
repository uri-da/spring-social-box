package org.springframework.social.box.connect;

import org.springframework.social.ApiException;
import org.springframework.social.box.api.Box;
import org.springframework.social.box.api.domain.BoxProfile;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 4:10 PM
 */
public class BoxAdapter  implements ApiAdapter<Box> {
    @Override
    public boolean test(Box api) {
        try {
            api.userOperations().getUserProfile();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(Box api, ConnectionValues connectionValues) {
        BoxProfile userProfile = api.userOperations().getUserProfile();

        connectionValues.setProviderUserId(userProfile.getId());
        connectionValues.setDisplayName(userProfile.getName());
    }

    @Override
    public UserProfile fetchUserProfile(Box api) {
        BoxProfile userProfile = api.userOperations().getUserProfile();
        return new UserProfileBuilder().setName(userProfile.getName()).setEmail(userProfile.getEmail()).setUsername(userProfile.getEmail()).build();
    }

    @Override
    public void updateStatus(Box api, String s) {

    }
}
