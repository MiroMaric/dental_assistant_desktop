package form.component;

import domain.Patient;
import form.ColorConstant;
import java.awt.Dimension;

public class PanelAllTeethView extends javax.swing.JPanel {

    private final Patient patient;
    private final int width;
    public PanelAllTeethView(Patient patient,int width) {
        this.patient = patient;
        this.width = width;
        initComponents();
        populatePanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    private void populatePanel() {
        this.setPreferredSize(new Dimension(width, width*5/12));
        scrollPane.setViewportView(new PanelTeeth(patient));
        scrollPane.revalidate();
        scrollPane.repaint();
    }
}
