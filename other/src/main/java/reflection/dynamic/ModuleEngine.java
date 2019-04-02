package reflection.dynamic;

import java.io.File;

/**
 * Loader Main
 */
public class ModuleEngine {

    static String path = "C:\\Users\\user\\IdeaProjects\\java\\other\\src\\main\\java\\reflection\\dynamic\\";

    public static void main(String[] args) {
        DynamicClassOverloader d = new DynamicClassOverloader(path, ClassLoader.getSystemClassLoader());

        // Getting list of available modules
        File dir = new File(path);
        String[] modules = dir.list();

        // Getting and execute module
        for (String module : modules) {
            try {
                // trim .java need refactoring
                String moduleName = module.substring(0, module.length() - 5); // trim .java
                Class clazz = d.loadClass("reflection.dynamic." + moduleName);

                // if substitute Modulation to Module, it will be working...
                if (Modulation.class.isAssignableFrom(clazz)) {
                    Modulation execute = (Modulation) clazz.newInstance();
                    execute.sout();
                }
            } catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * This method checking implementation Interface.
     * @param clazz
     * @return
     */
    private boolean checkingInterface(Class clazz, String interfacee) {
        // Array of all interfaces.
        Class[] interfacesList = clazz.getInterfaces();

        // checking implementation interface! need refactoring!
        boolean flag = false;
        for (int i = 0; i < interfacesList.length; i++) { //interfacee
            flag = interfacesList[i].toString().equals("interface reflection.dynamic.Modulation");
        }
        return flag;
    }
}

