/**
 * @author Luca Trambaiollo
 * @version 06/2020
 */

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;

public class SetAdapterTest
{
    private SetAdapter sa;

    @Before
    public void initialSet()
    {
        sa = new SetAdapter();
    }

    @Test
    public void testSize()
    {
        assertEquals(0, sa.size());

        sa.add(5);
        assertEquals(1, sa.size());
    }

    @Test
    public void testIsEmpty()
    {
        assertTrue(sa.isEmpty());

        sa.add(5);
        assertFalse( sa.isEmpty());
    }

    @Test
    public void testContains()
    {
        Object o = new Object();
        assertFalse(sa.contains(o));

        sa.add(o);
        assertTrue(sa.contains(o));
    }

    @Test (expected = NullPointerException.class)
    public void testContainsException()
    {
        sa.contains(null);
    }

    @Test
    public void testToArray()
    {
        int a = 3;
        sa.add(1);
        sa.add(2);
        sa.add(3);
        Object[] o = sa.toArray();
        for(int i= 0; i < o.length; i ++)
            assertEquals(o[i], a--);
    }

    @Test
    public void testAdd()
    {
        Object o = new Object();
        assertFalse(sa.contains(o));

        sa.add(o);
        assertTrue(sa.contains(o));
        assertEquals(1, sa.size());

        sa.add(1);
        assertTrue(sa.contains(1));
        assertEquals(2, sa.size());

        assertFalse(sa.add(o));
        assertFalse(sa.isEmpty());
    }

    @Test (expected = NullPointerException.class)
    public void testAddException()
    {
        Object o = null;
        sa.add(o);
    }

    @Test
    public void testRemove()
    {
        Object o = new Object();
        sa.add(o);
        assertTrue(sa.remove(o));
        assertEquals(0, sa.size());
        assertFalse(sa.remove(o));

        assertFalse(sa.contains(o));
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveException()
    {
        Object o = null;
        sa.remove(o);
    }

    @Test
    public void testContainsAll()
    {
        Collection c = new SetAdapter();
        c.add(1);
        c.add(2);
        sa.add(1);
        sa.add(2);
        assertTrue(sa.containsAll(c));

        c.add(3);
        assertFalse(sa.containsAll(c));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsAllException()
    {
        Collection c = null;
        sa.containsAll(c);
    }

    @Test
    public void testAddAll()
    {
        Collection c = new SetAdapter();
        c.add(1);
        c.add(2);
        assertTrue(sa.addAll(c));
        assertTrue(sa.contains(1));
        assertTrue(sa.contains(2));
        assertEquals(2, sa.size());
        assertFalse(sa.addAll(c));
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllException()
    {
        Collection c = null;
        sa.addAll(c);
    }

    @Test
    public void testRetainAll()
    {
        Collection c = new SetAdapter();
        c.add(1);
        c.add(2);
        sa.add(2);
        sa.add(1);
        sa.add(3);
        assertTrue(sa.retainAll(c));
        assertFalse(sa.contains(3));
        assertTrue(sa.contains(1));
        assertTrue(sa.contains(2));
        assertEquals(2, sa.size());
    }

    @Test (expected = NullPointerException.class)
    public void testRetainAllException()
    {
        Collection c = null;
        sa.retainAll(c);
    }

    @Test
    public void testRemoveAll()
    {
        Collection c = new SetAdapter();
        c.add(1);
        c.add(2);
        sa.add(2);
        sa.add(1);
        sa.add(3);
        assertTrue(sa.removeAll(c));
        assertTrue(sa.contains(3));
        assertFalse(sa.contains(1));
        assertFalse(sa.contains(2));
        assertFalse(sa.removeAll(c));
        assertEquals(1, sa.size());
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveAllException()
    {
        Collection c = null;
        sa.removeAll(c);
    }

    @Test
    public void testClear()
    {
        sa.add(1);
        sa.add(2);
        sa.clear();
        assertTrue(sa.isEmpty());
        assertEquals(0, sa.size());
    }

    @Test
    public void testEquals()
    {
        SetAdapter o = new SetAdapter();
        o.add(1);
        o.add(2);
        sa.add(1);
        sa.add(2);
        assertTrue(sa.equals(o));
        assertEquals(o.size(), sa.size());

        o.add(3);
        assertFalse(sa.equals(o));
    }

    @Test
    public void testHashCode()
    {
        Set s = new SetAdapter();
        sa.add(3);
        sa.add(4);
        s.add(3);
        s.add(4);
        //System.out.println(sa.hashCode());
        //System.out.println(s.hashCode());
        assertEquals(s.hashCode(), sa.hashCode());

        sa.add(5);
        assertNotEquals(s.hashCode(), sa.hashCode());
    }

    @Test
    public void testHasNextIterator()
    {
        sa.add(1);
        sa.add(2);
        sa.add(3);
        Iterator sai = sa.iterator();
        sai.next();
        assertTrue(sai.hasNext());
        sai.next();
        assertTrue(sai.hasNext());
        sai.next();
        assertFalse(sai.hasNext());
    }

    @Test
    public void testNextIterator()
    {
        sa.add(1);
        sa.add(2);
        sa.add(3);
        Iterator sai = sa.iterator();
        assertEquals(3, sai.next());
        assertEquals(2, sai.next());
        assertEquals(1, sai.next());
    }

    @Test
    public void testRemoveIterator()
    {
        sa.add(1);
        sa.add(2);
        sa.add(3);
        Iterator sai = sa.iterator();
        sai.next();
        sai.remove();

        assertEquals(2, sa.size());
        assertFalse(sa.contains(3));
        assertTrue(sa.contains(2));
        assertTrue(sa.contains(1));

        sai.next();
        sai.remove();
        assertEquals(1, sa.size());
        assertFalse(sa.contains(3));
        assertFalse(sa.contains(2));
        assertTrue(sa.contains(1));
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveIteratorException()
    {
        sa.add(1);
        sa.add(2);
        sa.add(3);
        Iterator sai = sa.iterator();
        sai.remove();
        sai.remove();
    }
}


