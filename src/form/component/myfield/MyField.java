package form.component.myfield;

import form.ColorConstant;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class MyField extends javax.swing.JPanel {

    protected abstract boolean validInputField();

    protected abstract Object getValueOfField();

    protected abstract void initFiled();

    protected abstract void addListeners();

    public MyField(String fieldName, String info, String regEx, boolean require) {
        this.regEx = regEx;
        this.require = require;
        initComponents();
        initPanelFieldComponents();
        preparePanel(fieldName, info, regEx);
        paintPanel();
        addListeners();
    }

    public boolean validInput() {
        if (isInputNull()) {
            return true;
        }
        return validInputField();
    }

    public Object getValue() {
        if (isInputNull()) {
            return null;
        }
        return getValueOfField();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInfo = new javax.swing.JLabel();
        lblFieldName = new javax.swing.JLabel();
        pnlField = new javax.swing.JPanel();
        cmbEmpty = new javax.swing.JCheckBox();
        lblEmpty = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));

        lblInfo.setText("info message");
        lblInfo.setPreferredSize(new java.awt.Dimension(315, 14));

        lblFieldName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFieldName.setText("field name:");

        pnlField.setBackground(new java.awt.Color(0, 153, 153));
        pnlField.setPreferredSize(new java.awt.Dimension(315, 45));
        pnlField.setLayout(new java.awt.BorderLayout());

        cmbEmpty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbEmptyMouseReleased(evt);
            }
        });

        lblEmpty.setText("Nepoznato");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(cmbEmpty)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmpty, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbEmpty)
                        .addGap(5, 5, 5)
                        .addComponent(lblEmpty))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEmptyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbEmptyMouseReleased
        if (cmbEmpty.isSelected()) {
            field.setVisible(false);
            lblIcon.setVisible(false);
        } else {
            field.setVisible(true);
            lblIcon.setVisible(true);
        }
    }//GEN-LAST:event_cmbEmptyMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JCheckBox cmbEmpty;
    private javax.swing.JLabel lblEmpty;
    private javax.swing.JLabel lblFieldName;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JPanel pnlField;
    // End of variables declaration//GEN-END:variables
    protected final boolean require;
    protected final String regEx;
    protected JComponent field;
    protected JLabel lblUnderline;
    protected JLabel lblIcon;

    public JLabel getLblFieldName() {
        return lblFieldName;
    }

    public JLabel getLblInfo() {
        return lblInfo;
    }

    public JPanel getPnlField() {
        return pnlField;
    }

    private void initPanelFieldComponents() {
        lblUnderline = new JLabel("   ");
        lblIcon = new JLabel();
        initFiled();
        pnlField.setLayout(new BorderLayout());
        pnlField.add(field, BorderLayout.CENTER);
        pnlField.add(lblIcon, BorderLayout.LINE_END);
        pnlField.add(lblUnderline, BorderLayout.PAGE_END);
    }

    private void preparePanel(String fieldName, String info, String regEx) {
        if (require) {
            lblEmpty.setVisible(false);
            cmbEmpty.setVisible(false);
        }
        lblUnderline.setOpaque(true);
        lblUnderline.setPreferredSize(new Dimension(400, 2));
        lblFieldName.setText(fieldName);
        lblInfo.setText(info);
        lblInfo.setVisible(false);
    }

    private void paintPanel() {
        setBackground(ColorConstant.GREEN_SPRING);
        lblEmpty.setForeground(Color.WHITE);
        lblFieldName.setForeground(ColorConstant.LIGHT_COLOR);
        lblInfo.setForeground(ColorConstant.LIGHT_COLOR);
        lblUnderline.setBackground(ColorConstant.LIGHT_COLOR);
        field.setBorder(null);
        setBackground(ColorConstant.GREEN_SPRING);
        field.setForeground(ColorConstant.LIGHT_COLOR);
        //getField().setCaretColor(ColorConstant.LIGHT_COLOR);
        field.setBackground(ColorConstant.GREEN_SPRING);
    }

    private boolean isInputNull() {
        return !require && cmbEmpty.isSelected();
    }

}
