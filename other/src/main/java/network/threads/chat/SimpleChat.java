package network.threads.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class SimpleChat {

    private JTextArea incoming;
    private JTextField outgoing;
    private BufferedReader reader;
    private PrintWriter writer;


    String ip;
    int port;
    Socket socket;

    public SimpleChat(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public static void main(String[] args) {
        SimpleChat simpleChat = new SimpleChat("127.0.0.1", 4343);
        simpleChat.start();
    }

    public void start() {
        JFrame jFrame = new JFrame("Java Simple Chat");
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15,50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEnabled(true);
        JScrollPane jScrollPane = new JScrollPane(
                incoming,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        outgoing = new JTextField(20);
        JButton jButton = new JButton("Send");
        jButton.addActionListener(new SendButtonListener());
        mainPanel.add(jScrollPane);
        mainPanel.add(outgoing);
        mainPanel.add(jButton);

        // starting
        setUpNetWorking();

        // start receive msg
        Thread thread = new Thread(new IncomingReader());
        thread.start();

        // add elements on frame
        jFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        jFrame.setSize(400,400);
        jFrame.setVisible(true);
    }

    private void setUpNetWorking() {
        try{
            socket = new Socket(ip, port);
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class SendButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            writer.println(outgoing.getText());
            writer.flush();
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    class IncomingReader implements Runnable {

        @Override
        public void run() {
            String msg;
            try{
                while ((msg = reader.readLine()) != null) {
                    System.out.println("read " + msg);
                    incoming.append(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
