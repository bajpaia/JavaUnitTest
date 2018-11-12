package space.harbpur.java.hw6;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestMyHashMap
{
    private MyHashMap<String, String> map;

    @Test
    public void testEmptyTable()
    {
        map = new MyHashMap<>();
        assertTrue(map.isEmpty());
    }

    @Test
    public void testValueInsertion()
    {
        map = new MyHashMap<>();
        assertTrue(map.isEmpty());
        map.put("1", "Me");
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
    }

    @Test
    public void testNotEmptyTable()
    {
        map = new MyHashMap<>();
        map.put("1", "Me");
        map.put("2", "Myself");
        map.put("3", "I");
        assertFalse(map.isEmpty());
    }

    @Test
    public void testMultipleEntries()
    {
        map = new MyHashMap<>();

        map.put("1", "Me");
        map.put("2", "Myself");
        map.put("3", "I");
        assertEquals(3, map.size());
    }

    @Test
    public void testCollisions()
    {
        map = new MyHashMap<>();
        map.put("1", "Me");
        map.put("1", "Myself");
        assertEquals(2, map.size());
    }

    @Test
    public void testSearchKeyFalse()
    {
        map = new MyHashMap<>();
        assertFalse(map.containsKey(""));
    }

    @Test
    public void testSearchKeyTrue()
    {
        map = new MyHashMap<>();
        map.put("1", "Me");
        map.put("2", "Myself");
        map.put("3", "I");
        assertTrue(map.containsKey("1"));
    }

    @Test
    public void testGetEmptyMap()
    {
        map = new MyHashMap<>();
        assertNull(map.get("1"));
    }

    @Test
    public void testGetFunc()
    {
        map = new MyHashMap<>();
        map.put("1", "Me");
        map.put("2", "Myself");
        map.put("3", "I");
        assertNotNull(map.get("1"));
        assertEquals("Me", map.get("1"));
    }


    @Test
    public void testRemoveFuncEmptyMap()
    {
        map = new MyHashMap<>();
        assertNull(map.remove("1"));
    }

    @Test
    public void testRemoveKey()
    {
        map = new MyHashMap<>();
        map.put("1", "Me");
        assertEquals("Me",map.remove("1"));
        assertEquals(0, map.size());
    }

    @Test
    public void testRemoveCollision()
    {
        map = new MyHashMap<>();
        map.put("1", "Me");
        map.put("1", "Myself");
        assertEquals(2, map.size());
        assertEquals("Me", map.remove("1"));
        assertEquals(1, map.size());
    }

    @Test
    public void testClear()
    {
        map = new MyHashMap<>();
        assertTrue(map.isEmpty());
        map.put("1", "Me");
        assertFalse(map.isEmpty());
        map.clear();
        assertTrue(map.isEmpty());
    }

}
