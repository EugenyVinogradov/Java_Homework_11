package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MovieManager {
    private Movie[] listMovies = new Movie[0];
    private int maxLimit = 10;

    public MovieManager(int maxLimit) {
        this.setMaxLimit(maxLimit);
    }

    public void addMovie(Movie newMovie) {
        int length = listMovies.length + 1;
        Movie[] tmp = new Movie[length];
        for (int i = 0; i < listMovies.length;i++) {
            tmp[i] = listMovies[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newMovie;
        listMovies = tmp;
    }
    public Movie[] findAll() {
        return listMovies;
    }

    public Movie[] findReverseMaxLimit(int maxLimit) {
        int length = maxLimit;
        Movie[] tmp = new Movie[length];
        for (int i =0; i < length; i++) {
            int index = length - i;
            tmp[i] = listMovies[index];
        }
        listMovies = tmp;
        return listMovies;
    }
}
