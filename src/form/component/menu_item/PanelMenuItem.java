package form.component.menu_item;

import form.ColorConstant;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelMenuItem extends javax.swing.JPanel {

    JPanel content;
    String iconName;
    public PanelMenuItem(JPanel panel, String iconName) {
        this.content = panel;
        this.iconName = iconName;
        initComponents();
        setMenuItemIcon();
        paintMenuItem();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMenuItem = new javax.swing.JLabel();
        lblMenuItemPointer = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(60, 67));
        setMinimumSize(new java.awt.Dimension(60, 67));
        setPreferredSize(new java.awt.Dimension(60, 67));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        lblMenuItem.setBackground(new java.awt.Color(102, 102, 102));
        lblMenuItem.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuItem.setText(" ");
        lblMenuItem.setMaximumSize(new java.awt.Dimension(60, 58));
        lblMenuItem.setMinimumSize(new java.awt.Dimension(60, 58));
        lblMenuItem.setOpaque(true);
        lblMenuItem.setPreferredSize(new java.awt.Dimension(60, 58));
        add(lblMenuItem);

        lblMenuItemPointer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuItemPointer.setText(" ");
        lblMenuItemPointer.setMaximumSize(new java.awt.Dimension(60, 9));
        lblMenuItemPointer.setOpaque(true);
        lblMenuItemPointer.setPreferredSize(new java.awt.Dimension(60, 9));
        add(lblMenuItemPointer);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMenuItem;
    private javax.swing.JLabel lblMenuItemPointer;
    // End of variables declaration//GEN-END:variables

    private void setMenuItemIcon() {
        lblMenuItem.setIcon(new ImageIcon(getClass().getResource("/icon/" + iconName + ".png")));
    }

    public void setContent(JPanel content) {
        this.content = content;
    }

    public void setMenuItemPointer() {
        lblMenuItemPointer.setIcon(new ImageIcon(getClass().getResource("/icon/pointer.png")));
    }

    public void removeMenuItemPointer() {
        lblMenuItemPointer.setIcon(null);
        lblMenuItemPointer.revalidate();
        lblMenuItemPointer.repaint();
    }

    private void paintMenuItem() {
        lblMenuItem.setBackground(ColorConstant.GRAY);
        lblMenuItemPointer.setBackground(ColorConstant.GREEN_STRONG);
    }

    public JPanel getContent() {
        return content;
    }
}
