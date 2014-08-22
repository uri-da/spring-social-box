package org.springframework.social.box.connect.url;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 21/08/2014
 * Time: 4:55 PM
 */
public interface BoxUrlService {
    String getApiUrl();
    String getOauth2AuthorizationUrl();
    String getOauth2TokenUrl();
}
