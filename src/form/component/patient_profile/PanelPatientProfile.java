package form.component.patient_profile;

import controller.Controller;
import domain.Patient;
import form.cardboard.FormEditCardboard;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PanelPatientProfile extends javax.swing.JPanel {

    Patient patient;

    public PanelPatientProfile(Patient patient) {
        this.patient = patient;
        initComponents();
        adjustPanel();
        populatePatientInfo();
        setIcons();
        addListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFirstname = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        lblhr = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblBirthDate = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblCardboardDate = new javax.swing.JLabel();
        lblDeactivated = new javax.swing.JLabel();
        lblBirthdayIcon = new javax.swing.JLabel();
        lblEmailIcon = new javax.swing.JLabel();
        lblAddressIcon = new javax.swing.JLabel();
        lblPhoneIcon = new javax.swing.JLabel();
        lblCardboardDateIcon = new javax.swing.JLabel();
        lblDeactivatedIcon = new javax.swing.JLabel();
        lblProfileImage = new javax.swing.JLabel();
        btnDeactivate = new javax.swing.JButton();
        btnChangePatient = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));

        lblFirstname.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblFirstname.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFirstname.setText("FIRSTNAME");

        lblLastname.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblLastname.setForeground(new java.awt.Color(255, 255, 255));
        lblLastname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLastname.setText("LASTNAME");

        lblhr.setBackground(new java.awt.Color(255, 255, 255));
        lblhr.setForeground(new java.awt.Color(255, 255, 255));
        lblhr.setText(" ");
        lblhr.setOpaque(true);

        lblEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setText("email");
        lblEmail.setMaximumSize(new java.awt.Dimension(200, 36));
        lblEmail.setMinimumSize(new java.awt.Dimension(200, 36));
        lblEmail.setPreferredSize(new java.awt.Dimension(200, 36));

        lblBirthDate.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblBirthDate.setForeground(new java.awt.Color(255, 255, 255));
        lblBirthDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBirthDate.setText("birthDate");
        lblBirthDate.setMaximumSize(new java.awt.Dimension(200, 36));
        lblBirthDate.setMinimumSize(new java.awt.Dimension(200, 36));
        lblBirthDate.setPreferredSize(new java.awt.Dimension(200, 36));

        lblAddress.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddress.setText("address");
        lblAddress.setMaximumSize(new java.awt.Dimension(200, 36));
        lblAddress.setMinimumSize(new java.awt.Dimension(200, 36));
        lblAddress.setPreferredSize(new java.awt.Dimension(200, 36));

        lblPhone.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhone.setText("phone");
        lblPhone.setMaximumSize(new java.awt.Dimension(200, 36));
        lblPhone.setMinimumSize(new java.awt.Dimension(200, 36));
        lblPhone.setPreferredSize(new java.awt.Dimension(200, 36));

        lblCardboardDate.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblCardboardDate.setForeground(new java.awt.Color(255, 255, 255));
        lblCardboardDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCardboardDate.setText("cardboardDate");
        lblCardboardDate.setMaximumSize(new java.awt.Dimension(200, 36));
        lblCardboardDate.setMinimumSize(new java.awt.Dimension(200, 36));
        lblCardboardDate.setPreferredSize(new java.awt.Dimension(200, 36));

        lblDeactivated.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblDeactivated.setForeground(new java.awt.Color(255, 255, 255));
        lblDeactivated.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeactivated.setText("deactivated");
        lblDeactivated.setMaximumSize(new java.awt.Dimension(200, 36));
        lblDeactivated.setMinimumSize(new java.awt.Dimension(200, 36));
        lblDeactivated.setPreferredSize(new java.awt.Dimension(200, 36));

        lblBirthdayIcon.setText(" ");
        lblBirthdayIcon.setToolTipText("datum rođenja");

        lblEmailIcon.setText(" ");
        lblEmailIcon.setToolTipText("email adresa");

        lblAddressIcon.setText(" ");
        lblAddressIcon.setToolTipText("adresa stanovanja");

        lblPhoneIcon.setText(" ");
        lblPhoneIcon.setToolTipText("telefon");

        lblCardboardDateIcon.setText(" ");
        lblCardboardDateIcon.setToolTipText("datum otvaranja kartona");

        lblDeactivatedIcon.setText(" ");
        lblDeactivatedIcon.setToolTipText("aktivan karton");

        lblProfileImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnDeactivate.setText("Deaktiviraj karton");

        btnChangePatient.setText("Izmeni podatke");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmailIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBirthdayIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAddressIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPhoneIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCardboardDateIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCardboardDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDeactivatedIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDeactivated, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnChangePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDeactivate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblhr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblProfileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(128, 128, 128))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(36, 36, 36))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblhr, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmailIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBirthdayIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddressIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhoneIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCardboardDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCardboardDateIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDeactivated, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDeactivatedIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnChangePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeactivate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        btnDeactivate.getAccessibleContext().setAccessibleDescription("Deaktiviraj karton pacijenta");
        btnChangePatient.getAccessibleContext().setAccessibleDescription("Izmeni osnovne podatke o pacijentu");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePatient;
    private javax.swing.JButton btnDeactivate;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressIcon;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblBirthdayIcon;
    private javax.swing.JLabel lblCardboardDate;
    private javax.swing.JLabel lblCardboardDateIcon;
    private javax.swing.JLabel lblDeactivated;
    private javax.swing.JLabel lblDeactivatedIcon;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailIcon;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhoneIcon;
    private javax.swing.JLabel lblProfileImage;
    private javax.swing.JLabel lblhr;
    // End of variables declaration//GEN-END:variables

    private void populatePatientInfo() {
        lblFirstname.setText(patient.getFirstname());
        lblLastname.setText(patient.getLastname());
        lblEmail.setText(patient.getEmail());
        lblBirthDate.setText(new SimpleDateFormat("dd.MM.yyyy").format(patient.getBirthDate()));
        lblAddress.setText(patient.getAddress());
        lblPhone.setText(patient.getPhone());
        lblCardboardDate.setText(new SimpleDateFormat("dd.MM.yyyy").format(patient.getCardboardDate()));
        lblDeactivated.setText(patient.isDeactivated() + "");
    }

    private void setIcons() {
        lblEmailIcon.setIcon(new ImageIcon("icons/email.png"));
        lblBirthdayIcon.setIcon(new ImageIcon("icons/birthday.png"));
        lblAddressIcon.setIcon(new ImageIcon("icons/address.png"));
        lblPhoneIcon.setIcon(new ImageIcon("icons/phone.png"));
        lblCardboardDateIcon.setIcon(new ImageIcon("icons/cardboardDate.png"));
        lblDeactivatedIcon.setIcon(new ImageIcon("icons/deactivated.png"));
        lblProfileImage.setIcon(new ImageIcon("icons/defaultProfileImage.png"));
    }

    private void adjustPanel() {
        if (patient.isDeactivated()) {
            btnDeactivate.setEnabled(false);
            btnChangePatient.setEnabled(false);
        }
    }

    private void addListeners() {
        if (btnDeactivate.isEnabled()) {
            btnDeactivate.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int answer = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Izaberite opciju", JOptionPane.YES_NO_OPTION);
                    if (answer == 0) {
                        patient.setDeactivated(true);
                        Controller.getInstance().updatePatient(patient);
                        btnDeactivate.setEnabled(false);
                        btnChangePatient.setEnabled(false);
                        btnDeactivate.removeMouseListener(this);
                        for(MouseListener ml:btnChangePatient.getMouseListeners())
                            btnChangePatient.removeMouseListener(ml);
                    }
                }
            });
        }
        if (btnChangePatient.isEnabled()) {
            btnChangePatient.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    FormEditCardboard formEditCardboard = new FormEditCardboard(null, true, patient);
                    formEditCardboard.setVisible(true);
                    formEditCardboard.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            populatePatientInfo();
                        }
                    });
                }
            });
        }
    }
}
