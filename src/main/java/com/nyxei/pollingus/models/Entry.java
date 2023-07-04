package com.nyxei.pollingus.models;

import com.nyxei.pollingus.models.question.Change;

import java.util.List;

public class Entry {
    private String id;
    private List<Change> changes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Change> getChanges() {
        return changes;
    }

    public void setChanges(List<Change> changes) {
        this.changes = changes;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id='" + id + '\'' +
                ", changes=" + changes +
                '}';
    }
}
