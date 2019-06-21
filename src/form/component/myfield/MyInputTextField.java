package form.component.myfield;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class MyInputTextField extends MyField {

    protected JTextField txtField;

    public MyInputTextField(String fieldName, String info, String regEx, boolean require) {
        super(fieldName, info, regEx, require);
    }

    @Override
    protected void initFiled() {
        field = new JTextField();
        txtField = (JTextField) field;
    }

    @Override
    public boolean validInputField() {
        return txtField.getText().matches(regEx);
    }

    @Override
    public Object getValueOfField() {
        if (!require && cmbEmpty.isSelected()) {
            return null;
        }
        return txtField.getText();
    }

    @Override
    public void setValue(Object value) {
        txtField.setText(String.valueOf(value));
    }

    @Override
    protected void addListeners() {
        txtField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                getLblInfo().setVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getLblInfo().setVisible(false);
            }
        });

        if (regEx == null) {
            return;
        }

        txtField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (!validInput()) {
                    lblIcon.setIcon(new ImageIcon(getClass().getResource("/icon/false.png")));
                } else {
                    lblIcon.setIcon(new ImageIcon(getClass().getResource("/icon/true.png")));
                }
            }
        });
    }

}
