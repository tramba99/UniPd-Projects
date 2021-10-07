/**
 * @author Luca Trambaiollo
 * @version 06/2020
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class ListAdapterTest
{
    private ListAdapter la;

    @Before
    public void initialSet()
    {
        la = new ListAdapter();
    }

    @Test
    public void testSize()
    {
        assertEquals(0, la.size());

        la.add(1);
        assertEquals(1, la.size());
    }

    @Test
    public void testIsEmpty()
    {
        assertTrue(la.isEmpty());

        la.add(5);
        assertFalse(la.isEmpty());
    }

    @Test
    public void testContains()
    {
        Object o = new Object();
        assertFalse(la.contains(o));

        la.add(o);
        assertTrue(la.contains(o));
    }

    @Test (expected = NullPointerException.class)
    public void testContainsException()
    {
        Object o = null;
        la.add(o);
        la.contains(o);
    }

    @Test
    public void testToArray()
    {
        int a = 1;
        la.add(1);
        la.add(2);
        la.add(3);
        Object[] o = la.toArray();
        for(int i= 0; i < o.length; i ++)
            assertEquals(o[i], a++);
    }

    @Test
    public void testAdd1()
    {
        Object o = new Object();
        assertFalse(la.contains(o));

        la.add(o);
        assertTrue(la.contains(o));
        assertEquals(1, la.size());

        la.add(1);
        assertTrue(la.contains(1));
        assertEquals(2, la.size());

        assertTrue(la.add(o));
        assertEquals(3, la.size());

        assertFalse(la.isEmpty());
    }

    @Test (expected = NullPointerException.class)
    public void testAdd1Exception()
    {
        Object o = null;
        la.add(o);
    }

    @Test
    public void testRemove()
    {
        Object o = new Object();
        la.add(o);
        la.add(o);
        assertTrue(la.remove(o));
        assertEquals(1, la.size());
        assertTrue(la.remove(o));
        assertEquals(0, la.size());
        assertFalse(la.remove(o));

        assertFalse(la.contains(o));
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveException()
    {
        Object o = null;
        la.remove(o);
    }

    @Test
    public void testContainsAll()
    {
        Collection c = new ListAdapter();
        c.add(1);
        c.add(2);
        la.add(1);
        la.add(2);
        assertTrue(la.containsAll(c));

        c.add(3);
        assertFalse(la.containsAll(c));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsAllException()
    {
        Collection c = null;
        la.containsAll(c);
    }

    @Test
    public void testAddAll1()
    {
        Collection c = new ListAdapter();
        c.add(1);
        c.add(2);
        assertTrue(la.addAll(c));
        assertTrue(la.contains(1));
        assertTrue(la.contains(2));
        assertEquals(2, la.size());
        assertTrue(la.addAll(c));
        assertEquals(4, la.size());
    }

    @Test(expected = NullPointerException.class)
    public void testAddAll1Exception()
    {
        Collection c = null;
        la.addAll(c);
    }

    @Test
    public void testAddAll2()
    {
        Collection c = new ListAdapter();
        c.add(1);
        c.add(2);
        la.add(5);
        la.add(7);
        assertTrue(la.addAll(1, c));
        assertTrue(la.contains(1));
        assertTrue(la.contains(2));
        assertEquals(4, la.size());

        assertEquals(5, la.get(0));
        assertEquals(2, la.get(1));
        assertEquals(1, la.get(2));
        assertEquals(7, la.get(3));
    }

    @Test(expected = NullPointerException.class)
    public void testAddAll2Exception1()
    {
        Collection c = null;
        la.addAll(0, c);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAll2Exception2()
    {
        Collection c = new ListAdapter();
        c.add(1);
        c.add(2);
        la.add(5);
        la.add(7);
        la.addAll(3, c);
    }

    @Test
    public void testRemoveAll()
    {
        Collection c = new ListAdapter();
        c.add(1);
        c.add(2);
        la.add(2);
        la.add(1);
        la.add(3);
        assertTrue(la.removeAll(c));
        assertTrue(la.contains(3));
        assertFalse(la.contains(1));
        assertFalse(la.contains(2));
        assertFalse(la.removeAll(c));
        assertEquals(1, la.size());
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveAllException()
    {
        Collection c = null;
        la.removeAll(c);
    }

    @Test
    public void testRetainAll()
    {
        Collection c = new ListAdapter();
        c.add(1);
        c.add(2);
        la.add(2);
        la.add(1);
        la.add(3);
        assertTrue(la.retainAll(c));
        assertFalse(la.contains(3));
        assertTrue(la.contains(1));
        assertTrue(la.contains(2));
        assertEquals(2, la.size());
    }

    @Test (expected = NullPointerException.class)
    public void testRetainAllException()
    {
        Collection c = null;
        la.retainAll(c);
    }

    @Test
    public void testClear()
    {
        la.add(1);
        la.add(2);
        la.clear();
        assertTrue(la.isEmpty());
        assertEquals(0, la.size());
    }

    @Test
    public void testEquals()
    {
        ListAdapter l = new ListAdapter();
        l.add(1);
        l.add(2);
        la.add(1);
        la.add(2);
        assertTrue(la.equals(l));
        assertEquals(l.size(), la.size());

        l.add(3);
        assertFalse(la.equals(l));
    }

    @Test
    public void testHashCode()
    {
        List l = new ListAdapter();
        la.add(3);
        la.add(4);
        l.add(3);
        l.add(4);
        //System.out.println(la.hashCode());
        //System.out.println(l.hashCode());
        assertEquals(l.hashCode(), la.hashCode());

        la.add(5);
        assertNotEquals(l.hashCode(), la.hashCode());
    }

    @Test
    public void testGet()
    {
        int index1 = 0;
        int index2 = 2;
        la.add(7);
        la.add(9);
        la.add(11);
        la.add(18);
        assertEquals(7, la.get(index1));
        assertEquals(11, la.get(index2));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetException()
    {
        la.add(7);
        la.get(1);
    }

    @Test
    public void testSet()
    {
        la.add(1);
        la.add(2);
        la.add(3);
        assertEquals(1, la.set(0, 7));
        assertEquals(2, la.set(1, 5));
        assertEquals(3, la.set(2, 9));

        assertEquals(7, la.get(0));
        assertEquals(5, la.get(1));
        assertEquals(9, la.get(2));
    }

    @Test(expected = NullPointerException.class)
    public void testSetException1()
    {
        la.add(1);
        la.set(0, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException2()
    {
        la.set(1, 10);
    }

    @Test
    public void testAdd2()
    {
        la.add(0, 8);
        la.add(1, 6);
        la.add(1, 10);
        la.add(1, 9);
        assertEquals(4, la.size());
        assertTrue(la.contains(8));
        assertTrue(la.contains(6));
        assertTrue(la.contains(10));
        assertTrue(la.contains(9));

        assertEquals(8 , la.get(0));
        assertEquals(9 , la.get(1));
        assertEquals(10 , la.get(2));
        assertEquals(6 , la.get(3));

    }

    @Test(expected = NullPointerException.class)
    public void testAdd2Exception1()
    {
        la.add(0, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd2Exception2()
    {
        la.set(1, 10);
    }

    @Test
    public void testRemove2()
    {
        la.add(1);
        la.add(2);
        la.add(3);
        la.remove(1);
        assertEquals(2, la.size());
        assertTrue(la.contains(1));
        assertTrue(la.contains(3));
        assertFalse(la.contains(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemove2Exception()
    {
        la.add(10);
        la.remove(1);
    }

    @Test
    public void testIndexOf()
    {
        la.add(3);
        la.add(5);
        la.add(9);
        la.add(5);
        assertEquals(1, la.indexOf(5));
        assertEquals(-1, la.indexOf(7));
    }

    @Test(expected = NullPointerException.class)
    public void testIndexOfException()
    {
        la.indexOf(null);
    }

    @Test
    public void testLastIndexOf()
    {
        la.add(3);
        la.add(5);
        la.add(9);
        la.add(5);
        assertEquals(3, la.lastIndexOf(5));
        assertEquals(-1, la.lastIndexOf(7));
    }

    @Test(expected = NullPointerException.class)
    public void testLastIndexOfException()
    {
        la.lastIndexOf(null);
    }

    @Test
    public void testSubList()
    {
        Object a = 1;
        Object b = 2;
        Object c = 3;
        Object d = 4;
        Object e = 5;
        Object f = 6;
        Object g = 7;

        la.add(a);
        la.add(b);
        la.add(c);
        la.add(d);
        la.add(e);
        la.add(f);
        la.add(g);
        List sublist = la.subList(1, 5);

        assertEquals(4, sublist.size());
        assertEquals(0, sublist.indexOf(b));
        assertEquals(1, sublist.indexOf(c));
        assertEquals(2, sublist.indexOf(d));
        assertEquals(3, sublist.indexOf(e));

        sublist.add(g);
        assertEquals(5, sublist.size());
        assertFalse(sublist.isEmpty());

        sublist.remove(d);
        assertEquals(4, sublist.size());
        assertFalse(sublist.contains(d));
        assertEquals(3, sublist.get(1));
        sublist.set(0, g);
        assertEquals(7, sublist.get(0));


        Iterator iter = sublist.iterator(); //Iterator per la sublist
        assertTrue(iter.hasNext());
        assertEquals(sublist.get(0), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(sublist.get(1), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(sublist.get(2), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(sublist.get(3), iter.next());

        iter = sublist.iterator();
        iter.next();
        iter.remove();
        assertEquals(3, sublist.size());

        sublist.add(20);
        assertTrue(la.contains(20));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testSublistException()
    {
        la.add(1);
        la.add(2);
        la.add(3);
        la.add(4);
        la.add(5);
        la.add(6);
        la.add(7);
        la.add(8);
        List sublist = la.subList(9, 11);
    }


    @Test
    public void testHasNextListIterator()
    {
        la.add(1);
        la.add(2);
        la.add(3);
        ListIterator lali = la.listIterator();
        lali.next();
        assertTrue(lali.hasNext());
        lali.next();
        assertTrue(lali.hasNext());
        lali.next();
        assertFalse(lali.hasNext());
    }

    @Test
    public void testNextListIterator()
    {
        la.add(1);
        la.add(2);
        la.add(3);
        ListIterator lali = la.listIterator();
        assertEquals(1, lali.next());
        assertEquals(2, lali.next());
        assertEquals(3, lali.next());
    }

    @Test
    public void testHasPreviousListIterator()
    {
        la.add(1);
        la.add(2);
        la.add(3);
        ListIterator lali = la.listIterator();
        lali.next();
        lali.next();
        lali.next();
        lali.previous();
        assertTrue(lali.hasPrevious());
        lali.previous();
        assertTrue(lali.hasPrevious());
        lali.previous();
        assertFalse(lali.hasPrevious());
    }

    @Test
    public void testPreviousListIterator()
    {
        la.add(1);
        la.add(2);
        la.add(3);
        ListIterator lali = la.listIterator();
        lali.next();
        lali.next();
        lali.next();
        assertEquals(3, lali.previous());
        assertEquals(2, lali.previous());
        assertEquals(1, lali.previous());
    }

    @Test
    public void testRemoveListIterator()
    {
        la.add(1);
        la.add(2);
        la.add(3);
        ListIterator lali = la.listIterator();
        lali.next();
        lali.remove();

        assertEquals(2, la.size());
        assertTrue(la.contains(1));
        assertFalse(la.contains(2));
        assertTrue(la.contains(3));

        lali.next();
        lali.remove();
        assertEquals(1, la.size());
        assertTrue(la.contains(1));
        assertFalse(la.contains(2));
        assertFalse(la.contains(3));
    }

    @Test
    public void testSetListIterator()
    {
        la.add(1);
        la.add(2);
        la.add(3);
        ListIterator lali = la.listIterator();
        lali.next();
        lali.next();
        lali.set(7);
        lali.previous();
        lali.set(10);
        assertTrue(la.contains(7));
        assertTrue(la.contains(10));
        assertTrue(la.contains(3));
    }

    @Test
    public void testAddListIterator()
    {
        la.add(1);
        la.add(2);
        la.add(3);
        ListIterator lali = la.listIterator();

        lali.next();
        lali.add(10);
        assertEquals(4, la.size());
        assertEquals(1, la.get(0));
        assertEquals(10, la.get(1));
        assertEquals(2, la.get(2));
        assertEquals(3, la.get(3));
    }
}


