/**
 * @author Luca Trambaiollo
 * @version 05/2020
 */

import java.util.*;

public class MapAdapter implements java.util.Map
{
    private Hashtable h = new Hashtable();

    /**
     * Returns the number of key-value mappings in this map. If the map contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     * @return the number of key-value mappings in this map.
     */
    public int size()
    {
        return h.size();
    }

    /**
     * Returns true if this map contains no key-value mappings.
     * @return true if this map contains no key-value mappings.
     */
    public boolean isEmpty()
    {
        return h.size() == 0;
    }

    /**
     * Returns true if this map contains a mapping for the specified key. More formally, returns true if and only if this map contains at a mapping for a key k such that (key==null ? k==null : key.equals(k)). (There can be at most one such mapping.)
     * @param key - key whose presence in this map is to be tested.
     * @return true if this map contains a mapping for the specified key.
     * @exception NullPointerException - if the key is null and this map does not not permit null keys.
     */
    public boolean containsKey(Object key)
    {
        if ( key == null)
        {
            throw new NullPointerException();
        }
        return h.containsKey(key);
    }

    /**
     * Returns true if this map maps one or more keys to the specified value. More formally, returns true if and only if this map contains at least one mapping to a value v such that (value==null ? v==null : value.equals(v)). This operation will probably require time linear in the map size for most implementations of the Map interface.
     * @param value - value whose presence in this map is to be tested.
     * @return true if this map maps one or more keys to the specified value.
     * @exception NullPointerException - if the value is null and this map does not not permit null values.
     */
    public boolean containsValue(Object value)
    {
        if ( value == null)
        {
            throw new NullPointerException();
        }
        return h.contains(value);
    }

    /**
     * Returns the value to which this map maps the specified key. Returns null if the map contains no mapping for this key. A return value of null does not necessarily indicate that the map contains no mapping for the key; it's also possible that the map explicitly maps the key to null. The containsKey operation may be used to distinguish these two cases.
     * More formally, if this map contains a mapping from a key k to a value v such that (key==null ? k==null : key.equals(k)), then this method returns v; otherwise it returns null. (There can be at most one such mapping.)
     * @param key - key whose associated value is to be returned.
     * @return the value to which this map maps the specified key, or null if the map contains no mapping for this key.
     * @exception NullPointerException - key is null and this map does not not permit null keys.
     */
    public Object get(Object key)
    {
        if ( key == null)
        {
            throw new NullPointerException();
        }
        return h.get(key);
    }

    /**
     * Associates the specified value with the specified key in this map. If the map previously contained a mapping for this key, the old value is replaced by the specified value. (A map m is said to contain a mapping for a key k if and only if m.containsKey(k) would return true.))
     * @param key - key with which the specified value is to be associated.
     * @param value - value to be associated with the specified key.
     * @return previous value associated with specified key, or null if there was no mapping for key. A null return can also indicate that the map previously associated null with the specified key, if the implementation supports null values.
     * @exception NullPointerException - this map does not permit null keys or values, and the specified key or value is null.
     */
    public Object put(Object key, Object value)
    {
        if ( key == null || value == null)
        {
            throw new NullPointerException();
        }
        return h.put(key, value);
    }

    /**
     * Removes the mapping for this key from this map if it is present. More formally, if this map contains a mapping from key k to value v such that (key==null ? k==null : key.equals(k)), that mapping is removed. (The map can contain at most one such mapping.)
     * Returns the value to which the map previously associated the key, or null if the map contained no mapping for this key. (A null return can also indicate that the map previously associated null with the specified key if the implementation supports null values.) The map will not contain a mapping for the specified key once the call returns.
     * @param key - key whose mapping is to be removed from the map.
     * @return previous value associated with specified key, or null if there was no mapping for key.
     * @exception NullPointerException - if the key is null and this map does not not permit null keys.
     */
    public Object remove(Object key)
    {
        if ( key == null)
        {
            throw new NullPointerException();
        }
        return h.remove(key);
    }

    /**
     * Copies all of the mappings from the specified map to this map. The effect of this call is equivalent to that of calling put(k, v) on this map once for each mapping from key k to value v in the specified map. The behavior of this operation is unspecified if the specified map is modified while the operation is in progress.
     * @param t - Mappings to be stored in this map.
     * @exception NullPointerException - the specified map is null.
     */
    public void putAll(Map t)
    {
        if ( t == null)
        {
            throw new NullPointerException();
        }
        Set s = t.keySet();
        Iterator iter = s.iterator();
        while(iter.hasNext())
        {
            Object key = iter.next();
            Object value = t.get(key);
            put(key, value);
        }
    }

