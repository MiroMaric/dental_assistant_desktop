/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author MikoPC
 */
@Embeddable
public class AppointmentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "appointmentID")
    private String appointmentID;
    @Basic(optional = false)
    @Column(name = "patientID")
    private String patientID;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    public AppointmentPK() {
    }

    public AppointmentPK(String appointmentID, String patientID, String username) {
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.username = username;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentID != null ? appointmentID.hashCode() : 0);
        hash += (patientID != null ? patientID.hashCode() : 0);
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppointmentPK)) {
            return false;
        }
        AppointmentPK other = (AppointmentPK) object;
        if ((this.appointmentID == null && other.appointmentID != null) || (this.appointmentID != null && !this.appointmentID.equals(other.appointmentID))) {
            return false;
        }
        if ((this.patientID == null && other.patientID != null) || (this.patientID != null && !this.patientID.equals(other.patientID))) {
            return false;
        }
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.AppointmentPK[ appointmentID=" + appointmentID + ", patientID=" + patientID + ", username=" + username + " ]";
    }
    
}
