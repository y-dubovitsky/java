package collection.comparable;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Main class
 */
public class Songs {

    private List<Song> list;
    private final String path = "names.txt";

    public static void main(String[] args) {
        Songs songs = new Songs();
        songs.addSong();
        // can be replace by lambda
        songs.sorted(new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
    }

    public void sorted(Comparator<Song> comparator) {
        // before
        sout(list);
        this.list.sort(comparator);
        System.out.println();
        // Заменяет исходный список на отсортированный!
        sout(list);
    }

    private void sout(@NotNull List<Song> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getTitle() + " ");
            System.out.println();
        }
    }

    /**
     * Add new Songs into list from the source.
     */
    public void addSong() {
        this.list = new ArrayList<>();
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String str;
            while ((str = br.readLine()) != null) {
                list.add(new Song(str, Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
