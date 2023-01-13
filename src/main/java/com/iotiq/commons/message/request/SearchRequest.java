package com.iotiq.commons.message.request;

import org.springframework.data.jpa.domain.Specification;

public interface SearchRequest<T> {
    Specification<T> buildSpecification();
}
