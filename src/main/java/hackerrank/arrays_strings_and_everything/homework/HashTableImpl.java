package hackerrank.arrays_strings_and_everything.homework;

import java.util.*;

/**
 * Created by sharath on 9/4/15.
 */
public class HashTableImpl<K,V> {
    static class Entry<K,V> {
        final K key;
        private V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int capacity;

    Entry<K,V>[] table;

    public HashTableImpl() {
        this(256);
    }

    public HashTableImpl(int size) {
        capacity = 1;
        while(capacity < size) {
            capacity = capacity * 2 ;
        }
        table = new Entry[capacity];
    }

    public V get(K key) {
        if(key == null)
            return null;
        int hash = Math.abs(key.hashCode()) % capacity;
        if(table[hash] == null)
            return null;
        else {
            Entry<K,V> curr = table[hash];
            while(curr != null) {
                if(curr.key.equals(key))
                    return curr.value;
                curr = curr.next;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        if(key == null)
            return null;
        int hash = Math.abs(key.hashCode()) % capacity;

        Entry<K,V> newEntry = new Entry<>(key, value, null);

        if(table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];

            while(current != null) {
                if(current.key.equals(key)) {
                    current.value = value;
                    return value;
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
        return value;
    }

    public V remove(K key) {
        if(key == null)
            return null;
        int hash = Math.abs(key.hashCode()) % capacity;

        Entry<K,V> removed = null;
        Entry<K,V> previous = null;
        Entry<K,V> current = table[hash];

        while(current != null) {
            if(current.key.equals(key)) {
                if(previous == null) {
                    removed = table[hash];
                    table[hash] = table[hash].next;
                    return removed.value;
                } else {
                    previous.next = current.next;
                    return current.value;
                }
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<capacity;i++){
            if(table[i]!=null){
                Entry<K, V> entry=table[i];
                while(entry!=null){
                    sb.append("{" + entry.key + "=" + entry.value + "}" + "   ");
                    entry=entry.next;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        HashTableImpl<Employee, Integer> hashMapCustom = new HashTableImpl<>();
        hashMapCustom.put(new Employee("10", "sam"), 12);
        hashMapCustom.put(new Employee("21", "amy"), 121);
        hashMapCustom.put(new Employee("31", "rob"), 151);
        hashMapCustom.put(new Employee("41", "sam"), 15);
        hashMapCustom.put(new Employee("42", "wil"), 89);

        System.out.println("Display values corresponding to keys>");
        System.out.println("value corresponding to employee with id=21 & name='amy' : " + hashMapCustom.get(new Employee("21", "amy")));
        System.out.println("value corresponding to employee with id=51 & name='pat' : "+hashMapCustom.get(new Employee("51", "pat")));

        System.out.print("Displaying : ");
        System.out.println(hashMapCustom);

        System.out.println("\n\nvalue corresponding to employee with id=21 & name='amy' removed: "+hashMapCustom.remove(new Employee("21", "amy")));
        System.out.println("value corresponding to employee with id=51 & name='pat' removed: "+hashMapCustom.remove(new Employee("51", "pat")));

        System.out.print("Displaying : ");
        System.out.println(hashMapCustom);

        System.out.println("Number of buckets " + hashMapCustom.capacity);
        System.out.println("Buckets filled " + hashMapCustom.table.length);

        HashTableImpl<Integer, Integer> hashTable = new HashTableImpl<>(1200);
        Random random = new Random();
        List<Integer> storedValues = new ArrayList<>();
        for(int i = 0; i <= 1000; i++) {
            Integer n = random.nextInt(1000);
            storedValues.add(n);
            hashTable.put(n, n);
        }

        Collections.shuffle(storedValues);

        for(int i = 0; i <= 1000; i++) {
            if(!hashTable.get(storedValues.get(i)).equals(storedValues.get(i))) {
                System.out.println("Broken hashtable");
            }
        }
    }


}
