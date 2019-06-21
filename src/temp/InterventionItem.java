/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MikoPC
 */
@Entity
@Table(name = "intervention_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterventionItem.findAll", query = "SELECT i FROM InterventionItem i"),
    @NamedQuery(name = "InterventionItem.findByItemID", query = "SELECT i FROM InterventionItem i WHERE i.interventionItemPK.itemID = :itemID"),
    @NamedQuery(name = "InterventionItem.findByInterventionID", query = "SELECT i FROM InterventionItem i WHERE i.interventionItemPK.interventionID = :interventionID"),
    @NamedQuery(name = "InterventionItem.findByNote", query = "SELECT i FROM InterventionItem i WHERE i.note = :note")})
public class InterventionItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InterventionItemPK interventionItemPK;
    @Basic(optional = false)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "interventionID", referencedColumnName = "interventionID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Intervention intervention;

    public InterventionItem() {
    }

    public InterventionItem(InterventionItemPK interventionItemPK) {
        this.interventionItemPK = interventionItemPK;
    }

    public InterventionItem(InterventionItemPK interventionItemPK, String note) {
        this.interventionItemPK = interventionItemPK;
        this.note = note;
    }

    public InterventionItem(String itemID, String interventionID) {
        this.interventionItemPK = new InterventionItemPK(itemID, interventionID);
    }

    public InterventionItemPK getInterventionItemPK() {
        return interventionItemPK;
    }

    public void setInterventionItemPK(InterventionItemPK interventionItemPK) {
        this.interventionItemPK = interventionItemPK;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (interventionItemPK != null ? interventionItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterventionItem)) {
            return false;
        }
        InterventionItem other = (InterventionItem) object;
        if ((this.interventionItemPK == null && other.interventionItemPK != null) || (this.interventionItemPK != null && !this.interventionItemPK.equals(other.interventionItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.InterventionItem[ interventionItemPK=" + interventionItemPK + " ]";
    }
    
}
