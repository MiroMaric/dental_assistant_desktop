package form.component;

import domain.tooth.Tooth;
import domain.tooth.ToothRootLabel;
import domain.tooth.ToothRootState;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Date;
import java.util.HashMap;

public class PanelToothOneRoots extends PanelTooth {

    private Color c1, c2;
    private ToothRootState rootState;

    public PanelToothOneRoots(int x, Tooth tooth, Date date) {
        super(x, tooth, date);
        initializeStates();
        this.c1 = Color.WHITE;
        this.c2 = Color.PINK;
        this.y = (int) Math.round(x * 2.45);
    }

    public PanelToothOneRoots(int x,Tooth tooth,HashMap<ToothRootLabel, ToothRootState> currentStatesOfSides) {
        super(x,tooth,null);
        initializeStates(currentStatesOfSides);
        this.c1 = Color.WHITE;
        this.c2 = Color.PINK;
        this.y = (int) Math.round(x * 2.45);
    }

    //100x245
    @Override
    protected void doDrawing(Graphics2D g2d) {

        int xpoints2[] = {x / 5, x / 4, 3 * x / 5, 13 * x / 20, 3 * x / 4, 4 * x / 5, 17 * x / 20};
        int ypoints2[] = {30 * y / 49, 20 * y / 49, y / 49, 0, y / 49, 11 * y / 49, 30 * y / 49};
        int npoints2 = 7;

        int xpoints3[] = {7 * x / 20, 4 * x / 10, 6 * x / 10, 13 * x / 20, 7 * x / 10, 13 * x / 20, 6 * x / 10};
        int ypoints3[] = {29 * y / 49, 20 * y / 49, 3 * y / 49, y / 49, 3 * y / 49, 16 * y / 49, 29 * y / 49};
        int npoints3 = 7;

        int xpoints1[] = {19 * x / 20, x / 5, x / 10, x / 20, x / 10, 3 * x / 20, 3 * x / 10, 17 * x / 20, 19 * x / 20};
        int ypoints1[] = {48 * y / 49, 48 * y / 49, 46 * y / 49, 40 * y / 49, 33 * y / 49, 30 * y / 49, 29 * y / 49, 29 * y / 49, 36 * y / 49};
        int npoints1 = 9;

        if (tooth.getLabel().getQuadrant() >= 3) {
            for (int i = 0; i < ypoints1.length; i++) {
                ypoints1[i] = y - ypoints1[i];
            }
            for (int i = 0; i < ypoints2.length; i++) {
                ypoints2[i] = y - ypoints2[i];
            }
            for (int i = 0; i < ypoints3.length; i++) {
                ypoints3[i] = y - ypoints3[i];
            }
        }
        if (tooth.getLabel().getQuadrant() == 2 || tooth.getLabel().getQuadrant() == 3) {
            for (int i = 0; i < xpoints1.length; i++) {
                xpoints1[i] = x - xpoints1[i];
            }
            for (int i = 0; i < xpoints2.length; i++) {
                xpoints2[i] = x - xpoints2[i];
            }
            for (int i = 0; i < xpoints3.length; i++) {
                xpoints3[i] = x - xpoints3[i];
            }
        }

        g2d.setPaint(c2);
        g2d.fillPolygon(xpoints2, ypoints2, npoints2);
        g2d.setPaint(new Color(rootState.getColor()));
        g2d.fillPolygon(xpoints3, ypoints3, npoints3);
        g2d.setPaint(c1);
        g2d.fillPolygon(xpoints1, ypoints1, npoints1);
    }

    private void initializeStates() {
        rootState = tooth.getRootStateAtDate(0, date);
    }

    private void initializeStates(HashMap<ToothRootLabel, ToothRootState> currentStatesOfSides) {
        rootState = currentStatesOfSides.values().stream().findFirst().get();
    }

}
