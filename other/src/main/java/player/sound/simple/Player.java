package player.sound.simple;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class play midi-files;
 */
public class Player {

    /**
     * Path to midi-file;
     */
    //TODO Не универсально! Нужно улучшить
    private String path = "C:\\Users\\user\\IdeaProjects\\java\\other\\src\\main\\resources\\2079.mid";

    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) {
        Player player = new Player();
        player.playSound();
    }

    /**
     * This method play sound;
     */
    public void playSound() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.setSequence(midiFromFile(path));
            sequencer.open();
            sequencer.start();
        } catch (IOException | InvalidMidiDataException | MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method return IS from midi file;
     * @param path
     */
    public InputStream midiFromFile(String path) {
        InputStream i = null;
        try {
            i = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }
}
