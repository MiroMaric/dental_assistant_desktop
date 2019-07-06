package form;

import controller.Controller;
import form.cardboard.FormSearchCardboard;
import domain.Appointment;
import form.cardboard.FormNewCardboard;
import form.component.TitleBar;
import icon.ErrorIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;
import utill.SettingsLoader;

public class FormMain extends javax.swing.JFrame {

    TableModelSchedule scheduleModel;

    public FormMain() {
        //decorateForm();
        initComponents();
        adjustForm();
        paintForm();
        adjustIcons();
        prepareSchedule();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        northPanel = new javax.swing.JPanel();
        lblNewCardboard = new javax.swing.JLabel();
        lblSearchCardboard = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        scheduleScrollPane = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();
        lblScheduleSettings = new javax.swing.JLabel();
        lblCenterLogo = new javax.swing.JLabel();
        pnlScheduleHeader = new javax.swing.JPanel();
        lblScheduleDate = new javax.swing.JLabel();
        lblPrevious = new javax.swing.JLabel();
        lblNext = new javax.swing.JLabel();
        txtSearchAppointment = new javax.swing.JTextField();
        lblSearchAppointment = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dental Assistant");
        setBackground(new java.awt.Color(84, 181, 244));

        northPanel.setBackground(new java.awt.Color(0, 102, 102));

        lblNewCardboard.setBackground(new java.awt.Color(102, 153, 255));
        lblNewCardboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewCardboard.setToolTipText("Novi karton");
        lblNewCardboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblNewCardboardMousePressed(evt);
            }
        });

        lblSearchCardboard.setBackground(new java.awt.Color(102, 153, 255));
        lblSearchCardboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchCardboard.setToolTipText("Novi karton");
        lblSearchCardboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSearchCardboardMousePressed(evt);
            }
        });

        javax.swing.GroupLayout northPanelLayout = new javax.swing.GroupLayout(northPanel);
        northPanel.setLayout(northPanelLayout);
        northPanelLayout.setHorizontalGroup(
            northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(northPanelLayout.createSequentialGroup()
                .addContainerGap(413, Short.MAX_VALUE)
                .addComponent(lblNewCardboard, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSearchCardboard, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(428, Short.MAX_VALUE))
        );
        northPanelLayout.setVerticalGroup(
            northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, northPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(northPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearchCardboard, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewCardboard, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(northPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setBackground(new java.awt.Color(0, 153, 153));
        centerPanel.setForeground(new java.awt.Color(255, 255, 255));

        scheduleScrollPane.setBackground(new java.awt.Color(204, 204, 204));
        scheduleScrollPane.setBorder(null);
        scheduleScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSchedule.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tblSchedule.setColumnSelectionAllowed(true);
        tblSchedule.setGridColor(new java.awt.Color(204, 204, 204));
        tblSchedule.setRowHeight(100);
        tblSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblScheduleMousePressed(evt);
            }
        });
        scheduleScrollPane.setViewportView(tblSchedule);

        lblScheduleSettings.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        lblScheduleSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScheduleSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblScheduleSettingsMouseClicked(evt);
            }
        });

        lblCenterLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCenterLogo.setText(" ");

        pnlScheduleHeader.setBackground(new java.awt.Color(0, 153, 153));
        pnlScheduleHeader.setMaximumSize(new java.awt.Dimension(300, 30));
        pnlScheduleHeader.setMinimumSize(new java.awt.Dimension(300, 30));

        lblScheduleDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblScheduleDate.setForeground(new java.awt.Color(0, 102, 102));
        lblScheduleDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScheduleDate.setText("Januar 2017");
        lblScheduleDate.setMaximumSize(new java.awt.Dimension(130, 30));
        lblScheduleDate.setMinimumSize(new java.awt.Dimension(0, 0));
        lblScheduleDate.setPreferredSize(new java.awt.Dimension(100, 50));

        lblPrevious.setBackground(new java.awt.Color(0, 102, 102));
        lblPrevious.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblPrevious.setForeground(new java.awt.Color(0, 102, 102));
        lblPrevious.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrevious.setMaximumSize(new java.awt.Dimension(30, 30));
        lblPrevious.setMinimumSize(new java.awt.Dimension(30, 30));
        lblPrevious.setPreferredSize(new java.awt.Dimension(30, 30));
        lblPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPreviousMousePressed(evt);
            }
        });

        lblNext.setBackground(new java.awt.Color(0, 102, 102));
        lblNext.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblNext.setForeground(new java.awt.Color(0, 102, 102));
        lblNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNext.setMaximumSize(new java.awt.Dimension(30, 30));
        lblNext.setMinimumSize(new java.awt.Dimension(30, 30));
        lblNext.setPreferredSize(new java.awt.Dimension(30, 30));
        lblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblNextMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlScheduleHeaderLayout = new javax.swing.GroupLayout(pnlScheduleHeader);
        pnlScheduleHeader.setLayout(pnlScheduleHeaderLayout);
        pnlScheduleHeaderLayout.setHorizontalGroup(
            pnlScheduleHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlScheduleHeaderLayout.createSequentialGroup()
                .addComponent(lblPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScheduleDate, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNext, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlScheduleHeaderLayout.setVerticalGroup(
            pnlScheduleHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScheduleHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblScheduleDate, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addComponent(lblPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lblNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtSearchAppointment.setBackground(new java.awt.Color(0, 153, 153));
        txtSearchAppointment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchAppointment.setForeground(new java.awt.Color(255, 255, 255));
        txtSearchAppointment.setAutoscrolls(false);
        txtSearchAppointment.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtSearchAppointment.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSearchAppointment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchAppointmentKeyReleased(evt);
            }
        });

        lblSearchAppointment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSearchAppointment.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchAppointment.setText(" ");
        lblSearchAppointment.setToolTipText("");

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scheduleScrollPane)
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addComponent(lblScheduleSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                        .addComponent(pnlScheduleHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(lblSearchAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(lblCenterLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(196, 196, 196))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCenterLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblScheduleSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlScheduleHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchAppointment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchAppointment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scheduleScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblScheduleSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblScheduleSettingsMouseClicked
        new FormScheduleSettings(this, true, scheduleModel).setVisible(true);
    }//GEN-LAST:event_lblScheduleSettingsMouseClicked

    private void lblNewCardboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewCardboardMousePressed
        new FormNewCardboard(this, true, null).setVisible(true);
    }//GEN-LAST:event_lblNewCardboardMousePressed

    private void lblSearchCardboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchCardboardMousePressed
        new FormSearchCardboard(this, true).setVisible(true);
    }//GEN-LAST:event_lblSearchCardboardMousePressed

    private void lblNextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMousePressed
        scheduleModel.nextMonth();
        refreshScheduleDateFromDateToLabel();
        tblSchedule.getTableHeader().repaint();
    }//GEN-LAST:event_lblNextMousePressed

    private void lblPreviousMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPreviousMousePressed
        scheduleModel.previousMonth();
        refreshScheduleDateFromDateToLabel();
        tblSchedule.getTableHeader().repaint();
    }//GEN-LAST:event_lblPreviousMousePressed

    private void txtSearchAppointmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchAppointmentKeyReleased
        TableModelSchedule tm = (TableModelSchedule) tblSchedule.getModel();
        String filter = txtSearchAppointment.getText().trim().toLowerCase();
        tm.filter(filter);
    }//GEN-LAST:event_txtSearchAppointmentKeyReleased

    private void tblScheduleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScheduleMousePressed
        int row = tblSchedule.getSelectedRow();
        int column = tblSchedule.getSelectedColumn();
        GregorianCalendar time = calculateTime(row, column);
        if(time.before(new GregorianCalendar()) && scheduleModel.getScheduledAppointments(time).isEmpty()){
            JOptionPane.showMessageDialog(this, "Nije moguće rezervisati termin",
                                            "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
            return;
        }
        new FormNewAppointment(this, true, time, scheduleModel).setVisible(true);
    }//GEN-LAST:event_tblScheduleMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel lblCenterLogo;
    private javax.swing.JLabel lblNewCardboard;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblPrevious;
    private javax.swing.JLabel lblScheduleDate;
    private javax.swing.JLabel lblScheduleSettings;
    private javax.swing.JLabel lblSearchAppointment;
    private javax.swing.JLabel lblSearchCardboard;
    private javax.swing.JPanel northPanel;
    private javax.swing.JPanel pnlScheduleHeader;
    private javax.swing.JScrollPane scheduleScrollPane;
    private javax.swing.JTable tblSchedule;
    private javax.swing.JTextField txtSearchAppointment;
    // End of variables declaration//GEN-END:variables

    private void adjustForm() {
        setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        lblSearchAppointment.setToolTipText("Pretraživanje termina");
    }

    private void decorateForm() {
        this.setUndecorated(true);
        TitleBar titleBar = new TitleBar("Dental Assistant", this);
        this.add(titleBar, BorderLayout.NORTH);
    }

    private void adjustIcons() {
        lblCenterLogo.setIcon(new ImageIcon("icons/logo.png"));
        lblSearchAppointment.setIcon(new ImageIcon("icons/search.png"));
        lblNext.setIcon(new ImageIcon("icons/next.png"));
        lblPrevious.setIcon(new ImageIcon("icons/previous.png"));
        lblScheduleSettings.setIcon(new ImageIcon("icons/settings.png"));
        lblNewCardboard.setIcon(new ImageIcon("icons/newCardboard.png"));
        lblSearchCardboard.setIcon(new ImageIcon("icons/searchCardboard.png"));

        lblNewCardboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblNewCardboard.setIcon(new javax.swing.ImageIcon("icons/newCardboardMax.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblNewCardboard.setIcon(new javax.swing.ImageIcon("icons/newCardboard.png"));
            }
        });

        lblSearchCardboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblSearchCardboard.setIcon(new javax.swing.ImageIcon("icons/searchCardboardMax.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblSearchCardboard.setIcon(new javax.swing.ImageIcon("icons/searchCardboard.png"));
            }
        });
    }

    private void prepareSchedule() {
        try {
            List<Appointment> appointments = Controller.getInstance().getAllAppointments();
            scheduleModel = new TableModelSchedule(appointments);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                                            "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
            addComponentListener(new ComponentAdapter(){
                @Override
                public void componentShown(ComponentEvent e) {
                    dispose();
                }
            });
            return;
        }
        tblSchedule.setModel(scheduleModel);
        TableCellRenderer tcr = new TableCellRendererSchedule();
        tblSchedule.setDefaultRenderer(Object.class, tcr);
        tblSchedule.setGridColor(Color.GRAY);
        tblSchedule.getColumnModel().getColumn(0).setMinWidth(0);
        tblSchedule.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblSchedule.getColumnModel().getColumn(0).setMaxWidth(50);
        tblSchedule.getTableHeader().setDefaultRenderer(tcr);
        tblSchedule.getTableHeader().setReorderingAllowed(false);
        tblSchedule.setCellSelectionEnabled(true);
        scheduleScrollPane.getVerticalScrollBar().setUnitIncrement(10);
        refreshScheduleDateFromDateToLabel();
    }

    //Da li ovo treba biti ovde?
    private GregorianCalendar calculateTime(int row, int column) {
        GregorianCalendar time = (GregorianCalendar) scheduleModel.getDateFrom().clone();
        time.add(GregorianCalendar.DAY_OF_YEAR, column - 1);
        time.set(GregorianCalendar.HOUR_OF_DAY, row + SettingsLoader.getInstance().getStartTime());
        time.set(GregorianCalendar.MINUTE, 0);
        time.set(GregorianCalendar.SECOND, 1);
        return time;
    }

    private void paintForm() {
        centerPanel.setBackground(ColorConstant.GREEN_SPRING);
        northPanel.setBackground(ColorConstant.GREEN_STRONG);
        pnlScheduleHeader.setBackground(ColorConstant.GREEN_SPRING);
        scheduleScrollPane.getViewport().setBackground(ColorConstant.GREEN_SPRING);
        lblScheduleDate.setForeground(ColorConstant.LIGHT_COLOR);
    }

    public void refreshScheduleDateFromDateToLabel() {
        SimpleDateFormat sfm = new SimpleDateFormat("MMM");
        SimpleDateFormat sfd = new SimpleDateFormat("dd");
        lblScheduleDate.setText(sfm.format(scheduleModel.getDateFrom().getTime()) + " " + sfd.format(scheduleModel.getDateFrom().getTime())
                + " - " + sfm.format(scheduleModel.getDateTo().getTime()) + " " + sfd.format(scheduleModel.getDateTo().getTime()));
    }

}
