package com.iotiq.commons.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.NonNull;

import java.util.LinkedList;
import java.util.StringJoiner;

@Data
@EqualsAndHashCode(callSuper = true)
public class Codes extends LinkedList<String> {
    private transient StringJoiner joiner = new StringJoiner(".");

    @NonNull
    public String[] toStringArray() {
        return toArray(new String[0]);
    }

    public String[] createCodes() {
        joiner = new StringJoiner(".");
        for (String messagePart : this) {
            joiner.add(messagePart);
            add(joiner.toString());
        }
        return toStringArray();
    }
}
