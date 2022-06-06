package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Movie {
    private int id;
    private String title;
    private String genre;
    private String imageUrl;
    private String premiereDate;
}
