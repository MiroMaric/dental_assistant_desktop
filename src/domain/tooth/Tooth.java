package domain.tooth;

import domain.GeneralDObject;
import domain.Patient;
import domain.intervention.InterventionItem;
import domain.intervention.SideIntervention;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Tooth implements GeneralDObject {

    private String toothID;
    private Patient patient;
    private ToothLabel label;
    private ToothState state;
    private List<ToothSide> sides;
    private List<ToothRoot> roots;

    public Tooth() {
    }

    public Tooth(String toothID, Patient patient, ToothLabel label, ToothState state, List<ToothSide> sides, List<ToothRoot> roots) {
        this.toothID = toothID;
        this.patient = patient;
        this.label = label;
        this.state = state;
        this.sides = sides;
        this.roots = roots;
    }
    
    public Tooth(Patient patient, ToothLabel label, ToothState state) {
        this.toothID = UUID.randomUUID().toString();
        this.patient = patient;
        this.label = label;
        this.state = state;
        this.sides = new LinkedList<>();
    }

//    public Tooth(ToothLabel label, ToothState state, List<ToothSide> sides) {
//        this.label = label;
//        this.state = state;
//        this.sides = sides;
//    }

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

    public List<ToothRoot> getRoots() {
        return roots;
    }

    public void setRoots(List<ToothRoot> roots) {
        this.roots = roots;
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
        List<InterventionItem> interventions = new LinkedList<>();
        sides.forEach(side -> {
            interventions.addAll(side.getSideInterventions());
        });
        roots.forEach(root->{
            interventions.addAll(root.getRootInterventions());
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

    public HashMap<ToothSideLabel, ToothSideState> getCurrentStatesOfSides() {
        HashMap<ToothSideLabel, ToothSideState> states = new HashMap<>();
        sides.forEach((side) -> {
            states.put(side.getLabel(), side.getSideInterventions().stream().max((o1, o2) -> o1.getIntervention().getDate().compareTo(o2.getIntervention().getDate())).get().getState());
        });
        return states;
    }

    public ToothSide getToothSide(int indexOf) {
        return sides.get(indexOf);
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.toothID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tooth other = (Tooth) obj;
        return Objects.equals(this.toothID, other.toothID);
    }

}
