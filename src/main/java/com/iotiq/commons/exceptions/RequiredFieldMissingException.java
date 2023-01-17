package com.iotiq.commons.exceptions;

import org.springframework.http.HttpStatus;

import java.util.LinkedList;

public class RequiredFieldMissingException extends ApplicationException {

    public RequiredFieldMissingException(String field) {
        super(HttpStatus.BAD_REQUEST, "IllegalArgument", new LinkedList<>(), new Object[]{field});
    }
}
