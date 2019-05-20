package GUI.beatbox;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * BeatBox class;
 */
public class BeatBox {

    JFrame jFrame;
    JPanel mainPanel;

    // List of the checkbox
    private ArrayList<JCheckBox> checkBoxes;

    // for music
    Sequencer sequencer;
    Sequence sequence;
    Track track;

    String[] instrumentsNames = {"Buss Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
            "Hand Clap", "High Tom"};

    int[] instrumentsNumbers = {35,42,46,38,49,39,50};

    // CheckBox state
    private ArrayList<Boolean> checkBoxStates = new ArrayList<>();

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        BeatBox beatBox = new BeatBox();
        beatBox.buildGUI();
    }

    /**
     * This method create GUI
     */
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

        // Serialize
        JButton jSaveState = new JButton("Save State");
        jSaveState.addActionListener(new SaveListener());
        buttonBox.add(jSaveState);

        JButton jLoadSate = new JButton("Load State");
        jLoadSate.addActionListener(new LoadListener());
        buttonBox.add(jLoadSate);

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

    /**
     * Inner class for processing user`s click on "save" button;
     */
    class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < checkBoxes.size(); i++) {

                // add state of checkbox into list
                checkBoxStates.add(checkBoxes.get(i).isSelected());
            }

            // Save dialog
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(jFrame);
            File file = jFileChooser.getSelectedFile();

            try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file))) {
                o.writeObject(checkBoxStates);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Inner class for processing user`s click on "load" button;
     */
    class LoadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showDialog(jFrame, "Load");
            File file = jFileChooser.getSelectedFile();

            try(ObjectInputStream o = new ObjectInputStream(new FileInputStream(file))) {
                checkBoxStates = (ArrayList<Boolean>)o.readObject();
                for (int i = 0; i < checkBoxStates.size(); i++) {
                    checkBoxes.get(i).setSelected(checkBoxStates.get(i));
                }
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
