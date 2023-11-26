package edu.hw7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Task3 {
    public record Person(int id, String name, String address, String phoneNumber) {
    }

    interface PersonDatabase {
        void add(Person person);

        void delete(int id);

        List<Person> findByName(String name);

        List<Person> findByAddress(String address);

        List<Person> findByPhone(String phone);
    }

    static class PersonDataBaseImpl implements PersonDatabase {
        HashMap<String, Person> mapNames = new HashMap<>();
        HashMap<String, Person> mapAddress = new HashMap<>();
        HashMap<String, Person> mapPhone = new HashMap<>();
       protected volatile HashMap<Integer,Person> allPersons;

        @Override
        public void add(Person person) {
            Thread threadForName = new Thread(() -> {
                mapNames.put(person.name, person);
                if (mapAddress.containsValue(person) && mapPhone.containsValue(person)) {
                    allPersons.put(person.id,person);
                }
            });
            threadForName.start();
            Thread threadForAddress = new Thread(() -> {
                mapAddress.put(person.address, person);
                if (mapNames.containsValue(person) && mapPhone.containsValue(person)) {
                    allPersons.put(person.id,person);
                }
            });
            threadForAddress.start();
            Thread threadForPhone = new Thread(() -> {
                mapPhone.put(person.phoneNumber, person);
                if (mapAddress.containsValue(person) && mapNames.containsValue(person)) {
                    allPersons.put(person.id,person);
                }
            });
            threadForPhone.start();
        }

        @Override
        public synchronized void delete(int id) {
            if(allPersons.containsKey(id)){
                Person person = allPersons.get(id);
                allPersons.remove(id, person);
                mapNames.remove(person.name,person);
                mapAddress.remove(person.address,person);
                mapPhone.remove(person.phoneNumber,person);
            }
        }

        @Override
        public synchronized List<Person> findByName(String name) {
                return allPersons.values().stream().filter(person -> person.name.equals(name)).toList();
        }

        @Override
        public synchronized List<Person> findByAddress(String address) {
            return allPersons.values().stream().filter(person -> person.address.equals(address)).toList();
        }

        @Override
        public synchronized List<Person> findByPhone(String phone) {
            return allPersons.values().stream().filter(person -> person.name.equals(phone)).toList();
        }
    }
}
