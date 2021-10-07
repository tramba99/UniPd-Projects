import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public class SetAdapterIterator implements java.util.Iterator
{
    private Hashtable hash;
    private Enumeration e;
    private boolean next = false;
    private Object key;

    /**
     * Constructor
     * @param hasht - the hashtable.
     */
    public SetAdapterIterator(Hashtable hasht)
    {
        hash = hasht;
        e = hash.keys();
    }

    /**
     * Returns true if the iteration has more elements. (In other words, returns true if next would return an element rather than throwing an exception.)
     * @return true if the iterator has more elements.
     */
    public boolean hasNext()
    {
        return e.hasMoreElements();
    }

    /**
     * * Returns the next element in the iteration.
     * @return the next element in the iteration.
     * @exception NoSuchElementException - iteration has no more elements.
     */
    public Object next()
    {
        if(!hasNext())
            throw new NoSuchElementException();
        next = true;
        key = e.nextElement();
        return key;
    }

    /**
     * Removes from the underlying collection the last element returned by the iterator. This method can be called only once per call to next. The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.
     * @exception IllegalStateException - if the next method has not yet been called, or the remove method has already been called after the last call to the next method.
     */
    public void remove()
    {
        if (next)
        {
            hash.remove(key);
            next = false;
        }
        else
            throw new IllegalStateException();

    }
}


