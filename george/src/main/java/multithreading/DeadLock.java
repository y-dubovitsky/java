package multithreading;

/**
 * Этот класс показывает, что такое ДэдЛок
 */
class DeadLock {

    public static void main(String[] args) {
        Resource a = new ResourceImpl();
        Resource b = new ResourceImpl();
        a.setResource(b); //! Оден ресурс ссылается на другой ресурс
        b.setResource(a);

        for (int i = 0; i < 10; i++) { //* В цикле создаются 2 потока, и вызываются на выполнение
            CustomThread one = new CustomThread();
            one.setResource(a);

            CustomThread two = new CustomThread();
            two.setResource(b);

            one.start();
            two.start();
        }
    }

    static class CustomThread extends Thread {

        Resource resource;

        public void setResource(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            resource.invokeResourceMethod();
        }
    }

    static class ResourceImpl implements Resource{

        Resource resource; //* Ссылка на другой ресурс
        String var = Resource.class.getCanonicalName();

        public void setResource(Resource resource) { //* Просто сеттер
            this.resource = resource;
        }

        public synchronized void printVar() {
            System.out.println(var);
        }

        public synchronized void invokeResourceMethod() { //! ВОТ ТУТ САМОЕ ГЛАВНОЕ, РЕСУРС вызывает СИНХРОНИЗИРОВАННЫЙ метод другого ресурса
            resource.printVar();
        }

    }

    interface Resource {
        void invokeResourceMethod();
        void setResource(Resource resource);
        void printVar();
    }

}
