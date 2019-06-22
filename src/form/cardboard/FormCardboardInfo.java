package form.cardboard;

import domain.Patient;
import form.ColorConstant;
import form.component.myfield.MyField;
import form.component.myfield.MyInputDateField;
import form.component.myfield.MyInputTextField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormCardboardInfo extends javax.swing.JDialog {

    private final List<MyField> myFields;
    protected Patient patient;
    
    public FormCardboardInfo(java.awt.Frame parent, boolean modal,Patient patient) {
        super(parent, modal);
        myFields = new ArrayList<>();
        this.patient = patient;
        initComponents();
        ajdustDialog();
        initFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn = new javax.swing.JButton();
        pnlNewCardboard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novi karton");
        setBackground(new java.awt.Color(0, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn.setText("Btn Text");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
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
                .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNewCardboard, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btn;
    private javax.swing.JPanel pnlNewCardboard;
    // End of variables declaration//GEN-END:variables
    private MyField pnlFirstname;
    private MyField pnlLastname;
    private MyField pnlEmail;
    private MyField pnlBirthDate;
    private MyField pnlAdress;
    private MyField pnlPhone;

    private void ajdustDialog() {
        getContentPane().setBackground(ColorConstant.GREEN_SPRING);
        setBackground(ColorConstant.GREEN_SPRING);
        pnlNewCardboard.setBackground(ColorConstant.GREEN_SPRING);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initFields() {
        pnlEmail = new MyInputTextField("E-pošta:", "E-pošta mora biti valida, e.g. me@mydomain.com", "^(([a-zA-Z\\d_\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?)$", false);
        pnlFirstname = new MyInputTextField("Ime:", "Ime mora imati 2 - 15 karaktera", "^(([A-Za-z]){2,15})$", true);
        pnlLastname = new MyInputTextField("Prezime:", "Prezime mora imati 2 - 15 karaktera", "^(([A-Za-z]){2,15})$", true);
        pnlAdress = new MyInputTextField("Adresa:", "Adresa mora imati 4 - 20 karaktera", "^(([\\w, ]){4,20})$", false);
        pnlPhone = new MyInputTextField("Telefon:", "Telefon mora biti unet u ispravnom formatu", "^((\\d){7,10})$", false);
        pnlBirthDate = new MyInputDateField("Datum rodjenja:", "Datum mora biti unetu u formatu dd.MM.yyyy", "dd.MM.yyyy", false);

        pnlNewCardboard.add(pnlFirstname);
        myFields.add(pnlFirstname);
        pnlNewCardboard.add(pnlLastname);
        myFields.add(pnlLastname);
        pnlNewCardboard.add(pnlBirthDate);
        myFields.add(pnlBirthDate);
        pnlNewCardboard.add(pnlEmail);
        myFields.add(pnlEmail);
        pnlNewCardboard.add(pnlAdress);
        myFields.add(pnlAdress);
        pnlNewCardboard.add(pnlPhone);
        myFields.add(pnlPhone);
    }

    protected void populatePatient() {
        String firstname = (String) pnlFirstname.getValue();
        String lastname = (String) pnlLastname.getValue();
        String email = (String) pnlEmail.getValue();
        Date birthDate = (Date) pnlBirthDate.getValue();
        String adress = (String) pnlAdress.getValue();
        String phone = (String) pnlPhone.getValue();
        if(patient!=null){
            patient.setFirstname(firstname);
            patient.setLastname(lastname);
            patient.setEmail(email);
            patient.setBirthDate(birthDate);
            patient.setAddress(adress);
            patient.setPhone(phone);
        }else{
            patient =  new Patient(firstname, lastname, email, adress, phone, birthDate, new Date());
        }
    }
    
    protected void populateForm(Patient patient){
        pnlFirstname.setValue(patient.getFirstname());
        pnlLastname.setValue(patient.getLastname());
        pnlEmail.setValue(patient.getEmail());
        pnlBirthDate.setValue(patient.getBirthDate());
        pnlAdress.setValue(patient.getAddress());
        pnlPhone.setValue(patient.getPhone());
    }
    
    protected boolean formIsValid(){
        return myFields.stream().noneMatch((myField) -> (!myField.validInput()));
    }
}
