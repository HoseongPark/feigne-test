package com.example.feignetest;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final RestTemplateRepository restTemplateRepository;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping(value = "/todo", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseBody
    public ResponseEntity<Book> register(@RequestPart("book") Book book, @RequestPart("media") MultipartFile media) {
        return ResponseEntity.ok().body(book);
    }

//    @PostMapping(value = "/todo", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
//    @ResponseBody
//    public ResponseEntity<Book> register(@RequestPart("book") Book book, @RequestPart("media") TestBook testBook) {
//        return ResponseEntity.ok().body(book);
//    }

    @PostMapping("/test")
    public String test(BookRegister bookRegister) throws IOException {
        MultipartFile image = bookRegister.getImage();
        Book book = Book.builder().title(bookRegister.getTitle()).author(bookRegister.getAuthor()).build();

        restTemplateRepository.register(book, image);

        return "success";
    }
}
