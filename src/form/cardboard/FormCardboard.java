package form.cardboard;

import controller.Controller;
import domain.Patient;
import domain.tooth.Tooth;
import form.ColorConstant;
import form.MyTableCellRenderer;
import form.TableModelToothInterventions;
import form.component.PanelJaw;
import form.component.PanelLegend;
import form.component.PanelTeeth;
import form.component.PanelTooth;
import form.component.PanelToothSides;
import form.component.intervention.PanelNewIntervention;
import form.component.menu_item.PanelMenuBar;
import form.component.patient_profile.PanelPatientProfile;
import form.component.patient_statistics.PanelPatientStatistics;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FormCardboard extends javax.swing.JFrame {

    Patient patient;
    Tooth selectedTooth;
    PanelJaw pnlJaw;
    TableModelToothInterventions tableModelToothInterventions;
    PanelMenuBar menuBar;
    int x = 95;

    public FormCardboard(Patient patient) {
        this.patient = patient;
        //this.patient = controller.Controller.getInstance().getPatient(new Patient("2bc00871-2bf0-4809-baf3-209e4de17dd4"));
        pnlJaw = new PanelJaw();
        initComponents();
        adjustForm();
        preparePnlJaw();
        prepareTblToothInterventions();
        populateTeethView();
        populateToothSideStatesLegend();
        populateToothRootStatesLegend();
        paintForm();
        setStartLook();
        prepareMenu();
        this.patient.getTeeth().forEach(t->System.out.println(t.getLabel().getToothLabelID()));
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {

        }
        new FormCardboard(null).setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlWest = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        pnlDynamicContent = new javax.swing.JPanel();
        pnlEast = new javax.swing.JPanel();
        pnlToothRoots = new javax.swing.JPanel();
        pnlToothSides = new javax.swing.JPanel();
        scrollPaneToothInterventions = new javax.swing.JScrollPane();
        tblToothInterventions = new javax.swing.JTable();
        pnlRootStateLegend = new javax.swing.JPanel();
        pnlSideStateLegend = new javax.swing.JPanel();
        pnlSouth = new javax.swing.JPanel();
        scrollPaneSouth = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlWest.setMinimumSize(new java.awt.Dimension(50, 0));
        pnlWest.setPreferredSize(new java.awt.Dimension(500, 600));

        pnlMenu.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        pnlDynamicContent.setPreferredSize(new java.awt.Dimension(500, 532));
        pnlDynamicContent.setLayout(new java.awt.GridLayout(1, 1));

        javax.swing.GroupLayout pnlWestLayout = new javax.swing.GroupLayout(pnlWest);
        pnlWest.setLayout(pnlWestLayout);
        pnlWestLayout.setHorizontalGroup(
            pnlWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDynamicContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlWestLayout.setVerticalGroup(
            pnlWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWestLayout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDynamicContent, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
        );

        getContentPane().add(pnlWest, java.awt.BorderLayout.WEST);

        pnlEast.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlToothRoots.setMaximumSize(new java.awt.Dimension(100, 245));
        pnlToothRoots.setMinimumSize(new java.awt.Dimension(100, 245));
        pnlToothRoots.setPreferredSize(new java.awt.Dimension(100, 245));

        javax.swing.GroupLayout pnlToothRootsLayout = new javax.swing.GroupLayout(pnlToothRoots);
        pnlToothRoots.setLayout(pnlToothRootsLayout);
        pnlToothRootsLayout.setHorizontalGroup(
            pnlToothRootsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlToothRootsLayout.setVerticalGroup(
            pnlToothRootsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );

        pnlToothSides.setMaximumSize(new java.awt.Dimension(150, 150));
        pnlToothSides.setMinimumSize(new java.awt.Dimension(150, 150));
        pnlToothSides.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout pnlToothSidesLayout = new javax.swing.GroupLayout(pnlToothSides);
        pnlToothSides.setLayout(pnlToothSidesLayout);
        pnlToothSidesLayout.setHorizontalGroup(
            pnlToothSidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        pnlToothSidesLayout.setVerticalGroup(
            pnlToothSidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        scrollPaneToothInterventions.setBorder(null);

        tblToothInterventions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        scrollPaneToothInterventions.setViewportView(tblToothInterventions);

        pnlRootStateLegend.setPreferredSize(new java.awt.Dimension(80, 0));

        javax.swing.GroupLayout pnlRootStateLegendLayout = new javax.swing.GroupLayout(pnlRootStateLegend);
        pnlRootStateLegend.setLayout(pnlRootStateLegendLayout);
        pnlRootStateLegendLayout.setHorizontalGroup(
            pnlRootStateLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlRootStateLegendLayout.setVerticalGroup(
            pnlRootStateLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlSideStateLegend.setPreferredSize(new java.awt.Dimension(100, 150));

        javax.swing.GroupLayout pnlSideStateLegendLayout = new javax.swing.GroupLayout(pnlSideStateLegend);
        pnlSideStateLegend.setLayout(pnlSideStateLegendLayout);
        pnlSideStateLegendLayout.setHorizontalGroup(
            pnlSideStateLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlSideStateLegendLayout.setVerticalGroup(
            pnlSideStateLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlEastLayout = new javax.swing.GroupLayout(pnlEast);
        pnlEast.setLayout(pnlEastLayout);
        pnlEastLayout.setHorizontalGroup(
            pnlEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEastLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneToothInterventions, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEastLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEastLayout.createSequentialGroup()
                        .addComponent(pnlToothSides, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEastLayout.createSequentialGroup()
                        .addComponent(pnlToothRoots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addGroup(pnlEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlRootStateLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(pnlSideStateLegend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );
        pnlEastLayout.setVerticalGroup(
            pnlEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEastLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlToothRoots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlRootStateLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlToothSides, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(pnlSideStateLegend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneToothInterventions, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(pnlEast, java.awt.BorderLayout.LINE_END);

        pnlSouth.setPreferredSize(new java.awt.Dimension(750, 225));

        scrollPaneSouth.setPreferredSize(new java.awt.Dimension(750, 100));

        javax.swing.GroupLayout pnlSouthLayout = new javax.swing.GroupLayout(pnlSouth);
        pnlSouth.setLayout(pnlSouthLayout);
        pnlSouthLayout.setHorizontalGroup(
            pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSouthLayout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(scrollPaneSouth, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );
        pnlSouthLayout.setVerticalGroup(
            pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneSouth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );

        getContentPane().add(pnlSouth, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlDynamicContent;
    private javax.swing.JPanel pnlEast;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlRootStateLegend;
    private javax.swing.JPanel pnlSideStateLegend;
    private javax.swing.JPanel pnlSouth;
    private javax.swing.JPanel pnlToothRoots;
    private javax.swing.JPanel pnlToothSides;
    private javax.swing.JPanel pnlWest;
    private javax.swing.JScrollPane scrollPaneSouth;
    private javax.swing.JScrollPane scrollPaneToothInterventions;
    private javax.swing.JTable tblToothInterventions;
    // End of variables declaration//GEN-END:variables

    private void adjustForm() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pnlToothRoots.setLayout(new BoxLayout(pnlToothRoots, BoxLayout.X_AXIS));
        pnlToothSides.setLayout(new BoxLayout(pnlToothSides, BoxLayout.X_AXIS));
        pnlSideStateLegend.setLayout(new GridLayout(8, 1));
        pnlRootStateLegend.setLayout(new GridLayout(8, 1));
        pnlDynamicContent.setLayout(new GridLayout(1, 1));
        //pnlSouth.setLayout(new GridLayout(1, 1));
        pnlMenu.setLayout(new GridLayout(1, 1));
        scrollPaneSouth.getVerticalScrollBar().setUnitIncrement(600);
    }

    private void paintForm() {
        pnlWest.setBackground(ColorConstant.GREEN_STRONG);
        pnlEast.setBackground(ColorConstant.GREEN_SPRING);
        pnlSouth.setBackground(ColorConstant.GRAY);
        pnlJaw.setBackground(ColorConstant.GREEN_SPRING);
        pnlToothRoots.setBackground(ColorConstant.GREEN_SPRING);
        pnlToothSides.setBackground(ColorConstant.GREEN_SPRING);
        pnlRootStateLegend.setBackground(ColorConstant.GREEN_SPRING);
        pnlSideStateLegend.setBackground(ColorConstant.GREEN_SPRING);
        pnlDynamicContent.setBackground(ColorConstant.GREEN_STRONG);
        scrollPaneToothInterventions.getViewport().setBackground(ColorConstant.GREEN_SPRING);
    }

    private void preparePnlJaw() {
        add(pnlJaw);

        pnlJaw.setLayout(null);
        JLabel[] labels = new JLabel[32];
        for (int i = 0; i <= 31; i++) {
            JLabel lbl = new JLabel();
            lbl.setForeground(Color.black);
            lbl.setHorizontalAlignment(JLabel.CENTER);
            lbl.setName(i + "");
            lbl.setFont(new Font("serif", Font.PLAIN, 30));
            addListenerToTooth(lbl);
            labels[i] = lbl;
            pnlJaw.add(lbl);
        }
        //Donja vilica
        pnlJaw.getComponents()[31].setBounds(210 - x, 320, 65, 60);
        pnlJaw.getComponents()[23].setBounds(530 - x, 320, 65, 60);
        pnlJaw.getComponents()[30].setBounds(220 - x, 380, 65, 55);
        pnlJaw.getComponents()[22].setBounds(520 - x, 380, 65, 55);
        pnlJaw.getComponents()[29].setBounds(235 - x, 435, 65, 50);
        pnlJaw.getComponents()[21].setBounds(505 - x, 435, 65, 50);
        pnlJaw.getComponents()[28].setBounds(250 - x, 485, 60, 35);
        pnlJaw.getComponents()[20].setBounds(490 - x, 485, 60, 35);
        pnlJaw.getComponents()[27].setBounds(270 - x, 520, 55, 30);
        pnlJaw.getComponents()[19].setBounds(475 - x, 520, 55, 30);
        pnlJaw.getComponents()[26].setBounds(295 - x, 550, 45, 30);
        pnlJaw.getComponents()[18].setBounds(460 - x, 550, 45, 30);
        pnlJaw.getComponents()[25].setBounds(340 - x, 560, 30, 30);
        pnlJaw.getComponents()[17].setBounds(430 - x, 560, 30, 30);
        pnlJaw.getComponents()[24].setBounds(370 - x, 570, 30, 30);
        pnlJaw.getComponents()[16].setBounds(400 - x, 570, 30, 30);
        //Gornja vilica
        pnlJaw.getComponents()[7].setBounds(210 - x, 245, 75, 50);
        pnlJaw.getComponents()[15].setBounds(510 - x, 245, 80, 50);
        pnlJaw.getComponents()[6].setBounds(215 - x, 195, 70, 50);
        pnlJaw.getComponents()[14].setBounds(515 - x, 195, 70, 50);
        pnlJaw.getComponents()[5].setBounds(220 - x, 145, 70, 50);
        pnlJaw.getComponents()[13].setBounds(510 - x, 145, 70, 50);
        pnlJaw.getComponents()[4].setBounds(240 - x, 115, 60, 30);
        pnlJaw.getComponents()[12].setBounds(500 - x, 115, 60, 30);
        pnlJaw.getComponents()[3].setBounds(260 - x, 85, 60, 30);
        pnlJaw.getComponents()[11].setBounds(480 - x, 85, 60, 30);
        pnlJaw.getComponents()[2].setBounds(290 - x, 55, 50, 30);
        pnlJaw.getComponents()[10].setBounds(470 - x, 55, 50, 30);
        pnlJaw.getComponents()[1].setBounds(315 - x, 25, 40, 35);
        pnlJaw.getComponents()[9].setBounds(445 - x, 25, 40, 35);
        pnlJaw.getComponents()[0].setBounds(350 - x, 15, 50, 40);
        pnlJaw.getComponents()[8].setBounds(400 - x, 15, 50, 40);

        for (int i = 0; i < patient.getTeeth().size(); i++) {
            switch (patient.getTeeth().get(i).getState().getName()) {
                case "odstranjen":
                    labels[i].setText("X");
                    break;
            }
        }

    }

    private void addListenerToTooth(JLabel lbl) {
        lbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                removeTeethBorders();
                lbl.setBorder(new LineBorder(Color.yellow, 2));
                selectedTooth = patient.getTeeth().get(Integer.parseInt(lbl.getName()));
                tableModelToothInterventions.setTooth(selectedTooth);
                pnlToothRoots.add(PanelTooth.getToothRootsPanel(selectedTooth,100));
                refreshToothViews(new Date());
                refreshNewInterventionPanel();
            }

            private void removeTeethBorders() {
                for (Component c : pnlJaw.getComponents()) {
                    if (c instanceof JLabel) {
                        ((JLabel) c).setBorder(null);
                    }
                }
            }

//            private PanelTooth getToothRootsPanel(Tooth tooth) {
//                PanelTooth panelToothRoots = null;
//                switch (tooth.getLabel().getNumOfRoots()) {
//                    case 1: {
//                        panelToothRoots = new PanelToothOneRoots(100, 245, tooth);
//                        break;
//                    }
//                    case 2: {
//                        panelToothRoots = new PanelToothTwoRoots(100, 175, tooth);
//                        break;
//                    }
//                    case 3: {
//                        panelToothRoots = new PanelToothThreeRoots(100, 210, tooth);
//                        break;
//                    }
//                }
//                return panelToothRoots;
//            }

        });
    }

    private void prepareTblToothInterventions() {
        tableModelToothInterventions = new TableModelToothInterventions();
        tblToothInterventions.setModel(tableModelToothInterventions);
        tblToothInterventions.getTableHeader().setDefaultRenderer(new MyTableCellRenderer());
        tblToothInterventions.getTableHeader().setReorderingAllowed(false);
        addRowSelectListenerTblToothInterventions();
    }

    private void removeToothViews() {
        pnlToothRoots.removeAll();
        pnlToothSides.removeAll();
    }

    private void refreshToothViews(Date date) {
        removeToothViews();
        pnlToothSides.add(new PanelToothSides(selectedTooth, date));
        pnlToothRoots.add(PanelTooth.getToothRootsPanel(selectedTooth,100));
        pnlToothRoots.revalidate();
    }

    private void addRowSelectListenerTblToothInterventions() {
        tblToothInterventions.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            //Dva puta se izvrsava na klik!
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRowIndex = tblToothInterventions.getSelectedRow();
                if (selectedRowIndex < 0) {
                    return;
                }
                Date date = tableModelToothInterventions.getInterventionDate(selectedRowIndex);
                refreshToothViews(date);
            }
        });
    }

    private void populateToothSideStatesLegend() {
        Controller.getInstance().getToothSideStates().forEach((state) -> {
            pnlSideStateLegend.add(new PanelLegend(new Color(state.getColor()), state.getName()));
        });
    }

    private void populateToothRootStatesLegend() {
        Controller.getInstance().getToothRootStates().forEach((state) -> {
            pnlRootStateLegend.add(new PanelLegend(new Color(state.getColor()), state.getName()));
        });
    }
    
    private void setStartLook() {
        selectedTooth = patient.getTeeth().get(0);
        ((JLabel) pnlJaw.getComponents()[0]).setBorder(new LineBorder(Color.yellow, 2));
        tableModelToothInterventions.setTooth(selectedTooth);
        pnlToothRoots.add(PanelTooth.getToothRootsPanel(selectedTooth,100));
        pnlToothSides.add(new PanelToothSides(selectedTooth, tableModelToothInterventions.getInterventionDate(0)));
    }

    private void prepareMenu() {
        menuBar = new PanelMenuBar(pnlDynamicContent);
        pnlMenu.add(menuBar);
        menuBar.addNewMenuItem(new PanelNewIntervention(selectedTooth), "newIntervention");
        menuBar.addNewMenuItem(new PanelPatientProfile(patient), "user");
        menuBar.addNewMenuItem(new PanelPatientStatistics(patient), "statistics");
        refreshNewInterventionPanel();
    }

    private void refreshNewInterventionPanel() {
        menuBar.refreshMenuItem(new PanelNewIntervention(selectedTooth), 0);
    }

    private void populateTeethView() {
        scrollPaneSouth.setViewportView(new PanelTeeth(patient));
        scrollPaneSouth.revalidate();
        scrollPaneSouth.repaint();
    }
}
