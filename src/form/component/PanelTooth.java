package form.component;

import domain.tooth.Tooth;
import domain.tooth.ToothRootLabel;
import domain.tooth.ToothRootState;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JPanel;

public abstract class PanelTooth extends JPanel {

    protected Tooth tooth;
    protected Date date;
    protected int x,y;
    protected Color c1,c2;
    
    public PanelTooth(int x,Tooth tooth,Date date) {
        this.tooth = tooth;
        this.date = date;
        this.x = x;
        this.c1 = Color.WHITE;
        this.c2 = Color.PINK;
        adjustPanel();
    }
    
    public static PanelTooth getToothRootsPanel(Tooth tooth,int x,Date date) {
        PanelTooth panelToothRoots = null;
        switch (tooth.getLabel().getNumOfRoots()) {
            case 1: {
                panelToothRoots = new PanelToothOneRoots(x, tooth,date);
                break;
            }
            case 2: {
                panelToothRoots = new PanelToothTwoRoots(x, tooth,date);
                break;
            }
            case 3: {
                panelToothRoots = new PanelToothThreeRoots(x, tooth,date);
                //panelToothRoots = new PanelToothTwoRoots(x, tooth,date);
                break;
            }
        }
        return panelToothRoots;
    }
    
    public static PanelTooth getToothRootsPanel(Tooth tooth,HashMap<ToothRootLabel,ToothRootState> currentStatesOfSides,int x) {
        PanelTooth panelToothRoots = null;
        switch (tooth.getLabel().getNumOfRoots()) {
            case 1: {
                panelToothRoots = new PanelToothOneRoots(x,tooth,currentStatesOfSides);
                break;
            }
            case 2: {
                panelToothRoots = new PanelToothTwoRoots(x,tooth,currentStatesOfSides);
                break;
            }
            case 3: {
                panelToothRoots = new PanelToothThreeRoots(x,tooth,currentStatesOfSides);
                //panelToothRoots = new PanelToothTwoRoots(x,tooth,currentStatesOfSides);
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
