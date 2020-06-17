package io.serialize.quize.player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class QuizCardPlayer {

    private JFrame jFrame;
    private JTextArea jTextArea;
    private ArrayList<QuizeCard> list;
    private JButton jButton;
    private boolean isAnswer = false;

    /**
     * Simple Constructor
     */
    public QuizCardPlayer() {
        list = new ArrayList<>();
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        QuizCardPlayer q = new QuizCardPlayer();
        q.createGui();
    }

    /**
     * This method created GUI
     */
    public void createGui() {
        jFrame = new JFrame("QuizCard Player");

        // Font create
        Font font = new Font("sanserif", Font.BOLD, 24);

        // text area
        jTextArea = new JTextArea(100,200);
        jTextArea.setFont(font);
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(true);

        // scroll
        JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        // add to the scroll panel text area
        jScrollPane.add(jTextArea);

        // Button
        jButton = new JButton("Press Me");
        jButton.addActionListener(new ButtonActionListener());

        // Menu
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");
        JMenuItem jLoadMenu = new JMenuItem("Load");
        jLoadMenu.addActionListener(new LoadMenuListener());
        JMenuItem jSaveMenu = new JMenuItem("Save");
        jMenu.add(jLoadMenu);
        jMenu.add(jSaveMenu);
        jMenuBar.add(jMenu);

        // Box
        //TODO Как разместить все четко по центру?
        Box box = new Box(BoxLayout.PAGE_AXIS);
        box.add(jScrollPane);
        box.add(jButton);

        // frame settings
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(box);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(500,500);
        jFrame.setVisible(true);
    }

    /**
     * This class is responsible for processing button clicks.
     */
    class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isAnswer) {
                // задать вопрос
                if (list.isEmpty()) {
                    jTextArea.setText("List is empty! Please, loading questions");
                } else {
                    //jTextArea.setText(list.get(i));
                }
                isAnswer = true;
            } else {
                // показать ответ
                isAnswer = false;
            }
        }

        public void setNextCard() {
            //TODO Метод должен перелистывать карточки
            // Можно ввести еще одну кнопку "Следующая карточка"
        }
    }

    /**
     * This class is responsible for processing menu clicks.
     */
    class LoadMenuListener implements ActionListener {

        /**
         * Dialog between users and machine. Chose files with answers and questions.
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser();
            //TODO It is too difficult, need refactoring!
            jFileChooser.showOpenDialog(jFrame);
            File answers = jFileChooser.getSelectedFile();
            jFileChooser.showOpenDialog(jFrame);
            File questions = jFileChooser.getSelectedFile();
            loadFromFile(answers, questions);
        }

        /**
         * Loading answers and questions from file and create Flash Cards.
         * @param answers
         * @param questions
         */
        //TODO need refactoring!
        public void loadFromFile(File answers, File questions) {
            try(BufferedReader brAns = new BufferedReader(new FileReader(answers));
                BufferedReader brQus = new BufferedReader(new FileReader(questions))) {
                String strAns;
                String strQus;
                while (((strAns = brAns.readLine()) != null) && ((strQus = brQus.readLine()) != null)) {
                    list.add(new QuizeCard(strAns, strQus));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
