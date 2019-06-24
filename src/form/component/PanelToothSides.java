package form.component;

import domain.tooth.Tooth;
import domain.tooth.ToothSideLabel;
import domain.tooth.ToothSideState;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JPanel;

public class PanelToothSides extends JPanel {

    private Tooth tooth;
    private ToothSideState vestibularna;
    private ToothSideState oralna;
    private ToothSideState mezijalna;
    private ToothSideState distalna;
    private ToothSideState mastikatorna;
    private int r;

    public PanelToothSides(Tooth tooth, Date date) {
        this.tooth = tooth;
        initialStates(date);
        initComponents();
        preparePanel();
        this.r = 140;
    }

    public PanelToothSides(Tooth tooth, Date date, int r) {
        this.tooth = tooth;
        initialStates(date);
        initComponents();
        preparePanel();
        this.r = r;
    }

    public PanelToothSides(HashMap<ToothSideLabel,ToothSideState> currentStatesOfSides, int r) {
        initialStates(currentStatesOfSides);
        initComponents();
        preparePanel();
        this.r = r;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g, r);
    }

    private void doDrawing(Graphics g, int r) {

        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setPaint(Color.gray);
        g2d.fillOval(0, 0, r + 4, r + 4);

        g2d.setPaint(new Color(vestibularna.getColor()));

        g2d.fillArc(2, 2, r, r, 46, 88);

        g2d.setPaint(new Color(mezijalna.getColor()));

        g2d.fillArc(2, 2, r, r, 136, 88);

        g2d.setPaint(new Color(oralna.getColor()));

        g2d.fillArc(2, 2, r, r, 226, 88);

        g2d.setPaint(new Color(distalna.getColor()));

        g2d.fillArc(2, 2, r, r, 316, 88);

        g2d.setPaint(Color.gray);

        g2d.fillOval(r / 4 + 2, r / 4 + 2, r / 2, r / 2);

        g2d.setPaint(new Color(mastikatorna.getColor()));

        g2d.fillOval(r / 4 + 3, r / 4 + 3, r / 2 - 2, r / 2 - 2);
    }

    private void preparePanel() {
        setPreferredSize(new Dimension(r + 10, r + 10));
        setOpaque(false);
    }

    private void initialStates(Date date) {
        vestibularna = tooth.getSideStateAtDate(0, date);
        oralna = tooth.getSideStateAtDate(1, date);
        mezijalna = tooth.getSideStateAtDate(2, date);
        distalna = tooth.getSideStateAtDate(3, date);
        mastikatorna = tooth.getSideStateAtDate(4, date);
    }

    private void initialStates(HashMap<ToothSideLabel,ToothSideState> currentStatesOfSides) {
        currentStatesOfSides.keySet().forEach((sideLabel) -> {
            switch(sideLabel.getName().toLowerCase()){
                case "vestibularna":
                    vestibularna = currentStatesOfSides.get(sideLabel);
                    break;
                case "oralna":
                    oralna = currentStatesOfSides.get(sideLabel);
                    break;
                case "mezijalna":
                    mezijalna = currentStatesOfSides.get(sideLabel);
                    break;
                case "distalna":
                    distalna = currentStatesOfSides.get(sideLabel);
                    break;
                case "mastikatorna":
                    mastikatorna = currentStatesOfSides.get(sideLabel);
                    break;
                default:
                    throw new RuntimeException("Logicka greska!");
            }
        });
    }

}
