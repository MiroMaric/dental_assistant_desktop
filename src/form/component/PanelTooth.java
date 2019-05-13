package form.component;

import domain.tooth.Tooth;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public abstract class PanelTooth extends JPanel {

    protected Tooth tooth;

    public PanelTooth() {
        adjustPanel();
    }
    
    public static PanelTooth getToothRootsPanel(Tooth tooth,int x) {
        PanelTooth panelToothRoots = null;
        switch (tooth.getLabel().getNumOfRoots()) {
            case 1: {
                panelToothRoots = new PanelToothOneRoots(x, tooth);
                break;
            }
            case 2: {
                panelToothRoots = new PanelToothTwoRoots(x, tooth);
                break;
            }
            case 3: {
                //panelToothRoots = new PanelToothThreeRoots(x, tooth);
                panelToothRoots = new PanelToothTwoRoots(x, tooth);
                break;
            }
        }
        return panelToothRoots;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        doDrawing(g2d);
    }

    protected abstract void doDrawing(Graphics2D g);

    private void adjustPanel() {
        setOpaque(false);
    }

}
