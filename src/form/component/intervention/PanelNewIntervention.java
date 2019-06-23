package form.component.intervention;

import domain.Patient;
import domain.intervention.Intervention;
import domain.intervention.InterventionItem;
import domain.intervention.SideIntervention;
import domain.tooth.Tooth;
import domain.tooth.ToothSide;
import domain.tooth.ToothSideLabel;
import domain.tooth.ToothSideState;
import form.ColorConstant;
import form.MyTableCellRenderer;
import form.TableModelToothInterventions;
import form.cardboard.FormCardboard;
import icon.ErrorIcon;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

public class PanelNewIntervention extends javax.swing.JPanel {

    private FormCardboard parent;
    private Tooth tooth;
    private Intervention intervention;
    private PanelNewInterventionItem pnlNewInterventionItem;
    private TableModelToothInterventions tableModelToothInterventions;
    private List<SideIntervention> sideInterventions;

    public PanelNewIntervention(FormCardboard parent,Tooth tooth) {
        this.parent = parent;
        this.tooth = tooth;
        prepareTempFields();
        initComponents();
        adjustPanel();
        prepareTblInterventionItem();
        paintPanel();
        setStartView();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtItemNote = new javax.swing.JTextArea();
        lblInterventionItemNote = new javax.swing.JLabel();
        pnlDynamicContent = new javax.swing.JPanel();
        btnAddInterventionitem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInterventionItems = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        pnlSaveIntervention = new javax.swing.JButton();
        pnlNewInterventionMenu = new javax.swing.JPanel();
        lblSideMenuItem = new javax.swing.JLabel();
        lblRootMenuItem = new javax.swing.JLabel();
        lblToothMenuItem = new javax.swing.JLabel();
        lblInterventionNote = new javax.swing.JLabel();
        btnRemoveInterventionItem = new javax.swing.JButton();

        txtItemNote.setColumns(15);
        txtItemNote.setLineWrap(true);
        txtItemNote.setRows(4);
        txtItemNote.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtItemNote);

        lblInterventionItemNote.setText("Napomena:");

        pnlDynamicContent.setPreferredSize(new java.awt.Dimension(500, 180));

