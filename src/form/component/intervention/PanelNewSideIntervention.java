package form.component.intervention;

import controller.Controller;
import domain.intervention.InterventionItem;
import domain.intervention.SideIntervention;
import domain.tooth.Tooth;
import domain.tooth.ToothSideState;
import form.ColorConstant;
import form.component.PanelToothSides;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class PanelNewSideIntervention extends PanelNewInterventionItem {

    SideIntervention sideIntervention;
    List<ToothSideState> currentStatesOfSides;
    List<JLabel> lblsSideLabels;
    PanelToothSides toothView;
    HashMap<String, ToothSideState> hashMapToothSideStates;
    int selectedSideIndex = -1;
    
    public PanelNewSideIntervention(Tooth tooth) {
        super(tooth);
        initComponents();
        currentStatesOfSides = this.tooth.getCurrentStatesOfSides();
        sideIntervention = new SideIntervention();
        lblsSideLabels = new LinkedList<>();
        hashMapToothSideStates = new HashMap<>();
        adjustPanel();
        populateLblSideLabelsList();
        populatePnlBtnGroupSideStates();
        setTextToLblSideLabels();
        addMouserPressedListenerToToothSideLabelLbls();
        setTheInitialState();
        paintPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupSideStates = new javax.swing.ButtonGroup();
        lblSideChoice = new javax.swing.JLabel();
        lblStatusChoice = new javax.swing.JLabel();
        lblView = new javax.swing.JLabel();
        pnlView = new javax.swing.JPanel();
        pnlBtnGroupSideStates = new javax.swing.JPanel();
        lblDistalna = new javax.swing.JLabel();
        lblOralna = new javax.swing.JLabel();
        lblMastikatorna = new javax.swing.JLabel();
        lblMezijalna = new javax.swing.JLabel();
        lblVestibularna = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(400, 160));

        lblSideChoice.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblSideChoice.setText("Strana zuba:");

        lblStatusChoice.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblStatusChoice.setText("Stanje strane:");

        lblView.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblView.setText("Pregled:");

        pnlView.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout pnlViewLayout = new javax.swing.GroupLayout(pnlView);
        pnlView.setLayout(pnlViewLayout);
        pnlViewLayout.setHorizontalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlViewLayout.setVerticalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnlBtnGroupSideStates.setMinimumSize(new java.awt.Dimension(125, 180));

        javax.swing.GroupLayout pnlBtnGroupSideStatesLayout = new javax.swing.GroupLayout(pnlBtnGroupSideStates);
        pnlBtnGroupSideStates.setLayout(pnlBtnGroupSideStatesLayout);
        pnlBtnGroupSideStatesLayout.setHorizontalGroup(
            pnlBtnGroupSideStatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlBtnGroupSideStatesLayout.setVerticalGroup(
            pnlBtnGroupSideStatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblDistalna.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblDistalna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDistalna.setText("DIS");
        lblDistalna.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblOralna.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblOralna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOralna.setText("ORA");
        lblOralna.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblMastikatorna.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblMastikatorna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMastikatorna.setText("MAS");
        lblMastikatorna.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblMezijalna.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblMezijalna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMezijalna.setText("MEZ");
        lblMezijalna.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblVestibularna.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblVestibularna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVestibularna.setText("VES");
        lblVestibularna.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOralna, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVestibularna, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMezijalna, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMastikatorna, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDistalna, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSideChoice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblStatusChoice, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(pnlBtnGroupSideStates, javax.swing.GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlView, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(lblView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatusChoice)
                    .addComponent(lblView)
                    .addComponent(lblSideChoice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlBtnGroupSideStates, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVestibularna, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMezijalna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDistalna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMastikatorna, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOralna, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupSideStates;
    private javax.swing.JLabel lblDistalna;
    private javax.swing.JLabel lblMastikatorna;
    private javax.swing.JLabel lblMezijalna;
    private javax.swing.JLabel lblOralna;
    private javax.swing.JLabel lblSideChoice;
    private javax.swing.JLabel lblStatusChoice;
    private javax.swing.JLabel lblVestibularna;
    private javax.swing.JLabel lblView;
    private javax.swing.JPanel pnlBtnGroupSideStates;
    private javax.swing.JPanel pnlView;
    // End of variables declaration//GEN-END:variables

    private void adjustPanel() {
        pnlView.setLayout(new GridLayout(1, 1));
        pnlBtnGroupSideStates.setLayout(new GridLayout(8, 1));
    }

    private void populateLblSideLabelsList() {
        lblsSideLabels.add(lblVestibularna);
        lblsSideLabels.add(lblOralna);
        lblsSideLabels.add(lblMezijalna);
        lblsSideLabels.add(lblDistalna);
        lblsSideLabels.add(lblMastikatorna);
    }

    private void prepereTooth() {
        if (sideIntervention.getState() != null && sideIntervention.getToothSide() != null) {
            currentStatesOfSides.set(selectedSideIndex,sideIntervention.getState());
            refreshView();
            undoCurrentStatesOfSides();
        }
    }

    private void refreshView() {
        toothView = new PanelToothSides(currentStatesOfSides,90);
        pnlView.removeAll();
        pnlView.add(toothView);
        pnlView.revalidate();
    }

    private void setTextToLblSideLabels() {
        //Kasnije
    }

    private void populatePnlBtnGroupSideStates() {
        List<ToothSideState> sideStates = Controller.getInstance().getToothSideStates();
        sideStates.forEach((state) -> {
            JRadioButton btn = new JRadioButton(state.getName());
            btn.setForeground(ColorConstant.LIGHT_COLOR);
            btnGroupSideStates.add(btn);
            pnlBtnGroupSideStates.add(btn);
            hashMapToothSideStates.put(state.getName(), state);
            addMouseClickedListenerToBtnToothState(btn);
        });
    }

    private void addMouserPressedListenerToToothSideLabelLbls() {
        lblsSideLabels.forEach((lbl) -> {
            lbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    lblsSideLabels.forEach((l) -> {
                        l.setBorder(BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
                    });
                    lbl.setBorder(BorderFactory.createLineBorder(Color.RED));
                    //Razmisli o ovome!!!
                    sideIntervention.setToothSide(tooth.getSides().get(lblsSideLabels.indexOf(lbl)));
                    selectedSideIndex = lblsSideLabels.indexOf(lbl);
                    prepereTooth();
                }
            });
        });
    }

    private void addMouseClickedListenerToBtnToothState(JRadioButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btn.setSelected(true);
                sideIntervention.setState(hashMapToothSideStates.get(btn.getText()));
                prepereTooth();
            }
        });
    }
    
    private void undoCurrentStatesOfSides() {
        currentStatesOfSides = tooth.getCurrentStatesOfSides();
    }
    
    @Override
    public InterventionItem getInterventionItem() {
        if(sideIntervention.getState()==null || sideIntervention.getToothSide()==null)
            return null;
        SideIntervention pom = sideIntervention;
        setTheInitialState();
        return pom;
    }

    private void setTheInitialState() {
        sideIntervention = new SideIntervention();
        lblsSideLabels.forEach((t) -> {
            t.setBorder(BorderFactory.createEtchedBorder((javax.swing.border.EtchedBorder.RAISED)));
        });
        btnGroupSideStates.clearSelection();
        refreshView();
    }

    private void paintPanel() {
        setBackground(ColorConstant.GREEN_STRONG);
        pnlBtnGroupSideStates.setBackground(ColorConstant.GREEN_STRONG);
        pnlView.setBackground(ColorConstant.GREEN_STRONG);
        lblDistalna.setForeground(ColorConstant.LIGHT_COLOR);
        lblMastikatorna.setForeground(ColorConstant.LIGHT_COLOR);
        lblMezijalna.setForeground(ColorConstant.LIGHT_COLOR);
        lblOralna.setForeground(ColorConstant.LIGHT_COLOR);
        lblSideChoice.setForeground(ColorConstant.LIGHT_COLOR);
        lblStatusChoice.setForeground(ColorConstant.LIGHT_COLOR);
        lblView.setForeground(ColorConstant.LIGHT_COLOR);
        lblVestibularna.setForeground(ColorConstant.LIGHT_COLOR);
    }
}
