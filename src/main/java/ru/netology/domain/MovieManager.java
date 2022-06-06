package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MovieManager {
    private MoviesRepository repository;
    private int maxLimit = 10;

    public MovieManager(int maxLimit) {
        this.setMaxLimit(maxLimit);
    }

    public void addMovie(Movie newMovie) {
        repository.save(newMovie);
    }
    public Movie[] findAll() {
        return repository.findAll();
    }
    public Movie[] findReverseMaxLimit(int maxLimit) {
        return repository.findReverseMaxLimit(maxLimit);
    }
}
