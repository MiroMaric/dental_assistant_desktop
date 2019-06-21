package controller;

import domain.Appointment;
import domain.GeneralDObject;
import domain.Patient;
import domain.tooth.ToothLabel;
import domain.User;
import domain.intervention.Intervention;
import domain.intervention.InterventionItem;
import domain.intervention.SideIntervention;
import domain.tooth.Tooth;
import domain.tooth.ToothRootState;
import domain.tooth.ToothSide;
import domain.tooth.ToothSideLabel;
import domain.tooth.ToothSideState;
import domain.tooth.ToothState;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import session.Session;
import storage.StorageUser;
import storage.database.BrokerDatabase;
import storage.database.DatabaseConnection;

public class Controller {

    private static Controller instance;
    private final BrokerDatabase brokerDatabase;

    private Controller() {
        brokerDatabase = new BrokerDatabase();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public User logIn(String username, String password) {
        try {
            User user = (User) brokerDatabase.findRecord(new User(username, password));
            if (user != null) {
                Session.getInstance().setUser(user);
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean insertRecord(GeneralDObject object) {
        try {
            return brokerDatabase.insertRecord(object);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean savePatient(Patient patient) {
        try {
            DatabaseConnection.getInstance().getConnection().setAutoCommit(false);
            Intervention intervention = new Intervention(new Date(), "Novi elektronski karton", StorageUser.getInstance().getUser());
            brokerDatabase.insertRecord(intervention);
            brokerDatabase.insertRecord(patient);
            List<ToothLabel> toothLabels = brokerDatabase.getAllRecord(new ToothLabel()).stream().map(o -> (ToothLabel) o).collect(Collectors.toList());
            ToothState toothState = (ToothState) brokerDatabase.findRecord(new ToothState(null, "prirodan", null, null));
            List<ToothSideLabel> toothSideLabels = brokerDatabase.getAllRecord(new ToothSideLabel()).stream().map(o -> (ToothSideLabel) o).collect(Collectors.toList());
            ToothSideState toothSideState = (ToothSideState) brokerDatabase.findRecord(new ToothSideState(-1, "zdrava", null, -1));
            for (ToothLabel tl : toothLabels) {
                Tooth tooth = new Tooth(patient, tl, toothState);
                brokerDatabase.insertRecord(tooth);
                for (ToothSideLabel tsl : toothSideLabels) {
                    ToothSide toothSide = new ToothSide(tooth, tsl);
                    SideIntervention sideIntevention = new SideIntervention(intervention, "Pocetno stanje", toothSide, toothSideState);
                    brokerDatabase.insertRecord(toothSide);
                    brokerDatabase.insertRecord(new InterventionItem(sideIntevention.getItemID(), sideIntevention.getIntervention(), sideIntevention.getNote()) {
                    });
                    brokerDatabase.insertRecord(sideIntevention);
                }
            }
            DatabaseConnection.getInstance().getConnection().commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
//        User user = new User("miko");
//        StorageUser.getInstance().setUser(user);
//        Controller.getInstance().savePatient(new Patient("Marko", "Markovic", "marko@gmail.com", "adresa123", "0661234567", new Date(), new Date()));
//        ----
//        Patient p = new Patient();
//        p.setPatientID("2bc00871-2bf0-4809-baf3-209e4de17dd4");
//        Patient patient = Controller.getInstance().getPatient(p);
//        for (Tooth t : patient.getTeeth()) {
//            System.out.println(t.getSides().get(0).getSideInterventions().get(0).getState().getName());
//        }
    }

    public List<Patient> getAllPatients() {
        try {
            List<Patient> patients = brokerDatabase.getAllRecord(new Patient()).stream().map(o -> (Patient) o).collect(Collectors.toList());
            return patients;
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Potrebno veliko poboljsanje!
    public Patient getPatient(Patient patient) {
        try {
            Patient p = (Patient) brokerDatabase.findRecord(patient);
            List<Tooth> teeth = brokerDatabase.findRecords(new Tooth(), p).stream().map(o -> (Tooth) o).collect(Collectors.toList());
            for (Tooth t : teeth) {
                t.setLabel((ToothLabel) brokerDatabase.findRecord(t.getLabel()));
                t.setState((ToothState) brokerDatabase.findRecord(t.getState()));
                t.setPatient(p);
                List<ToothSide> toothSides = brokerDatabase.findRecords(new ToothSide(), t).stream().map(o -> (ToothSide) o).collect(Collectors.toList());
                for (ToothSide ts : toothSides) {
                    ts.setLabel((ToothSideLabel) brokerDatabase.findRecord(ts.getLabel()));
                    List<SideIntervention> sideInterventions = brokerDatabase.findRecords(new SideIntervention(), ts).stream().map(o -> (SideIntervention) o).collect(Collectors.toList());
                    System.out.println(sideInterventions.get(0).getItemID());
                    for (SideIntervention si : sideInterventions) {
                        si.setToothSide(ts);
                        si.setState((ToothSideState) brokerDatabase.findRecord(new ToothSideState(si.getState().getToothSideStateID())));
                        String note = ((InterventionItem) brokerDatabase.findRecord(new InterventionItem(si.getItemID()) {
                        })).getNote();
                        si.setNote(note);
                        si.setIntervention((Intervention) brokerDatabase.findRecord(si.getIntervention()));
                    }
                    sideInterventions.sort((o1, o2) -> o1.getIntervention().getDate().compareTo(o2.getIntervention().getDate()));
                    ts.setSideInterventions(sideInterventions);
                }
                toothSides.sort((s1, s2) -> s1.getLabel().getToothSideLabelID().compareTo(s2.getLabel().getToothSideLabelID()));
                t.setSides(toothSides);
            }
            teeth.sort((Tooth o1, Tooth o2) -> o1.getLabel().getToothLabelID().compareTo(o2.getLabel().getToothLabelID()));
            p.setTeeth(teeth);
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<ToothLabel> getAllTeeth() {
        try {
            List<ToothLabel> teeth = new LinkedList<>();
            List<GeneralDObject> objects = brokerDatabase.getAllRecord(new ToothLabel());
            objects.forEach((o) -> {
                teeth.add((ToothLabel) o);
            });
            return teeth;
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Appointment> getAppointments() {
        try {
            List<Appointment> appointments = brokerDatabase.getAllRecord(new Appointment()).stream().map(o -> (Appointment) o).collect(Collectors.toList());
            for (Appointment a : appointments) {
                a.setPatient((Patient) brokerDatabase.findRecord(new Patient(a.getPatient().getPatientID())));
                a.setUser((User) brokerDatabase.findRecord(new Patient(a.getUser().getUsername())));
            }
            return appointments;
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void saveAppointment(Appointment appointment) {
        try {
            brokerDatabase.insertRecord(appointment);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAppointment(Appointment appointment) {
        try {
            brokerDatabase.updateRecord(appointment);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAppointment(Appointment appointment) {
        try {
            brokerDatabase.deleteRecord(appointment);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ToothSideState> getToothSideStates() {
        try {
            return brokerDatabase.getAllRecord(new ToothSideState()).stream().map(o -> (ToothSideState) o).collect(Collectors.toList());
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<ToothRootState> getToothRootStates() {
        try {
            return brokerDatabase.getAllRecord(new ToothRootState()).stream().map(o -> (ToothRootState) o).collect(Collectors.toList());
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<ToothSideLabel> getToothSideLabels() {
        try {
            return brokerDatabase.getAllRecord(new ToothSideLabel()).stream().map(o -> (ToothSideLabel) o).collect(Collectors.toList());
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updatePatient(Patient patient) {
        try {
            return brokerDatabase.updateRecord(patient);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
