/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MikoPC
 */
@Entity
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
    , @NamedQuery(name = "Patient.findByPatientID", query = "SELECT p FROM Patient p WHERE p.patientID = :patientID")
    , @NamedQuery(name = "Patient.findByFirstname", query = "SELECT p FROM Patient p WHERE p.firstname = :firstname")
    , @NamedQuery(name = "Patient.findByLastname", query = "SELECT p FROM Patient p WHERE p.lastname = :lastname")
    , @NamedQuery(name = "Patient.findByEmail", query = "SELECT p FROM Patient p WHERE p.email = :email")
    , @NamedQuery(name = "Patient.findByBirthDate", query = "SELECT p FROM Patient p WHERE p.birthDate = :birthDate")
    , @NamedQuery(name = "Patient.findByAddress", query = "SELECT p FROM Patient p WHERE p.address = :address")
    , @NamedQuery(name = "Patient.findByPhone", query = "SELECT p FROM Patient p WHERE p.phone = :phone")
    , @NamedQuery(name = "Patient.findByCardboardDate", query = "SELECT p FROM Patient p WHERE p.cardboardDate = :cardboardDate")
    , @NamedQuery(name = "Patient.findByDeactivated", query = "SELECT p FROM Patient p WHERE p.deactivated = :deactivated")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "patientID")
    private String patientID;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "cardboardDate")
    @Temporal(TemporalType.DATE)
    private Date cardboardDate;
    @Basic(optional = false)
    @Column(name = "deactivated")
    private boolean deactivated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Collection<Appointment> appointmentCollection;

    public Patient() {
    }

    public Patient(String patientID) {
        this.patientID = patientID;
    }

    public Patient(String patientID, String firstname, String lastname, Date cardboardDate, boolean deactivated) {
        this.patientID = patientID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.cardboardDate = cardboardDate;
        this.deactivated = deactivated;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCardboardDate() {
        return cardboardDate;
    }

    public void setCardboardDate(Date cardboardDate) {
        this.cardboardDate = cardboardDate;
    }

    public boolean getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientID != null ? patientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.patientID == null && other.patientID != null) || (this.patientID != null && !this.patientID.equals(other.patientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.Patient[ patientID=" + patientID + " ]";
    }
    
}
