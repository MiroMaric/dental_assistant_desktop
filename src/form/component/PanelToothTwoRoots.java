package form.component;

import domain.tooth.Tooth;
import domain.tooth.ToothRootLabel;
import domain.tooth.ToothRootState;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Date;
import java.util.HashMap;


public class PanelToothTwoRoots extends PanelTooth{

    
    private final Color c1, c2;
    private ToothRootState firstRootState;
    private ToothRootState secondRootState;
    //c1-gledj;c2-?;c3-1.koren;c4-2.koren  
    public PanelToothTwoRoots(int x, Tooth tooth,Date date) {
        super(x,tooth,date);
        initializeStates();
        this.c1 = Color.WHITE;
        this.c2 = Color.PINK;
        this.y = (int)Math.round(x*1.75);
    }

    public PanelToothTwoRoots(int x,Tooth tooth,HashMap<ToothRootLabel, ToothRootState> currentStatesOfRoots) {
        super(x,tooth,null);
        initializeStates(currentStatesOfRoots);
        this.c1 = Color.WHITE;
        this.c2 = Color.PINK;
        this.y = (int)Math.round(x*1.75);
        
    }
    //100x175
    @Override
    protected void doDrawing(Graphics2D g2d) {
        
        //Ostalo
        int xpoints2[] = {17*x/20,17*x/20,7*x/10,21*x/40,3*x/5,x/2,x/10,0,0,x/20,x/5};
        int ypoints2[] = {16*y/35,22*y/35,33*y/35,y,27*y/35,21*y/35,34*y/35,34*y/35,31*y/35,24*y/35,16*y/35};
        int npoints2 = 11;
        
        //Koren2
        int xpoints3[] = {3*x/4,3*x/4,13*x/20,13*x/20,11*x/20};
        int ypoints3[] = {16*y/35,25*y/35,32*y/35,27*y/35,17*y/35};
        int npoints3 = 5;
        
        //Koren1
        int xpoints4[] = {x/4,3*x/20,x/20,x/2};
        int ypoints4[] = {16*y/35,24*y/35,34*y/35,17*y/35};
        int npoints4 = 4;
        
        //Gledj
        int xpoints1[] = {x/10, x/5, 9*x/20, 3*x/4, x, 19*x/20, 17*x/20, 11*x/20, x/5, x/10, x/20, x/10};
        int ypoints1[] = {2*y/35, 0, y/35, 0, 2*y/35, 14*y/35, 16*y/35, 17*y/35, 16*y/35, 12*y/35, y/5, 2*y/35};
        int npoints1 = 11;
        
        if(tooth.getLabel().getQuadrant()<=2){
            for(int i=0;i<ypoints1.length;i++)
                ypoints1[i]=y-ypoints1[i];
            for(int i=0;i<ypoints2.length;i++)
                ypoints2[i]=y-ypoints2[i];
            for(int i=0;i<ypoints3.length;i++)
                ypoints3[i]=y-ypoints3[i];
            for(int i=0;i<ypoints4.length;i++)
                ypoints4[i]=y-ypoints4[i];
        }
        if(tooth.getLabel().getQuadrant()==1 || tooth.getLabel().getQuadrant()==4){
            for(int i=0;i<xpoints1.length;i++)
                xpoints1[i]=x-xpoints1[i];
            for(int i=0;i<xpoints2.length;i++)
                xpoints2[i]=x-xpoints2[i];
            for(int i=0;i<xpoints3.length;i++)
                xpoints3[i]=x-xpoints3[i];
            for(int i=0;i<xpoints4.length;i++)
                xpoints4[i]=x-xpoints4[i];
        }
        
        g2d.setPaint(c2);
        g2d.fillPolygon(xpoints2, ypoints2, npoints2);
        g2d.setPaint(new Color(firstRootState.getColor()));
        g2d.fillPolygon(xpoints3, ypoints3, npoints3);
        g2d.setPaint(new Color(secondRootState.getColor()));
        g2d.fillPolygon(xpoints4, ypoints4, npoints4);
        g2d.setPaint(c1);
        g2d.fillPolygon(xpoints1, ypoints1, npoints1);
    }

    private void initializeStates() {
        firstRootState = tooth.getRootStateAtDate(0,date);
        secondRootState = tooth.getRootStateAtDate(1,date);
    }

    private void initializeStates(HashMap<ToothRootLabel, ToothRootState> currentStatesOfRoots) {
        currentStatesOfRoots.keySet().forEach((rootLabel) -> {
            System.out.println("------>" + rootLabel.getName().toLowerCase());
            switch(rootLabel.getName().toLowerCase()){
                case "koren1":
                    firstRootState = currentStatesOfRoots.get(rootLabel);
                    break;
                case "koren2":
                    secondRootState = currentStatesOfRoots.get(rootLabel);
                    break;
                default:
                    throw new RuntimeException("Logicka greska!");
            }
        });
    }
    
}
