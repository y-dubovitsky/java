package io.serialize.quize.builder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class QuizCardBuilder {

    private JFrame jFrame;
    private JTextArea answers;
    private JTextArea questions;
    private ArrayList<QuizCard> quizCards = new ArrayList<>();

    public static void main(String[] args) {
        QuizCardBuilder q = new QuizCardBuilder();
        q.buildGui();
    }

    public void buildGui() {
        jFrame = new JFrame("QuizCardBuilder");

        // Texts areas
        Font font = new Font("sanserif", Font.BOLD, 14);
        questions = new JTextArea("Questions", 5,5);
        questions.setLineWrap(true);
        questions.setLineWrap(true);
        questions.setFont(font);
        answers = new JTextArea("Answers", 5,5);
        answers.setLineWrap(true);
        answers.setLineWrap(true);
        answers.setFont(font);

        JScrollPane jScrollPaneQuestions = new JScrollPane(
                questions,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        JScrollPane jScrollPaneAnswers = new JScrollPane(
                answers,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        // Button
        JButton jNext = new JButton("Next Card");
        jNext.addActionListener(new jNextListener());

        // Labels
        JLabel jLabelAnswers = new JLabel("Answers");
        JLabel jLabelQuestions = new JLabel("Questions");

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu jFileMenu = new JMenu("File");
        JMenuItem jMenuItemSave = new JMenuItem("Save");
        jMenuItemSave.addActionListener(new ItemSaveListener());
        JMenuItem jMenuItemLoad = new JMenuItem("Load");
        jMenuItemLoad.addActionListener(new ItemLoadListener());
        jFileMenu.add(jMenuItemLoad);
        jFileMenu.add(jMenuItemSave);
        menuBar.add(jFileMenu);

        // Boxing
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(jLabelQuestions);
        box.add(jScrollPaneQuestions);
        box.add(jLabelAnswers);
        box.add(jScrollPaneAnswers);
        box.add(jNext);

        jFrame.setJMenuBar(menuBar);
        jFrame.getContentPane().add(box);
        jFrame.setSize(300,300);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    //TODO Предусмотреть возможность если ничего не выбрано!
    private void saveToFile(File file) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (QuizCard card : this.quizCards) {
                bw.write(card.getAnswer());
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveLikeObject(File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.answers);
            //TODO Нужно запомнить количество записанных объектов!
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSavedAnswers(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.quizCards = (ArrayList<QuizCard>)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    class jNextListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCard quizCard = new QuizCard("answers.txt");
            answers.setText(quizCard.getAnswer());
            quizCards.add(quizCard);
        }
    }

    class ItemSaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(jFrame);
            saveToFile(jFileChooser.getSelectedFile());
        }
    }

    class ItemLoadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showDialog(jFrame, "What do you want to load?");
            // Загружает выбранный файл
            File file = jFileChooser.getSelectedFile();
        }
    }
}
