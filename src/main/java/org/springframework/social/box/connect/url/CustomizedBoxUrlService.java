package org.springframework.social.box.connect.url;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 21/08/2014
 * Time: 4:58 PM
 */
public class CustomizedBoxUrlService implements BoxUrlService {

    public static final String API_BASE_URL = "https://api.box.com";
    public static final String OAUTH_BASE_URL = "https://www.box.com";
    public static final String UPLOAD_BASE_URL = "https://upload.box.com";

    private static final String API_PATH = "/2.0";
    private static final String OAUTH2_AUTHORIZATION_PATH = "/api/oauth2/authorize";
    private static final String OAUTH2_TOKEN_PATH = "/api/oauth2/token";
    private static final String UPLOAD_PATH = "/api/2.0";

    public static final String API_URL = API_BASE_URL + API_PATH;
    public static final String UPLOAD_URL = UPLOAD_BASE_URL + UPLOAD_PATH;

    private final String apiUrl;
    private final String oAuth2AuthorizationUrl;
    private final String oAuth2TokenUrl;
    private final String uploadUrl;


    public CustomizedBoxUrlService() {
        this(API_BASE_URL, OAUTH_BASE_URL, UPLOAD_BASE_URL);
    }

    public CustomizedBoxUrlService(String alternateApiBaseUrl, String alternateOAuthBaseUrl, String alternateUploadBaseUrl) {
        apiUrl = alternateApiBaseUrl + API_PATH;
        oAuth2AuthorizationUrl = alternateOAuthBaseUrl + OAUTH2_AUTHORIZATION_PATH;
        oAuth2TokenUrl = alternateOAuthBaseUrl + OAUTH2_TOKEN_PATH;
        uploadUrl = alternateUploadBaseUrl + UPLOAD_PATH;
    }

    @Override
    public String getApiUrl() {
        return apiUrl;
    }

    @Override
    public String getOauth2AuthorizationUrl() {
        return oAuth2AuthorizationUrl;
    }

    @Override
    public String getOauth2TokenUrl() {
        return oAuth2TokenUrl;
    }

    @Override
    public String getUploadUrl() {
        return uploadUrl;
    }
}
