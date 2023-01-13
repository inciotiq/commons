package com.iotiq.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@NoArgsConstructor
public class PageableRequest {
    protected int page = 0;
    protected int size = 20;

    public Pageable buildPageable(Sort sort) {
        return PageRequest.of(getPage(), getSize(), sort);
    }
}
