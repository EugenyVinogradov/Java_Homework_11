package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MovieManagerTest {
    MovieManager manager = new MovieManager();
    Movie first = new Movie(1,"Бладшот", "боевик", "URL1", "01.01.2011");
    Movie second = new Movie(2,"Вперед", "мультфильм", "URL2", "01.02.2012");
    Movie third = new Movie(3,"Отель 'Белград'", "комедия", "URL3", "01.03.2013");
    Movie fourth = new Movie(4,"Джентельмены", "боевик", "URL4", "01.04.2014");
    Movie fifth = new Movie(5,"Человек-невидимка", "ужасы", "URL5", "01.05.2015");
    Movie sixth = new Movie(6,"Тролли. Мировой тур", "мультфильм", "URL6", "01.06.2016");

    @Test
    public void checkFindAll() {
        Movie[] listMovies = new Movie[0];
        MovieManager manager = new MovieManager( listMovies, 10);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        Movie[] actual = manager.findAll();
        Movie[] expected = {first, second, third, fourth, fifth,sixth};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void checkAdding() {
        Movie newMovie = new Movie(7, "Номер один", "комедия", "URL7", "01.07.2017");
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(newMovie);
        Movie[] actual = manager.findAll();
        Movie[] expected = {first, second, third, fourth, fifth,sixth,newMovie};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
     public void checkFindReverseMaxLimit() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        Movie[] actual = manager.findReverseMaxLimit(5);
        Movie[] expected = {sixth, fifth, fourth, third, second};
        Assertions.assertArrayEquals(expected, actual);
    }

}
