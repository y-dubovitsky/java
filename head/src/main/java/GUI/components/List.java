package GUI.components;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * GUI jList
 */
public class List implements ListSelectionListener {

    JFrame jFrame;
    JList<String> jList;
    int indexCount;

    public List() {
        this.jFrame = new JFrame();
    }

    public static void main(String[] args) {
        List list = new List();
        list.setList();
        list.setSetting();
    }

    public void setList() {
        this.jList = new JList<>(new String[]{"first", "second", "third"});
        this.jList.setFixedCellHeight(5);
        this.jList.addListSelectionListener(this);
        this.jList.setSelectedIndex(1);
        JScrollPane jScrollPane = new JScrollPane(this.jList);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.jFrame.getContentPane().add(BorderLayout.NORTH,jScrollPane);
    }

    public void setSetting() {
        this.jFrame.setSize(300,300);
        this.jFrame.setVisible(true);
        this.jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println(e.getFirstIndex());
    }
}
