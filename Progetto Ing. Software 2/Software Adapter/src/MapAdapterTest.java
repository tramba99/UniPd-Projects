/**
 * @author Luca Trambaiollo
 * @version 06/2020
 */

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;

public class MapAdapterTest
{
    private MapAdapter ma;

    @Before
    public void initialSet()
    {
        ma = new MapAdapter();
    }

    @Test
    public void testSize()
    {
        assertEquals(0, ma.size());

        ma.put(5, 5);
        assertEquals(1, ma.size());
    }

    @Test
    public void testIsEmpty()
    {
        assertTrue(ma.isEmpty());

        ma.put(5, 5);
        assertFalse( ma.isEmpty());
    }

    @Test
    public void testContainsKey()
    {
        assertFalse(ma.containsKey(5));

        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);

        assertTrue(ma.containsKey(5));
        assertTrue(ma.containsKey(9));
        assertTrue(ma.containsKey(4));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsKeyException()
    {
        ma.containsKey(null);
    }

    @Test
    public void testContainsValue()
    {
        assertFalse(ma.containsKey(5));

        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);

        assertTrue(ma.containsValue(5));
        assertTrue(ma.containsValue(9));
        assertTrue(ma.containsValue(4));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsValueException()
    {
        ma.containsValue(null);
    }

    @Test
    public void testGet()
    {
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);

