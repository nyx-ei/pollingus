package com.nyxei.pollingus.models.question;

public class Change {
    private String field;
    private Value value;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Change{" +
                "field='" + field + '\'' +
                ", value=" + value +
                '}';
    }
}
