package com.nyxei.pollingus.models.question;

import lombok.Data;

@Data
public class Change {
    private String field;
    private Value value;

    @Override
    public String toString() {
        return "Change{" +
                "field='" + field + '\'' +
                ", value=" + value +
                '}';
    }
}
