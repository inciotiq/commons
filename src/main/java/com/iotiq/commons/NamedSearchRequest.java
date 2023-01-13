package com.iotiq.commons;

import com.iotiq.commons.util.NullHandlerUtil;
import org.springframework.data.jpa.domain.Specification;

public interface NamedSearchRequest<T> extends SearchRequest<T> {

    String getName();

    @Override
    default Specification<T> buildSpecification() {
        return nameIsLike(getName());
    }

    default Specification<T> nameIsLike(String name) {
        return (root, query, cb) ->
                NullHandlerUtil.setIfNotNull(getName(), () -> cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
    }
}
