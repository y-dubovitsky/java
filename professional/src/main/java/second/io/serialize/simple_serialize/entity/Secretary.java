package second.io.serialize.simple_serialize.entity;

import java.io.Serializable;

public class Secretary implements Worker, Serializable {

    private String name;
    private int wages;
    private int birthday;

    public Secretary(String name, int w, int b) {
        this.name = name;
        this.wages = w;
        this.birthday = b;
    }

    public void raiceWages(int wages) {
        this.wages = wages;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
