package player.sound.simple;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import java.io.*;


/**
 * This class play midi-files;
 */
public class Player {

    /**
     * Path to midi-file;
     */
    private String path = "2079.mid";

    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) throws Exception{
        Player player = new Player();
        player.playSound();
    }

    /**
     * This method play sound;
     */
    public void playSound() throws Exception{
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
    public InputStream midiFromFile(String path) throws Exception{
        ClassLoader loader = this.getClass().getClassLoader();
        return loader.getResourceAsStream(path);
    }
}
