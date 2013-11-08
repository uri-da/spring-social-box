package org.springframework.social.box.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * User: greg
 * Date: 24/10/13
 * Time: 4:33 PM
 */
public class BoxProfile {

    private String id;
    private String name;
    @JsonProperty("login")
    private String email;
    private String language;
    private String phone;
    private String address;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("job_title")
    private String jobTitle;
    private String status;
    @JsonProperty("max_upload_size")
    private Long maxUploadSize;
    @JsonProperty("space_used")
    private Long spaceUsed;
    @JsonProperty("space_amount")
    private Long spaceAmount;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("modified_at")
    private Date modifiedAt;
    private String type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getMaxUploadSize() {
        return maxUploadSize;
    }

    public void setMaxUploadSize(Long maxUploadSize) {
        this.maxUploadSize = maxUploadSize;
    }

    public Long getSpaceUsed() {
        return spaceUsed;
    }

    public void setSpaceUsed(Long spaceUsed) {
        this.spaceUsed = spaceUsed;
    }

    public Long getSpaceAmount() {
        return spaceAmount;
    }

    public void setSpaceAmount(Long spaceAmount) {
        this.spaceAmount = spaceAmount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
