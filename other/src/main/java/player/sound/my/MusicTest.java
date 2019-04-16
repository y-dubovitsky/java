package player.sound.my;

import javax.sound.midi.*;

/**
 * Musical instrument class
 */
public class MusicTest {

    //TODO what is it?
    private Sequencer sequencer;
    private Sequence seq;

    private Track track;

    // default parameters of MidiMessage
    private int[] array = new int[]{144, 1, 44, 100};

    /**
     * Constructor
     */
    public MusicTest() {
        try {
            // Getting new musical instrument and open it!
            this.sequencer = MidiSystem.getSequencer();
            this.sequencer.open();

            // create new musical sequence; this is what instrument will be play
            this.seq = new Sequence(Sequence.PPQ, 4);
            // Getting new Track
            this.track = seq.createTrack();
        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    //TODO Make this method more abstract
    /**
     * THis method create MIDI music;
     * @param tick - time of play sound
     * @param value - structure of Short Message;
     * @return
     */
    public MidiEvent messageCreate(int tick, int... value) {
        ShortMessage shortMessage = new ShortMessage();
        try{
            shortMessage.setMessage(value[0], value[1], value[2], value[3]);
        }catch (InvalidMidiDataException i) {
            // TODO add behaviour
            i.printStackTrace();
        }
        MidiEvent midiEvent = new MidiEvent(shortMessage, tick);
        return midiEvent;
    }

    public void startPlay() {
        try {
            for (int i = 0; i < 100; i++) {
                track.add(this.messageCreate(i, 144,1,44, 100));
            }

            //TODO I don`t know, work it or not...
            // track.add(new MidiEvent(new SimpleMidiMessage(), 1));

            //
            this.sequencer.setSequence(seq);
            this.sequencer.start();
        } catch (InvalidMidiDataException m) {
            m.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MusicTest m = new MusicTest();
        m.startPlay();
    }
}
