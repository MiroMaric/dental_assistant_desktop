package form;

import controller.Controller;
import domain.User;
import form.component.myfield.MyInputTextField;
import form.component.myfield.MyField;
import form.component.myfield.MyInputPasswordField;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;

public class FormSignUp extends javax.swing.JFrame {

    public FormSignUp() {
        initComponents();
        initFields();
        adjustForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSignUp = new javax.swing.JPanel();
        btnSignUp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registracija");

        pnlSignUp.setPreferredSize(new java.awt.Dimension(0, 542));
        pnlSignUp.setLayout(new java.awt.GridLayout(7, 1));

        btnSignUp.setText("Registruj me");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        for(Component c:pnlSignUp.getComponents()){
            MyField regField = (MyField)c;
            if(!regField.validInput()){
                JOptionPane.showMessageDialog(this, "Polja nisu popunjena ispravno.", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        User user = new User((String)pnlUsername.getValue(),(String)pnlPassword.getValue(),(String)pnlEmail.getValue()
                ,(String)pnlFirstname.getValue(),(String)pnlLastname.getValue(),(String)pnlAdress.getValue(),
                (String)pnlPhone.getValue());
        System.out.println(user);
        boolean ok = Controller.getInstance().insertRecord(user);
    }//GEN-LAST:event_btnSignUpActionPerformed

    MyField pnlUsername;
    MyField pnlPassword;
    MyField pnlEmail;
    MyField pnlFirstname;
    MyField pnlLastname;
    MyField pnlAdress;
    MyField pnlPhone;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignUp;
    private javax.swing.JPanel pnlSignUp;
    // End of variables declaration//GEN-END:variables

    private void initFields() {
        pnlUsername = new MyInputTextField("Korisničko ime:", "Korisničko ime mora imati 4 - 20 karaktera", "^((\\w){4,20})$",true);
        pnlPassword = new MyInputPasswordField("Šifra", "Šifra mora imati 6-20 karaktera", "^((\\w){6,20})$",true);
        pnlEmail = new MyInputTextField("E-pošta:", "E-pošta mora biti valida, e.g. me@mydomain.com", "^(([a-zA-Z\\d_\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?)$",true);
        pnlFirstname = new MyInputTextField("Ime:", "Ime mora imati 2 - 15 karaktera", "^(([A-Za-z]){2,15})$",true);
        pnlLastname = new MyInputTextField("Prezime:", "Prezime mora imati 2 - 15 karaktera", "^(([A-Za-z]){2,15})$",true);
        pnlAdress = new MyInputTextField("Adresa:", "Adresa mora imati 4 - 20 karaktera", "^(([\\w, ]){4,20})$",false);
        pnlPhone = new MyInputTextField("Telefon:", "Telefon mora biti unet u ispravnom formatu", "^((\\d){7,10})$",false);

        pnlSignUp.add(pnlUsername);
        pnlSignUp.add(pnlPassword);
        pnlSignUp.add(pnlEmail);
        pnlSignUp.add(pnlFirstname);
        pnlSignUp.add(pnlLastname);
        pnlSignUp.add(pnlAdress);
        pnlSignUp.add(pnlPhone);
    }

    private void adjustForm() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(ColorConstant.GREEN_SPRING);
        pnlSignUp.setBackground(ColorConstant.GREEN_SPRING);
    }

}
