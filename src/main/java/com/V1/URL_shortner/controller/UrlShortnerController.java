package com.V1.URL_shortner.controller;

import com.V1.URL_shortner.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/urls")
@RequiredArgsConstructor
public class UrlShortnerController {

    private final UrlShortenerService urlShortenerService;
    //API to shorten a URL
    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestParam String originalUrl){
        String shortCode = urlShortenerService.shortenUrl(originalUrl);
        return ResponseEntity.ok(shortCode);
    }

    //API to retrieve the original URL from a short code
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortCode){
        String originalUrl = urlShortenerService.getOriginalUrl(shortCode);
        return ResponseEntity.status(302).location(URI.create(originalUrl)).build();
    }

}

