package main.java.generics14.example2;

public class InterfaceGenShow<T extends InterGenClass> implements InterGen<T> {

    T value;

    public T method() {
        return this.value;
    }

    public static void main(String[] args) {

    }
}

class ABCClass implements ABC {

}

class InterGenClass extends ABCClass implements InterGen {

    @Override
    public ABC method() {
        return null;
    }
}

interface InterGen<T extends ABC> {
    T method();
}

interface ABC {

}
