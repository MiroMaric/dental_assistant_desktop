package form.component.menu_item;

import form.ColorConstant;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelMenuBar extends javax.swing.JPanel {

    List<PanelMenuItem> menuItems;
    PanelMenuItem currentlyActiveMenuItem;
    JPanel dynamicContent;
    public PanelMenuBar(JPanel dynamicContent) {
        menuItems = new LinkedList<>();
        this.dynamicContent = dynamicContent;
        initComponents();
        adjustMenuBar();
        paintMenuBar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(ColorConstant.GREEN_STRONG);
        g.fillRect(0, 58, 500, 67);
    }

    private void paintMenuBar() {
        setBackground(ColorConstant.GRAY);
    }

    private void adjustMenuBar() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    public void addNewMenuItem(JPanel panel, String iconName) {
        PanelMenuItem menuItem = new PanelMenuItem(panel, iconName);
        if(currentlyActiveMenuItem==null)
            currentlyActiveMenuItem = menuItem;
        menuItems.add(menuItem);
        add(menuItem);
        revalidate();
        addListenerToMenuItem(menuItem);
    }

    public void refreshMenuItem(JPanel panel,int index) {
        menuItems.get(index).setContent(panel);
        refreshDynamicContent();
    }

    private void addListenerToMenuItem(PanelMenuItem menuItem) {
        menuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                menuItems.forEach((t) -> {
                    t.removeMenuItemPointer();
                });
                menuItem.setMenuItemPointer();
                currentlyActiveMenuItem = menuItem;
                refreshDynamicContent();
            }
        });
    }

    private void refreshDynamicContent() {
        dynamicContent.removeAll();
        dynamicContent.add(currentlyActiveMenuItem.getContent());
        dynamicContent.revalidate();
        dynamicContent.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