        javax.swing.GroupLayout pnlDynamicContentLayout = new javax.swing.GroupLayout(pnlDynamicContent);
        pnlDynamicContent.setLayout(pnlDynamicContentLayout);
        pnlDynamicContentLayout.setHorizontalGroup(
            pnlDynamicContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        pnlDynamicContentLayout.setVerticalGroup(
            pnlDynamicContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        btnAddInterventionitem.setText("Dodaj");
        btnAddInterventionitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInterventionitemActionPerformed(evt);
            }
        });

        tblInterventionItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblInterventionItems);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        pnlSaveIntervention.setText("Sacuvaj");

        lblSideMenuItem.setBackground(new java.awt.Color(0, 153, 153));
        lblSideMenuItem.setForeground(new java.awt.Color(255, 255, 255));
        lblSideMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSideMenuItem.setText("Strana");
        lblSideMenuItem.setMaximumSize(new java.awt.Dimension(30, 15));
        lblSideMenuItem.setOpaque(true);
        lblSideMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSideMenuItemMousePressed(evt);
            }
        });

        lblRootMenuItem.setBackground(new java.awt.Color(0, 153, 153));
        lblRootMenuItem.setForeground(new java.awt.Color(255, 255, 255));
        lblRootMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRootMenuItem.setText("Koren");
        lblRootMenuItem.setMaximumSize(new java.awt.Dimension(30, 15));
        lblRootMenuItem.setOpaque(true);
        lblRootMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRootMenuItemMousePressed(evt);
            }
        });

        lblToothMenuItem.setBackground(new java.awt.Color(0, 153, 153));
        lblToothMenuItem.setForeground(new java.awt.Color(255, 255, 255));
        lblToothMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblToothMenuItem.setText("Zub");
        lblToothMenuItem.setMaximumSize(new java.awt.Dimension(30, 15));
        lblToothMenuItem.setOpaque(true);
        lblToothMenuItem.setPreferredSize(new java.awt.Dimension(30, 15));
        lblToothMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblToothMenuItemMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlNewInterventionMenuLayout = new javax.swing.GroupLayout(pnlNewInterventionMenu);
        pnlNewInterventionMenu.setLayout(pnlNewInterventionMenuLayout);
        pnlNewInterventionMenuLayout.setHorizontalGroup(
            pnlNewInterventionMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewInterventionMenuLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(lblSideMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRootMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblToothMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNewInterventionMenuLayout.setVerticalGroup(
            pnlNewInterventionMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewInterventionMenuLayout.createSequentialGroup()
                .addGroup(pnlNewInterventionMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSideMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlNewInterventionMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRootMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblToothMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblInterventionNote.setText("Opis intervencije:");

        btnRemoveInterventionItem.setText("Ukloni");
        btnRemoveInterventionItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveInterventionItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNewInterventionMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDynamicContent, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblInterventionItemNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(btnAddInterventionitem, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInterventionNote, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(166, 166, 166))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRemoveInterventionItem, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(pnlSaveIntervention, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlNewInterventionMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInterventionItemNote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddInterventionitem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlDynamicContent, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemoveInterventionItem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlSaveIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblInterventionNote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblSideMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSideMenuItemMousePressed
        pnlNewInterventionItem = new PanelNewSideIntervention(tooth);
        refreshDynamicContent();
    }//GEN-LAST:event_lblSideMenuItemMousePressed

    private void lblRootMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRootMenuItemMousePressed
        pnlNewInterventionItem = new PanelNewRootIntervention(tooth);
        refreshDynamicContent();
    }//GEN-LAST:event_lblRootMenuItemMousePressed

    private void lblToothMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblToothMenuItemMousePressed
        pnlNewInterventionItem = new PanelNewToothIntervention(tooth);
        refreshDynamicContent();
    }//GEN-LAST:event_lblToothMenuItemMousePressed

    private void btnAddInterventionitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInterventionitemActionPerformed
        InterventionItem item = pnlNewInterventionItem.getInterventionItem();
        if (item == null) {
            String message = "Morate prvo uneti intervenciju";
            JOptionPane.showMessageDialog(this, message, "Greška", 0, new ErrorIcon());
            return;
        }
        String itemNote = txtItemNote.getText();
        item.setNote(itemNote);
        item.setIntervention(intervention);
        tableModelToothInterventions.addInterventionItem(item);
        if (item instanceof SideIntervention) {
            SideIntervention sideIntervention = (SideIntervention) item;
            tooth.getSides().get(tooth.getSides().indexOf(sideIntervention.getToothSide())).getSideInterventions().add(sideIntervention);
            sideInterventions.add(sideIntervention);
        }
        parent.refreshToothViews(new Date());
        pnlNewInterventionItem.refreshView();
    }//GEN-LAST:event_btnAddInterventionitemActionPerformed

    private void btnRemoveInterventionItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveInterventionItemActionPerformed
        int index = tblInterventionItems.getSelectedRow();
        InterventionItem interventionItem = tableModelToothInterventions.getInterventionItem(index);
        tableModelToothInterventions.removeInterventionItem(index);
        if (interventionItem instanceof SideIntervention) {
            SideIntervention si = (SideIntervention) interventionItem;
            si.getToothSide().getSideInterventions().remove(si);
        }
        parent.refreshToothViews(new Date());
        pnlNewInterventionItem.refreshView();
    }//GEN-LAST:event_btnRemoveInterventionItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddInterventionitem;
    private javax.swing.JButton btnRemoveInterventionItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblInterventionItemNote;
    private javax.swing.JLabel lblInterventionNote;
    private javax.swing.JLabel lblRootMenuItem;
    private javax.swing.JLabel lblSideMenuItem;
    private javax.swing.JLabel lblToothMenuItem;
    private javax.swing.JPanel pnlDynamicContent;
    private javax.swing.JPanel pnlNewInterventionMenu;
    private javax.swing.JButton pnlSaveIntervention;
    private javax.swing.JTable tblInterventionItems;
    private javax.swing.JTextArea txtItemNote;
    // End of variables declaration//GEN-END:variables

    private void adjustPanel() {
        pnlDynamicContent.setLayout(new GridLayout(1, 1));
    }

    private void prepareTblInterventionItem() {
        tableModelToothInterventions = new TableModelToothInterventions();
        tblInterventionItems.setModel(tableModelToothInterventions);
        tblInterventionItems.getTableHeader().setDefaultRenderer(new MyTableCellRenderer());
        tblInterventionItems.getTableHeader().setReorderingAllowed(false);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeTableColumns();
            }
        });
    }

    private void paintPanel() {
        pnlNewInterventionMenu.setBackground(ColorConstant.GREEN_STRONG);
        setBackground(ColorConstant.GREEN_STRONG);
        lblInterventionItemNote.setForeground(ColorConstant.LIGHT_COLOR);
        lblInterventionNote.setForeground(ColorConstant.LIGHT_COLOR);
    }

    private void refreshDynamicContent() {
        pnlDynamicContent.removeAll();
        pnlDynamicContent.add(pnlNewInterventionItem);
        pnlDynamicContent.revalidate();
    }

    private void setStartView() {
        pnlNewInterventionItem = new PanelNewSideIntervention(tooth);
        refreshDynamicContent();
    }

    public void resizeTableColumns() {
        int[] percentWidth = {15, 15, 55, 15};
        int tWidth = tblInterventionItems.getWidth();
        for (int i = 0; i < tblInterventionItems.getColumnModel().getColumnCount(); i++) {
            tblInterventionItems.getColumnModel().getColumn(i).setPreferredWidth(Math.round(percentWidth[i] * tWidth));
        }
    }

    private void prepareTempFields() {
        intervention = new Intervention();
        intervention.setDate(new Date());
        sideInterventions = new ArrayList<>();
    }

    //!!!
    public HashMap<ToothSideLabel, ToothSideState> getCurrentStatesOfSides() {
        HashMap<ToothSideLabel, ToothSideState> states = new HashMap<>();
        tooth.getSides().forEach((side) -> {
            states.put(side.getLabel(), side.getSideInterventions().stream().max((o1, o2) -> o1.getIntervention().getDate().compareTo(o2.getIntervention().getDate())).get().getState());
        });
        return states;
    }

    //!!!
    public ToothSide getToothSide(int indexOf) {
        return tooth.getSides().get(indexOf);
    }

    public void setNewTooth(Tooth selectedTooth) {
        tooth = selectedTooth;
        pnlNewInterventionItem.refreshView();
    }
}
