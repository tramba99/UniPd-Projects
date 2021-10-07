/**
 * @author Luca Trambaiollo
 * @version 06/2020
 */

import java.util.Collection;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Iterator;

public class SetAdapter implements java.util.Set
{
    private Hashtable h = new Hashtable();

    /**
     * Returns the number of elements in this set (its cardinality). If this set contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     * @return the number of elements in this set (its cardinality).
     */
    public int size()
    {
        return h.size();
    }

    /**
     * Returns true if this set contains no elements.
     * @return true if this set contains no elements.
     */
    public boolean isEmpty()
    {
        return h.size() == 0;
    }

    /**
     * Returns true if this set contains the specified element. More formally, returns true if and only if this set contains an element e such that (o==null ? e==null : o.equals(e)).
     * @param o - element whose presence in this set is to be tested.
     * @return true if this set contains the specified element.
     * @exception NullPointerException - if the specified element is null and this set does not support null elements .
     *
     */
    public boolean contains(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException();
        }
        return h.contains(o);
    }

    /**
     * Returns an iterator over the elements in this set. The elements are returned in no particular order (unless this set is an instance of some class that provides a guarantee).
     * @return an iterator over the elements in this set.
     */
    public Iterator iterator()
    {
        return new SetAdapterIterator(h);
    }

    /**
     * Returns an array containing all of the elements in this set. Obeys the general contract of the Collection.toArray method.
     * @return an array containing all of the elements in this set.
     */
    public Object[] toArray()
    {
        Object[] o = new Object[h.size()];
        Enumeration e = h.elements();
        for (int i = 0; i < o.length; i++)
        {
            if (e.hasMoreElements())
                o[i] = e.nextElement();
        }
        return o;
    }

    /**
     * Returns an array containing all of the elements in this set; the runtime type of the returned array is that of the specified array. Obeys the general contract of the Collection.toArray(Object[]) method.
     * @param a - the array into which the elements of this set are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose.
     * @return an array containing the elements of this set.
     * @exception UnsupportedOperationException
     */
    public Object[] toArray(Object[] a) throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds the specified element to this set if it is not already present. More formally, adds the specified element, o, to this set if this set contains no element e such that (o==null ? e==null : o.equals(e)). If this set already contains the specified element, the call leaves this set unchanged and returns false. In combination with the restriction on constructors, this ensures that sets never contain duplicate elements.
     * @param o - element to be added to this set.
     * @return true if this set did not already contain the specified element.
     * @exception NullPointerException - if the specified element is null and this set does not support null elements.
     */
    public boolean add(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException();
        }
        if (h.contains(o))
        {
            return false;
        }
        else
        {
            h.put(o, o);
            return true;
        }
    }

    /**
     * Removes the specified element from this set if it is present. More formally, removes an element e such that (o==null ? e==null : o.equals(e)), if the set contains such an element. Returns true if the set contained the specified element (or equivalently, if the set changed as a result of the call). (The set will not contain the specified element once the call returns.)
     * @param o - object to be removed from this set, if present.
     * @return true if the set contained the specified element.
     * @exception NullPointerException - if the specified element is null and this set does not support null elements.
     */
    public boolean remove(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException();
        }
        if (h.contains(o))
        {
            h.remove(o,o);
            return true;
        }
        else
            return false;
    }

    /**
     * Returns true if this set contains all of the elements of the specified collection. If the specified collection is also a set, this method returns true if it is a subset of this set.
     * @param c - collection to be checked for containment in this set.
     * @return true if this set contains all of the elements of the specified collection.
     * @exception NullPointerException - if the specified collection is null.
     */
    public boolean containsAll(Collection c)
    {
        if (c==null)
        {
            throw new NullPointerException();
        }
        boolean b = true;
        Object[] o = c.toArray();
        for (int i = 0; i < o.length && b == true; i++)
        {
            if (contains(o[i]))
                b = true;
            else
            {
                b = false;
            }
        }
        return b;
    }

    /**
     * Adds all of the elements in the specified collection to this set if they're not already present. If the specified collection is also a set, the addAll operation effectively modifies this set so that its value is the union of the two sets. The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress.
     * @param c - collection whose elements are to be added to this set.
     * @return true if this set changed as a result of the call.
     * @exception NullPointerException - if the specified collection is null.
     */
    public boolean addAll(Collection c)
    {
        if (c==null)
        {
            throw new NullPointerException();
        }
        boolean b = false;
        Object[] o = c.toArray();
        for(int i = 0; i < o.length; i++)
        {
            if (contains(o[i]))
                b = b || false;
            else
            {
                h.put(o[i], o[i]);
                b = b || true;
            }
        }
        return b;
    }

    /**
     * Retains only the elements in this set that are contained in the specified collection. In other words, removes from this set all of its elements that are not contained in the specified collection. If the specified collection is also a set, this operation effectively modifies this set so that its value is the intersection of the two sets.
     * @param c - collection that defines which elements this set will retain.
     * @return true if this collection changed as a result of the call.
     * @exception NullPointerException - if the specified collection is null.
     */
    public boolean retainAll(Collection c)
    {
        if (c==null)
        {
            throw new NullPointerException();
        }
        Object[] o = c.toArray();
        boolean b = false;
        clear();
        for(int i = 0; i < o.length; i++)
        {
            h.put(o[i], o[i]);
            b = b || true;
        }
        return b;
    }

    /**
     * Removes from this set all of its elements that are contained in the specified collection. If the specified collection is also a set, this operation effectively modifies this set so that its value is the asymmetric set difference of the two sets.
     * @param c - collection that defines which elements will be removed from this set.
     * @return true if this set changed as a result of the call.
     * @exception NullPointerException - if the specified collection is null.
     */
    public boolean removeAll(Collection c)
    {
        if (c==null)
        {
            throw new NullPointerException();
        }
        boolean b = false;
        Object[] o = c.toArray();
        for(int i = 0; i < o.length; i++)
        {
            if (contains(o[i]))
            {
                h.remove(o[i]);
                b = b || true;
            }
            else
                b = b || false;
        }
        return b;
    }

    /**
     * Removes all of the elements from this set. This set will be empty after this call returns (unless it throws an exception).
     */
    public void clear()
    {
        h.clear();
    }

    /**
     * Compares the specified object with this set for equality. Returns true if the specified object is also a set, the two sets have the same size, and every member of the specified set is contained in this set (or equivalently, every member of this set is contained in the specified set). This definition ensures that the equals method works properly across different implementations of the set interface.
     * @param o - Object to be compared for equality with this set.
     * @return true if the specified Object is equal to this set.
     */
    public boolean equals(Object o)
    {
        boolean b = true;
        Object[] obj = ((SetAdapter)o).toArray();
        if(SetAdapter.class.isInstance(o))
        {
            if (((SetAdapter)o).size() == size())
            {
                for(int i = 0; i < size(); i++)
                    b = b && contains(obj[i]);
                return b;
            }
            else
                return false;
        }
        else
            return false;
    }

    /**
     * Returns the hash code value for this set. The hash code of a set is defined to be the sum of the hash codes of the elements in the set, where the hashcode of a null element is defined to be zero. This ensures that s1.equals(s2) implies that s1.hashCode()==s2.hashCode() for any two sets s1 and s2, as required by the general contract of the Object.hashCode method.
     * @return the hash code value for this set.
     */
    public int hashCode()
    {
        Object[] o = toArray();
        int a = 0;
        for(int i = 0; i < size(); i ++)
            a = a + o[i].hashCode();
        return a;
    }
}


