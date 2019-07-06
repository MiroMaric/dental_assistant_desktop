package form.cardboard;

import controller.Controller;
import domain.Patient;
import icon.ErrorIcon;
import icon.SuccessIcon;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author MikoPC
 */
public class FormEditCardboard extends FormCardboardInfo {

    public FormEditCardboard(Frame parent, boolean modal, Patient patient) {
        super(parent, modal, patient);
        prepareForm();
    }

    private void prepareForm() {
        setTitle("Izmena podataka o pacijentu");
        populateForm(patient);
        btn.setText("Izmeni");
        btn.addActionListener((ActionEvent e) -> {
            if (formIsValid()) {
                try {
                    Controller.getInstance().updatePatient(getNewPatientFromForm());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
                    return;
                }
                populatePatient();
                JOptionPane.showMessageDialog(this, "Podaci o pacijentu su uspešno izmenjeni", "Uspešno izmenjeni podaci", JOptionPane.OK_OPTION, new SuccessIcon());
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Podaci nisu uneti ispravno", "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
            }
        });
    }

}
