package com.V1.URL_shortner.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Limit;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shortned_url")
public class ShortnedUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 500)
    private String originalUrl;

    @Column(length = 10)
    private String shortCode;

    @Column(nullable = false)
    private LocalDateTime CreatedAt;

}
