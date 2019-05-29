package collection.generics.list;

import java.util.ArrayList;

/**
 * In this class demonstrated how to use Generics and WildCards!
 */
public class ArList {

    public static void main(String[] args) {
        new ArList().start();
    }

    public void start() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal());
        list.add(new Dog());
        list.add(new Cat());

        // invoke method
        takeAnimalList(list);

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());

        // This is not work! Because we can pass to method ONLY! ArrayList<Animal>
        //takeAnimalList(dogs);

        // Arrays
        Dog[] dogss = {new Dog(), new Dog(), new Dog()};
        takeAnimalArray(dogss);

        // Wildcard
        takeAnimalWildcard(list);

        ArrayList<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());
        dogList.add(new Dog());
        takeAnimalWildcard(dogList);
    }

    /**
     * Method on;y for testing
     */
    private void check() {
        // <Object> = <Object>
        //ArrayList<Object> list = new ArrayList<Dog>();
    }

    private void takeAnimalList(ArrayList<Animal> list) {
        for(Animal a : list) {
            a.eat();
        }
    }

    private void takeAnimalArray(Animal[] array) {
        //array[array.length + 1] = new Cat();
        // Attention! You can`t do this! Why? Look up!
        //array[0] = new Cat();
        for (Animal a: array) {
            a.eat();
        }
    }

    private void takeAnimalWildcard(ArrayList<? extends Animal> list) {
        for (Animal a: list) {
            a.eat();
        }
    }

    /**
     * below are shown inner simple classes.
     */
    class Animal {
        public void eat() {
            System.out.println("Eat the food");
        }
    }

    class Dog extends Animal {
        public void bark() {
            System.out.println("Uaf Uaf Gav");
        }
    }

    class Cat extends Animal {
        public void meow() {
            System.out.println("Meow meow meow");
        }
    }
}
