package form.component;

import form.ColorConstant;
import java.awt.Color;


public class PanelLegend extends javax.swing.JPanel {

    Color color;
    String text;

    public PanelLegend(Color color,String text) {
        this.color = color;
        this.text = text;
        initComponents();
        prepareLegend();
        paintPanel();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblColor = new javax.swing.JLabel();
        lblText = new javax.swing.JLabel();

        lblColor.setText(" ");
        lblColor.setOpaque(true);

        lblText.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblText.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblText, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblText))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables

    private void prepareLegend() {
        lblColor.setBackground(color);
        lblText.setText(text);
    }

    private void paintPanel() {
        setBackground(ColorConstant.GREEN_SPRING);
        lblText.setForeground(ColorConstant.LIGHT_COLOR);
    }
    
    
}