        assertEquals(5, ma.get(5));
        assertEquals(9, ma.get(9));
        assertEquals(4, ma.get(4));
    }

    @Test(expected = NullPointerException.class)
    public void testGetException()
    {
        ma.get(null);
    }

    @Test
    public void testPut()
    {
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);

        assertEquals(3, ma.size());
        assertFalse(ma.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testPutException()
    {
        ma.put(null, null);
    }

    @Test
    public void testRemove()
    {
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);

        ma.remove(9);
        assertEquals(2, ma.size());
        assertFalse(ma.containsKey(9));
        assertFalse(ma.containsValue(9));

        ma.remove(5);
        ma.remove(4);
        assertTrue(ma.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveException()
    {
        ma.remove(null);
    }

    @Test
    public void testPutAll()
    {
        MapAdapter t = new MapAdapter();
        t.put(5,5);
        t.put(9,9);
        t.put(4,4);
        ma.putAll(t);
        assertEquals(3, ma.size());
        assertTrue(ma.containsKey(9));
        assertTrue(ma.containsValue(9));
    }

    @Test(expected = NullPointerException.class)
    public void testPutAllException()
    {
        ma.putAll(null);
    }

    @Test
    public void testClear()
    {
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);

        ma.clear();
        assertEquals(0, ma.size());
    }

    @Test
    public void testEquals()
    {
        MapAdapter t = new MapAdapter();
        t.put(5,5);
        t.put(9,9);
        t.put(4,4);
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);
        assertFalse(ma.entrySet().equals(t));
    }

    @Test
    public void testHashCode()
    {
        MapAdapter t = new MapAdapter();
        t.put(5,5);
        t.put(9,9);
        t.put(4,4);
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);
        assertEquals(ma.hashCode(), t.hashCode());
    }

    @Test
    public void testGetKeyEntry()
    {
        MapAdapter.Entry e = new MapAdapter.Entry(7, 7);
        assertEquals(7, e.getKey());
    }

    @Test
    public void testGetValueEntry()
    {
        MapAdapter.Entry e = new MapAdapter.Entry(5, 5);
        assertEquals(5, e.getValue());
    }

    @Test
    public void testSetValueEntry()
    {
        MapAdapter.Entry e = new MapAdapter.Entry(5, 5);
        e.setValue(9);
        assertEquals(9, e.getValue());
    }

    @Test(expected = NullPointerException.class)
    public void testSetValueEntryException()
    {
        MapAdapter.Entry e = new MapAdapter.Entry(5, 5);
        e.setValue(null);
    }

    @Test
    public void testEqualsEntry()
    {
        MapAdapter.Entry e = new MapAdapter.Entry(5, 5);
        MapAdapter.Entry en = new MapAdapter.Entry(5, 5);
        assertTrue(e.equals(en));
    }

    @Test
    public void testHashCodeEntry()
    {
        MapAdapter.Entry e = new MapAdapter.Entry(5, 5);
        MapAdapter.Entry en = new MapAdapter.Entry(5, 5);
        assertEquals(e.hashCode(), en.hashCode());
    }

    @Test
    public void testToSting()
    {
        MapAdapter.Entry e = new MapAdapter.Entry(5, 5);
        assertEquals("5: 5", e.toString());
    }

    @Test
    public void testEntrySet()
    {
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);
        ma.put(10,10);

        Set s = ma.entrySet();
        MapAdapter.Entry e = new MapAdapter.Entry(5, 5);
        assertTrue(s.contains(e));
        s.remove(e);
        assertFalse(s.contains(e));
        MapAdapter.Entry e1 = new MapAdapter.Entry(9, 9);
        MapAdapter.Entry e2 = new MapAdapter.Entry(4, 4);
        MapAdapter.Entry e3 = new MapAdapter.Entry(10, 10);
        Set c =  ma.entrySet();
        assertTrue(s.equals(c));
        assertTrue(s.containsAll(c));
        assertTrue(s.removeAll(c));

        assertEquals(0, s.size());
        assertTrue(s.isEmpty());
        assertTrue(ma.isEmpty());


        //Test per iteratore
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);
        ma.put(10,10);
        Set sa = ma.entrySet();
        Iterator iter = sa.iterator();
        MapAdapter.Entry e4 = new MapAdapter.Entry(9, 9);
        MapAdapter.Entry e5 = new MapAdapter.Entry(4, 4);
        MapAdapter.Entry e6 = new MapAdapter.Entry(10, 10);
        MapAdapter.Entry e7 = new MapAdapter.Entry(5, 5);
        assertTrue(iter.hasNext());
        assertEquals(e6, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(e4, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(e7, iter.next());
        iter.remove();
        assertFalse(sa.contains(e7));
        assertEquals(3, sa.size());
    }

    @Test
    public void testKeySet()
    {
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);
        ma.put(10,10);

        Set s = ma.keySet();
        assertTrue(s.contains(5));
        s.remove(5);
        assertFalse(s.contains(5));
        assertEquals(3, s.size());

        Set c =  ma.keySet();
        assertTrue(s.equals(c));
        assertTrue(s.containsAll(c));
        assertTrue(s.removeAll(c));

        assertEquals(0, s.size());
        assertTrue(s.isEmpty());
        assertTrue(ma.isEmpty());


        //Test per iteratore
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);
        ma.put(10,10);
        Set sa = ma.keySet();
        Iterator iter = sa.iterator();
        assertTrue(iter.hasNext());
        assertEquals(10, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(9, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(5, iter.next());
        iter.next();
        iter.remove();
        assertFalse(sa.contains(4));
        assertEquals(3, sa.size());
    }

    @Test
    public void testValues()
    {
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);
        ma.put(10,10);

        Collection s = ma.values();
        assertTrue(s.contains(5));
        s.remove(5);
        assertFalse(s.contains(5));
        assertEquals(3, s.size());

        Collection c =  ma.values();
        assertTrue(s.equals(c));
        assertTrue(s.containsAll(c));
        assertTrue(s.removeAll(c));

        assertEquals(0, s.size());
        assertTrue(s.isEmpty());
        assertTrue(ma.isEmpty());

        //Test per iteratore
        ma.put(5,5);
        ma.put(9,9);
        ma.put(4,4);
        ma.put(10,10);
        Collection sa = ma.values();
        Iterator iter = sa.iterator();
        assertTrue(iter.hasNext());
        assertEquals(10, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(9, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(5, iter.next());
        iter.next();
        iter.remove();
        assertFalse(sa.contains(4));
        assertEquals(3, sa.size());
    }
}


