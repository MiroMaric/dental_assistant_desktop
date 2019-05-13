
package form.component;

import domain.tooth.Tooth;
import java.awt.Color;
import java.awt.Graphics2D;

public class PanelToothThreeRoots extends PanelTooth{
    Color c1, c2, c3,c4,c5;
    int x, y;
    
    //c1-gledj;c2-?;c3-1.koren;c4-2.koren
    public PanelToothThreeRoots(int x, Tooth tooth) {
        this.c1 = Color.WHITE;
        this.c2 = Color.PINK;
        this.c3 = Color.GRAY;
        this.c4 = Color.GRAY;
        this.c5 = Color.GRAY;
        this.x = x;
        this.y = (int)Math.round(x*2.1);
        this.tooth = tooth;
    }

    //100x210
    @Override
    protected void doDrawing(Graphics2D g2d) {
        
        //Ostalo
        int xpoints2[] = {5,10,25,30,34,30,40,55,65,75,70,80,90,80,80};
        int ypoints2[] = {150,50,25,25,40,60,40,20,5,15,40,35,50,95,140};
        int npoints2 = 15;
        
        //Koren2
        int xpoints3[] = {20,15,20,25,40};
        int ypoints3[] = {135,75,50,80,135};
        int npoints3 = 5;
        
        //Koren1
        int xpoints4[] = {35,45,60,65,70,60,60};
        int ypoints4[] = {130,60,25,15,20,70,130};
        int npoints4 = 7;
        
        int xpoints5[] = {60,70,80,80,70};
        int ypoints5[] = {130,65,55,65,130};
        int npoints5 = 5;
        
        //Gledj
        int xpoints1[] = {5,0,5,30,80,90,100,85,55,25};
        int ypoints1[] = {200,175,150,130,130,145,180,210,200,210};
        int npoints1 = 10;
        
        if(tooth.getLabel().getQuadrant()>=3){
            for(int i=0;i<ypoints1.length;i++)
                ypoints1[i]=y-ypoints1[i];
            for(int i=0;i<ypoints2.length;i++)
                ypoints2[i]=y-ypoints2[i];
            for(int i=0;i<ypoints3.length;i++)
                ypoints3[i]=y-ypoints3[i];
            for(int i=0;i<ypoints4.length;i++)
                ypoints4[i]=y-ypoints4[i];
            for(int i=0;i<ypoints5.length;i++)
                ypoints5[i]=y-ypoints5[i];
        }
        if(tooth.getLabel().getQuadrant()==2 || tooth.getLabel().getQuadrant()==3){
            for(int i=0;i<xpoints1.length;i++)
                xpoints1[i]=x-xpoints1[i];
            for(int i=0;i<xpoints2.length;i++)
                xpoints2[i]=x-xpoints2[i];
            for(int i=0;i<xpoints3.length;i++)
                xpoints3[i]=x-xpoints3[i];
            for(int i=0;i<xpoints4.length;i++)
                xpoints4[i]=x-xpoints4[i];
            for(int i=0;i<xpoints5.length;i++)
                xpoints5[i]=x-xpoints5[i];
        }
        
        g2d.setPaint(c2);
        g2d.fillPolygon(xpoints2, ypoints2, npoints2);
        g2d.setPaint(c3);
        g2d.fillPolygon(xpoints3, ypoints3, npoints3);
        g2d.setPaint(c4);
        g2d.fillPolygon(xpoints4, ypoints4, npoints4);
        g2d.setPaint(c5);
        g2d.fillPolygon(xpoints5, ypoints5, npoints5);
        g2d.setPaint(c1);
        g2d.fillPolygon(xpoints1, ypoints1, npoints1);
    }
}
