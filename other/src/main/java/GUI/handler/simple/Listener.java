package GUI.handler.simple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Listener
 */
public class Listener implements ActionListener {

    AWTEvent action;

    /**
     * When user press the button or something else, this method invoke!
     * @param e - no matter what is it!
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.action = e;
        System.out.println("Hello it is Event");
        //this.actionInfo();
    }

    public void actionInfo() {
        //TODO Доделать! Этот методы вызвает все методы класса по имени!
        Class<?> clazz = action.getClass();
        Method[] methods = clazz.getMethods();
        try {
            for (int i = 0; i < methods.length; i++) {
                methods[i].invoke(methods[i].getName());
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
