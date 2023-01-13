package com.iotiq.commons.exceptions;

import lombok.Setter;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Objects;

@Setter
public abstract class ApplicationException extends RuntimeException implements MessageSourceResolvable {
    final HttpStatus status;
    final String prefix;
    final Codes codes = new Codes();
    final transient Object[] arguments;

    protected ApplicationException(HttpStatus status, String prefix, List<String> messageParts, Object[] arguments) {
        this.status = status;
        this.prefix = prefix;
        this.arguments = arguments;

        codes.add("exception");
        codes.add(prefix);
        codes.addAll(messageParts);
    }

    protected ApplicationException(HttpStatus status, String prefix, List<String> messageParts) {
        this(status, prefix, messageParts, new String[0]);
    }

    @Nullable
    @Override
    public String[] getCodes() {
        return codes.createCodes();
    }

    @Nullable
    @Override
    public Object[] getArguments() {
        return Objects.requireNonNullElseGet(arguments, () -> new Object[]{});
    }
}
