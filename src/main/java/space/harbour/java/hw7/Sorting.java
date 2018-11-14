package space.harbour.java.hw7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    public void byYear(List<Movie> movies)
    {

        movies.sort(Comparator.comparingInt(Movie::getYear));
    }

    public void byRuntime(List<Movie> movies)
    {
        movies.sort(Comparator.comparingInt(Movie::getRuntime));
    }

    public void byRating(List<Movie> movies)
    {
        movies.sort(Comparator.comparing(movie ->
                Arrays.stream(movie.getRatings())
                        .filter(rating -> "Internet Movie Database".equals(rating.getSource())).findAny().get().getValue()));
    }

    public List<Movie> filterDirector(List<Movie> movies, Director director)
    {
        return movies.stream()
                .filter(movie -> movie.getDirector().getName().equals(director.getName()))
                .collect(Collectors.toList());
    }

    public List<Movie> filterActor(List<Movie> movies, Actor actor)
    {
        return movies.stream()
                .filter(movie -> Arrays.stream(movie.getActors()).anyMatch(a ->
                        actor.getName().equals(a.getName())))
                .collect(Collectors.toList());
    }

    public List<Movie> filterGenre(List<Movie> movies, String genre)
    {
        return movies.stream()
                .filter(movie -> Arrays.stream(movie.getGenres()).anyMatch(genre::equals))
                .collect(Collectors.toList());
    }

    public static void main(String[] args)
    {

    }
}