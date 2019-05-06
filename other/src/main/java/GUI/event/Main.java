package GUI.event;

/**
 * Testing class
 */
public class Main {

    /**
     * Main method
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{

        //TODO
        // Добавить многопоточность, так как так не работает
        // Вечный цикл

        MyEvent myEvent = new MyEvent();
        myEvent.addEventListeners(new MyEventListener());
        myEvent.event();

        //sleeping 5 sec
        Thread.sleep(5000);

        // the event has come
        myEvent.stopEvent();
    }
}
