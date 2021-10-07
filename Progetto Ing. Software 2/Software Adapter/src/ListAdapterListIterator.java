/**
 * @author Luca Trambaiollo
 * @version 06/2020
 */

import java.util.NoSuchElementException;


public class ListAdapterListIterator implements java.util.ListIterator
{
    ListAdapter la;
    int next;
    Object last;

    public ListAdapterListIterator(ListAdapter list)
    {
        la = list;
        next = 0;
        last = null;
    }

    /**
     * Returns true if this list iterator has more elements when traversing the list in the forward direction. (In other words, returns true if next would return an element rather than throwing an exception.)
     * @return true if the list iterator has more elements when traversing the list in the forward direction.
     */
    public boolean hasNext()
    {
        if(la.size() == 0) {
            return false;
        }
        if(next >= la.size()) {
            return false;
        }
        return true;
    }

    /**
     * Returns the next element in the list. This method may be called repeatedly to iterate through the list, or intermixed with calls to previous to go back and forth. (Note that alternating calls to next and previous will return the same element repeatedly.)
     * @return the next element in the list.
     * @exception NoSuchElementException - if the iteration has no next element.
     */
    public Object next()
    {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        Object lasts = la.get(next);
        next++;
        last = true;
        return lasts;
    }

    /**
     * Returns true if this list iterator has more elements when traversing the list in the reverse direction. (In other words, returns true if previous would return an element rather than throwing an exception.)
     * @return true if the list iterator has more elements when traversing the list in the reverse direction.
     */
    public boolean hasPrevious()
    {
        return next != 0;
    }

    /**
     * Returns the previous element in the list. This method may be called repeatedly to iterate through the list backwards, or intermixed with calls to next to go back and forth. (Note that alternating calls to next and previous will return the same element repeatedly.)
     * @return the previous element in the list.
     * @exception NoSuchElementException - if the iteration has no previous element.
     */
    public Object previous()
    {
        if(!hasPrevious()) {
            throw new NoSuchElementException();
        }
        next --;
        Object lasts = la.get(next);
        last = true;
        return lasts;
    }

    /**
     * Returns the index of the element that would be returned by a subsequent call to next. (Returns list size if the list iterator is at the end of the list.)
     * @return the index of the element that would be returned by a subsequent call to next, or list size if list iterator is at end of list.
     */
    public int nextIndex()
    {
        if(next >= la.size()) {
            return la.size();
        }
        return next;
    }

    /**
     * Returns the index of the element that would be returned by a subsequent call to previous. (Returns -1 if the list iterator is at the beginning of the list.)
     * @return the index of the element that would be returned by a subsequent call to previous, or -1 if list iterator is at beginning of list.
     */
    public int previousIndex()
    {
        if(next <= 0) {
            return -1;
        }

        return next-1;
    }

    /**
     * Removes from the list the last element that was returned by next or previous. This call can only be made once per call to next or previous. It can be made only if ListIterator.add has not been called after the last call to next or previous.
     * @exception IllegalStateException - neither next nor previous have been called, or remove or add have been called after the last call to * next or previous.
     */
    public void remove()
    {
        if(next == 0) {
            throw new IllegalStateException();
        }
        la.remove(next);
        last = null;
        next--;
    }

    /**
     * Replaces the last element returned by next or previous with the specified element. This call can be made only if neither ListIterator.remove nor ListIterator.add have been called after the last call to next or previous.
     * @param o - the element with which to replace the last element returned by next or previous.
     * @exception IllegalStateException - if neither next nor previous have been called, or remove or add have been called after the last call to next or previous.
     */
    public void set(Object o)
    {
        if(last == null) {
            throw new IllegalStateException();
        }

        la.set(previousIndex(), o);
    }

    /**
     * Inserts the specified element into the list . The element is inserted immediately before the next element that would be returned by next, if any, and after the next element that would be returned by previous, if any. (If the list contains no elements, the new element becomes the sole element on the list.) The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, and a subsequent call to previous would return the new element. (This call increases by one the value that would be returned by a call to nextIndex or previousIndex.)
     * @param o - the element to insert.
     */
    public void add(Object o)
    {
        if(o == null) {
            throw new NullPointerException();
        }
        last = null;
        la.add(next, o);
        next++;
    }
}