    /**
     * Removes all mappings from this map (optional operation).
     */
    public void clear()
    {
        h.clear();
    }

    /**
     * Returns a set view of the keys contained in this map. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress, the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll retainAll, and clear operations. It does not support the add or addAll operations.
     * @return a set view of the keys contained in this map.
     */
    public Set keySet()
    {
        return new KeySet(h);
    }

    /**
     * Returns a collection view of the values contained in this map. The collection is backed by the map, so changes to the map are reflected in the collection, and vice-versa. If the map is modified while an iteration over the collection is in progress, the results of the iteration are undefined. The collection supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Collection.remove, removeAll, retainAll and clear operations. It does not support the add or addAll operations.
     * @return a collection view of the values contained in this map.
     */
    public Collection values()
    {
        return new CollectionValues(h);
    }

    /**
     * Returns a set view of the mappings contained in this map. Each element in the returned set is a Map.Entry. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress, the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll, retainAll and clear operations. It does not support the add or addAll operations.
     * @return a set view of the mappings contained in this map.
     */
    public Set entrySet()
    {
        return (Set) new EntrySet(h);
    }

    /**
     * Compares the specified object with this map for equality. Returns true if the given object is also a map and the two Maps represent the same mappings. More formally, two maps t1 and t2 represent the same mappings if t1.entrySet().equals(t2.entrySet()). This ensures that the equals method works properly across different implementations of the Map interface.
     * @param o - object to be compared for equality with this map.
     * @return true if the specified object is equal to this map.
     */
    public boolean equals(Object o)
    {
        if (!(o instanceof MapAdapter))
            return false;
        Map map = (MapAdapter)o;
        return this.entrySet().equals(map.entrySet());
    }

    /**
     * Returns the hash code value for this map. The hash code of a map is defined to be the sum of the hashCodes of each entry in the map's entrySet view. This ensures that t1.equals(t2) implies that t1.hashCode()==t2.hashCode() for any two maps t1 and t2, as required by the general contract of Object.hashCode.
     * @return the hash code value for this map.
     */
    public int hashCode()
    {
        return this.entrySet().hashCode();
    }


    static class Entry implements Map.Entry
    {
        private Object key;
        private Object value;

        /**
         * Constructor.
         */
        public Entry(Object k, Object v)
        {
            key = k;
            value = v;
        }

        /**
         * Returns the key corresponding to this entry.
         * @return the key corresponding to this entry.
         */
        public Object getKey()
        {
            return key;
        }

        /**
         * Returns the value corresponding to this entry. If the mapping has been removed from the backing map (by the iterator's remove operation), the results of this call are undefined.
         * @return the value corresponding to this entry.
         */
        public Object getValue()
        {
            return value;
        }

        /**
         * Replaces the value corresponding to this entry with the specified value. (Writes through to the map.) The behavior of this call is undefined if the mapping has already been removed from the map (by the iterator's remove operation).
         * @param value - new value to be stored in this entry.
         * @return old value corresponding to the entry.
         * @exception NullPointerException - the backing map does not permit null values, and the specified value is null.
         */
        public Object setValue(Object value)
        {
            if (value == null)
                throw new NullPointerException();
            Object o = this.value;
            this.value = value;
            return o;
        }

        /**
         * Compares the specified object with this entry for equality. Returns true if the given object is also a map entry and the two entries represent the same mapping. More formally, two entries e1 and e2 represent the same mapping if
         *      (e1.getKey()==null ?
         *       e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &&
         *      (e1.getValue()==null ?
         *       e2.getValue()==null : e1.getValue().equals(e2.getValue()))
         *
         * This ensures that the equals method works properly across different implementations of the Map.Entry interface.
         * @param o - object to be compared for equality with this map entry.
         * @return true if the specified object is equal to this map entry.
         */
        public boolean equals(Object o)
        {
            if( !(o instanceof Entry))
            {
                return false;
            }
            Entry e = (Entry)o;
            if(e.getKey() == key && e.getValue() == value)
                return true;
            return false;
        }

