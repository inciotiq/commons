package com.iotiq.commons.util;

import com.iotiq.commons.exceptions.EntityNotFoundException;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class NullHandlerUtil {

    private NullHandlerUtil() {
    }

    public static <T> void setIfNotNull(Consumer<T> setter, Supplier<T> getter) {
        T value = getter.get();
        if (value != null) {
            setter.accept(value);
        }
    }

    public static <T, R> void setIfNotNull(Consumer<T> setter, Supplier<T> getter, R value) {
        if (value != null) {
            setter.accept(getter.get());
        }
    }

    public static <T> T setIfNotNull(Object obj, Supplier<T> func) {
        if (obj != null) {
            return func.get();
        }
        return null;
    }

    /**
     * calls the setter function with objectGetter's result when called with keyGetter's result, if keyGetter returns a
     * non-null value. Does not ignore null keys.
     *
     * @param setter       - used to set the object, e.g. User::setName
     * @param keyGetter    - gets the key that will be passed to objectGetter, e.g. UserRequest::getUserId
     * @param objectGetter - gets the object that will be passed to the getter function, e.g. userRepository::findById
     * @param entityName   - name of the entity to be used in the EntityNotFoundException if object getters returns an
     *                     empty Optional, e.g. EntityNames.User
     * @param <T>          - type of object
     * @param <R>          - type of key
     */
    public static <T, R> void setIfExistsOrThrow(
            Consumer<T> setter, Supplier<R> keyGetter, Function<R, Optional<T>> objectGetter, String entityName
    ) {
        R key = keyGetter.get();
        if (key != null) {
            T apply = objectGetter.apply(key).orElseThrow(() -> new EntityNotFoundException(entityName));
            setter.accept(apply);
        } else { // set null if key is null
            setter.accept(null);
        }
    }
}
