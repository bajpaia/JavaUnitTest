package space.harbpur.java.hw6;
import java.util.*;
class Element<K, V>implements Map.Entry<K, V>
{
    K key;
    V value;

    public Element(K key, V value) {
        this.key = key;
        this.value = value;
    }






    public K getKey()
    {
        return key;
    }

    public V getValue()
    {
        return value;
    }

    public V setValue(V value)
    {
        return this.value = value;
    }

}