        /**
         * Returns the hash code value for this map entry. The hash code of a map entry e is defined to be:
         *      (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
         *      (e.getValue()==null ? 0 : e.getValue().hashCode())
         *
         * This ensures that e1.equals(e2) implies that e1.hashCode()==e2.hashCode() for any two Entries e1 and e2, as required by the general contract of Object.hashCode.
         * @return the hash code value for this map entry.
         */
        public int hashCode()
        {
            int hashKey = 0;
            int hashValue = 0;

            if(key == null)
                hashKey = 0;
            else
                hashKey = key.hashCode();

            if(value == null)
                hashValue = 0;
            else
                hashValue = value.hashCode();

            return hashKey^hashValue;
        }

        /**
         * Returns the key-value pair.
         * @return the key-value pair.
         */
        public String toString()
        {
            String s = key + ": " + value;
            return s;
        }
    }



    class EntrySet implements Set
    {
        private Hashtable h = new Hashtable();

        /**
         * Constructor.
         * @param ht - the hashtable.
         */
        public EntrySet(Hashtable ht)
        {
            h = ht;
        }

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
         * @exception ClassCastException
         */
        public boolean contains(Object o)
        {
            if (o == null)
            {
                throw new NullPointerException();
            }
            if (!(MapAdapter.Entry.class.isInstance(o)))
            {
                throw new ClassCastException();
            }
            Entry e = (Entry)o;
            return h.containsKey(e.getKey());
        }

        /**
         * Returns an iterator over the elements in this set. The elements are returned in no particular order (unless this set is an instance of some class that provides a guarantee).
         * @return an iterator over the elements in this set.
         */
        public Iterator iterator()
        {
            return new EntrySetIterator(h);
        }

