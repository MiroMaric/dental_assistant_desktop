/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MikoPC
 */
@Entity
@Table(name = "appointment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
    , @NamedQuery(name = "Appointment.findByAppointmentID", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.appointmentID = :appointmentID")
    , @NamedQuery(name = "Appointment.findByPatientID", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.patientID = :patientID")
    , @NamedQuery(name = "Appointment.findByUsername", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.username = :username")
    , @NamedQuery(name = "Appointment.findByStartTime", query = "SELECT a FROM Appointment a WHERE a.startTime = :startTime")
    , @NamedQuery(name = "Appointment.findByEndTime", query = "SELECT a FROM Appointment a WHERE a.endTime = :endTime")
    , @NamedQuery(name = "Appointment.findByDescription", query = "SELECT a FROM Appointment a WHERE a.description = :description")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppointmentPK appointmentPK;
    @Basic(optional = false)
    @Column(name = "startTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "endTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "patientID", referencedColumnName = "patientID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Patient patient;
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Appointment() {
    }

    public Appointment(AppointmentPK appointmentPK) {
        this.appointmentPK = appointmentPK;
    }

    public Appointment(AppointmentPK appointmentPK, Date startTime, Date endTime, String description) {
        this.appointmentPK = appointmentPK;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public Appointment(String appointmentID, String patientID, String username) {
        this.appointmentPK = new AppointmentPK(appointmentID, patientID, username);
    }

    public AppointmentPK getAppointmentPK() {
        return appointmentPK;
    }

    public void setAppointmentPK(AppointmentPK appointmentPK) {
        this.appointmentPK = appointmentPK;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentPK != null ? appointmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.appointmentPK == null && other.appointmentPK != null) || (this.appointmentPK != null && !this.appointmentPK.equals(other.appointmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.Appointment[ appointmentPK=" + appointmentPK + " ]";
    }
    
}
