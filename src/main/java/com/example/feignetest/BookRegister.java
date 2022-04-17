package com.example.feignetest;

import java.io.Serializable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BookRegister implements Serializable {

    private String title;
    private String author;
    private MultipartFile image;

}
