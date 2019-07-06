package form.cardboard;

import controller.Controller;
import domain.Patient;
import form.ColorConstant;
import form.MyTableCellRenderer;
import form.TableModelPatient;
import icon.ErrorIcon;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;

public class FormSearchCardboard extends javax.swing.JDialog {

    public FormSearchCardboard(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        adjustForm();
        preparePatientsTable();
        paintForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFilter = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pretraživanje kartona");

        lblFilter.setText("Ime i prezime:");

        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFilterKeyReleased(evt);
            }
        });

        scrollPane.setBorder(null);

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatientsMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tblPatients);

        btnSearch.setText("Pronađi");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyReleased
        TableModelPatient tm = (TableModelPatient) tblPatients.getModel();
        String filter = txtFilter.getText().trim().toLowerCase();
        tm.filter(filter);
    }//GEN-LAST:event_txtFilterKeyReleased

    private void tblPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientsMouseClicked
        int row = tblPatients.getSelectedRow();
        TableModelPatient tm = (TableModelPatient) tblPatients.getModel();
        Patient p = tm.getFilteredPatients().get(row);
    }//GEN-LAST:event_tblPatientsMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        int row = tblPatients.getSelectedRow();
        if (row == -1) {
            String message = "Morate prvo izabrati pacijenta";
            JOptionPane.showMessageDialog(this, message, "Greška", 0, new ErrorIcon());
            return;
        }
        TableModelPatient tmp = (TableModelPatient) tblPatients.getModel();
        Patient patient = tmp.getFilteredPatients().get(row);
        try {
            //Ucitavamo pacijenta sa svim potrebni podacima
            patient = Controller.getInstance().findCardboard(patient);
            FormCardboard cardboardForm = new FormCardboard(patient);
            dispose();
            cardboardForm.setVisible(true);
            cardboardForm.toFront();
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void adjustForm() {
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void preparePatientsTable() {
        try {
            //Ucitavamo pacijente sa "ogoljenim" podacima radi perfomansi
            tblPatients.setModel(new TableModelPatient(Controller.getInstance().getAllPatients()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
            txtFilter.setEnabled(false);
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentShown(ComponentEvent e) {
                    dispose();
                }
            });
            return;
        }
        TableCellRenderer tcr = new MyTableCellRenderer();
        tblPatients.getTableHeader().setDefaultRenderer(tcr);
        tblPatients.getTableHeader().setReorderingAllowed(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables

    private void paintForm() {
        getContentPane().setBackground(ColorConstant.GREEN_SPRING);
        lblFilter.setForeground(Color.WHITE);
        scrollPane.getViewport().setBackground(ColorConstant.GREEN_SPRING);
    }
}
