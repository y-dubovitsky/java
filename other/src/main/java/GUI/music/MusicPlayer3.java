package GUI.music;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

/**
 * Music player with GUI.
 */
public class MusicPlayer3 {

    static JFrame jFrame = new JFrame();
    static DrawPanel drawPanel;

    public static void main(String[] args) {
        MusicPlayer3 musicPlayer3 = new MusicPlayer3();
        musicPlayer3.start();
    }

    /**
     * Settings
     */
    public MusicPlayer3() {
        drawPanel = new DrawPanel();
        jFrame.setContentPane(drawPanel);
        jFrame.setBounds(30,30,300, 300);
        jFrame.setVisible(true);
    }

    public void start() {
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            //TODO Вот с этим моментом разобраться
            sequencer.addControllerEventListener(drawPanel, new int[] {127});
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            int r = 0;
            for (int i = 5; i < 55; i+= 4) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(MusicUtils.makeEvent(144, 1,r,100,i));
                track.add(MusicUtils.makeEvent(176, 1,127,0,i));
                track.add(MusicUtils.makeEvent(128, 1,r,100,i + 2));
            }
            sequencer.setSequence(sequence);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Inner class for GUI
     */
    class DrawPanel extends JPanel implements ControllerEventListener {

        boolean msg = false;

        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (msg) {
                Graphics2D g2 = (Graphics2D) g;

                //TODO Сделать рефакторинг
                int r = (int)(Math.random() * 250);
                int gr = (int)(Math.random() * 250);
                int b = (int)(Math.random() * 250);

                g2.setColor(new Color(r,gr,b));

                int x = (int)((Math.random() * 40) + 10);
                int y = (int)((Math.random() * 40) + 10);
                int w = (int)((Math.random() * 120) + 10);
                int h = (int)((Math.random() * 120) + 10);

                g2.fillRect(x, y, h, w);
                msg = false;
            }
        }
    }
}
