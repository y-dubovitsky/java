package lambda;

interface WithNameAndAge {
    void setName(String name);
    void setAge(int age);
}

@FunctionalInterface
interface Settable<C extends WithNameAndAge> {
    void set(C entity, String name, int age);
}

class Cat implements WithNameAndAge {

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ChangeStateOfObjectWithLambda {

    private static <T extends WithNameAndAge>  void changeEntity(T entity, Settable<T> s) {
        s.set(entity, "Мурзик", 3);
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat);

        Settable<Cat> catSettable = (obj, name, age) -> {
            obj.setName(name);
            obj.setAge(age);
        };

        // вызываем метод, в который передаем кота и лямбду
        changeEntity(cat, catSettable);
        // выводим на экран и видим, что состояние кота изменилось (имеет имя и возраст)
        System.out.println(cat);
    }
}
