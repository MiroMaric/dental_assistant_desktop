package form.cardboard;

import controller.Controller;
import domain.Patient;
import icon.ErrorIcon;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author MikoPC
 */
public class FormNewCardboard extends FormCardboardInfo {

    public FormNewCardboard(Frame parent, boolean modal) {
        super(parent, modal);
        prepareForm();
    }

    private void prepareForm() {
        setTitle("Novi karton");
        btn.setText("Kreiraj");
        btn.addActionListener((ActionEvent e) -> {
            if (formIsValid()) {
                Patient patient = getPatient();
                if (Controller.getInstance().savePatient(patient)) {
                    JOptionPane.showMessageDialog(this, "Novi karton je krairan", "", JOptionPane.OK_OPTION);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Došlo je do greške", "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Podaci nisu uneti ispravno", "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
            }
        });
    }

}
