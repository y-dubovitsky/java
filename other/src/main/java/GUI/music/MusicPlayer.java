package GUI.music;

import javax.sound.midi.*;

public class MusicPlayer {

    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();

            // open piano
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 61; i+= 4) {
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(128, 1,i, 100, i+2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Вспомогательный статический методод, возвращающий событие.
     * @param comd
     * @param chan
     * @param one
     * @param two
     * @param tick
     * @return
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
