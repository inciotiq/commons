package com.iotiq.commons.util;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordUtil {
    private final PasswordEncoder encoder;

    public String encode(CharSequence rawPassword) {
        return encoder.encode(rawPassword);
    }

}
