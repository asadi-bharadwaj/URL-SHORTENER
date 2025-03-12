package com.V1.URL_shortner.repository;

import com.V1.URL_shortner.entity.ShortnedUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortenedUrlRepository  extends JpaRepository<ShortnedUrl, Long> {

    Optional<ShortnedUrl> findByShortCode(String shortCode);

    Optional<ShortnedUrl> findByOriginalUrl(String originalUrl);
}
