package GUI.music;

import javax.sound.midi.*;

/**
 * Music player without GUI and with static function of creation MidiEvents.
 * version 1.0
 */
public class MusicPlayer1 {

    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();

            // open piano
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 61; i+= 4) {

                // used static method from MusicUtils class
                track.add(MusicUtils.makeEvent(144, 1, i, 100, i));
                track.add(MusicUtils.makeEvent(128, 1,i, 100, i+2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
