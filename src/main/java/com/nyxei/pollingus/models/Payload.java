package com.nyxei.pollingus.models;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Payload {
    private String object;
    private String id;
    private Integer time;
    private List<JSONObject> messages = new ArrayList<>();
    private List<JSONObject> changed_fields = new ArrayList<>();
    private List<JSONObject> changes = new ArrayList<>();

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public List<JSONObject> getMessages() {
        return messages;
    }

    public void setMessages(List<JSONObject> messages) {
        this.messages = messages;
    }

    public List<JSONObject> getChanged_fields() {
        return changed_fields;
    }

    public void setChanged_fields(List<JSONObject> changed_fields) {
        this.changed_fields = changed_fields;
    }

    public List<JSONObject> getChanges() {
        return changes;
    }

    public void setChanges(List<JSONObject> changes) {
        this.changes = changes;
    }

    public Payload() {
    }
}
