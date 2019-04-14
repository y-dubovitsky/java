package player.sound;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import static java.lang.System.out;

public class MusicTest {
    public Sequencer sequencer;

    public MusicTest() {
        try {
            this.sequencer = MidiSystem.getSequencer();
        } catch (MidiUnavailableException m) {
            m.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MusicTest m = new MusicTest();
    }
}
