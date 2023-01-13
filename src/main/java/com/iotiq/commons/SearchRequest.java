package com.iotiq.commons;

import org.springframework.data.jpa.domain.Specification;

public interface SearchRequest<T> {
    Specification<T> buildSpecification();
}
