package com.nyxei.pollingus.models;

import com.nyxei.pollingus.models.question.Change;
import lombok.Data;

import java.util.List;

@Data
public class Entry {
    private String id;
    private List<Change> changes;

    @Override
    public String toString() {
        return "Entry{" +
                "id='" + id + '\'' +
                ", changes=" + changes +
                '}';
    }
}
