package form;

import icon.ErrorIcon;
import java.awt.Color;
import javax.swing.JOptionPane;
import utill.SettingsLoader;

public class FormScheduleSettings extends javax.swing.JDialog {

    TableModelSchedule scheduleModel;
    
    FormScheduleSettings(FormMain parent, boolean modal, TableModelSchedule scheduleModel) {
        super(parent, modal);
        this.scheduleModel = scheduleModel;
        initComponents();
        adjustForm();
        setColors();
        populateCombos();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStartTime = new javax.swing.JLabel();
        cmbStartTime = new javax.swing.JComboBox<>();
        cmbEndTime = new javax.swing.JComboBox<>();
        lblEndTime = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Podešavanje planera");
        setBackground(new java.awt.Color(153, 153, 153));

        lblStartTime.setText("Početno vreme:");

        lblEndTime.setText("Krajnje vreme:");

        btnSubmit.setText("Potvrdi");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblStartTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbEndTime, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblEndTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        int startTime = Integer.parseInt(cmbStartTime.getSelectedItem().toString());
        int endTime = Integer.parseInt(cmbEndTime.getSelectedItem().toString());
        if(startTime>=endTime){
            String message = "Početno vreme mora biti pre krajnjeg vremena";
            JOptionPane.showMessageDialog(this, message, "Greška", 0, new ErrorIcon());
            return;
        }
        System.out.println(startTime+"-"+endTime);
        SettingsLoader.getInstance().setScheduleProperty("start_time", startTime+"");
        SettingsLoader.getInstance().setScheduleProperty("end_time", endTime+"");
        scheduleModel.fireTableDataChanged();
        dispose();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void adjustForm() {
        setLocationRelativeTo(null);
        setTitle("Podešavanje planera");
        setResizable(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbEndTime;
    private javax.swing.JComboBox<String> cmbStartTime;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblStartTime;
    // End of variables declaration//GEN-END:variables

    private void populateCombos() {
        cmbEndTime.removeAll();
        cmbStartTime.removeAll();
        for(int i=0;i<24;i++){
            cmbEndTime.addItem(i+"");
            cmbStartTime.addItem(i+"");
        }
        cmbStartTime.setSelectedItem(SettingsLoader.getInstance().getStartTime()+"");
        cmbEndTime.setSelectedItem(SettingsLoader.getInstance().getEndTime()+"");
    }

    private void setColors() {
        getContentPane().setBackground(ColorConstant.GREEN_SPRING);
        lblEndTime.setForeground(Color.WHITE);
        lblStartTime.setForeground(Color.WHITE);
        //repaint();
    }
}
