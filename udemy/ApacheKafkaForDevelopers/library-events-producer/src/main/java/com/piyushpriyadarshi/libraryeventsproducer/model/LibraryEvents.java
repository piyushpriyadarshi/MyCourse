package com.piyushpriyadarshi.libraryeventsproducer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LibraryEvents {

    private Integer libraryEventId;
    private Book book;
}
