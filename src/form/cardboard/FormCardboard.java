package form.cardboard;

import controller.Controller;
import domain.Patient;
import domain.User;
import domain.intervention.InterventionItem;
import domain.tooth.Tooth;
import form.ColorConstant;
import form.MyTableCellRenderer;
import form.TableModelToothInterventions;
import form.component.PanelAllTeethView;
import form.component.PanelJaw;
import form.component.PanelLegend;
import form.component.PanelTeeth;
import form.component.PanelTooth;
import form.component.PanelToothSides;
import form.component.intervention.PanelNewIntervention;
import form.component.menu_item.PanelMenuBar;
import icon.FalseIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import session.Session;

public class FormCardboard extends javax.swing.JFrame {

    Patient patient;
    Tooth selectedTooth;
    PanelJaw pnlJaw;
    TableModelToothInterventions tableModelToothInterventions;
    PanelMenuBar menuBar;
    int x = 95;
    private PanelNewIntervention pnlNewIntervention;

    public FormCardboard(Patient patient) {
        //this.patient = patient;
        try {
            this.patient = controller.Controller.getInstance().findCardboard(new Patient("7bbd3175-ee4d-4601-8278-11b2848f9a56"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Session.getInstance().setUser(new User("miko"));
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
        this.patient.getTeeth().forEach(t -> System.out.println(t.getLabel().getToothLabelID()));
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
        pnlToothLabel = new javax.swing.JPanel();
        lblToothLabel = new javax.swing.JLabel();
        lbllblTothLabel = new javax.swing.JLabel();
        pnlSouth = new javax.swing.JPanel();
        scrollPaneSouth = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        lblDentalAssistantImg = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlWest.setMinimumSize(new java.awt.Dimension(50, 0));
        pnlWest.setPreferredSize(new java.awt.Dimension(500, 600));

        pnlMenu.setBackground(new java.awt.Color(0, 150, 150));

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
        tblToothInterventions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblToothInterventionsMouseClicked(evt);
            }
        });
        scrollPaneToothInterventions.setViewportView(tblToothInterventions);

        pnlRootStateLegend.setPreferredSize(new java.awt.Dimension(100, 150));

        javax.swing.GroupLayout pnlRootStateLegendLayout = new javax.swing.GroupLayout(pnlRootStateLegend);
        pnlRootStateLegend.setLayout(pnlRootStateLegendLayout);
        pnlRootStateLegendLayout.setHorizontalGroup(
            pnlRootStateLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlRootStateLegendLayout.setVerticalGroup(
            pnlRootStateLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
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

        lblToothLabel.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        lblToothLabel.setForeground(new java.awt.Color(255, 255, 255));
        lblToothLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblToothLabel.setText(" ");
        lblToothLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbllblTothLabel.setForeground(new java.awt.Color(255, 255, 255));
        lbllblTothLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllblTothLabel.setText("Oznaka zuba:");

        javax.swing.GroupLayout pnlToothLabelLayout = new javax.swing.GroupLayout(pnlToothLabel);
        pnlToothLabel.setLayout(pnlToothLabelLayout);
        pnlToothLabelLayout.setHorizontalGroup(
            pnlToothLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlToothLabelLayout.createSequentialGroup()
                .addGroup(pnlToothLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblToothLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbllblTothLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        pnlToothLabelLayout.setVerticalGroup(
            pnlToothLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlToothLabelLayout.createSequentialGroup()
                .addComponent(lbllblTothLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblToothLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(pnlEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEastLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlToothSides, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(pnlEastLayout.createSequentialGroup()
                        .addComponent(pnlToothLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlToothRoots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addGroup(pnlEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlRootStateLegend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSideStateLegend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );
        pnlEastLayout.setVerticalGroup(
            pnlEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEastLayout.createSequentialGroup()
                .addGroup(pnlEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEastLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pnlEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlToothRoots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlRootStateLegend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlToothLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
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

        jLabel1.setText(" ");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        lblDentalAssistantImg.setText(" ");

        javax.swing.GroupLayout pnlSouthLayout = new javax.swing.GroupLayout(pnlSouth);
        pnlSouth.setLayout(pnlSouthLayout);
        pnlSouthLayout.setHorizontalGroup(
            pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSouthLayout.createSequentialGroup()
                .addGroup(pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDentalAssistantImg, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneSouth, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
        );
        pnlSouthLayout.setVerticalGroup(
            pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneSouth, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addGroup(pnlSouthLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSouthLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblDentalAssistantImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlSouth, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        JDialog teethForm = new JDialog();
        teethForm.setTitle("Pregled svih zuba");
        teethForm.setModal(true);
        teethForm.setSize(1200, 500);
        teethForm.setLocationRelativeTo(null);
        teethForm.add(new PanelAllTeethView(patient,1200));
        teethForm.setVisible(true);
    }//GEN-LAST:event_jLabel1MousePressed

    private void tblToothInterventionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblToothInterventionsMouseClicked
        int i = tblToothInterventions.getSelectedRow();
        if(i<0)
            return;
        InterventionItem interventionItem = tableModelToothInterventions.getIntervention(i);
        new FormInterventionItemInfo(this, true, interventionItem).setVisible(true);
    }//GEN-LAST:event_tblToothInterventionsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDentalAssistantImg;
    private javax.swing.JLabel lblToothLabel;
    private javax.swing.JLabel lbllblTothLabel;
    private javax.swing.JPanel pnlDynamicContent;
    private javax.swing.JPanel pnlEast;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlRootStateLegend;
    private javax.swing.JPanel pnlSideStateLegend;
    private javax.swing.JPanel pnlSouth;
    private javax.swing.JPanel pnlToothLabel;
    private javax.swing.JPanel pnlToothRoots;
    private javax.swing.JPanel pnlToothSides;
    private javax.swing.JPanel pnlWest;
    private javax.swing.JScrollPane scrollPaneSouth;
    private javax.swing.JScrollPane scrollPaneToothInterventions;
    private javax.swing.JTable tblToothInterventions;
    // End of variables declaration//GEN-END:variables

    private void adjustForm() {
        setTitle(patient.getFirstname() + " " + patient.getLastname());
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
        lblDentalAssistantImg.setIcon(new ImageIcon("icons/dentalAssistantSouth.png"));
    }

    private void paintForm() {
        pnlWest.setBackground(ColorConstant.GREEN_STRONG);
        pnlEast.setBackground(ColorConstant.GREEN_SPRING);
        pnlSouth.setBackground(ColorConstant.GREEN_STRONG);
        //pnlSouth.setBackground(new Color(240, 240, 240));
        pnlJaw.setBackground(ColorConstant.GREEN_SPRING);
        pnlToothRoots.setBackground(ColorConstant.GREEN_SPRING);
        pnlToothSides.setBackground(ColorConstant.GREEN_SPRING);
        pnlRootStateLegend.setBackground(ColorConstant.GREEN_SPRING);
        pnlSideStateLegend.setBackground(ColorConstant.GREEN_SPRING);
        pnlDynamicContent.setBackground(ColorConstant.GREEN_STRONG);
        scrollPaneToothInterventions.getViewport().setBackground(ColorConstant.GREEN_SPRING);
        pnlToothLabel.setBackground(ColorConstant.GREEN_STRONG);
    }

    private void preparePnlJaw() {
        add(pnlJaw);
        pnlJaw.setLayout(null);
        JLabel[] labels = new JLabel[32];
        for (int i = 0; i <= 31; i++) {
            JLabel lbl = new JLabel();
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
            labels[i].setForeground(Color.YELLOW);
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            labels[i].setName(i + "");
            labels[i].setFont(new Font("serif", Font.PLAIN, 30));
            labels[i].setToolTipText(patient.getTeeth().get(i).getLabel().toString());
            switch (patient.getTeeth().get(i).getCurrentState().getName()) {
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
                lblToothLabel.setText(selectedTooth.getLabel().toString());
                refreshToothViews(new Date());
            }

            private void removeTeethBorders() {
                for (Component c : pnlJaw.getComponents()) {
                    if (c instanceof JLabel) {
                        ((JLabel) c).setBorder(null);
                    }
                }
            }
        });
    }

    private void prepareTblToothInterventions() {
        tableModelToothInterventions = new TableModelToothInterventions();
        tblToothInterventions.setModel(tableModelToothInterventions);
        tblToothInterventions.getTableHeader().setDefaultRenderer(new MyTableCellRenderer());
        tblToothInterventions.getTableHeader().setReorderingAllowed(false);
        addRowSelectListenerTblToothInterventions();
    }

    public void refreshToothViews(Date date) {
        pnlToothRoots.removeAll();
        pnlToothRoots.add(PanelTooth.getToothRootsPanel(selectedTooth, 100, date));
        pnlToothRoots.revalidate();
        pnlToothSides.removeAll();
        pnlToothSides.add(new PanelToothSides(selectedTooth, date));
        tableModelToothInterventions.setTooth(selectedTooth);
        populateTeethView();
        pnlNewIntervention.setNewTooth(selectedTooth);
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
                tblToothInterventions.valueChanged(e);
                refreshRootsAndSidesViewOnly(date);
            }

            private void refreshRootsAndSidesViewOnly(Date date) {
                pnlToothRoots.removeAll();
                pnlToothRoots.add(PanelTooth.getToothRootsPanel(selectedTooth, 100, date));
                pnlToothRoots.revalidate();
                pnlToothSides.removeAll();
                pnlToothSides.add(new PanelToothSides(selectedTooth, date));
            }
        });
    }

    private void populateToothSideStatesLegend() {
        try {
            Controller.getInstance().getAllToothSideStates().forEach((state) -> {
                pnlSideStateLegend.add(new PanelLegend(new Color(state.getColor()), state.getName()));
            });
        } catch (Exception ex) {
            JLabel errorMessage = new JLabel(new FalseIcon());
            errorMessage.setToolTipText(ex.getMessage());
            pnlSideStateLegend.add(errorMessage);
            //JOptionPane.showMessageDialog(this, "Došlo je do greške prilikom učitvanja oznaka strana zuba", "Greška", JOptionPane.OK_OPTION, new ErrorIcon());
        }
    }

    private void populateToothRootStatesLegend() {
        try {
            Controller.getInstance().getAllToothRootStates().forEach((state) -> {
                pnlRootStateLegend.add(new PanelLegend(new Color(state.getColor()), state.getName()));
            });
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, "Došlo je do greške prilikom učitvanja oznaka strana zuba", "Greška", JOptionPane.OK_OP
            JLabel errorMessage = new JLabel(new FalseIcon());
            errorMessage.setToolTipText(ex.getMessage());
            pnlRootStateLegend.add(errorMessage);
        }
    }

    private void setStartLook() {
        selectedTooth = patient.getTeeth().get(0);
        ((JLabel) pnlJaw.getComponents()[0]).setBorder(new LineBorder(Color.yellow, 2));
        tableModelToothInterventions.setTooth(selectedTooth);
        pnlToothRoots.add(PanelTooth.getToothRootsPanel(selectedTooth, 100, new Date()));
        pnlToothSides.add(new PanelToothSides(selectedTooth, new Date()));
        lblToothLabel.setText(selectedTooth.getLabel().toString());
    }

    private void prepareMenu() {
        menuBar = new PanelMenuBar(pnlDynamicContent);
        pnlMenu.add(menuBar);
        pnlNewIntervention = new PanelNewIntervention(this, selectedTooth);
        menuBar.addNewMenuItem(new PanelPatientProfile(patient), "user","osnovni podaci");
        menuBar.addNewMenuItem(pnlNewIntervention, "newIntervention","nova intervencija");
        menuBar.addNewMenuItem(new PanelPatientStatistics(patient), "statistics","info");
    }

    private void populateTeethView() {
        scrollPaneSouth.setViewportView(new PanelTeeth(patient));
        scrollPaneSouth.revalidate();
        scrollPaneSouth.repaint();
    }
}
