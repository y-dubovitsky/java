package GUI.event;

/**
 * My Listener
 */
public class MyEventListener implements EventListener {

    /**
     * When the event comes, this method started!
     */
    public void actionPerformed() {
        System.out.println("actionPerformed " + Math.random() * 1000);
    }
}
