package form;

import domain.Appointment;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import utill.SettingsLoader;

public class TableCellRendererSchedule extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (!(table.getModel() instanceof TableModelSchedule)) {
            return c;
        }
        TableModelSchedule tm = (TableModelSchedule) table.getModel();
        //row==-1 -> heder deo tabele
        if (row == -1) {
            return getHeaderCell(tm, column);
        }
        JPanel[] grid = new JPanel[4];
        JPanel panel = new JPanel(new GridLayout(4, 1));
        for (int i = 0; i < 4; i++) {
            JPanel pnl = new JPanel();
            if (i == 3) {
                //Postavlja siri border na ceo sat
                pnl.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, ColorConstant.GREEN_SPRING));
            } else {
                //Ako nije ceo sat
                pnl.setBorder(BorderFactory.createLineBorder(ColorConstant.GREEN_SPRING));
            }
            if (column == 0) {
                prepareTimePanel(pnl,row,i);
            } else {
                Appointment appointment = tm.getCellState(row, column, i * 15);
                if (appointment != null) 
                    prepareNotePanel(pnl, row, i, appointment);
                else 
                    prepareNotNotePanel(tm, pnl, column);
            }
            pnl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("ok");
                }
            });
            grid[i] = pnl;
            panel.add(grid[i]);
        }
        return panel;
    }

    private Component getHeaderCell(TableModelSchedule tm, int column) {
        JLabel headerCell = new JLabel(tm.getColumnName(column));
        headerCell.setOpaque(true);
        headerCell.setBackground(ColorConstant.GREEN_STRONG);
        headerCell.setForeground(ColorConstant.LIGHT_COLOR);
        headerCell.setPreferredSize(new Dimension(200, 30));
        headerCell.setHorizontalAlignment(JLabel.CENTER);
        return headerCell;
    }

    private void prepareNotePanel(JPanel pnl, int row, int i, Appointment appointment) {
        JLabel lbl = new JLabel();
        lbl.setForeground(ColorConstant.GREEN_STRONG);
        lbl.setToolTipText(appointment.getDescription());
        if (noteHeight(appointment) == 1) {
            pnl.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, ColorConstant.GREEN_SPRING));
            lbl.setText(appointment.getPatient().getFirstname() + " " + appointment.getPatient().getLastname());
        } else {
            int pnlPosition = getPositionInNote(row, i, appointment);
            switch (pnlPosition) {
                case 0:
                    pnl.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, ColorConstant.GREEN_SPRING));
                    lbl.setText(appointment.getPatient().toString());
                    break;
                case 1:
                    pnl.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, ColorConstant.GREEN_SPRING));
                    lbl.setText(appointment.getStrDuration());
                    break;
                case 2:
                    pnl.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, ColorConstant.GREEN_SPRING));
                    lbl.setText(appointment.getDescription());
                    break;
                default:
                    pnl.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, ColorConstant.GREEN_SPRING));
                    break;
            }
            if (isLastPosition(row, i, appointment)) {
                pnl.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, ColorConstant.GREEN_SPRING));
            }
        }
        pnl.add(lbl);
        pnl.setBackground(ColorConstant.NOTE_COLOR);
    }

    private int getPositionInNote(int row, int i, Appointment appointment) {
        GregorianCalendar rowTime = (GregorianCalendar) appointment.getStartTime().clone();
        rowTime.set(GregorianCalendar.HOUR, SettingsLoader.getInstance().getStartTime());
        rowTime.set(GregorianCalendar.MINUTE, 0);
        rowTime.add(GregorianCalendar.MINUTE, row * 60 + i * 15);
        long differenceInMinute = Math.round(Math.abs(appointment.getStartTime().getTimeInMillis() - rowTime.getTimeInMillis()) / (1000 * 60));
        return (int) differenceInMinute / 15;
    }

    private boolean isLastPosition(int row, int i, Appointment appointment) {
        int pos = getPositionInNote(row, i, appointment);
        GregorianCalendar time = ((GregorianCalendar) appointment.getStartTime().clone());
        time.add(GregorianCalendar.MINUTE, pos * 15 + 20);
        return time.getTimeInMillis() > appointment.getEndTime().getTimeInMillis();
    }

    private int noteHeight(Appointment appointment) {
        long differenceInMinute = Math.round(Math.abs(appointment.getStartTime().getTimeInMillis() - appointment.getEndTime().getTimeInMillis()) / (1000 * 60));
        return (int) differenceInMinute / 15;
    }

    private void prepareNotNotePanel(TableModelSchedule tableModelSchedule,JPanel panel,int column) {
        GregorianCalendar now = new GregorianCalendar();
        int day = now.get(GregorianCalendar.DAY_OF_WEEK) - 1;
        if (day == 0) {
            day = 7;
        }
        if (tableModelSchedule.getDateFrom().getTimeInMillis() <= now.getTimeInMillis() && tableModelSchedule.getDateTo().getTimeInMillis() >= now.getTimeInMillis()
                && day == column) {
            panel.setBackground(new Color(200, 255, 255));
        } else {
            panel.setBackground(ColorConstant.LIGHT_COLOR);
        }
    }

    private void prepareTimePanel(JPanel panel, int row,int i) {
        GregorianCalendar time = new GregorianCalendar();
        time.set(GregorianCalendar.HOUR_OF_DAY, row + SettingsLoader.getInstance().getStartTime());
        time.set(GregorianCalendar.MINUTE, 15 * i);
        panel.add(new JLabel(new SimpleDateFormat("kk:mm").format(time.getTime())));
        panel.setBackground(ColorConstant.LIGHT_COLOR);
    }
}
