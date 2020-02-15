package collections.collections_class;

public class Human implements Comparable<Human> {

    private Age age;
    private Nationality nationality;

    public Human(Age age, Nationality nationality) {
        this.age = age;
        this.nationality = nationality;
    }

    public Age getAge() {
        return age;
    }

    public Nationality getNationality() {
        return nationality;
    }

    /**
     * Сортируем людей по возрасту
     * @param o
     * @return
     */
    @Override
    public int compareTo(Human o) {
        if (this.age.name().compareTo(o.age.name()) > 0) {
            return 1;
        } else if (this.age.name().compareTo(o.age.name()) < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.age.name() + " " + this.nationality.name();
    }
}
