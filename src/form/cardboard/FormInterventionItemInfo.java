package form.cardboard;

import domain.intervention.InterventionItem;
import form.ColorConstant;
import java.text.SimpleDateFormat;

public class FormInterventionItemInfo extends javax.swing.JDialog {

    private final InterventionItem interventionItem;

    public FormInterventionItemInfo(java.awt.Frame parent, boolean modal, InterventionItem interventionItem) {
        super(parent, modal);
        this.interventionItem = interventionItem;
        initComponents();
        adjustForm();
        populateForm();
        paintForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFirstname = new javax.swing.JLabel();
        pnl = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblLabel = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        lblNoteValue = new javax.swing.JLabel();
        lblStateValue = new javax.swing.JLabel();
        lblLabelValue = new javax.swing.JLabel();
        lblDateValue = new javax.swing.JLabel();
        lblUserValue = new javax.swing.JLabel();
        lblInterventionNote = new javax.swing.JLabel();
        lblInterventionItemInfo = new javax.swing.JLabel();
        lblTooth = new javax.swing.JLabel();
        lblToothValue = new javax.swing.JLabel();

        lblFirstname.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblFirstname.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFirstname.setText("FIRSTNAME");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnl.setBackground(new java.awt.Color(0, 153, 153));

        lblUser.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUser.setText("korisnik:");
        lblUser.setMaximumSize(new java.awt.Dimension(200, 36));
        lblUser.setMinimumSize(new java.awt.Dimension(200, 36));
        lblUser.setPreferredSize(new java.awt.Dimension(200, 36));

        lblDate.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDate.setText("datum:");
        lblDate.setMaximumSize(new java.awt.Dimension(200, 36));
        lblDate.setMinimumSize(new java.awt.Dimension(200, 36));
        lblDate.setPreferredSize(new java.awt.Dimension(200, 36));

        lblLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLabel.setText("oznaka:");
        lblLabel.setMaximumSize(new java.awt.Dimension(200, 36));
        lblLabel.setMinimumSize(new java.awt.Dimension(200, 36));
        lblLabel.setPreferredSize(new java.awt.Dimension(200, 36));

        lblState.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblState.setForeground(new java.awt.Color(255, 255, 255));
        lblState.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblState.setText("stanje:");
        lblState.setMaximumSize(new java.awt.Dimension(200, 36));
        lblState.setMinimumSize(new java.awt.Dimension(200, 36));
        lblState.setPreferredSize(new java.awt.Dimension(200, 36));

        lblNote.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblNote.setForeground(new java.awt.Color(255, 255, 255));
        lblNote.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNote.setLabelFor(lblNoteValue);
        lblNote.setText("opis:");
        lblNote.setMaximumSize(new java.awt.Dimension(200, 36));
        lblNote.setMinimumSize(new java.awt.Dimension(200, 36));
        lblNote.setPreferredSize(new java.awt.Dimension(200, 36));

        lblNoteValue.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblNoteValue.setForeground(new java.awt.Color(255, 255, 255));
        lblNoteValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoteValue.setText("opis:");
        lblNoteValue.setMaximumSize(new java.awt.Dimension(200, 36));
        lblNoteValue.setMinimumSize(new java.awt.Dimension(200, 36));
        lblNoteValue.setPreferredSize(new java.awt.Dimension(200, 36));

        lblStateValue.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblStateValue.setForeground(new java.awt.Color(255, 255, 255));
        lblStateValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStateValue.setText("stanje:");
        lblStateValue.setMaximumSize(new java.awt.Dimension(200, 36));
        lblStateValue.setMinimumSize(new java.awt.Dimension(200, 36));
        lblStateValue.setPreferredSize(new java.awt.Dimension(200, 36));

        lblLabelValue.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblLabelValue.setForeground(new java.awt.Color(255, 255, 255));
        lblLabelValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLabelValue.setText("oznaka:");
        lblLabelValue.setMaximumSize(new java.awt.Dimension(200, 36));
        lblLabelValue.setMinimumSize(new java.awt.Dimension(200, 36));
        lblLabelValue.setPreferredSize(new java.awt.Dimension(200, 36));

        lblDateValue.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblDateValue.setForeground(new java.awt.Color(255, 255, 255));
        lblDateValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDateValue.setText("datum:");
        lblDateValue.setMaximumSize(new java.awt.Dimension(200, 36));
        lblDateValue.setMinimumSize(new java.awt.Dimension(200, 36));
        lblDateValue.setPreferredSize(new java.awt.Dimension(200, 36));

        lblUserValue.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblUserValue.setForeground(new java.awt.Color(255, 255, 255));
        lblUserValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserValue.setText("korisnik:");
        lblUserValue.setMaximumSize(new java.awt.Dimension(200, 36));
        lblUserValue.setMinimumSize(new java.awt.Dimension(200, 36));
        lblUserValue.setPreferredSize(new java.awt.Dimension(200, 36));

        lblInterventionNote.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblInterventionNote.setForeground(new java.awt.Color(255, 255, 255));
        lblInterventionNote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInterventionNote.setText("opis intervencije:");
        lblInterventionNote.setMaximumSize(new java.awt.Dimension(200, 36));
        lblInterventionNote.setMinimumSize(new java.awt.Dimension(200, 36));
        lblInterventionNote.setPreferredSize(new java.awt.Dimension(200, 36));

        lblInterventionItemInfo.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblInterventionItemInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblInterventionItemInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInterventionItemInfo.setText("Informacije o intervenciji");

        lblTooth.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblTooth.setForeground(new java.awt.Color(255, 255, 255));
        lblTooth.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTooth.setText("zub:");
        lblTooth.setMaximumSize(new java.awt.Dimension(200, 36));
        lblTooth.setMinimumSize(new java.awt.Dimension(200, 36));
        lblTooth.setPreferredSize(new java.awt.Dimension(200, 36));

        lblToothValue.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblToothValue.setForeground(new java.awt.Color(255, 255, 255));
        lblToothValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblToothValue.setText("zub:");
        lblToothValue.setMaximumSize(new java.awt.Dimension(200, 36));
        lblToothValue.setMinimumSize(new java.awt.Dimension(200, 36));
        lblToothValue.setPreferredSize(new java.awt.Dimension(200, 36));

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addComponent(lblInterventionNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayout.createSequentialGroup()
                        .addComponent(lblInterventionItemInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayout.createSequentialGroup()
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblState, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lblLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lblDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lblUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lblTooth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStateValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLabelValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addComponent(lblNoteValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblUserValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblToothValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInterventionItemInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTooth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addComponent(lblUserValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDateValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblToothValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLabelValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStateValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNoteValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInterventionNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDateValue;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblInterventionItemInfo;
    private javax.swing.JLabel lblInterventionNote;
    private javax.swing.JLabel lblLabel;
    private javax.swing.JLabel lblLabelValue;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblNoteValue;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblStateValue;
    private javax.swing.JLabel lblTooth;
    private javax.swing.JLabel lblToothValue;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserValue;
    private javax.swing.JPanel pnl;
    // End of variables declaration//GEN-END:variables

    private void adjustForm() {
        setLocationRelativeTo(null);
        setTitle("Informacije o intervenciji");
    }

    private void populateForm() {
        lblUserValue.setText(interventionItem.getIntervention().getUser().getUsername());
        lblDateValue.setText(new SimpleDateFormat("dd.MM.yyyy").format(interventionItem.getIntervention().getDate()));
        lblNoteValue.setText(interventionItem.getNote());
        lblLabelValue.setText(interventionItem.getItemLabel());
        lblStateValue.setText(interventionItem.getStateLabel());
        lblInterventionNote.setText(interventionItem.getIntervention().getNote());
        lblToothValue.setText(interventionItem.getToothLabel());
    }

    private void paintForm() {
        pnl.setBackground(ColorConstant.GREEN_STRONG);
    }
}
