package com.nyxei.pollingus.models;

public class Payload {
    private String object;
    private String id;
    private Integer time;
    private Object[] entry = {};
    private Object[] changed_fields = {};
    private Object[] changes = {};

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

    public Object[] getEntry() {
        return entry;
    }

    public void setEntry(Object[] entry) {
        this.entry = entry;
    }

    public Object[] getChanged_fields() {
        return changed_fields;
    }

    public void setChanged_fields(Object[] changed_fields) {
        this.changed_fields = changed_fields;
    }

    public Object[] getChanges() {
        return changes;
    }

    public void setChanges(Object[] changes) {
        this.changes = changes;
    }

    public Payload() {
    }
}
