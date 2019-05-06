package GUI.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Event class
 */
public class MyEvent {

    /**
     * List of Listener
     */
    List<EventListener> eventListeners = new ArrayList<>();

    private volatile boolean stop = true;

    public void stopEvent() {
        this.stop = false;
    }

    public void addEventListeners(EventListener e) {
        eventListeners.add(e);
    }

    /**
     * While stop  = true, cycle works.
     */
    public void event() {
        // if event has come, exit from cycle!
        while (stop) {
            if (!eventListeners.isEmpty()) {
                eventListeners.get(0).actionPerformed();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
