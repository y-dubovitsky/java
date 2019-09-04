package lambda;

interface Change<T extends Dog> {
    void setSate(T o, String name);
}

class Dog {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class ChangeStateWithLambda {

    private static <T extends Dog> void changeState(T dog, String name) {
        dog.setName(name);
    }

    public static void main(String[] args) {
        Change change = (o, name) -> {
            o.setName(name);
        };

        Dog dog = new Dog("Hello my name is Rex");
        System.out.println(dog);
        changeState(dog, "Matthey");
        System.out.println(dog);
    }

}
