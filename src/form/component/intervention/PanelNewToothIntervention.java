package form.component.intervention;

import controller.Controller;
import domain.intervention.InterventionItem;
import domain.intervention.ToothIntervention;
import domain.tooth.Tooth;
import domain.tooth.ToothState;
import form.ColorConstant;
import icon.FalseIcon;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelNewToothIntervention extends PanelNewInterventionItem {

    private final HashMap<String, ToothState> hashMapToothStates;
    private ToothIntervention toothIntervention;

    public PanelNewToothIntervention(Tooth tooth) {
        super(tooth);
        hashMapToothStates = new HashMap<>();
        initComponents();
        adjustPanel();
        populatePnlBtnGroupToothStates();
        setTheInitialState();
        paintPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupToothStates = new javax.swing.ButtonGroup();
        pnlBtnGroupToothStates = new javax.swing.JPanel();
        lblStatusChoice = new javax.swing.JLabel();
        pnlView = new javax.swing.JPanel();
        lblView = new javax.swing.JLabel();

        pnlBtnGroupToothStates.setMinimumSize(new java.awt.Dimension(125, 180));

        javax.swing.GroupLayout pnlBtnGroupToothStatesLayout = new javax.swing.GroupLayout(pnlBtnGroupToothStates);
        pnlBtnGroupToothStates.setLayout(pnlBtnGroupToothStatesLayout);
        pnlBtnGroupToothStatesLayout.setHorizontalGroup(
            pnlBtnGroupToothStatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlBtnGroupToothStatesLayout.setVerticalGroup(
            pnlBtnGroupToothStatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblStatusChoice.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblStatusChoice.setText("Stanje zuba:");

        pnlView.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout pnlViewLayout = new javax.swing.GroupLayout(pnlView);
        pnlView.setLayout(pnlViewLayout);
        pnlViewLayout.setHorizontalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );
        pnlViewLayout.setVerticalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );

        lblView.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblView.setText("Pregled:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBtnGroupToothStates, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblStatusChoice, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblView, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlView, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatusChoice)
                    .addComponent(lblView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBtnGroupToothStates, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlView, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public InterventionItem getInterventionItem() {
        if (toothIntervention.getState() == null || toothIntervention.getTooth() == null) {
            return null;
        }
        ToothIntervention pom = toothIntervention;
        setTheInitialState();
        return pom;
    }

    @Override
    public void refreshView() {
        ToothState state = tooth.getCurrentState();
        pnlView.removeAll();
        pnlView.add(new JLabel(new ImageIcon("icons/tooth_state/"+state.getName()+".png")));
        pnlView.revalidate();
    }

    @Override
    public void setNewTooth(Tooth tooth) {
        this.tooth = tooth;
        toothIntervention.setTooth(tooth);
        refreshView();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupToothStates;
    private javax.swing.JLabel lblStatusChoice;
    private javax.swing.JLabel lblView;
    private javax.swing.JPanel pnlBtnGroupToothStates;
    private javax.swing.JPanel pnlView;
    // End of variables declaration//GEN-END:variables

    private void adjustPanel() {
        pnlView.setLayout(new GridLayout(1, 1));
        pnlView.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        pnlBtnGroupToothStates.setLayout(new GridLayout(8, 1));
    }

    private void populatePnlBtnGroupToothStates() {
        List<ToothState> toothStates;
        try {
            toothStates = Controller.getInstance().getAllToothStates();
            System.out.println(toothStates.size());
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, "Došlo je do greške prilikom učitvanja oznaka korena zuba", "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
            JLabel errorMessage = new JLabel(new FalseIcon());
            errorMessage.setToolTipText("Trenutno nije moguće prikazati stanja");
            pnlBtnGroupToothStates.removeAll();
            pnlBtnGroupToothStates.add(errorMessage);
            return;
        }
        hashMapToothStates.clear();
        toothStates.forEach((state) -> {
            JRadioButton btn = new JRadioButton(state.getName());
            btn.setForeground(ColorConstant.LIGHT_COLOR);
            btnGroupToothStates.add(btn);
            pnlBtnGroupToothStates.add(btn);
            hashMapToothStates.put(state.getName(), state);
            addMouseClickedListenerToBtnState(btn);
        });
    }

    private void addMouseClickedListenerToBtnState(JRadioButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                btn.setSelected(true);
                toothIntervention.setState(hashMapToothStates.get(btn.getText()));
                prepereTooth();
            }
        });
    }

    private void prepereTooth() {
        pnlView.removeAll();
        pnlView.add(new JLabel(new ImageIcon("icons/tooth_state/"+toothIntervention.getStateLabel()+".png")));
        pnlView.revalidate();
        pnlView.repaint();
    }

    private void setTheInitialState() {
        toothIntervention = new ToothIntervention();
        toothIntervention.setTooth(tooth);
        btnGroupToothStates.clearSelection();
        refreshView();
    }

    private void paintPanel() {
        setBackground(ColorConstant.GREEN_STRONG);
        lblStatusChoice.setForeground(ColorConstant.LIGHT_COLOR);
        lblView.setForeground(ColorConstant.LIGHT_COLOR);
        pnlBtnGroupToothStates.setBackground(ColorConstant.GREEN_STRONG);
        pnlView.setBackground(ColorConstant.GREEN_STRONG);
    }

}
