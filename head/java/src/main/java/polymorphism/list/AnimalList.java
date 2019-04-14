package polymorphism.list;

/**
 * Simple List
 */
public class AnimalList {

    private Animal[] animals = new Animal[10];
    private int position = 0;

    public void add(Animal animal) {
        if (position < animals.length) {
            animals[position] = animal;
            position++;
        }
    }
    //TODO add dynamic extension
}
