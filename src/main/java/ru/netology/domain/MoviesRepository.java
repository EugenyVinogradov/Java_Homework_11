package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MoviesRepository {
    private Movie[] listMovies = new Movie[0];

    public Movie[] findAll() {
        return listMovies;
    }

    public void save (Movie newMovie) {
        int length = listMovies.length + 1;
        Movie[] tmp = new Movie[length];
        for (int i = 0; i < listMovies.length;i++) {
            tmp[i] = listMovies[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newMovie;
        listMovies = tmp;
    }

    public Movie[] findById(int id) {
        Movie[] tmp = new Movie[1];
        for (Movie movie : listMovies) {
            if (id == movie.getId()) {
                tmp[0] = movie;
            }
        }
        return tmp; // Нам же не надо перезаписывать listMovies?
    }

    public Movie[] removeById(int id) {
        Movie[] tmp = new Movie[listMovies.length - 1];
        int index = 0;
        for (Movie movie : listMovies) {
            if (id != movie.getId()) {
                tmp[index] = movie;
                index++;
            }
            listMovies = tmp;
        }
        return listMovies;
    }

    public Movie[] removeAll() {
        Movie[] tmp = new Movie[0];
        listMovies = tmp;
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