        /**
         * Returns an array containing all of the elements in this set. Obeys the general contract of the Collection.toArray method.
         * @return an array containing all of the elements in this set.
         */
        public Object[] toArray()
        {
            Enumeration eKey = h.keys();

            Object[] entries = new Object[size()];

            for(int i = 0; i < entries.length; i++)
                if(eKey.hasMoreElements())
                {
                    Object key = eKey.nextElement();
                    entries[i] = new Entry(key,h.get(key));
                }

            return entries;
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
         * @exception UnsupportedOperationException
         */
        public boolean add(Object o)
        {
            throw new UnsupportedOperationException();
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
            if (!(Entry.class.isInstance(o)))
            {
                throw new ClassCastException();
            }
            Entry e = (Entry)o;
            Object obj = h.remove(e.getKey());
            if(obj==null)
                return false;
            else
                return true;
        }

        /**
         * Returns true if this set contains all of the elements of the specified collection. If the specified collection is also a set, this method returns true if it is a subset of this set.
         * @param c - collection to be checked for containment in this set.
         * @return true if this set contains all of the elements of the specified collection.
         * @exception NullPointerException - if the specified collection is null.
         * @exception IllegalArgumentException
         */
        public boolean containsAll(Collection c)
        {
            if(c == null)
                throw new NullPointerException();

            if(!(c instanceof EntrySet))
                throw new IllegalArgumentException();

            Object[] o = c.toArray();

            for(int i = 0; i < o.length;i++)
            {
                Entry entry = (Entry)o[i];
                Object key = entry.getKey();

                if(!(h.containsKey(key)))
                    return false;
            }
            return true;
        }

        /**
         * Adds all of the elements in the specified collection to this set if they're not already present. If the specified collection is also a set, the addAll operation effectively modifies this set so that its value is the union of the two sets. The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress.
         * @param c - collection whose elements are to be added to this set.
         * @return true if this set changed as a result of the call.
         * @exception UnsupportedOperationException
         */
        public boolean addAll(Collection c)
        {
            throw new UnsupportedOperationException();
        }

        /**
         * Retains only the elements in this set that are contained in the specified collection. In other words, removes from this set all of its elements that are not contained in the specified collection. If the specified collection is also a set, this operation effectively modifies this set so that its value is the intersection of the two sets.
         * @param c - collection that defines which elements this set will retain.
         * @return true if this collection changed as a result of the call.
         * @exception NullPointerException - if the specified collection is null.
         * @exception IllegalArgumentException
         */
        public boolean retainAll(Collection c)
        {
            if (c==null)
            {
                throw new NullPointerException();
            }
            if(!(c instanceof EntrySet))
                throw new IllegalArgumentException();
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
         * @exception IllegalArgumentException
         */
        public boolean removeAll(Collection c)
        {
            if(c == null)
                throw new NullPointerException();

            if(!(c instanceof EntrySet))
                throw new IllegalArgumentException();

            int k = size();
            EntrySet entrySet = (EntrySet)c;

            Object[] o = entrySet.toArray();
            for(int i = 0; i < o.length; i++)
            {
                Entry temp = (Entry)o[i];
                remove(temp);
            }
            return k != size();
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
            if(o instanceof Set)
            {
                EntrySet es = (EntrySet)o;
                Object[] obj = es.toArray();
                for(int i = 0; i < obj.length; i++)
                {
                    Entry entry = (Entry)obj[i];
                    Object key = entry.getKey();

                    if(!(containsKey(key)))
                        return false;
                    else
                        return true;
                }
            }
            return false;
        }

        /**
         * Returns the hash code value for this set. The hash code of a set is defined to be the sum of the hash codes of the elements in the set, where the hashcode of a null element is defined to be zero. This ensures that s1.equals(s2) implies that s1.hashCode()==s2.hashCode() for any two sets s1 and s2, as required by the general contract of the Object.hashCode method.
         * @return the hash code value for this set.
         */
        public int hashCode()
        {
            Enumeration keys = h.keys();
            int a = 0;
            while(keys.hasMoreElements())
            {
                Object key= keys.nextElement();
                a += (new Entry(key, h.get(key))).hashCode();
            }
            return a;
        }

        class EntrySetIterator implements Iterator
        {
            private Hashtable hash;
            private Object last;
            private Enumeration enu;

            /**
             * Constructor
             * @param h - the hashtable.
             */
            public EntrySetIterator(Hashtable h)
            {
                hash = h;
                last = null;
                enu = h.keys();
            }

            /**
             * * Returns the next element in the iteration.
             * @return the next element in the iteration.
             * @exception NoSuchElementException - iteration has no more elements.
             */
            public Object next()
            {
                if(!hasNext())
                    throw new java.util.NoSuchElementException();
                last = enu.nextElement();
                return new Entry(last,hash.get(last));
            }

            /**
             * Returns true if the iteration has more elements. (In other words, returns true if next would return an element rather than throwing an exception.)
             * @return true if the iterator has more elements.
             */
            public boolean hasNext()
            {
                return enu.hasMoreElements();
            }

            /**
             * Removes from the underlying collection the last element returned by the iterator. This method can be called only once per call to next. The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.
             * @exception IllegalStateException - if the next method has not yet been called, or the remove method has already been called after the last call to the next method.
             */
            public void remove()
            {
                if(last != null)
                {
                    hash.remove(last);
                    last = null;
                }
                else
                    throw new IllegalStateException();
            }
        }
    }


    class KeySet implements Set
    {
        private Hashtable hash = new Hashtable();

        /**
         *
         * @param ht - the hashtable.
         */
        public KeySet(Hashtable ht)
        {
            hash = ht;
        }

        /**
         * Returns the number of elements in this set (its cardinality). If this set contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
         * @return the number of elements in this set (its cardinality).
         */
        public int size()
        {
            return hash.size();
        }

        /**
         * Returns true if this set contains no elements.
         * @return true if this set contains no elements.
         */
        public boolean isEmpty()
        {
            return hash.size() == 0;
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
            return hash.containsKey(o);
        }

        /**
         * Returns an iterator over the elements in this set. The elements are returned in no particular order (unless this set is an instance of some class that provides a guarantee).
         * @return an iterator over the elements in this set.
         */
        public Iterator iterator()
        {
            return new KeySetIterator(hash);
        }

        /**
         * Returns an array containing all of the elements in this set. Obeys the general contract of the Collection.toArray method.
         * @return an array containing all of the elements in this set.
         */
        public Object[] toArray()
        {
            Object[] o = new Object[hash.size()];
            Enumeration e = hash.elements();
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
         * @exception UnsupportedOperationException
         */
        public boolean add(Object o)
        {
            throw new UnsupportedOperationException();
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
            Object obj = hash.remove(o);
            if(obj==null)
                return false;
            else
                return true;
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
         * @exception UnsupportedOperationException
         */
        public boolean addAll(Collection c)
        {
            throw new UnsupportedOperationException();
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
                hash.put(o[i], o[i]);
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
                    hash.remove(o[i]);
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
            hash.clear();
        }

        /**
         * Compares the specified object with this set for equality. Returns true if the specified object is also a set, the two sets have the same size, and every member of the specified set is contained in this set (or equivalently, every member of this set is contained in the specified set). This definition ensures that the equals method works properly across different implementations of the set interface.
         * @param o - Object to be compared for equality with this set.
         * @return true if the specified Object is equal to this set.
         */
        public boolean equals(Object o)
        {
            boolean b = true;
            Object[] obj = ((KeySet)o).toArray();
            if(KeySet.class.isInstance(o))
            {
                if (((KeySet)o).size() == size())
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
            int hashCode = 0;
            Iterator i = iterator();
            Entry e;
            Object key;
            Object value;
            while(i.hasNext())
            {
                key = i.next();
                value = hash.get(key);
                e = new Entry(key, value);
                hashCode = hashCode + e.hashCode();
            }
            return hashCode;
        }

        class KeySetIterator implements Iterator
        {
            private Hashtable hash;
            private Enumeration e;
            private boolean next = false;
            private Object key;

            /**
             * Constructor.
             * @param hasht - the hashtable
             */
            public KeySetIterator(Hashtable hasht)
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
    }



    class CollectionValues implements Collection
    {
        private Hashtable hash = new Hashtable();

        /**
         * Constructor.
         * @param ht - the hashtable.
         */
        public CollectionValues(Hashtable ht)
        {
            hash = ht;
        }

        /**
         * Returns the number of elements in this collection. If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
         * @return the number of elements in this collection
         */
        public int size()
        {
            return hash.size();
        }

        /**
         * Returns true if this collection contains no elements.
         * @return true if this collection contains no elements
         */
        public boolean isEmpty()
        {
            return hash.size() == 0;
        }

        /**
         * Returns true if this collection contains the specified element. More formally, returns true if and only if this collection contains at least one element e such that (o==null ? e==null : o.equals(e)).
         * @param o - element whose presence in this collection is to be tested.
         * @return true if this collection contains the specified element
         * @exception NullPointerException - if the specified element is null and this collection does not support null elements
         */
        public boolean contains(Object o)
        {
            if (o == null)
            {
                throw new NullPointerException();
            }
            return hash.contains(o);
        }

        /**
         * Returns an iterator over the elements in this collection. There are no guarantees concerning the order in which the elements are returned (unless this collection is an instance of some class that provides a guarantee).
         * @return an Iterator over the elements in this collection
         */
        public Iterator iterator()
        {
            return new CollectionValuesIterator(hash);
        }

        /**
         *Returns an array containing all of the elements in this collection. If the collection makes any guarantees as to what order its elements are returned by its iterator, this method must return the elements in the same order.
         * The returned array will be "safe" in that no references to it are maintained by this collection. (In other words, this method must allocate a new array even if this collection is backed by an array). The caller is thus free to modify the returned array.
         *
         * This method acts as bridge between array-based and collection-based APIs.
         * @return an array containing all of the elements in this collection
         */
        public Object[] toArray()
        {
            Object[] o = new Object[hash.size()];
            Enumeration e = hash.elements();
            for (int i = 0; i < o.length; i++)
            {
                if (e.hasMoreElements())
                    o[i] = e.nextElement();
            }
            return o;
        }

        /**
         * @exception UnsupportedOperationException
         */
        public Object[] toArray(Object[] a) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        /**
         * @exception UnsupportedOperationException
         */
        public boolean add(Object o)
        {
            throw new UnsupportedOperationException();
        }

        /**
         * Removes a single instance of the specified element from this collection, if it is present (optional operation). More formally, removes an element e such that (o==null ? e==null : o.equals(e)), if this collection contains one or more such elements. Returns true if this collection contained the specified element (or equivalently, if this collection changed as a result of the call).
         * @param o  - element to be removed from this collection, if present.
         * @return true if this collection changed as a result of the call
         * @exception NullPointerException - if the specified element is null and this collection does not support null elements.
         */
        public boolean remove(Object o)
        {
            if (o == null)
            {
                throw new NullPointerException();
            }
            if (!(hash.contains(o)))
                return false;
            CollectionValuesIterator cvi = (CollectionValuesIterator)iterator();
            Object value;
            while (cvi.hasNext())
            {
                value = cvi.next();
                if (value == o)
                    cvi.remove();
            }
            return true;
        }

        /**
         * Returns true if this collection contains all of the elements in the specified collection.
         * @param c - collection to be checked for containment in this collection.
         * @return true if this collection contains all of the elements in the specified collection
         * @exception NullPointerException - if the specified collection is null
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
         * @exception UnsupportedOperationException
         */
        public boolean addAll(Collection c)
        {
            throw new UnsupportedOperationException();
        }

        /**
         * Retains only the elements in this collection that are contained in the specified collection. In other words, removes from this collection all of its elements that are not contained in the specified collection.
         * @param c  - elements to be retained in this collection.
         * @return true if this collection changed as a result of the call
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
                hash.put(o[i], o[i]);
                b = b || true;
            }
            return b;
        }

        /**
         * Removes all this collection's elements that are also contained in the specified collection. After this call returns, this collection will contain no elements in common with the specified collection.
         * @param c - elements to be removed from this collection.
         * @return true if this collection changed as a result of the call
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
                    hash.remove(o[i]);
                    b = b || true;
                }
                else
                    b = b || false;
            }
            return b;
        }

        /**
         * Removes all of the elements from this collection (optional operation). This collection will be empty after this method returns unless it throws an exception.
         */
        public void clear()
        {
            hash.clear();
        }

        /**
         * Compares the specified object with this collection for equality.
         * While the Collection interface adds no stipulations to the general contract for the Object.equals, programmers who implement the Collection interface "directly" (in other words, create a class that is a Collection but is not a Set or a List) must exercise care if they choose to override the Object.equals. It is not necessary to do so, and the simplest course of action is to rely on Object's implementation, but the implementer may wish to implement a "value comparison" in place of the default "reference comparison." (The List and Set interfaces mandate such value comparisons.)
         *
         * The general contract for the Object.equals method states that equals must be symmetric (in other words, a.equals(b) if and only if b.equals(a)). The contracts for List.equals and Set.equals state that lists are only equal to other lists, and sets to other sets. Thus, a custom equals method for a collection class that implements neither the List nor Set interface must return false when this collection is compared to any list or set. (By the same logic, it is not possible to write a class that correctly implements both the Set and List interfaces.)
         * @param o - Object to be compared for equality with this collection.
         * @return true if the specified object is equal to this collection
         */
        public boolean equals(Object o)
        {
            boolean b = true;
            Object[] obj = ((CollectionValues)o).toArray();
            if(CollectionValues.class.isInstance(o))
            {
                if (((CollectionValues)o).size() == size())
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
         * Returns the hash code value for this collection. While the Collection interface adds no stipulations to the general contract for the Object.hashCode method, programmers should take note that any class that overrides the Object.equals method must also override the Object.hashCode method in order to satisfy the general contract for the Object.hashCodemethod. In particular, c1.equals(c2) implies that c1.hashCode()==c2.hashCode().
         * @return the hash code value for this collection
         */
        public int hashCode()
        {
            int hashCode = 0;
            Enumeration enu = hash.keys();
            Entry e;
            Object key;
            Object value;
            while(enu.hasMoreElements())
            {
                key = enu.nextElement();
                value = hash.get(key);
                e = new Entry(key, value);
                hashCode = hashCode + e.hashCode();
            }
            return hashCode;
        }

        class CollectionValuesIterator implements Iterator
        {
            private Hashtable hash;
            private Enumeration e;
            private boolean next = false;
            private Object value;

            /**
             * Constructor.
             * @param hasht - the hashtable
             */
            public CollectionValuesIterator(Hashtable hasht)
            {
                hash = hasht;
                e = hash.elements();
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
                value = e.nextElement();
                return value;
            }

            /**
             * Removes from the underlying collection the last element returned by the iterator. This method can be called only once per call to next. The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.
             * @exception IllegalStateException - if the next method has not yet been called, or the remove method has already been called after the last call to the next method.
             */
            public void remove()
            {
                if (next)
                {
                    hash.remove(value);
                    next = false;
                }
                else
                    throw new IllegalStateException();

            }
        }
    }

}






