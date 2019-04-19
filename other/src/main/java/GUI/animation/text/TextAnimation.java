package GUI.animation.text;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.URL;

public class TextAnimation {

    private JFrame jFrame;

    public TextAnimation(int x, int y) {
        this.jFrame = new JFrame();
        jFrame.setSize(x,y);
        jFrame.setVisible(true);
    }

    //TODO Not work!
    public void start() {
        Animation animation = new Animation(new JLabel("One Two Three"));
        Image image = new Image();
        for (int i = 0; i < 100; i++) {
            //TODO Не понятно animation.getjLabel()
            this.jFrame.getContentPane().add(BorderLayout.WEST, animation.getjLabel());
            this.jFrame.getContentPane().add(BorderLayout.EAST, animation);
            this.jFrame.getContentPane().add(BorderLayout.CENTER, image);
            //TODO Используем сеттер
            animation.setjLabel();
            image.repaint();
            animation.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TextAnimation t = new TextAnimation(500,500);
        t.start();
    }

    //TODO Нне работает если расширить класс JPanel?????
    class Animation extends JPanel{

        JLabel jLabel;

        Animation(JLabel jLabel) {
            this.jLabel = jLabel;
        }

        public JLabel getjLabel() {
            return this.jLabel;
        }

        public void setjLabel() {
            System.out.println("Sets");
            this.jLabel = new JLabel(new GUI.handler.inner.Utils().getText());
        }

        //TODO Теперь работает
        @Override
        protected void paintComponent(Graphics g) {
            System.out.println("TRololololo");
        }
    }

    class Image extends JPanel {

        String path = "/lion.png";
        // Work
        int x = 50;
        int y = 50;

        @Override
        protected void paintComponent(Graphics g) {
            System.out.println("Image");
            URL url = this.getClass().getResource(path);
            ImageIcon image = new ImageIcon(url);
            // Pay attention to x ++ y ++
            g.drawImage(image.getImage(), x++, y++, new ImageObserver() {
                @Override
                public boolean imageUpdate(java.awt.Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        }
    }
}
