package edu.hw3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class Task8 {
    static class BackIterator<E extends Collection, T> implements Iterator {
        Stack<T> collectionElements = new Stack<>();

         BackIterator(E collection) {
            Iterator<T> iter = collection.iterator();
            while (iter.hasNext()) {
                collectionElements.push(iter.next());

            }
        }

        @Override
        public boolean hasNext() {
            return !collectionElements.isEmpty();
        }

        @Override
        public Object next() {
            return collectionElements.pop();
        }
    }
}
