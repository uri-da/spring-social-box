package org.springframework.social.box.api.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * User: greg
 * Date: 29/10/13
 * Time: 4:19 PM
 */
public class Entry {

    public enum Type {
        FILE, FOLDER;

        @Override
        public String toString(){
            return super.toString().toLowerCase();
        }
    }


    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("sequence_id")
    private Object sequenceId;
    @JsonProperty("etag")
    private Object etag;
    @JsonProperty("name")
    private String name;

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

    public Object getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Object sequenceId) {
        this.sequenceId = sequenceId;
    }

    public Object getEtag() {
        return etag;
    }

    public void setEtag(Object etag) {
        this.etag = etag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
