package form;

import controller.Controller;
import domain.Appointment;
import domain.Patient;
import domain.User;
import icon.ErrorIcon;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import session.Session;

public class FormNewAppointment extends javax.swing.JDialog {

    //Ovo obrisi odavde!
    private final TableModelSchedule tableModelSchedule;
    private final List<Appointment> scheduledAppointments;
    private final GregorianCalendar startTime;
    private final GregorianCalendar time;
    private int selectedScheduledAppointments;

    public FormNewAppointment(java.awt.Frame parent, boolean modal, GregorianCalendar time, TableModelSchedule tms) {
        super(parent, modal);
        this.tableModelSchedule = tms;
        this.startTime = time;
        this.time = time;
        this.time.add(GregorianCalendar.MINUTE, 5);
        scheduledAppointments = tableModelSchedule.getScheduledAppointments(time);
        selectedScheduledAppointments = -1;
        initComponents();
        adjustForm();
        preparePatientsTable();
        prepareAppointmentsTable();
        paintForm();
        setNewAppointmentsState();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanePatients = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        lblFilter = new javax.swing.JLabel();
        lblPatient = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        lblDuration = new javax.swing.JLabel();
        cmbDuration = new javax.swing.JComboBox<>();
        btnSaveChange = new javax.swing.JButton();
        cmbStart = new javax.swing.JComboBox<>();
        lblStart = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtPatient = new javax.swing.JTextField();
        lblDateValue = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lblBasicInformation = new javax.swing.JLabel();
        scrollPaneAppointments = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        lblScheduledAppointments = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novi termin");
        setResizable(false);

        scrollPanePatients.setBackground(new java.awt.Color(0, 153, 153));
        scrollPanePatients.setBorder(null);

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPatients.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPatientsMousePressed(evt);
            }
        });
        scrollPanePatients.setViewportView(tblPatients);

        lblFilter.setText("Ime i prezime:");

        lblPatient.setText("Pacijent: ");

        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFilterKeyReleased(evt);
            }
        });

        lblDuration.setText("Trajanje:");

        btnSaveChange.setText("Rezerviši");
        btnSaveChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangeActionPerformed(evt);
            }
        });

        cmbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStartActionPerformed(evt);
            }
        });

        lblStart.setText("Početak:");

        lblDate.setText("Datum:");

        txtPatient.setEnabled(false);

        lblDateValue.setText("datum");

        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDescription.setText("Napomena:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescription);

        lblBasicInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBasicInformation.setText("Osnovne informacije:");

        scrollPaneAppointments.setBackground(new java.awt.Color(0, 153, 153));
        scrollPaneAppointments.setBorder(null);

        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblAppointmentsMousePressed(evt);
            }
        });
        scrollPaneAppointments.setViewportView(tblAppointments);

        lblScheduledAppointments.setText("Zakazani termini:");

        btnRemove.setText("Otkaži");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanePatients, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFilter))
                    .addComponent(scrollPaneAppointments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblScheduledAppointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblStart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDuration, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDateValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbStart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbDuration, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPatient)
                                .addGap(18, 18, 18)
                                .addComponent(txtPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblBasicInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescription)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSaveChange, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFilter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPanePatients, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(lblScheduledAppointments)
                        .addGap(1, 1, 1)
                        .addComponent(scrollPaneAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescription)
                            .addComponent(lblBasicInformation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveChange, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDateValue, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStart, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStart, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyReleased
        TableModelPatient tm = (TableModelPatient) tblPatients.getModel();
        String filter = txtFilter.getText().trim().toLowerCase();
        tm.filter(filter);
    }//GEN-LAST:event_txtFilterKeyReleased

    private void btnSaveChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangeActionPerformed
        if (selectedScheduledAppointments == -1)
            saveAppointment();
        else
            changeAppointment();
    }//GEN-LAST:event_btnSaveChangeActionPerformed

    private void cmbStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStartActionPerformed
        prepareChooseDuration();
    }//GEN-LAST:event_cmbStartActionPerformed

    private void tblPatientsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientsMousePressed
        int row = tblPatients.getSelectedRow();
        if (row == -1) {
            return;
        }
        selectedScheduledAppointments = -1;
        setNewAppointmentsState();
        TableModelPatient tm = (TableModelPatient) tblPatients.getModel();
        Patient p = tm.getFilteredPatients().get(row);
        txtPatient.setText(p.toString());
    }//GEN-LAST:event_tblPatientsMousePressed

    private void tblAppointmentsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAppointmentsMousePressed
        int row = tblAppointments.getSelectedRow();
        if (row == -1) {
            return;
        }
        selectedScheduledAppointments = row;
        setChangeAppointmentsState();
    }//GEN-LAST:event_tblAppointmentsMousePressed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int row = tblAppointments.getSelectedRow();
        if (row == -1) {
            return;
        }
        deleteAppointment(row);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void adjustForm() {
        setLocationRelativeTo(null);
        lblDateValue.setText(new SimpleDateFormat("kk-dd.MM.yyyy").format(time.getTime()));
        if(time.before(new GregorianCalendar())){
            btnSaveChange.setEnabled(false);
            btnRemove.setEnabled(false);
            btnSaveChange.setToolTipText("Nije moguće rezervisati termin");
            btnRemove.setToolTipText("Izabrani termin više nije moguće menjati");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSaveChange;
    private javax.swing.JComboBox<Integer> cmbDuration;
    private javax.swing.JComboBox<Integer> cmbStart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBasicInformation;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDateValue;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblPatient;
    private javax.swing.JLabel lblScheduledAppointments;
    private javax.swing.JLabel lblStart;
    private javax.swing.JScrollPane scrollPaneAppointments;
    private javax.swing.JScrollPane scrollPanePatients;
    private javax.swing.JTable tblAppointments;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtPatient;
    // End of variables declaration//GEN-END:variables

    private void preparePatientsTable() {
        try {
            tblPatients.setModel(new TableModelPatient(Controller.getInstance().getAllPatients()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
            txtFilter.setEnabled(false);
            return;
        }
        tblPatients.getTableHeader().setDefaultRenderer(new MyTableCellRenderer());
        tblPatients.getTableHeader().setReorderingAllowed(false);
        tblPatients.setDefaultRenderer(Object.class, new MyTableCellRenderer(ColorConstant.LIGHT_COLOR));
        tblPatients.setSelectionForeground(ColorConstant.GREEN_STRONG);
    }

    private void prepareAppointmentsTable() {
        tblAppointments.setModel(new TableModelPatient(scheduledAppointments.stream().map(o -> o.getPatient()).collect(Collectors.toList())));
        tblAppointments.getTableHeader().setDefaultRenderer(new MyTableCellRenderer());
        tblAppointments.setDefaultRenderer(Object.class, new MyTableCellRenderer(ColorConstant.NOTE_COLOR));
        tblAppointments.getTableHeader().setReorderingAllowed(false);
        tblAppointments.setSelectionForeground(ColorConstant.GREEN_STRONG);
    }

    private void paintForm() {
        getContentPane().setBackground(ColorConstant.GREEN_SPRING);
        lblDate.setForeground(ColorConstant.LIGHT_COLOR);
        lblDateValue.setForeground(ColorConstant.LIGHT_COLOR);
        lblDuration.setForeground(ColorConstant.LIGHT_COLOR);
        lblFilter.setForeground(ColorConstant.LIGHT_COLOR);
        lblPatient.setForeground(ColorConstant.LIGHT_COLOR);
        lblStart.setForeground(ColorConstant.LIGHT_COLOR);
        lblDescription.setForeground(ColorConstant.LIGHT_COLOR);
        lblBasicInformation.setForeground(ColorConstant.LIGHT_COLOR);
        lblScheduledAppointments.setForeground(ColorConstant.LIGHT_COLOR);
        scrollPanePatients.getViewport().setBackground(ColorConstant.GREEN_SPRING);
        scrollPaneAppointments.getViewport().setBackground(ColorConstant.GREEN_SPRING);
    }

    private void setNewAppointmentsState() {
        btnRemove.setVisible(false);
        btnSaveChange.setText("Rezerviši");
        tblAppointments.clearSelection();
        txtDescription.setText("");
        prepareChooseStartTime();
        prepareChooseDuration();
    }

    private void setChangeAppointmentsState() {
        btnRemove.setVisible(true);
        btnSaveChange.setText("Izmeni");
        tblPatients.clearSelection();
        txtPatient.setText(scheduledAppointments.get(selectedScheduledAppointments).getPatient().toString());
        txtDescription.setText(scheduledAppointments.get(selectedScheduledAppointments).getDescription());
        prepareChooseStartTime();
        prepareChooseDuration();
    }

    private void saveAppointment() {
        int row = tblPatients.getSelectedRow();
        if (row == -1) {
            String message = "Morate prvo izabrati pacijenta";
            JOptionPane.showMessageDialog(this, message, "Greška", 0, new ErrorIcon());
            return;
        }
        TableModelPatient tmp = (TableModelPatient) tblPatients.getModel();
        User user = Session.getInstance().getUser();
        Patient patient = tmp.getFilteredPatients().get(row);
        GregorianCalendar endTime = new GregorianCalendar();
        startTime.set(GregorianCalendar.MINUTE, (Integer) (cmbStart.getSelectedItem()));
        endTime.setTime(startTime.getTime());
        endTime.add(GregorianCalendar.MINUTE, (Integer) (cmbDuration.getSelectedItem()));
        String description = txtDescription.getText();
        Appointment appointment = new Appointment(patient, user, (GregorianCalendar) startTime.clone(), (GregorianCalendar) endTime.clone(), description);
        try {
            Controller.getInstance().saveAppointment(appointment);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(),
                    "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
            return;
        }
        tableModelSchedule.addAppointments(appointment);
        dispose();
    }

    private void changeAppointment() {
        int row = tblAppointments.getSelectedRow();
        if (row == -1) {
            String message = "Morate prvo izabrati pacijenta";
            JOptionPane.showMessageDialog(this, message, "Greška", 0, new ErrorIcon());
            return;
        }
        String description = txtDescription.getText();
        GregorianCalendar endTime = new GregorianCalendar();
        startTime.set(GregorianCalendar.MINUTE, (Integer) (cmbStart.getSelectedItem()));
        endTime.setTime(startTime.getTime());
        endTime.add(GregorianCalendar.MINUTE, (Integer) (cmbDuration.getSelectedItem()));
        Appointment appointment = 
                new Appointment(scheduledAppointments.get(row).getAppointmentID(),
                scheduledAppointments.get(row).getPatient(),
                Session.getInstance().getUser(),
                startTime,
                endTime,
                description);
        try {
            Controller.getInstance().updateAppointment(appointment);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
            return;
        }
        scheduledAppointments.get(row).setDescription(description);
        scheduledAppointments.get(row).setStartTime(startTime);
        scheduledAppointments.get(row).setEndTime(endTime);
        scheduledAppointments.get(row).setUser(Session.getInstance().getUser());
        tableModelSchedule.fireTableDataChanged();
        dispose();
    }

    private void deleteAppointment(int row) {
        try {
            Controller.getInstance().deleteAppointment(scheduledAppointments.get(row));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
            return;
        }
        tableModelSchedule.removeScheduledAppointment(scheduledAppointments.get(row));
        dispose();
    }

    //Da li ova metoda treba da se nalazi ovde?
    private void prepareChooseStartTime() {
        GregorianCalendar pom = (GregorianCalendar) time.clone();
        List<Integer> startTimes = new LinkedList<>();
        for (int i = 0; i <= 45; i += 15) {
            startTimes.add(i);
        }
        for (Appointment a : tableModelSchedule.getAppointments()) {
            if (selectedScheduledAppointments != -1 && a == scheduledAppointments.get(selectedScheduledAppointments)) {
                continue;
            }
            for (int i = 0; i <= 45; i += 15) {
                pom.add(GregorianCalendar.MINUTE, i);
                if (a.getStartTime().getTimeInMillis() <= pom.getTimeInMillis() && a.getEndTime().getTimeInMillis() >= pom.getTimeInMillis()) {
                    if (startTimes.contains(i)) {
                        startTimes.remove(new Integer(i));
                    }
                }
                pom.add(GregorianCalendar.MINUTE, -i);
            }
        }
        cmbStart.setModel(new DefaultComboBoxModel(startTimes.toArray()));
    }

    private void prepareChooseDuration() {
        cmbDuration.removeAllItems();
        GregorianCalendar pom = (GregorianCalendar) time.clone();
        try {
            pom.set(GregorianCalendar.MINUTE, (Integer) (cmbStart.getSelectedItem()));
        } catch (Exception e) {
            //Baca excetpion u slucaju da je popunjen termin
            return;
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.YEAR, gc.get(GregorianCalendar.YEAR) + 100);
        for (Appointment a : tableModelSchedule.getAppointments()) {
            if (selectedScheduledAppointments != -1 && a == scheduledAppointments.get(selectedScheduledAppointments)) {
                continue;
            }
            if (a.getStartTime().getTimeInMillis() >= pom.getTimeInMillis() && a.getStartTime().getTimeInMillis() <= gc.getTimeInMillis()) {
                gc = (GregorianCalendar) a.getStartTime().clone();
            }
        }
        gc.add(GregorianCalendar.MINUTE, 5);
        pom.add(GregorianCalendar.MINUTE, 15);
        int counter = 1;
        while (counter <= 8 && pom.getTimeInMillis() <= gc.getTimeInMillis()) {
            cmbDuration.addItem(counter * 15);
            counter++;
            pom.add(GregorianCalendar.MINUTE, 15);
        }
    }

}
