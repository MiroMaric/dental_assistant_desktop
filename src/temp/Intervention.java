/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "intervention")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intervention.findAll", query = "SELECT i FROM Intervention i"),
    @NamedQuery(name = "Intervention.findByInterventionID", query = "SELECT i FROM Intervention i WHERE i.interventionID = :interventionID"),
    @NamedQuery(name = "Intervention.findByDate", query = "SELECT i FROM Intervention i WHERE i.date = :date"),
    @NamedQuery(name = "Intervention.findByNote", query = "SELECT i FROM Intervention i WHERE i.note = :note")})
public class Intervention implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "interventionID")
    private String interventionID;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "note")
    private String note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intervention")
    private List<InterventionItem> interventionItemList;
    @JoinColumn(name = "userID", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User userID;

    public Intervention() {
    }

    public Intervention(String interventionID) {
        this.interventionID = interventionID;
    }

    public Intervention(String interventionID, Date date, String note) {
        this.interventionID = interventionID;
        this.date = date;
        this.note = note;
    }

    public String getInterventionID() {
        return interventionID;
    }

    public void setInterventionID(String interventionID) {
        this.interventionID = interventionID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @XmlTransient
    public List<InterventionItem> getInterventionItemList() {
        return interventionItemList;
    }

    public void setInterventionItemList(List<InterventionItem> interventionItemList) {
        this.interventionItemList = interventionItemList;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (interventionID != null ? interventionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intervention)) {
            return false;
        }
        Intervention other = (Intervention) object;
        if ((this.interventionID == null && other.interventionID != null) || (this.interventionID != null && !this.interventionID.equals(other.interventionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.Intervention[ interventionID=" + interventionID + " ]";
    }
    
}
