package multithreading;

/**
 * Этот класс НЕУКЛЮЖЕ, НО демонстрирует как работает синхронизация и как работать с общими ресурсами
 */
class Synchronization {

    public static void main(String[] args) {
        Synchronization synchronization = new Synchronization();

        Resource first = new Resource();

        synchronization.threadAction(first, () -> {
                    first.changeVarWithoutSynch();
                }
        );
        System.out.println(first.getVar());

        //! Можно вынести в отдельный метод

        Resource second = new Resource();

        synchronization.threadAction(second, () -> {
                    second.changeVarWithSynch();
                }
        );

        System.out.println(second.getVar());

    }

    private void threadAction(Resource resource, FunctionInterface method) {
        Thread one = new Thread(() -> {
            method.invokeMethod();
        });

        Thread two = new Thread(() -> {
            method.invokeMethod();
        });

        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Resource {
        int var;

        public int getVar() {
            return var;
        }

        public void setVar(int var) {
            synchronized (this) {
                this.var = var;
            }
        }

        public void changeVarWithoutSynch() {
            int i = this.var;
            Thread.yield(); //! Текущий поток уступит выполнение
            i++;
            this.var = i;
        }

        public synchronized void changeVarWithSynch() {
            int i = this.var;
            i++;
            this.var = i;
        }
    }

    @FunctionalInterface
    interface FunctionInterface {
        void invokeMethod();
    }
}
