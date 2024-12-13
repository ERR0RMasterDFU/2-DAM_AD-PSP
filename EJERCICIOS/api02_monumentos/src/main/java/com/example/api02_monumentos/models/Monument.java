package com.example.api02_monumentos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Monument {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String countryCode;
    private String countryName;
    private String cityName;
    private String name;
    private String longitude;
    private String latitude;

    @Lob
    private String description;

    @Lob
    private String image;
}
