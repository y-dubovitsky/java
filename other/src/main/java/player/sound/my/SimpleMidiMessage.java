package player.sound.my;

import javax.sound.midi.MidiMessage;

/**
 * Basis class of MidiMessage class
 */
public class SimpleMidiMessage extends MidiMessage {


    public SimpleMidiMessage() {
        super(new byte[]{44,1,44,100});
    }

    //TODO This is tamp stamp
    @Override
    public Object clone() {
        return null;
    }
}
