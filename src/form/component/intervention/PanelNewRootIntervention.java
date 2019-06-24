package form.component.intervention;

import controller.Controller;
import domain.intervention.InterventionItem;
import domain.intervention.RootIntervention;
import domain.tooth.Tooth;
import domain.tooth.ToothRoot;
import domain.tooth.ToothRootLabel;
import domain.tooth.ToothRootState;
import form.ColorConstant;
import form.component.PanelTooth;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelNewRootIntervention extends PanelNewInterventionItem {

    private HashMap<ToothRootLabel, ToothRootState> currentStatesOfRoots;
    private PanelTooth rootsView;
    private RootIntervention rootIntervention;
    private final HashMap<String, ToothRootState> hashMapToothRootStates;
    private final HashMap<String, ToothRoot> hashMapToothRoots;

    public PanelNewRootIntervention(Tooth tooth) {
        super(tooth);
        rootIntervention = new RootIntervention();
        hashMapToothRootStates = new HashMap<>();
        hashMapToothRoots = new HashMap<>();
        initComponents();
        adjustPanel();
        populatePnlBtnGroupRootLabels();
        populatePnlBtnGroupRootStates();
        setTheInitialState();
        paintPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupRootStates = new javax.swing.ButtonGroup();
        btnGroupRootLabels = new javax.swing.ButtonGroup();
        lblSideChoice = new javax.swing.JLabel();
        lblStatusChoice = new javax.swing.JLabel();
        lblView = new javax.swing.JLabel();
        pnlView = new javax.swing.JPanel();
        pnlBtnGroupRootStates = new javax.swing.JPanel();
        pnlBtnGroupRootLabels = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(400, 160));

        lblSideChoice.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblSideChoice.setText("Koreni zuba:");

        lblStatusChoice.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblStatusChoice.setText("Stanje korena:");

        lblView.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblView.setText("Pregled:");

        pnlView.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout pnlViewLayout = new javax.swing.GroupLayout(pnlView);
        pnlView.setLayout(pnlViewLayout);
        pnlViewLayout.setHorizontalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        pnlViewLayout.setVerticalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlBtnGroupRootStates.setMinimumSize(new java.awt.Dimension(125, 180));

        javax.swing.GroupLayout pnlBtnGroupRootStatesLayout = new javax.swing.GroupLayout(pnlBtnGroupRootStates);
        pnlBtnGroupRootStates.setLayout(pnlBtnGroupRootStatesLayout);
        pnlBtnGroupRootStatesLayout.setHorizontalGroup(
            pnlBtnGroupRootStatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlBtnGroupRootStatesLayout.setVerticalGroup(
            pnlBtnGroupRootStatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlBtnGroupRootLabels.setMinimumSize(new java.awt.Dimension(125, 180));

        javax.swing.GroupLayout pnlBtnGroupRootLabelsLayout = new javax.swing.GroupLayout(pnlBtnGroupRootLabels);
        pnlBtnGroupRootLabels.setLayout(pnlBtnGroupRootLabelsLayout);
        pnlBtnGroupRootLabelsLayout.setHorizontalGroup(
            pnlBtnGroupRootLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlBtnGroupRootLabelsLayout.setVerticalGroup(
            pnlBtnGroupRootLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSideChoice)
                    .addComponent(pnlBtnGroupRootLabels, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblStatusChoice, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(pnlBtnGroupRootStates, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblView, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(pnlView, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatusChoice)
                    .addComponent(lblView)
                    .addComponent(lblSideChoice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlBtnGroupRootStates, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlView, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                    .addComponent(pnlBtnGroupRootLabels, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public InterventionItem getInterventionItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refreshView() {
        populatePnlBtnGroupRootLabels();
        currentStatesOfRoots = tooth.getCurrentStatesOfRoots();
        rootsView = PanelTooth.getToothRootsPanel(tooth, currentStatesOfRoots, 50);
        pnlView.removeAll();
        pnlView.add(rootsView);
        pnlView.revalidate();
    }

    @Override
    public void setNewTooth(Tooth tooth) {
        this.tooth = tooth;
        refreshView();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupRootLabels;
    private javax.swing.ButtonGroup btnGroupRootStates;
    private javax.swing.JLabel lblSideChoice;
    private javax.swing.JLabel lblStatusChoice;
    private javax.swing.JLabel lblView;
    private javax.swing.JPanel pnlBtnGroupRootLabels;
    private javax.swing.JPanel pnlBtnGroupRootStates;
    private javax.swing.JPanel pnlView;
    // End of variables declaration//GEN-END:variables

    private void adjustPanel() {
        pnlView.setLayout(new GridLayout(1, 1));
        pnlView.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        pnlBtnGroupRootLabels.setLayout(new GridLayout(8, 1));
        pnlBtnGroupRootStates.setLayout(new GridLayout(8, 1));
    }

    private void populatePnlBtnGroupRootLabels() {
        pnlBtnGroupRootLabels.removeAll();
        btnGroupRootLabels = new ButtonGroup();
        tooth.getRoots().forEach(root -> {
            JRadioButton btn = new JRadioButton(root.getLabel().getName());
            btn.setForeground(ColorConstant.LIGHT_COLOR);
            btnGroupRootLabels.add(btn);
            pnlBtnGroupRootLabels.add(btn);
            hashMapToothRoots.put(root.getLabel().getName(), root);
            addMouseClickedListenerToBtnRootLabel(btn);
        });
        if (btnGroupRootLabels.getButtonCount() == 1) {
            btnGroupRootLabels.setSelected(btnGroupRootLabels.getElements().nextElement().getModel(), true);
        }
        pnlBtnGroupRootLabels.repaint();
    }

    private void populatePnlBtnGroupRootStates() {
        List<ToothRootState> rootStates = Controller.getInstance().getToothRootStates();
        rootStates.forEach((state) -> {
            JRadioButton btn = new JRadioButton(state.getName());
            btn.setForeground(ColorConstant.LIGHT_COLOR);
            btnGroupRootStates.add(btn);
            pnlBtnGroupRootStates.add(btn);
            hashMapToothRootStates.put(state.getName(), state);
            addMouseClickedListenerToBtnRootState(btn);
        });
    }

    private void addMouseClickedListenerToBtnRootLabel(JRadioButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btn.setSelected(true);
                rootIntervention.setToothRoot(hashMapToothRoots.get(btn.getText()));
                prepereTooth();
            }
        });
    }

    private void addMouseClickedListenerToBtnRootState(JRadioButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btn.setSelected(true);
                rootIntervention.setToothRootState(hashMapToothRootStates.get(btn.getText()));
                prepereTooth();
            }
        });
    }

    private void prepereTooth() {
        if (rootIntervention.getToothRootState() != null && rootIntervention.getToothRoot() != null) {
            currentStatesOfRoots.put(rootIntervention.getToothRoot().getLabel(), rootIntervention.getToothRootState());
            rootsView = PanelTooth.getToothRootsPanel(tooth, currentStatesOfRoots, 50);
            pnlView.removeAll();
            pnlView.add(rootsView);
            pnlView.revalidate();
            currentStatesOfRoots = tooth.getCurrentStatesOfRoots();
        }
    }

    private void setTheInitialState() {
        btnGroupRootStates.clearSelection();
        refreshView();
    }

    private void paintPanel() {
        setBackground(ColorConstant.GREEN_STRONG);
        pnlBtnGroupRootStates.setBackground(ColorConstant.GREEN_STRONG);
        pnlBtnGroupRootLabels.setBackground(ColorConstant.GREEN_STRONG);
        pnlView.setBackground(ColorConstant.GREEN_STRONG);
        lblSideChoice.setForeground(ColorConstant.LIGHT_COLOR);
        lblStatusChoice.setForeground(ColorConstant.LIGHT_COLOR);
        lblView.setForeground(ColorConstant.LIGHT_COLOR);
    }
}
