/**
 * @author Luca Trambaiollo
 * @version 06/2020
 */

import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class ListAdapter implements java.util.List
{
    private Vector v;
    private int from;
    private int to;

    public ListAdapter()
    {
        v = new Vector();
        from = 0;
        to = 0;
    }

    public ListAdapter(Vector v, int fr, int t)
    {
        this.v = v;
        from = fr;
        to = t;
    }

    /**
     * Returns the number of elements in this list. If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     * @return the number of elements in this list.
     */
    public int size()
    {
        return to-from;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements.
     */
    public boolean isEmpty()
    {
        return to == from;
    }

    /**
     * Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element e such that (o==null ? e==null : o.equals(e)).
     * @param o - element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
     * @exception NullPointerException - if the specified element is null and this list does not support null elements .
     */
    public boolean contains(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException();
        }
        return indexOf(o) != -1;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * @return an iterator over the elements in this list in proper sequence.
     */
    public Iterator iterator()
    {
        return new ListAdapterListIterator(this);
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence. Obeys the general contract of the Collection.toArray method.
     * @return an array containing all of the elements in this list in proper sequence.
     */
    public Object[] toArray()
    {
        Object[] o = new Object[size()];
        int a = 0;
        for(int i = from ; i < to; i++)
        {
            o[a] = v.elementAt(i);
            a++;
        }
        return o;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array. Obeys the general contract of the Collection.toArray(Object[]) method.
     * @param a - the array into which the elements of this list are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list.
     * @exception UnsupportedOperationException
     */
    public Object[] toArray(Object[] a)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * Appends the specified element to the end of this list.
     * Lists that support this operation may place limitations on what elements may be added to this list. In particular, some lists will refuse to add null elements, and others will impose restrictions on the type of elements that may be added. List classes should clearly specify in their documentation any restrictions on what elements may be added.
     * @param o - element to be appended to this list.
     * @return true (as per the general contract of the Collection.add method).
     * @exception NullPointerException - if the specified element is null and this list does not support null elements.
     */
    public boolean add(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException();
        }
        add(to, o);
        return true;
    }

    /**
     * Removes the first occurrence in this list of the specified element. If this list does not contain the element, it is unchanged. More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
     * @param o - element to be removed from this list, if present.
     * @return true if this list contained the specified element.
     * @exception NullPointerException - if the specified element is null and this list does not support null elements (optional).
     */
    public boolean remove(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException();
        }
        if (!contains(o))
            return false;
        remove(indexOf(o));
        return true;
    }

    /**
     * Returns true if this list contains all of the elements of the specified collection.
     * @param c - collection to be checked for containment in this list.
     * @return true if this list contains all of the elements of the specified collection.
     * @exception NullPointerException - if the specified collection is null.
     */
    public boolean containsAll(Collection c)
    {
        if (c == null)
        {
            throw new NullPointerException();
        }
        Iterator i = c.iterator();
        boolean b = true;
        while(i.hasNext())
        {
            Object o = i.next();
            if(!contains(o))
            {
                b = false;
                break;
            }
        }
        return b;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator . The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress. (Note that this will occur if the specified collection is this list, and it's nonempty.)
     * @param c - collection whose elements are to be added to this list.
     * @return true if this list changed as a result of the call.
     * @exception NullPointerException - if the specified collection is null.
     */
    public boolean addAll(Collection c)
    {
        if (c == null)
        {
            throw new NullPointerException();
        }
        Iterator i = c.iterator();
        boolean b = false;
        while(i.hasNext())
        {
            add(to, i.next());
            b = true;
        }
        return b;
    }

    /**
     * Inserts all of the elements in the specified collection into this list at the specified position . Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). The new elements will appear in this list in the order that they are returned by the specified collection's iterator. The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress. (Note that this will occur if the specified collection is this list, and it's nonempty.)
     * @param index - index at which to insert first element from the specified collection.
     * @param c - elements to be inserted into this list.
     * @return true if this list changed as a result of the call.
     * @exception NullPointerException - if the specified collection is null.
     * @exception IndexOutOfBoundsException - if the index is out of range.
     */
    public boolean addAll(int index, Collection c)
    {
        if (c == null)
        {
            throw new NullPointerException();
        }
        if (index < 0 || index > size())
        {
            throw new IndexOutOfBoundsException();
        }
        Iterator i = c.iterator();
        boolean b = false;
        while(i.hasNext())
        {
            add(index, i.next());
            b = true;
        }
        return b;
    }

    /**
     * Removes from this list all the elements that are contained in the specified collection.
     * @param c - collection that defines which elements will be removed from this list.
     * @return true if this list changed as a result of the call.
     * @exception NullPointerException - if the specified collection is null.
     */
    public boolean removeAll(Collection c)
    {
        if (c == null)
        {
            throw new NullPointerException();
        }
        Iterator i = c.iterator();
        boolean b = false;
        while(i.hasNext())
        {
            if(remove(i.next()))
                b = true;
        }
        return b;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection. In other words, removes from this list all the elements that are not contained in the specified collection.
     * @param c - collection that defines which elements this set will retain.
     * @return true if this list changed as a result of the call.
     * @exception NullPointerException - if the specified collection is null.
     */
    public boolean retainAll(Collection c)
    {
        if (c == null)
        {
            throw new NullPointerException();
        }
        Object[] o = toArray();
        boolean b = false;

        for(int i = 0; i < o.length; i ++) {
            if(c.contains(o[i]) == false) {
                remove(o[i]);
                b = true;
            }

        }
        return b;
    }

    /**
     * Removes all of the elements from this list. This list will be empty after this call returns (unless it throws an exception).
     */
    public void clear()
    {
        v.removeAllElements();
        to=from=0;
    }

    /**
     * Compares the specified object with this list for equality. Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal. (Two elements e1 and e2 are equal if (e1==null ? e2==null : e1.equals(e2)).) In other words, two lists are defined to be equal if they contain the same elements in the same order. This definition ensures that the equals method works properly across different implementations of the List interface.
     * @param o - the object to be compared for equality with this list.
     * @return true if the specified object is equal to this list.
     */
    public boolean equals(Object o)
    {
        Iterator i = v.iterator();
        Iterator it = ((ListAdapter)o).iterator();
        boolean b = true;
        if(! (o instanceof ListAdapter))
        {
            return false;
        }
        if (!(((ListAdapter)o).size() == size()))
        {
            return false;
        }
        else
        {
            while(it.hasNext())
                b = b && (i.next() == it.next());
            return b;
        }
    }

    /**
     * Returns the hash code value for this list. The hash code of a list is defined to be the result of the following calculation:
     *   hashCode = 1;
     *   Iterator i = list.iterator();
     *   while (i.hasNext()) {
     *       Object obj = i.next();
     *       hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
     *   }
     *
     * This ensures that list1.equals(list2) implies that list1.hashCode()==list2.hashCode() for any two lists, list1 and list2, as required by the general contract of Object.hashCode.
     * @return the hash code value for this list.
     */
    public int hashCode()
    {
        int hashCode = 1;
        Iterator i = iterator();
        while(i.hasNext())
        {
            Object obj = i.next();
            hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
        }
        return hashCode;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of element to return.
     * @return the element at the specified position in this list.
     * @exception IndexOutOfBoundsException - if the index is out of range.
     */
    public Object get(int index)
    {
        if (index < 0 || index > size())
        {
            throw new IndexOutOfBoundsException();
        }
        if ( index>to)
            throw new IndexOutOfBoundsException();
        return v.elementAt(index+from);
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index - index of element to replace.
     * @param element - element to be stored at the specified position.
     * @return the element previously at the specified position.
     * @exception NullPointerException - if the specified element is null and this list does not support null elements.
     * @exception IndexOutOfBoundsException - if the index is out of range.
     */
    public Object set(int index, Object element)
    {
        if (element == null)
        {
            throw new NullPointerException();
        }
        if(index>=to)
        {
            throw new IndexOutOfBoundsException();
        }
        Object o = get(index);
        v.setElementAt(element, index+from);
        return o;
    }

    /**
     * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     * @param index - index at which the specified element is to be inserted.
     * @param element - element to be inserted.
     * @exception NullPointerException - if the specified element is null and this list does not support null elements.
     * @exception IndexOutOfBoundsException - if the index is out of range.
     */
    public void add(int index, Object element)
    {
        if (element == null)
        {
            throw new NullPointerException();
        }
        if(index<from || index>to)
            throw new IndexOutOfBoundsException();
        v.insertElementAt(element, index+from);
        to++;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.
     * @param index - the index of the element to removed.
     * @return the element previously at the specified position.
     * @exception IndexOutOfBoundsException - if the index is out of range.
     */
    public Object remove(int index)
    {
        if (index < 0 || index > size())
        {
            throw new IndexOutOfBoundsException();
        }
        if(index<from || index>to)
            throw new IndexOutOfBoundsException();
        Object o = get(index);
        v.removeElementAt(index+from);
        to--;
        return o;
    }

    /**
     * Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element. More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
     * @param o - element to search for.
     * @return the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
     * @exception NullPointerException - if the specified element is null and this list does not support null elements.
     */
    public int indexOf(Object o)
    {
        if(o == null)
        {
            throw new NullPointerException();
        }
        int a = v.indexOf(o, from);
        if(a >= from && a < to)
        {
            return a-from;
        }
        return -1;
    }

    /**
     * Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element. More formally, returns the highest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
     * @param o - element to search for.
     * @return the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
     * @exception NullPointerException - if the specified element is null and this list does not support null elements.
     */
    public int lastIndexOf(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException();
        }
        if(!contains(o))
        {
            return -1;
        }
        int last = 0;
        for(int i = 0; i < size(); i ++)
        {
            if(get(i) == o)
            {
                last = i;
            }
        }
        return last;
    }

    /**
     * Returns a list iterator of the elements in this list (in proper sequence).
     * @return a list iterator of the elements in this list (in proper sequence).
     */
    public ListIterator listIterator()
    {
        return new ListAdapterListIterator(this);
    }

    /**
     * Returns a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list. The specified index indicates the first element that would be returned by an initial call to the next method. An initial call to the previous method would return the element with the specified index minus one.
     * @param index - index of first element to be returned from the list iterator (by a call to the next method).
     * @return a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list.
     * @exception IndexOutOfBoundsException - if the index is out of range.
     */
    public ListIterator listIterator(int index)
    {
        if (index < 0 || index > size())
        {
            throw new IndexOutOfBoundsException();
        }
        else
            return subList(index, size()).listIterator();
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the returned list is empty.) The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa. The returned list supports all of the optional list operations supported by this list.
     * This method eliminates the need for explicit range operations (of the sort that commonly exist for arrays). Any operation that expects a list can be used as a range operation by passing a subList view instead of a whole list. For example, the following idiom removes a range of elements from a list:
     *
     * 	    list.subList(from, to).clear();
     *
     * Similar idioms may be constructed for indexOf and lastIndexOf, and all of the algorithms in the Collections class can be applied to a subList.
     * The semantics of the list returned by this method become undefined if the backing list (i.e., this list) is structurally modified in any way other than via the returned list. (Structural modifications are those that change the size of this list, or otherwise perturb it in such a fashion that iterations in progress may yield incorrect results.)
     * @param fromIndex - low endpoint (inclusive) of the subList.
     * @param toIndex - high endpoint (exclusive) of the subList.
     * @return a view of the specified range within this list.
     * @exception IndexOutOfBoundsException - for an illegal endpoint index value.
     */
    public List subList(int fromIndex, int toIndex)
    {
        if(fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        return new ListAdapter(v, fromIndex, toIndex);
    }

}





