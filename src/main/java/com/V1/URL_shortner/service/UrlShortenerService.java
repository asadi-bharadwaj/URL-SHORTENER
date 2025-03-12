package com.V1.URL_shortner.service;

public interface UrlShortenerService {
   String shortenUrl(String originalUrl);
   String getOriginalUrl(String shortCode);
}
