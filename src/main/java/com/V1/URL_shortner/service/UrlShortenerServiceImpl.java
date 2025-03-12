package com.V1.URL_shortner.service;

import com.V1.URL_shortner.entity.ShortnedUrl;
import com.V1.URL_shortner.repository.ShortenedUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlShortenerServiceImpl implements UrlShortenerService{

    private final ShortenedUrlRepository shortenedUrlRepository;

    // 1. Shorten a URL and return the short code
    @Override
    public String shortenUrl(String originalUrl) {
        //check if the URL is already shortend
        Optional<ShortnedUrl> existingURl = shortenedUrlRepository.findByOriginalUrl(originalUrl);
        if(existingURl.isPresent()){
            return existingURl.get().getShortCode();
        }
        //Generate a shortcode
        String shortCode = generateShortCode(originalUrl);

        //save to Data base
        ShortnedUrl shortnedUrl = ShortnedUrl.builder()
                .originalUrl(originalUrl)
                .shortCode(shortCode)
                .CreatedAt(LocalDateTime.now())
                .build();

        shortenedUrlRepository.save(shortnedUrl);
        return shortCode;
    }

    // 2️⃣ Retrieve original URL from short code
    @Override
    public String getOriginalUrl(String shortCode) {
        ShortnedUrl shortenedUrl = shortenedUrlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));
        return shortenedUrl.getOriginalUrl();
    }


    //Method to generate a shortCode(Base 64 encoding)
    private String generateShortCode(String url){
        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(url.getBytes(StandardCharsets.UTF_8))
                .substring(0,8);
    }


}
