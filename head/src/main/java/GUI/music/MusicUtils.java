package GUI.music;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Various utils for creation MIDI-instruction, events and etc...
 */
public class MusicUtils {

    /**
     * Auxiliary(вспомогательный) method for creation MidiEvents.
     * @param comd - command for midi instruction
     * @param tick - timing
     * @return - MidiEvent
     */
    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent midiEvent = null;
        try{
            ShortMessage shortMessage = new ShortMessage();
            shortMessage.setMessage(comd, chan, one, two);
            midiEvent = new MidiEvent(shortMessage, tick);
        } catch (Exception e) {

        }
        return midiEvent;
    }
}
