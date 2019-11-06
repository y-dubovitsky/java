package second.io.serialize.simple_serialize.entity;

import java.io.Serializable;

/**
 * This simple class implements Serialize;
 */
public class Employee implements Serializable {

    private String name;
    private int wages;
    private int birthday;

    public Employee(String name, int w, int b) {
        this.name = name;
        this.wages = w;
        this.birthday = b;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
