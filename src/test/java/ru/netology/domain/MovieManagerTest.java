package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;

import static org.mockito.Mockito.*;


public class MovieManagerTest {
    private MoviesRepository repository = Mockito.mock(MoviesRepository.class);
    private MovieManager manager = new MovieManager(repository, 10);
    Movie first = new Movie(1,"Бладшот", "боевик", "URL1", "01.01.2011");
    Movie second = new Movie(2,"Вперед", "мультфильм", "URL2", "01.02.2012");
    Movie third = new Movie(3,"Отель 'Белград'", "комедия", "URL3", "01.03.2013");
    Movie fourth = new Movie(4,"Джентельмены", "боевик", "URL4", "01.04.2014");
    Movie fifth = new Movie(5,"Человек-невидимка", "ужасы", "URL5", "01.05.2015");
    Movie sixth = new Movie(6,"Тролли. Мировой тур", "мультфильм", "URL6", "01.06.2016");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        Movie[] returned = {first,second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();
    }
    @Test
    public void checkFindAll() {
        Movie[] actual = manager.findAll();
        Movie[] expected = {first, second, third, fourth, fifth,sixth};
        Assertions.assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
    @Test
    public void checkAddingRepository() {
        Movie newMovie = new Movie(7, "Номер один", "комедия", "URL7", "01.07.2017");
        Movie[] returned = {first,second, third, fourth, fifth, sixth, newMovie};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(newMovie);
        repository.save(newMovie);
        Movie[] actual = repository.findAll();
        Movie[] expected = {first, second, third, fourth, fifth,sixth,newMovie};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void checkFindReverseMaxLimit() {
        MovieManager manager = new MovieManager(5);
        Movie[] returned = {sixth, fifth, fourth, third, second};
        doReturn(returned).when(repository).findReverseMaxLimit(5);
        Movie[] actual = repository.findReverseMaxLimit(5);
        Movie[] expected = {sixth, fifth, fourth, third, second};
        Assertions.assertArrayEquals(expected, actual);
        verify(repository).findReverseMaxLimit(5);
    }
    @Test
    public void checkFindById() {
        MovieManager manager = new MovieManager();
        Movie[] returnedById = {second};
        doReturn(returnedById).when(repository).findById(2);
        Movie[] actual = repository.findById(2);
        Movie[] expected = {second};
        Assertions.assertArrayEquals(expected, actual);
        verify(repository).findById(2);
    }
    @Test
    public void checkRemoveFindById() {
        Movie[] returned = {first,second, fourth, fifth, sixth};
        doReturn(returned).when(repository).removeById(3);
        Movie[] actual = repository.removeById(3);
        Movie[] expected = {first, second, fourth, fifth,sixth};
        Assertions.assertArrayEquals(expected, actual);
        verify(repository).removeById(3);
    }
    @Test
    public void checkRemoveAll() {
        Movie[] returned = {};
        doReturn(returned).when(repository).removeAll();
        Movie[] actual = repository.removeAll();;
        Movie[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
        verify(repository).removeAll();
    }

}