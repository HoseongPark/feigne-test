package com.example.feignetest;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Repository
@RequiredArgsConstructor
public class RestTemplateRepository {

    private final RestTemplate restTemplate;

    public void register(Book book, MultipartFile media) throws IOException {
        String serverUrl = "http://127.0.0.1:8080/todo";

        MultiValueMap<Object, Object> multiValueMap = new LinkedMultiValueMap<>();
        HttpHeaders totalHeader = new HttpHeaders();
        totalHeader.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Json
        HttpHeaders jsonHeader = new HttpHeaders();
        jsonHeader.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Book> jsonEntity = new HttpEntity<>(book, jsonHeader);

        // Media
        HttpHeaders mediaHeader = new HttpHeaders();
        mediaHeader.setContentType(MediaType.MULTIPART_FORM_DATA);
        InputStreamResource mediaInput = new InputStreamResource(media.getInputStream(), media.getOriginalFilename());

        HttpEntity<Resource> mediaEntity = new HttpEntity<>(media.getResource(), mediaHeader);

        // Total Entity
        multiValueMap.add("media", mediaEntity);
        multiValueMap.add("book", jsonEntity);

        HttpEntity<MultiValueMap<Object, Object>> totalEntity = new HttpEntity<>(multiValueMap, totalHeader);

        // Send Rest Http
        ResponseEntity<String> exchange = restTemplate.exchange(serverUrl, HttpMethod.POST, totalEntity, String.class);
        System.out.println(exchange.getBody());
    }

}
