package main.java.string16.example5;

class MyClassParent {
    String name = "";

    MyClassParent() {

    }

    MyClassParent(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return name;
    }
}

class MyClass extends MyClassParent {
    static MyClassParent myClassParent;

    MyClass(MyClassParent mcp) {
        myClassParent = mcp;
    }

    @Override
    public String toString() {
        super.toString();
        return myClassParent.name;
    }
}

public class InsertShow {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Дратути!");
        System.out.println("sb до insert = " + sb);
        MyClassParent myClassParent = new MyClassParent("MyClassParent");
        MyClass myClass = new MyClass(myClassParent);
        sb.insert(sb.length(), MyClass.myClassParent);
        System.out.println("sb после insert = " + sb);
    }
}
