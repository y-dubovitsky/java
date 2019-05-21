package network.sockets.adviser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JFrame jFrame;
    private Box box;
    private JTextArea jTextArea;
    private JLabel jLabel;
    private JButton jButton;

    private String str;

    public void setStr(String str) {
        this.str = str;
    }

    public void createInterface() {
        // settings
        jFrame = new JFrame();
        box = new Box(BoxLayout.Y_AXIS);
        jTextArea = new JTextArea();
        jLabel = new JLabel("Chat");
        jButton = new JButton("Send Message");

        box.add(this.jLabel);
        box.add(this.jTextArea);
        box.add(this.jButton);
        jFrame.getContentPane().add(box);

        jFrame.setSize(300,300);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        jButton.addActionListener(new SendingListener());
    }

    class SendingListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jTextArea.setText(str);
        }
    }

}
