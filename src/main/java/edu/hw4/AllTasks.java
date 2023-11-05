package edu.hw4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class AllTasks {
    public record Animal(
        String name,
        Type type,
        Sex sex,
        int age,
        int height,
        int weight,
        boolean bites
    ) {
        enum Type {
            CAT, DOG, BIRD, FISH, SPIDER
        }

        enum Sex {
            M, F
        }

        @SuppressWarnings("all")
        public int paws() {
            return switch (type) {
                case CAT, DOG -> 4;
                case BIRD -> 2;
                case FISH -> 0;
                case SPIDER -> 8;
            };
        }

    }

    public static class ValidationError {
        String problemFieldName;

        public ValidationError(String fieldName) {
            problemFieldName = fieldName;
        }

        @SuppressWarnings("all")
        static int maxWeight = 350000;
        @SuppressWarnings("all")
        static int maxHeight = 10000;
        @SuppressWarnings("all")
        static int maxAge = 100;

        static Set<ValidationError> validate(Animal animal) {
            Set<ValidationError> list = new HashSet<>();
            if (animal.age > maxAge || animal.age <= 0) {
                list.add(new ValidationError("age"));
            }
            if (animal.height <= 0 || animal.height > maxHeight) {
                list.add(new ValidationError("height"));
            }
            if (animal.weight <= 0 || animal.weight > maxWeight) {
                list.add(new ValidationError("weight"));
            }
            return list;
        }
    }

    public static class AnimalOperations<T extends Collection<Animal>> {
        Comparator<Animal> compByHeight = Comparator.comparingInt(o -> o.height);

        public List<Animal> sortByHeight(T animals) {    //task 1
            return animals.stream().sorted(compByHeight).toList();
        }

        Comparator<Animal> compByWeight = ((o1, o2) -> o2.weight - o1.weight);

        public List<Animal> sortByWeight(T animals, int lim) {    //task 2
            return animals.stream().sorted(compByWeight).limit(lim).toList();
        }

        public Map<Animal.Type, Long> countByType(T animals) {    // task 3
            return animals.stream().collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
        }

        Comparator<Animal> compLongestName = Comparator.comparingInt(o -> o.name.length());

        public Animal animalLongestName(T animals) {    //task 4
            return animals.stream().max(compLongestName).orElseThrow();
        }

        public Animal.Sex mostCommonSex(T animals) {    //task 5
            return
                animals.stream().collect(Collectors.groupingBy(Animal::sex, Collectors.counting())).entrySet().stream()
                    .reduce((x, y) -> {
                        if (x.getValue() > y.getValue()) {
                            return x;
                        } else {
                            return y;
                        }
                    }).orElseThrow().getKey();
        }

        Comparator<Animal> maxWeight = Comparator.comparingInt(o -> o.weight);

        public Map<Animal.Type, Animal> onesBiggestWeight(T animals) {   //task 6
            Map<Animal.Type, Optional<Animal>>
                ansWrongType =
                animals.stream().collect(Collectors.groupingBy(Animal::type, Collectors.maxBy(maxWeight)));
            Map<Animal.Type, Animal> ans = new HashMap<>();
            ansWrongType.forEach((keyType, valueAnimal) -> ans.put(keyType, valueAnimal.orElseThrow()));
            return ans;
        }

        Comparator<Animal> compByAge = Comparator.comparingInt(o -> -o.age);

        public Animal oldestK(T animals, int lim) {  //task 7
            return animals.stream().sorted(compByAge).distinct().limit(lim).skip(lim - 1).findFirst().orElseThrow();
        }

        public Optional<Animal> littleAndHighWeight(T animals, int limHeight) {    //task 8
            return animals.stream().filter(anim -> anim.height < limHeight).max(maxWeight);
        }

        public Integer sumOfPaws(T animals) {    //task 9
            return animals.stream().map(Animal::paws).reduce(Integer::sum).orElseThrow();
        }

        public List<Animal> differentPawsAndAge(T animals) { //task 10
            return animals.stream().filter(animal -> animal.age != animal.paws()).toList();
        }
        @SuppressWarnings("all")
        public List<Animal> highAndBiting(T animals) {   //task 11
            return animals.stream().filter(animal -> animal.height > 100 && animal.bites).toList();
        }

        public Long weightMoreThanHeight(T animals) {    //task 12
            return animals.stream().filter(animal -> animal.height < animal.weight).count();
        }

        public List<Animal> longNames(T animals) {   //task 13
            return animals.stream().filter(animal -> animal.name.split(" ").length > 2).toList();
        }

        public boolean highDog(T animals, int limHeight) {   //task 14
            return animals.stream().anyMatch(animal -> animal.height > limHeight && animal.type == Animal.Type.DOG);
        }

        public Map<Animal.Type, Integer> sumOfWeight(T animals, int leftLim, int rightLim) {    // task 15
            return animals.stream().filter(animal -> animal.age >= leftLim && animal.age <= rightLim)
                .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> animal.weight)));
        }

        Comparator<Animal> complicatedComp = (o1, o2) -> {
            int ans = o1.type.compareTo(o2.type);
            if (ans == 0) {
                ans = o1.sex.compareTo(o2.sex);
                if (ans == 0) {
                    ans = o1.name.compareTo(o2.name);
                }
            }
            return ans;
        };

        public List<Animal> complicatedSort(T animals) {    //task 16
            return animals.stream().sorted(complicatedComp).toList();
        }

        public Boolean whoBites(T animals) { // task 17
            Map<Animal.Type, Long> map = animals.stream()
                .filter(animal -> (animal.type == Animal.Type.SPIDER || animal.type == Animal.Type.DOG)
                    && animal.bites).collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
            return (map.containsKey(Animal.Type.SPIDER)
                && map.containsKey(Animal.Type.DOG)
                && (map.get(Animal.Type.SPIDER) != 0 || map.get(Animal.Type.DOG) != 0)
                && map.get(Animal.Type.SPIDER) > map.get(Animal.Type.DOG));
        }

        public Animal biggestFish(T[] animals) {    //task 18
            return Arrays.stream(animals)
                .map(animalsI -> animalsI.stream().filter(animal -> animal.type == Animal.Type.FISH).max(maxWeight)
                    .orElseThrow()).max(maxWeight)
                .orElseThrow();
        }

        public Map<String, Set<ValidationError>> failedAnimals(T animals) {   //task 19
            return animals.stream().map(animal -> Map.entry(animal.name, ValidationError.validate(animal)))
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue
                ));
        }

        public Map<String, String> beautifyOutput(Map<String, Set<ValidationError>> errorMap) { //task 20
            return errorMap.entrySet().stream().map((entry) -> Map.entry(
                    entry.getKey(),
                    entry.getValue().stream().map(errObj -> errObj.problemFieldName).reduce((x, y) -> x + " " + y)
                ))
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().orElseThrow()));

        }

    }
}
