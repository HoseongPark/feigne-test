package com.example.feignetest;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BookRegister {

    private String title;
    private MultipartFile image;

}
