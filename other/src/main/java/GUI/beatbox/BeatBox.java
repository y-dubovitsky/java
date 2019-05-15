package GUI.beatbox;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BeatBox {

    JFrame jFrame;
    JPanel mainPanel;

    // List of the checkbox
    ArrayList<JCheckBox> checkBoxes;
    Sequencer sequencer;
    Sequence sequence;
    Track track;

    String[] instrumentsNames = {"Buss Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
    "Hand Clap", "High Tom"};

    int[] instrumentsNumbers = {35,42,46,38,49,39,50};

    public static void main(String[] args) {
        BeatBox beatBox = new BeatBox();
        beatBox.buildGUI();
    }

    public void buildGUI() {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout borderLayout = new BorderLayout();
        JPanel background = new JPanel(borderLayout);

        // ??
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        checkBoxes = new ArrayList<>();

        // Создает ящик, который располагает все элементы вдоль оси х.
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        // Create start button
        JButton jStart = new JButton("Start");
        jStart.addActionListener(new StartListener());
        buttonBox.add(jStart);

        // Create Stop button
        JButton jStop = new JButton("Stop");
        jStop.addActionListener(new StopListener());
        buttonBox.add(jStop);

        // Create upTempo button
        JButton jUp = new JButton("Up Tempo");
        jUp.addActionListener(new UpListener());
        buttonBox.add(jUp);

        // Create upTempo button
        JButton jDown = new JButton("Down Tempo");
        jDown.addActionListener(new DownListener());
        buttonBox.add(jDown);

        // Ящик для имен
        Box namesBox = new Box(BoxLayout.Y_AXIS);

        for (int i = 0; i < instrumentsNames.length; i++) {
            namesBox.add(new Label(instrumentsNames[i]));
        }

        // Размещаем на панели "ящики"
        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, namesBox);

        // Добавляем панель на фрейм
        jFrame.getContentPane().add(background);

        //TODO Attention!
        GridLayout grid = new GridLayout(7,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 112; i++) {
            JCheckBox j = new JCheckBox();
            j.setSelected(false);
            checkBoxes.add(j);
            mainPanel.add(j);
        }

        jFrame.setBounds(50,50,300,300);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrack() {

    }

    class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class StopListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class UpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class DownListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
