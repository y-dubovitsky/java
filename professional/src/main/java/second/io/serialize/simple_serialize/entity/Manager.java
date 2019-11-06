package second.io.serialize.simple_serialize.entity;

import java.io.Serializable;

public class Manager implements Serializable, Worker {

    private String name;
    private int wages;
    private int birthday;
    private Secretary secretary;

    public Manager(String name, Secretary secretary, int w, int b) {
        this.name = name;
        this.wages = w;
        this.birthday = b;
        this.secretary = secretary;
    }

    @Override
    public String toString() {
        return "Manager " + this.name + " has a secretary " + this.secretary;
    }

}
