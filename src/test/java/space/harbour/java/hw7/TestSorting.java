package space.harbour.java.hw7;
import org.junit.*;
import java.util.*;
import junit.framework.TestCase;
public class TestSorting extends TestCase
{
    Sorting sorter;
    List<Movie> movies;

    @Before
    public void setUp() throws Exception
    {
        super.setUp();
        sorter = new Sorting();
        movies = new ArrayList<>();
        movies.add(new Movie().readFile("BladeRunner.json"));

    }
    @Test
    public void testByReleaseFunc()
    {
        assertEquals("Blade Runner", movies.get(0).getTitle());
        sorter.byYear(movies);
        assertEquals("Blade Runner", movies.get(0).getTitle());
    }
    public void testByRuntimefunc() {
        assertEquals("Blade Runner", movies.get(0).getTitle());

        sorter.byRuntime(movies);
        assertEquals("Blade Runner", movies.get(0).getTitle());
    }

    @Test
    public void testSortByRating() {
        assertEquals("Blade Runner", movies.get(0).getTitle());
        sorter.byRating(movies);
        assertEquals("Blade Runner", movies.get(0).getTitle());
    }
    @Test
    public void testFilterByGenre()
    {
        assertEquals("Blade Runner", movies.get(0).getTitle());
        movies = sorter.filterGenre(movies, "Thriller");

        assertEquals(1, movies.size());

    }

    @Test
    public void testFilterByDirector()
    {
        assertEquals("Blade Runner", movies.get(0).getTitle());
        Director director = new Director();
        director.setName("Alfred Hitchcock");
        movies = sorter.filterDirector(movies, director);

        assertEquals(0, movies.size());
    }

    @Test
    public void testFilterByActor()
    {
        assertEquals("Blade Runner", movies.get(0).getTitle());


        Actor actor = new Actor();
        actor.setName("Andrew Garfield");
        movies = sorter.filterActor(movies, actor);
        assertEquals(0, movies.size());

    }
}
