package form.component;

import domain.tooth.Tooth;
import domain.tooth.ToothRootLabel;
import domain.tooth.ToothRootState;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Date;
import java.util.HashMap;

public class PanelToothThreeRoots extends PanelTooth {

    private ToothRootState firstRootState;
    private ToothRootState secondRootState;
    private ToothRootState thirdRootState;

    public PanelToothThreeRoots(int x, Tooth tooth, Date date) {
        super(x, tooth, date);
        initializeStates();
        this.y = (int) Math.round(x * 2.1);
    }

    public PanelToothThreeRoots(int x, Tooth tooth, HashMap<ToothRootLabel, ToothRootState> currentStatesOfRoots) {
        super(x, tooth, null);
        initializeStates(currentStatesOfRoots);
        this.y = (int) Math.round(x * 1.75);
    }

    //100x210
    @Override
    protected void doDrawing(Graphics2D g2d) {

        //Ostalo
//        int xpoints2[] = {5,10,25,30,34,30,40,55,65,75,70,80,90,80,80};
//        int ypoints2[] = {150,50,25,25,40,60,40,20,5,15,40,35,50,95,140};
//        int npoints2 = 15;
        int xpoints2[] = {x/20, x/10, x/4, 3*x/10, 34*x/100, 3*x/10, 2*x/5, 11*x/20, 13*x/20, 3*x/4, 7*x/10, 4*x/5, 9*x/10, 4*x/5, 4*x/5};
        int ypoints2[] = {5*y/7, 5*y/21, 5*y/42, 5*y/42, 4*y/21, 2*y/7, 4*y/21, 2*y/21, y/21, y/14, 4*y/21, y/6, 5*y/21, 19*y/42, 2*y/3};
        int npoints2 = 15;

        //Koren2
        //int xpoints3[] = {20,15,20,25,40};
        //int ypoints3[] = {135,75,50,80,135};
        int xpoints3[] = {x / 5, 3 * x / 20, x / 5, x / 4, 2 * x / 5};
        int ypoints3[] = {9 * y / 14, 5 * y / 14, 5 * y / 21, 8 * y / 21, 9 * y / 14};
        int npoints3 = 5;

        //Koren1
        //int xpoints4[] = {35, 45, 60, 65, 70, 60, 60};
        //int ypoints4[] = {130, 60, 25, 15, 20, 70, 130};
        int xpoints4[] = {7 * x / 20, 9 * x / 20, 3 * x / 5, 13 * x / 20, 7 * x / 10, 3 * x / 5, 3 * x / 5};
        int ypoints4[] = {13 * y / 21, 2 * y / 7, 5 * y / 42, y / 14, 2 * y / 21, y / 3, 13 * y / 21};
        int npoints4 = 7;

        //int xpoints5[] = {60, 70, 80, 80, 70};
        //int ypoints5[] = {130, 65, 55, 65, 130};
        int xpoints5[] = {3 * x / 5, 7 * x / 10, 4 * x / 5, 4 * x / 5, 7 * x / 10};
        int ypoints5[] = {13 * y / 21, 13 * y / 42, 11 * y / 42, 13 * y / 42, 13 * y / 21};
        int npoints5 = 5;

        //Gledj
        //int xpoints1[] = {5, 0, 5, 30, 80, 90, 100, 85, 55, 25};
        //int ypoints1[] = {200, 175, 150, 130, 130, 145, 180, 210, 200, 210};
        int xpoints1[] = {x / 20, 0, x / 20, 3 * x / 10, 4 * x / 5, 9 * x / 10, x, 17 * x / 20, 11 * x / 20, x / 4};
        int ypoints1[] = {20 * y / 21, 5 * y / 6, 5 * y / 7, 13 * y / 21, 13 * y / 21, 29 * y / 42, 6 * y / 7, y, 20 * y / 21, y};
        int npoints1 = 10;

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
            for (int i = 0; i < ypoints4.length; i++) {
                ypoints4[i] = y - ypoints4[i];
            }
            for (int i = 0; i < ypoints5.length; i++) {
                ypoints5[i] = y - ypoints5[i];
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
            for (int i = 0; i < xpoints4.length; i++) {
                xpoints4[i] = x - xpoints4[i];
            }
            for (int i = 0; i < xpoints5.length; i++) {
                xpoints5[i] = x - xpoints5[i];
            }
        }

        g2d.setPaint(c2);
        g2d.fillPolygon(xpoints2, ypoints2, npoints2);
        g2d.setPaint(new Color(firstRootState.getColor()));
        g2d.fillPolygon(xpoints3, ypoints3, npoints3);
        g2d.setPaint(new Color(secondRootState.getColor()));
        g2d.fillPolygon(xpoints4, ypoints4, npoints4);
        g2d.setPaint(new Color(thirdRootState.getColor()));
        g2d.fillPolygon(xpoints5, ypoints5, npoints5);
        g2d.setPaint(c1);
        g2d.fillPolygon(xpoints1, ypoints1, npoints1);
    }

    protected void initializeStates() {
        firstRootState = tooth.getRootStateAtDate(0, date);
        secondRootState = tooth.getRootStateAtDate(1, date);
        thirdRootState = tooth.getRootStateAtDate(2, date);
    }

    private void initializeStates(HashMap<ToothRootLabel, ToothRootState> currentStatesOfRoots) {
        currentStatesOfRoots.keySet().forEach((rootLabel) -> {
            switch (rootLabel.getName().toLowerCase()) {
                case "koren1":
                    firstRootState = currentStatesOfRoots.get(rootLabel);
                    break;
                case "koren2":
                    secondRootState = currentStatesOfRoots.get(rootLabel);
                    break;
                case "koren3":
                    thirdRootState = currentStatesOfRoots.get(rootLabel);
                    break;
                default:
                    throw new RuntimeException("Logicka greska!");
            }
        });
    }
}
