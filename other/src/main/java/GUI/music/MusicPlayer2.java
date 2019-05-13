package GUI.music;

import javax.sound.midi.*;

/**
 * Music player with ControllerEvent
 * version 2.0
 */
public class MusicPlayer2 implements ControllerEventListener {
    public static void main(String[] args) {
        MusicPlayer2 musicPlayer2 = new MusicPlayer2();
        musicPlayer2.start();
    }

    /**
     * Lets get started music!
     */
    public void start() {
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            // create my event for observation
            int[] userEvent = {127};
            sequencer.addControllerEventListener(this, userEvent);

            for (int i = 6; i < 60; i+=4) {
                track.add(MusicUtils.makeEvent(144, 1, i, 100, i));

                // add my event for observer
                // See in book what is 176 and 127. 176 - controllerEvent, 127 - number of Event
                track.add(MusicUtils.makeEvent(176, 1,127,100,i));
                track.add(MusicUtils.makeEvent(128,1, i, 100, i+2));
            }
            sequencer.setSequence(sequence);

            // i dont understand, what is doing this method.
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("Event was created!");
    }
}
