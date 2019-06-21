package form.component;

import domain.Patient;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Date;

public class PanelTeeth extends javax.swing.JPanel {

    Patient patient;

    public PanelTeeth(Patient patient) {
        this.patient = patient;
        initComponents();
        populateTeethPanel();
        paintPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(750, 32767));
        setPreferredSize(new java.awt.Dimension(400, 450));
        setLayout(new java.awt.GridLayout(4, 16));
    }// </editor-fold>//GEN-END:initComponents

    private void populateTeethPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridy = 0;
        gbc.ipady = 140;
        for (int i = 7; i >= 0; i--) {
            gbc.gridx = 7 - i;
            add(PanelTooth.getToothRootsPanel(patient.getTeeth().get(i), 60), gbc);
        }
        for (int i = 8; i < 16; i++) {
            gbc.gridx = i;
            add(PanelTooth.getToothRootsPanel(patient.getTeeth().get(i), 60), gbc);
        }
        gbc.gridy = 1;
        gbc.ipady = 60;
        for (int i = 7; i >= 0; i--) {
            gbc.gridx = 7 - i;
            add(new PanelToothSides(patient.getTeeth().get(i), new Date(), 60), gbc);
        }
        for (int i = 8; i < 16; i++) {
            gbc.gridx = i;
            add(new PanelToothSides(patient.getTeeth().get(i), new Date(), 60), gbc);
        }
        gbc.gridy = 2;
        for (int i = 31; i >= 24; i--) {
            gbc.gridx = 31 - i;
            add(new PanelToothSides(patient.getTeeth().get(i), new Date(), 60), gbc);

        }
        for (int i = 16; i < 24; i++) {
            gbc.gridx = i - 8;
            add(new PanelToothSides(patient.getTeeth().get(i), new Date(), 60), gbc);

        }
        gbc.gridy = 3;
        gbc.ipady = 140;
        for (int i = 31; i >= 24; i--) {
            gbc.gridx = 31 - i;
            add(PanelTooth.getToothRootsPanel(patient.getTeeth().get(i), 60), gbc);
        }
        for (int i = 16; i < 24; i++) {
            gbc.gridx = i - 8;
            add(PanelTooth.getToothRootsPanel(patient.getTeeth().get(i), 60), gbc);
        }
        revalidate();
        repaint();
    }

    private void paintPanel() {
        setBackground(new Color(220, 220, 220));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
