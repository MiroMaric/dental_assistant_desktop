package domain.tooth;

import domain.GeneralDObject;
import domain.Patient;
import domain.intervention.InterventionItem;
import domain.intervention.SideIntervention;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Tooth implements GeneralDObject, Cloneable {

    private String toothID;
    private Patient patient;
    private ToothLabel label;
    private ToothState state;
    private List<ToothSide> sides;

    public Tooth() {
    }

    public Tooth(Patient patient, ToothLabel label, ToothState state, List<ToothSide> sides) {
        this.patient = patient;
        this.label = label;
        this.state = state;
        this.sides = sides;
    }

    public Tooth(Patient patient, ToothLabel label, ToothState state) {
        this.toothID = UUID.randomUUID().toString();
        this.patient = patient;
        this.label = label;
        this.state = state;
        this.sides = new LinkedList<>();
    }

    public Tooth(ToothLabel label, ToothState state, List<ToothSide> sides) {
        this.label = label;
        this.state = state;
        this.sides = sides;
    }

    public Tooth(ToothLabel label, ToothState state) {
        this.label = label;
        this.state = state;
        this.sides = new LinkedList<>();
    }

    public Tooth(String toothID, Patient patient, ToothLabel label, ToothState state) {
        this.patient = patient;
        this.toothID = toothID;
        this.label = label;
        this.state = state;
    }

    public Tooth(String toothID1, Patient patient) {
        this.toothID = toothID1;
        this.patient = patient;
    }

    public ToothLabel getLabel() {
        return label;
    }

    public void setLabel(ToothLabel label) {
        this.label = label;
    }

    public ToothState getState() {
        return state;
    }

    public void setState(ToothState state) {
        this.state = state;
    }

    public List<ToothSide> getSides() {
        return sides;
    }

    public void setSides(List<ToothSide> sides) {
        this.sides = sides;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getToothID() {
        return toothID;
    }

    public void setToothID(String toothID) {
        this.toothID = toothID;
    }

    public List<InterventionItem> getAllInterventions() {
        //1.getAllSideInterventions();
        List<InterventionItem> interventions = new LinkedList<>();
        sides.forEach(side -> {
            side.getSideInterventions().forEach(i -> {
                interventions.add(i);
            });
        });
        return interventions;
    }

    public List<SideIntervention> getAllSideInterventions() {
        List<SideIntervention> interventions = new LinkedList<>();
        sides.forEach(side -> {
            side.getSideInterventions().forEach(i -> {
                interventions.add(i);
            });
        });
        return interventions;
    }

    public List<ToothSideState> getCurrentStatesOfSides() {
        List<ToothSideState> states = new LinkedList<>();
        sides.forEach(side -> {
            states.add(side.getSideInterventions().stream()
                    .max((o1, o2) -> o1.getIntervention().getDate().compareTo(o2.getIntervention().getDate())).get().getState());
        });
        return states;
    }

    public ToothSideState getSideStateAtDate(int i, Date date) {
        SideIntervention result = null;
        Date tempDate = new GregorianCalendar(1, 0, 0).getTime();
        for (SideIntervention si : sides.get(i).getSideInterventions()) {
            if (si.getIntervention().getDate().getTime() <= date.getTime()
                    && tempDate.getTime() <= si.getIntervention().getDate().getTime()) {
                result = si;
                tempDate = si.getIntervention().getDate();
            }
        }
        if (result == null) {
            throw new RuntimeException("Logicka greska!");
        }
        return result.getState();
    }

    @Override
    public String getClassName() {
        return "tooth";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(toothID).append("',")
                .append("'").append(patient.getPatientID()).append("',")
                .append("'").append(label.getToothLabelID()).append("',")
                .append("'").append(state.getToothStateID()).append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNameByColumn(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereCondition() {
        return "patientID='" + patient.getPatientID() + "' and toothID='" + toothID + "'";
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        String toothID1 = rs.getString("toothID");
        String patientID1 = rs.getString("patientID");
        String toothLabelID1 = rs.getString("toothLabelID");
        String toothStateID1 = rs.getString("toothStateID");
        return new Tooth(toothID1, new Patient(patientID1), new ToothLabel(toothLabelID1), new ToothState(toothStateID1));
    }

}
