package edu.hw7;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import static edu.hw7.Task3.Person;

public class Task3_5 {

    class PersonDataBaseImplSecond extends Task3.PersonDataBaseImpl {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        @Override
        public void delete(int id) {
            lock.readLock().lock();
            try {
                super.delete(id);
            } finally {
                lock.readLock().unlock();
            }
        }

        @Override
        public List<Person> findByName(String name) {
            lock.writeLock().lock();
            try {
                return allPersons.values().stream().filter(person -> person.name().equals(name)).toList();
            } finally {
                lock.writeLock().unlock();
            }
        }

        @Override
        public List<Person> findByAddress(String address) {
            lock.writeLock().lock();
            try {
                return allPersons.values().stream().filter(person -> person.address().equals(address)).toList();
            } finally {
                lock.writeLock().unlock();
            }
        }
        @Override
        public List<Person> findByPhone(String phone) {
            lock.writeLock().lock();
            try {
                return allPersons.values().stream().filter(person -> person.name().equals(phone)).toList();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
