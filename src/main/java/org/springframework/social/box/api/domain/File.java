package org.springframework.social.box.api.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * User: greg
 * Date: 30/10/13
 * Time: 10:47 AM
 */
public class File {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("sequence_id")
    private String sequenceId;
    @JsonProperty("etag")
    private String etag;
    @JsonProperty("sha1")
    private String sha1;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("size")
    private Long size;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("modified_at")
    private String modifiedAt;
    @JsonProperty("trashed_at")
    private Object trashedAt;
    @JsonProperty("purged_at")
    private Object purgedAt;
    @JsonProperty("content_created_at")
    private String contentCreatedAt;
    @JsonProperty("content_modified_at")
    private String contentModifiedAt;
    @JsonProperty("created_by")
    private BoxProfile createdBy;
    @JsonProperty("modified_by")
    private BoxProfile modifiedBy;
    @JsonProperty("owned_by")
    private BoxProfile ownedBy;
    @JsonProperty("item_status")
    private String itemStatus;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Object getTrashedAt() {
        return trashedAt;
    }

    public void setTrashedAt(Object trashedAt) {
        this.trashedAt = trashedAt;
    }

    public Object getPurgedAt() {
        return purgedAt;
    }

    public void setPurgedAt(Object purgedAt) {
        this.purgedAt = purgedAt;
    }

    public String getContentCreatedAt() {
        return contentCreatedAt;
    }

    public void setContentCreatedAt(String contentCreatedAt) {
        this.contentCreatedAt = contentCreatedAt;
    }

    public String getContentModifiedAt() {
        return contentModifiedAt;
    }

    public void setContentModifiedAt(String contentModifiedAt) {
        this.contentModifiedAt = contentModifiedAt;
    }

    public BoxProfile getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(BoxProfile createdBy) {
        this.createdBy = createdBy;
    }

    public BoxProfile getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(BoxProfile modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public BoxProfile getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(BoxProfile ownedBy) {
        this.ownedBy = ownedBy;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
