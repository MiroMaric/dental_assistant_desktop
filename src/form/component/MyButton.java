/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.component;

import form.ColorConstant;
import javax.swing.JButton;

/**
 *
 * @author MikoPC
 */
public class MyButton extends JButton{

    public MyButton(String text) {
        prepareMyButton(text);
    }

    private void prepareMyButton(String text) {
        setBackground(ColorConstant.GREEN_STRONG);
        setForeground(ColorConstant.GREEN_SPRING);
        setBorder(null);
        setText(text);
        setSize(130,40);
    }

}
