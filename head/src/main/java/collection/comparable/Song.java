package collection.comparable;

/**
 * A song class;
 */
public class Song {

    private String title;
    private double time;

    public Song(String title, double time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public double getTime() {
        return time;
    }
}
