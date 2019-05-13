package form.component.myfield;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class MyInputPasswordField extends MyField {

    private JPasswordField passField;

    public MyInputPasswordField(String fieldName, String info, String regEx,boolean require) {
        super(fieldName, info, regEx,require);
    }

    @Override
    protected void initFiled() {
        field = new JPasswordField();
        passField = (JPasswordField)field;
    }

    
    @Override
    public boolean validInputField() {
        return new String(passField.getPassword()).matches(regEx);
    }

    @Override
    public Object getValueOfField() {
        return new String(passField.getPassword());
    }
    
    @Override
    protected void addListeners() {
        passField.addFocusListener(new FocusAdapter() {
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
        
        passField.addKeyListener(new KeyAdapter() {
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
