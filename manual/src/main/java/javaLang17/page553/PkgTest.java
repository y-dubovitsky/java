package main.java.javaLang17.page553;

public class PkgTest {
    public static void main(String[] args) {
        Package packge[];

        packge = Package.getPackages();
        for (int i = 0; i < packge.length; i++) {
            System.out.println(packge[i].getName());
            System.out.println(packge[i].getAnnotations());
            System.out.println(packge[i].getSpecificationVendor());
            System.out.println(packge[i].getSpecificationVersion() + "\n");
        }
        // Диспетчер защиты
        System.out.println(System.getSecurityManager());
    }
}

class MySecurityManager extends SecurityManager {
    public static void main(String[] args) {
        MySecurityManager mySecurityManager = new MySecurityManager();
        System.out.println(mySecurityManager);
    }
}
