package form;

import controller.Controller;
import domain.Patient;
import form.component.myfield.MyField;
import form.component.myfield.MyInputDateField;
import form.component.myfield.MyInputTextField;
import java.util.Date;

public class FormNewCardboard extends javax.swing.JDialog {

    public FormNewCardboard(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        ajdustDialog();
        initFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCeateCardboard = new javax.swing.JButton();
        pnlNewCardboard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novi karton");
        setBackground(new java.awt.Color(0, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCeateCardboard.setText("Kreiraj");
        btnCeateCardboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCeateCardboardActionPerformed(evt);
            }
        });

        pnlNewCardboard.setPreferredSize(new java.awt.Dimension(0, 542));
        pnlNewCardboard.setLayout(new java.awt.GridLayout(6, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNewCardboard, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCeateCardboard, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNewCardboard, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCeateCardboard, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCeateCardboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCeateCardboardActionPerformed
        String firstname = (String)pnlFirstname.getValue();
        String lastname = (String)pnlLastname.getValue();
        String email = (String)pnlEmail.getValue();
        Date birthDate = (Date)pnlBirthDate.getValue();
        String adress = (String)pnlAdress.getValue();
        String phone = (String)pnlPhone.getValue();
        Patient patient = new Patient(firstname, lastname, email, adress, phone, birthDate, new Date());
        Controller.getInstance().savePatient(patient);
    }//GEN-LAST:event_btnCeateCardboardActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCeateCardboard;
    private javax.swing.JPanel pnlNewCardboard;
    // End of variables declaration//GEN-END:variables
    MyField pnlFirstname;
    MyField pnlLastname;
    MyField pnlEmail;
    MyField pnlBirthDate;
    MyField pnlAdress;
    MyField pnlPhone;

    private void ajdustDialog() {
        getContentPane().setBackground(ColorConstant.GREEN_SPRING);
        setBackground(ColorConstant.GREEN_SPRING);
        pnlNewCardboard.setBackground(ColorConstant.GREEN_SPRING);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initFields() {
        pnlEmail = new MyInputTextField("E-pošta:", "E-pošta mora biti valida, e.g. me@mydomain.com", "^(([a-zA-Z\\d_\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?)$",false);
        pnlFirstname = new MyInputTextField("Ime:", "Ime mora imati 2 - 15 karaktera", "^(([A-Za-z]){2,15})$",true);
        pnlLastname = new MyInputTextField("Prezime:", "Prezime mora imati 2 - 15 karaktera", "^(([A-Za-z]){2,15})$",true);
        pnlAdress = new MyInputTextField("Adresa:", "Adresa mora imati 4 - 20 karaktera", "^(([\\w, ]){4,20})$",false);
        pnlPhone = new MyInputTextField("Telefon:", "Telefon mora biti unet u ispravnom formatu", "^((\\d){7,10})$",false);
        pnlBirthDate = new MyInputDateField("Datum rodjenja:", "Datum mora biti unetu u formatu dd.MM.yyyy", "dd.MM.yyyy",false);
        
        pnlNewCardboard.add(pnlFirstname);
        pnlNewCardboard.add(pnlLastname);
        pnlNewCardboard.add(pnlBirthDate);
        pnlNewCardboard.add(pnlEmail);
        pnlNewCardboard.add(pnlAdress);
        pnlNewCardboard.add(pnlPhone);
    }
}
