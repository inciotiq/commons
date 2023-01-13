package com.iotiq.commons.message.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponse<T> {
    Collection<T> content;
    @JsonProperty("page")
    PageMetadata metadata;

    public static <E> PagedResponse<E> of(Collection<E> content, PageMetadata pageMetadata) {
        return new PagedResponse<>(content, pageMetadata);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class PageMetadata {
        int size;
        int number;
        long totalElements;
        long totalPages;

        public static <T> PageMetadata getPageMetadata(Page<T> page) {
            Pageable pageable = page.getPageable();

            int pageSize = pageable.getPageSize();
            int pageNumber = pageable.getPageNumber();
            long totalElements = page.getTotalElements();
            int totalPages = page.getTotalPages();

            return new PageMetadata(pageSize, pageNumber, totalElements, totalPages);
        }
    }
}
