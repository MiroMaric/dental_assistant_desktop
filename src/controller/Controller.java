package controller;

import communication.Communication;
import domain.Appointment;
import domain.Patient;
import domain.User;
import domain.intervention.Intervention;
import domain.tooth.ToothRootState;
import domain.tooth.ToothSideLabel;
import domain.tooth.ToothSideState;
import domain.tooth.ToothState;
import java.awt.Color;
import java.util.List;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.dto.CreateCardboardDto;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public User logIn(String username, String password) throws Exception {
        User user = new User(username, password);
        Request request = new Request(Operation.OPERATION_LOGIN, user);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (User) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public List<Appointment> getAllAppointments() throws Exception {
        Request requst = new Request(Operation.OPERATION_GET_ALL_APPOINTMENTS, null);
        Communication.getInstance().sendRequest(requst);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<Appointment>) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public List<Patient> getAllPatients() throws Exception {
        Request request = new Request(Operation.OPERATION_GET_ALL_PATIENTS, null);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<Patient>) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public void deleteAppointment(Appointment appointment) throws Exception {
        Request request = new Request(Operation.OPERATION_DELETE_APPOINTMENT, appointment);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) response.getError();
            throw ex;
        }
    }

    public void saveAppointment(Appointment appointment) throws Exception {
        Request request = new Request(Operation.OPERATION_SAVE_APPOINTMENT, appointment);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) response.getError();
            throw ex;
        }
    }

    public void updateAppointment(Appointment appointment) throws Exception {
        Request request = new Request(Operation.OPERATION_UPDATE_APPOINTMENT, appointment);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) response.getError();
            throw ex;
        }
    }

    public void updatePatient(Patient patient) throws Exception {
        Request request = new Request(Operation.OPERATION_UPDATE_PATIENT, patient);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) response.getError();
            throw ex;
        }
    }

    public List<ToothSideState> getAllToothSideStates() throws Exception {
        Request request = new Request(Operation.OPERATION_GET_ALL_TOOTH_SIDE_STATES, null);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<ToothSideState>) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public List<ToothRootState> getAllToothRootStates() throws Exception {
        Request request = new Request(Operation.OPERATION_GET_ALL_TOOTH_ROOT_STATES, null);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<ToothRootState>) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public List<ToothState> getAllToothStates()throws Exception{
        Request request = new Request(Operation.OPERATION_GET_ALL_TOOTH_STATES, null);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<ToothState>) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    //----------------
    public List<ToothSideLabel> getToothSideLabels() throws Exception {
        Communication.getInstance().sendRequest(new Request(Operation.OPERATION_GET_ALL_TOOTH_SIDE_LABELS, null));
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (List<ToothSideLabel>) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }
    //----------------

    public void registerNewUser(User user) throws Exception {
        Request request = new Request(Operation.OPERATION_REGISTER_NEW_USER, user);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) response.getError();
            throw ex;
        }
    }

    public void createCardboard(Patient patient) throws Exception {
        Request request = new Request(Operation.OPERATION_CREATE_CARDBOARD, new CreateCardboardDto(patient, Session.getInstance().getUser()));
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) response.getError();
            throw ex;
        }
    }

    public Patient findCardboard(Patient patient) throws Exception {
        Request request = new Request(Operation.OPERATION_FIND_CARDBOARD, patient);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return (Patient) response.getData();
        }
        Exception ex = (Exception) response.getError();
        throw ex;
    }

    public void saveIntervention(Intervention intervention) throws Exception {
        Request request = new Request(Operation.OPERATION_SAVE_INTERVENTION, intervention);
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.ERROR) {
            Exception ex = (Exception) response.getError();
            throw ex;
        }
    }

    public static void main(String[] args) {
        System.out.println(Color.GRAY.getRGB());
    }

}
