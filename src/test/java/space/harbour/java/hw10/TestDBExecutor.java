package space.harbour.java.hw10;

import com.mongodb.BasicDBObject;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import space.harbour.java.hw7.Movie;
public class TestDBExecutor extends TestCase
{
    MovieDBExecutor DBexecutor;
    @Before
    public void setUp() throws Exception
    {
    super.setUp();
    DBexecutor = new MovieDBExecutor();
    }

    @After
    public void tearDown() throws Exception
    {
        DBexecutor.execDeleteAll();
        DBexecutor.close();
        super.tearDown();
    }

    @Test
    public void testInsert()
    {
        DBexecutor.execInsert(new Movie().readFile("BladeRunner.json"));
        assertEquals(1, DBexecutor.execQuery(new BasicDBObject()).size());
    }
    @Test
    public void testInsertMultiple()
    {
        DBexecutor.execInsert(new Movie().readFile("BladeRunner.json"));
        DBexecutor.execInsert(new Movie().readFile("RaidersofTheLostArk.json"));
        assertEquals(2, DBexecutor.execQuery(new BasicDBObject()).size());
    }


    @Test
    public void testDeleteALL()
    {
        DBexecutor.execInsert(new Movie().readFile("BladeRunner.json"));
        DBexecutor.execInsert(new Movie().readFile("RaidersofTheLostArk.json"));
        assertEquals(2, DBexecutor.execQuery(new BasicDBObject()).size());
        DBexecutor.execDeleteAll();
        assertEquals(0, DBexecutor.execQuery(new BasicDBObject()).size());
    }

}
