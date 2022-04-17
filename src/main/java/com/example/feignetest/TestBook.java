package com.example.feignetest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class TestBook {

    private String title;
    private String author;

}
