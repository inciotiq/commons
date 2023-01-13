package com.iotiq.commons;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class PagedResponseBuilder {

    private PagedResponseBuilder() {
    }

    public static <T, E> PagedResponse<E> createResponse(Page<T> page, Collection<E> content) {
        PagedResponse.PageMetadata pageMetadata = PagedResponse.PageMetadata.getPageMetadata(page);

        return PagedResponse.of(content, pageMetadata);
    }

}
